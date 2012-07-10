package org.hl7.fhir.tools.publisher.implementations;

/*
 Copyright (c) 2011-2012, HL7, Inc
 All rights reserved.

 Redistribution and use in source and binary forms, with or without modification, 
 are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, this 
 list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, 
 this list of conditions and the following disclaimer in the documentation 
 and/or other materials provided with the distribution.
 * Neither the name of HL7 nor the names of its contributors may be used to 
 endorse or promote products derived from this software without specific 
 prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
 ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
 WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
 IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
 INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
 PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
 WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
 ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
 POSSIBILITY OF SUCH DAMAGE.

*/

import java.util.Date;
import java.util.List;

import org.hl7.fhir.definitions.Config;
import org.hl7.fhir.definitions.ecore.fhir.BindingDefn;
import org.hl7.fhir.definitions.ecore.fhir.BindingType;
import org.hl7.fhir.definitions.ecore.fhir.CompositeTypeDefn;
import org.hl7.fhir.definitions.ecore.fhir.ConstrainedTypeDefn;
import org.hl7.fhir.definitions.ecore.fhir.DefinedCode;
import org.hl7.fhir.definitions.ecore.fhir.Definitions;
import org.hl7.fhir.definitions.ecore.fhir.ElementDefn;
import org.hl7.fhir.definitions.ecore.fhir.Invariant;
import org.hl7.fhir.definitions.ecore.fhir.TypeRef;


public class CSharpResourceGenerator extends GenBlock
{
	public GenBlock generateComposite( CompositeTypeDefn composite, Definitions definitions ) throws Exception
	{
		begin();
		
		header(definitions.getDate(), definitions.getVersion());
		
		ln("namespace HL7.Fhir.Instance.Model");
		bs("{");
			compositeClass( composite ); 
		es("}");
		
		return end();
	}

	
	public GenBlock generateGlobalEnums( List<BindingDefn> globalEnums, 
			Definitions definitions ) throws Exception
	{
		begin();
		
		header(definitions.getDate(), definitions.getVersion());
		
		ln("namespace HL7.Fhir.Instance.Model");
		bs("{");
			enums(globalEnums); 
		es("}");
		
		return end();
	}

	

	public GenBlock generateConstrained( ConstrainedTypeDefn constrained, 
			Definitions definitions) throws Exception
	{
		begin();
		
		header(definitions.getDate(), definitions.getVersion());
		
		ln("namespace HL7.Fhir.Instance.Model");
		bs("{");
			ln("/*");
			ln("* " +  constrained.getAnnotations().getDefinition());
			ln("*/");
			ln("public partial class " +  GeneratorUtils.generateCSharpTypeName(constrained.getName()) );
				nl(" : ");
				nl(GeneratorUtils.generateCSharpTypeName(constrained.getBaseType().getName()));
			bs("{");
				ln("// TODO: Add code to enforce these constraints:");
				for( Invariant inv : constrained.getDetails() ) 
					ln("// * " + inv.getHuman() );
			es("}");
		es("}");
				
		return end();
	}
	
	public GenBlock header(Date genDate, String version)
	{
		begin();
		
		ln("using System;");
		ln("using System.Collections.Generic;");
		ln("using HL7.Fhir.Instance.Support;");
		ln("using System.Xml.Linq;");
		ln();
		ln("/*");
		ln(Config.FULL_LICENSE_CODE);
		ln("*/");
		ln();
		ln("//");
		ln("// Generated on " + Config.DATE_FORMAT().format(genDate));
				nl(" for FHIR v" + version);
		ln("//");
		
		return end();
	}
	
	public GenBlock compositeClass( CompositeTypeDefn composite ) throws Exception
	{
		begin();
		
		ln("/*");
		ln("* " + composite.getAnnotations().getDefinition());
		ln("*/");

		// Generate the class itself		
		compositeClassHeader( composite );
		bs("{");		
			// Generate local bindings
			if( composite.getBindings().size() > 0)
				enums( composite.getBindings() );
			
			// Generate the nested local types in this scope
			if( composite.getLocalCompositeTypes().size() > 0)
				nestedLocalTypes( composite.getLocalCompositeTypes() ); 			
	
			// Generate this classes properties
			for( ElementDefn member : composite.getElements() )
			{
				// Generate members, except for resource-specific
				// members as they are already defined in the abstract
				// and hand-made Resource class
				if( !GeneratorUtils.isBaseResourceMember(member) )
					generateMemberProperty(composite, member);
			}
		es("}");
		ln();
		
		return end();
	}


	
	
	private void generateMemberProperty(CompositeTypeDefn context, ElementDefn member)
			throws Exception {
		ln("// " + member.getAnnotation().getShortDefinition());
		ln("public ");
		
		if( member.getMaxCardinality() == -1 )  nl("List<");		
		if( member.isAllowDAR() ) nl("Absentable<");

		// Determine the most appropriate FHIR type to use for this
		// (possibly polymorphic) element.
		TypeRef tref = GeneratorUtils.getMostSpecializedCommonBaseForElement(member);
		
		if( GeneratorUtils.isCodeWithCodeList( member.getParentType(), tref ) )
		{
			nl("Code<" + GeneratorUtils.generateCSharpTypeName(tref.getBindingRef()) + ">");
			//isNullable = false;
		}
		else 
		{
			nl( GeneratorUtils.generateCSharpTypeName(tref.getName()) );
			//isNullable = mapsToNullableFhirPrimitive(tref.getName());
		}
					
		if( member.isAllowDAR() ) nl(">");
		if( member.getMaxCardinality() == -1 ) nl(">");

		// All generated members should be nullable, to indicate whether
		// the element has data or not. This means cardinality needs to be 
		// checked by the validation routines and is not converted to
		// a structural aspect here.
		//if( !isNullable ) nl("?");
		
		nl( " " + GeneratorUtils.generateCSharpMemberName(context, member.getName()) );
		nl(" { get; set; }");
		ln();
	}
	
	
	private boolean mapsToNullableFhirPrimitive( String name )
	{
		return !(name.equals("boolean") ||
			name.equals("integer") ||
			name.equals("decimal")); 
	}

	private void nestedLocalTypes( List<CompositeTypeDefn> nestedTypes) throws Exception
	{
		begin();

		for( CompositeTypeDefn nested : nestedTypes )
		{
			compositeClass( nested );
			ln();
		}
		
		end();
	}

			
	public GenBlock genericBaseClass( CompositeTypeDefn genericType )
	{
		begin();
		
		ln("public partial class " + genericType.getName() + ": Composite { }");
		
		return end();
	}
	
	private void compositeClassHeader(CompositeTypeDefn composite) throws Exception
	{
		ln( "public partial class " +
				GeneratorUtils.generateCSharpTypeName(composite.getName()) );
		
		// Optionally, add generic parameter
//		if( composite.isGenericType() ) nl("<T>");
		
		// Derive from appropriate baseclass
		nl(" : ");
		
//		if( composite.isGenericType() ) 
//			nl( composite.getName() );
		if( composite.isResource() ) 
			nl( "Resource" );
		else if( composite.isComposite() ) 
			nl( "Composite" );
	}
	
	public GenBlock enums( List<BindingDefn> bindings ) throws Exception
	{
		begin();
		
		for( BindingDefn binding : bindings ) 
		{
			if( binding.getBinding() == BindingType.CODE_LIST )
			{	
				generateEnum(binding);
				ln();
				
				generateEnumParser(binding);
				ln();
			}
		}
	
		return end();
	}


	public GenBlock generateEnumParser(BindingDefn binding) {
		begin();
		
		ln("/*");
		ln("* Parse string into " + binding.getName());
		ln("*/");
		ln("public static class " + binding.getName() + "Handling");
		bs("{"); 
			ln("public static bool TryParse");
				nl("(string value, ");
				nl("out " + binding.getName() + " result)");
			bs("{");
				ln( "result = default(" + binding.getName() + ");");
				ln();					
				enumValueCases(binding);
				ln();
				ln("return true;");					
			es("}");
		es("}");
		ln();
		
		return end();
	}


	private void enumValueCases(BindingDefn binding) 
	{
		boolean isFirstClause = true;
			
		for( DefinedCode code : binding.getCodes() ) 
		{					
			if( !isFirstClause )
				ln("else ");
			else
				ln();
					
			isFirstClause = false;
			
			nl("if( value ==");
				nl("\"" + code.getCode() + "\")");
			bs();
				ln("result = " + binding.getName());
					nl("." + GeneratorUtils.generateCSharpMemberName(null,code.getCode()));
					nl(";");
			es();						
		}
		ln("else");
		bs();
			ln("return false;");
		es();
	}


	public GenBlock generateEnum(BindingDefn binding) throws Exception {
		begin();
		
		ln("/*");
		ln("* " + binding.getAnnotations().getDefinition() );
		ln("*/");
		ln("public enum " + 
				GeneratorUtils.generateCSharpTypeName(binding.getName()));
		bs("{");
			for( DefinedCode code : binding.getCodes() ) 
			{
				String definition = code.getDefinition();
				
				ln(GeneratorUtils.generateCSharpMemberName(null,code.getCode()) + ",");
				
				if( definition != null )
					nl(" // " + code.getDefinition());		
			}
		es("}");
		
		return end();
	}
}
