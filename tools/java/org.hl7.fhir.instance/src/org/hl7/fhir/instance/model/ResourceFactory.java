package org.hl7.fhir.instance.model;

/*
  Copyright (c) 2011-2012, HL7, Inc.
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

// Generated on Wed, Oct 3, 2012 17:55+1000 for FHIR v0.06

public class ResourceFactory {

    public static Resource createResource(String name) throws Exception {
        if ("XdsEntry".equals(name))
            return new XdsEntry();
        if ("Conformance".equals(name))
            return new Conformance();
        if ("DocumentHeader".equals(name))
            return new DocumentHeader();
        if ("AssessmentDefinition".equals(name))
            return new AssessmentDefinition();
        if ("Device".equals(name))
            return new Device();
        if ("Animal".equals(name))
            return new Animal();
        if ("Agent".equals(name))
            return new Agent();
        if ("Location".equals(name))
            return new Location();
        if ("Organization".equals(name))
            return new Organization();
        if ("Prescription".equals(name))
            return new Prescription();
        if ("Profile".equals(name))
            return new Profile();
        if ("Admission".equals(name))
            return new Admission();
        if ("Group".equals(name))
            return new Group();
        if ("InterestOfCare".equals(name))
            return new InterestOfCare();
        if ("ValueSet".equals(name))
            return new ValueSet();
        if ("Problem".equals(name))
            return new Problem();
        if ("Test".equals(name))
            return new Test();
        if ("MessageHeader".equals(name))
            return new MessageHeader();
        if ("Specimen".equals(name))
            return new Specimen();
        if ("AssessmentScale".equals(name))
            return new AssessmentScale();
        if ("Patient".equals(name))
            return new Patient();
        if ("LabReport".equals(name))
            return new LabReport();
        if ("Person".equals(name))
            return new Person();
        if ("XdsFolder".equals(name))
            return new XdsFolder();
        else
            throw new Exception("Unknown Resource Name '"+name+"'");
    }

    public static Element createType(String name) throws Exception {
        if ("Period".equals(name))
            return new Period();
        if ("Coding".equals(name))
            return new Coding();
        if ("Range".equals(name))
            return new Range();
        if ("Age".equals(name))
            return new Age();
        if ("Count".equals(name))
            return new Count();
        if ("Quantity".equals(name))
            return new Quantity();
        if ("Attachment".equals(name))
            return new Attachment();
        if ("Money".equals(name))
            return new Money();
        if ("Distance".equals(name))
            return new Distance();
        if ("Contact".equals(name))
            return new Contact();
        if ("HumanId".equals(name))
            return new HumanId();
        if ("Extension".equals(name))
            return new Extension();
        if ("Schedule".equals(name))
            return new Schedule();
        if ("Choice".equals(name))
            return new Choice();
        if ("HumanName".equals(name))
            return new HumanName();
        if ("Address".equals(name))
            return new Address();
        if ("Duration".equals(name))
            return new Duration();
        if ("Ratio".equals(name))
            return new Ratio();
        if ("ResourceReference".equals(name))
            return new ResourceReference();
        if ("CodeableConcept".equals(name))
            return new CodeableConcept();
        if ("Identifier".equals(name))
            return new Identifier();
        if ("Narrative".equals(name))
            return new Narrative();
        else
            throw new Exception("Unknown Type Name '"+name+"'");
    }

}

