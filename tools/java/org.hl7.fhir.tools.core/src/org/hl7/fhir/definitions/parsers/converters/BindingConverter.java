package org.hl7.fhir.definitions.parsers.converters;

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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hl7.fhir.definitions.ecore.fhir.BindingDefn;
import org.hl7.fhir.definitions.ecore.fhir.BindingType;
import org.hl7.fhir.definitions.ecore.fhir.BindingStrength;
import org.hl7.fhir.definitions.ecore.fhir.DefinedCode;
import org.hl7.fhir.definitions.ecore.fhir.FhirFactory;
import org.hl7.fhir.definitions.model.BindingSpecification;
import org.hl7.fhir.utilities.Utilities;


public class BindingConverter 
{
	public static List<BindingDefn> buildBindingsFromFhirModel( Collection<org.hl7.fhir.definitions.model.BindingSpecification> bindings )
	{
		List<BindingDefn> result = new ArrayList<BindingDefn>();
		
	    for (org.hl7.fhir.definitions.model.BindingSpecification binding : bindings) 
	    {
	    	if( !binding.getName().equals("*unbound*") )
	    	{
	    		result.add(buildBindingFromFhirModel(binding));
	    	}
	    }
	    
	    return result;
	}
	
	public static BindingDefn buildBindingFromFhirModel( org.hl7.fhir.definitions.model.BindingSpecification spec )
	{
		BindingDefn result = FhirFactory.eINSTANCE.createBindingDefn();
		
		result.setId( Integer.parseInt( spec.getId() ) );
		result.setName( spec.getName() );

		result.setAnnotations( FhirFactory.eINSTANCE.createAnnotations() );		
		result.getAnnotations().setShortDefinition( Utilities.cleanupTextString(spec.getDescription()));
		result.getAnnotations().setDefinition( Utilities.cleanupTextString(spec.getDefinition()));
		
		result.setBinding( BindingType.get(spec.getBinding().ordinal()) );
		result.setStrength( BindingStrength.get(spec.getBindingStrength().ordinal()) );

		String artifact = spec.getReference();
		if( artifact != null && artifact.startsWith("#"))
			artifact = artifact.substring(1);
		
		result.setArtifactName( artifact );
		result.setSource( spec.getSource() );
	
		for( org.hl7.fhir.definitions.model.DefinedCode code : spec.getCodes() )
		{
			DefinedCode convertedCode = convertFromFhirDefinedCode( code );
			result.getCodes().add( convertedCode );
		}
		
		return result;
	}

	
	public static DefinedCode convertFromFhirDefinedCode( org.hl7.fhir.definitions.model.DefinedCode code) 
	{
		DefinedCode result = FhirFactory.eINSTANCE.createDefinedCode();
		
		result.setCode( code.getCode() );
		result.setDefinition( Utilities.cleanupTextString(code.getDefinition()) );
//		result.setAnnotations( FhirFactory.eINSTANCE.createAnnotations() );		
//		result.getAnnotations().setDefinition(Utilities.cleanupTextString(code.getDefinition()));
//		result.getAnnotations().setComment( Utilities.cleanupTextString(code.getComment()));
		
		return  result;
	}
}