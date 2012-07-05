package org.hl7.fhir.tools.publisher.implementations;

import java.util.Map;

import org.hl7.fhir.definitions.ecore.fhir.ConstrainedTypeDefn;
import org.hl7.fhir.definitions.ecore.fhir.Definitions;
import org.hl7.fhir.definitions.ecore.fhir.ElementDefn;

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


public class ConstrainedTypeGeneratorInput {
	
	public ConstrainedTypeGeneratorInput( Definitions definitions, ConstrainedTypeDefn subject)
	{
		this.setDefinition(definitions);
		this.setSubject(subject);
	}
	
	public Definitions getDefinition() {
		return definition;
	}

	public void setDefinition(Definitions definition) {
		this.definition = definition;
	}

	public ConstrainedTypeDefn getSubject() {
		return subject;
	}

	public void setSubject(ConstrainedTypeDefn subject) {
		this.subject = subject;
	}

	public Map<ElementDefn, GeneratorUtils.NamedElementGroup> getNestedComponents() {
		return nestedComponents;
	}

	public void setNestedComponents(Map<ElementDefn, GeneratorUtils.NamedElementGroup> nestedComponents) {
		this.nestedComponents = nestedComponents;
	}

	private Map<ElementDefn, GeneratorUtils.NamedElementGroup> nestedComponents;
	
	private Definitions definition;
	
	private ConstrainedTypeDefn subject;
 
}