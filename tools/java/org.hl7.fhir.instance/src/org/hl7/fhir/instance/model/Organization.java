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

// Generated on Tue, Nov 20, 2012 11:09+1100 for FHIR v0.06

import java.util.*;

/**
 * For any company/corporation/institution/government department that has relevance to the care process
 */
public class Organization extends Resource {

    public class Accreditation extends Element {
        /**
         * The identifier of the accreditation
         */
        private Identifier identifier;

        /**
         * The type of the accreditation
         */
        private CodeableConcept code;

        /**
         * The organization that confered/confers the accreditation
         */
        private ResourceReference institution;

        /**
         * The period for which the accreditation is held
         */
        private Period period;

        public Identifier getIdentifier() { 
          return this.identifier;
        }

        public void setIdentifier(Identifier value) { 
          this.identifier = value;
        }

        public CodeableConcept getCode() { 
          return this.code;
        }

        public void setCode(CodeableConcept value) { 
          this.code = value;
        }

        public ResourceReference getInstitution() { 
          return this.institution;
        }

        public void setInstitution(ResourceReference value) { 
          this.institution = value;
        }

        public Period getPeriod() { 
          return this.period;
        }

        public void setPeriod(Period value) { 
          this.period = value;
        }

    }

    public class RelatedOrganization extends Element {
        /**
         * The organization that is related to this organization
         */
        private ResourceReference organization;

        /**
         * Code that specifies how this organization is related to the subject. A code is required.
         */
        private CodeableConcept type;

        public ResourceReference getOrganization() { 
          return this.organization;
        }

        public void setOrganization(ResourceReference value) { 
          this.organization = value;
        }

        public CodeableConcept getType() { 
          return this.type;
        }

        public void setType(CodeableConcept value) { 
          this.type = value;
        }

    }

    public class ContactPerson extends Element {
        /**
         * Address to use when contacting the contact person for this organization
         */
        private Address address;

        /**
         * Telecom details for the contact person at this organization
         */
        private List<Contact> telecom = new ArrayList<Contact>();

        /**
         * Name of the contact person
         */
        private HumanName name;

        /**
         * Link to the actual person that is a contact person for the organization
         */
        private ResourceReference person;

        public Address getAddress() { 
          return this.address;
        }

        public void setAddress(Address value) { 
          this.address = value;
        }

        public List<Contact> getTelecom() { 
          return this.telecom;
        }

        public HumanName getName() { 
          return this.name;
        }

        public void setName(HumanName value) { 
          this.name = value;
        }

        public ResourceReference getPerson() { 
          return this.person;
        }

        public void setPerson(ResourceReference value) { 
          this.person = value;
        }

    }

    /**
     * Identifier for the organization that is used to identify the organization across multiple disparate systems
     */
    private List<HumanId> identifier = new ArrayList<HumanId>();

    /**
     * A name associated with the organization
     */
    private List<String_> name = new ArrayList<String_>();

    /**
     * An address for the organization
     */
    private List<Address> address = new ArrayList<Address>();

    /**
     * A contact detail for the organization
     */
    private List<Contact> telecom = new ArrayList<Contact>();

    /**
     * The kind of organization that this is
     */
    private CodeableConcept type;

    /**
     * Indication of whether this organization's record is still active.
     */
    private Coding status;

    /**
     * The industry that this organization is involved in
     */
    private CodeableConcept industryCode;

    /**
     * The qualifications/certifications an organisation has, including format educational achievements, accreditations, and current certifications. All these qualifications may be used to determine what roles the organisation may play in a healthcare environment
     */
    private List<Accreditation> accreditation = new ArrayList<Accreditation>();

    /**
     * Other organizations who are related to this person. The relationship might be one of several types: sub- or super- orgnizations (i.e. ward in a hospital, owning corporation of a hospital) or partner organizations (i.e. the operating corporation for a hospital)
     */
    private RelatedOrganization relatedOrganization;

    /**
     * Contact details for a person acting as a contact for the organization
     */
    private List<ContactPerson> contactPerson = new ArrayList<ContactPerson>();

    public List<HumanId> getIdentifier() { 
      return this.identifier;
    }

    public List<String_> getName() { 
      return this.name;
    }

    public List<Address> getAddress() { 
      return this.address;
    }

    public List<Contact> getTelecom() { 
      return this.telecom;
    }

    public CodeableConcept getType() { 
      return this.type;
    }

    public void setType(CodeableConcept value) { 
      this.type = value;
    }

    public Coding getStatus() { 
      return this.status;
    }

    public void setStatus(Coding value) { 
      this.status = value;
    }

    public CodeableConcept getIndustryCode() { 
      return this.industryCode;
    }

    public void setIndustryCode(CodeableConcept value) { 
      this.industryCode = value;
    }

    public List<Accreditation> getAccreditation() { 
      return this.accreditation;
    }

    public RelatedOrganization getRelatedOrganization() { 
      return this.relatedOrganization;
    }

    public void setRelatedOrganization(RelatedOrganization value) { 
      this.relatedOrganization = value;
    }

    public List<ContactPerson> getContactPerson() { 
      return this.contactPerson;
    }


}

