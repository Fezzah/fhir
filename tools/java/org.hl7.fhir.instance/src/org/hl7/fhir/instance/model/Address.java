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

// Generated on Sat, Jun 30, 2012 08:13+1000 for FHIR v0.04

import java.util.*;

/**
 * There is a variety of postal address formats defined around the world. This format defines a superset that is the basis for addresses all around the world 
 */
public class Address extends Type {

    public enum AddressUse {
        home, // A communication address at a home.
        work, // An office address. First choice for business related contacts during business hours.
        temp, // A temporary address. The period can provide more detailed information.
        old; // This address is no longer in use (or was never correct, but retained for records)
        public static AddressUse fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("home".equals(codeString))
          return home;
        if ("work".equals(codeString))
          return work;
        if ("temp".equals(codeString))
          return temp;
        if ("old".equals(codeString))
          return old;
        throw new Exception("Unknown AddressUse code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case home: return "home";
            case work: return "work";
            case temp: return "temp";
            case old: return "old";
            default: return "?";
          }
        }
    }

    public enum AddressPartType {
        part, // Part of an address line (typically used with an extension that further defines the meaning of the part).
        line, // A line of an address (typically used for street names & numbers, unit details, delivery hints etc) .
        city, // The name of the city, town, village, or other community or delivery centre.
        state, // sub-unit of a country with limited sovereignty in a federally organized country. A code may be used if codes are in common use (i.e. US 2 letter state codes).
        country, // Country. ISO 3166 3 letter codes can be used in place of a full country name.
        zip, // A postal code designating a region defined by the postal service.
        dpid; // A value that uniquely identifies the postal address. (often used in barcodes). 
        public static AddressPartType fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("part".equals(codeString))
          return part;
        if ("line".equals(codeString))
          return line;
        if ("city".equals(codeString))
          return city;
        if ("state".equals(codeString))
          return state;
        if ("country".equals(codeString))
          return country;
        if ("zip".equals(codeString))
          return zip;
        if ("dpid".equals(codeString))
          return dpid;
        throw new Exception("Unknown AddressPartType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case part: return "part";
            case line: return "line";
            case city: return "city";
            case state: return "state";
            case country: return "country";
            case zip: return "zip";
            case dpid: return "dpid";
            default: return "?";
          }
        }
    }

    public class Part extends Element {
        /**
         * Type of address part (see below)
         */
        private AddressPartType type;

        /**
         * The content of the address part
         */
        private String value;

        public AddressPartType getType() { 
          return this.type;
        }

        public void setType(AddressPartType value) { 
          this.type = value;
        }

        public String getValue() { 
          return this.value;
        }

        public void setValue(String value) { 
          this.value = value;
        }

    }

    /**
     * The use of this address
     */
    private AddressUse use;

    /**
     * a full text representation of the address
     */
    private String text;

    /**
     * A part of an address
     */
    private List<Part> part = new ArrayList<Part>();

    /**
     * Time period when address was/is in use
     */
    private Interval<DateTime> period;

    public AddressUse getUse() { 
      return this.use;
    }

    public void setUse(AddressUse value) { 
      this.use = value;
    }

    public String getText() { 
      return this.text;
    }

    public void setText(String value) { 
      this.text = value;
    }

    public List<Part> getPart() { 
      return this.part;
    }

    public Interval<DateTime> getPeriod() { 
      return this.period;
    }

    public void setPeriod(Interval<DateTime> value) { 
      this.period = value;
    }


}

