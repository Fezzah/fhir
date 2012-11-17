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

// Generated on Sat, Nov 17, 2012 08:35+1100 for FHIR v0.06

import java.util.*;

/**
 * Optional Extensions Element - found in all resources
 */
public class Extension extends Element {

    /**
     * Source of the definition for the extension code - a logical name or a URL
     */
    private Uri url;

    /**
     * Internal reference to context of the extension - a pointer to an xml:id in the same resource
     */
    private String ref;

    /**
     * If this element is set to true, then the containing resource element and its children are only safe to process if the reader understands this extension. 
     */
    private Boolean mustUnderstand;

    /**
     * Value of extension - may be a resource or one of a constraint set of the data types (see Extensibility in the spec for list)
     */
    private org.hl7.fhir.instance.model.Type value;

    /**
     * Nested Extensions - further extensions that are part of the extension
     */
    private List<Extension> extension = new ArrayList<Extension>();

    public Uri getUrl() { 
      return this.url;
    }

    public void setUrl(Uri value) { 
      this.url = value;
    }

    public String getRef() { 
      return this.ref;
    }

    public void setRef(String value) { 
      this.ref = value;
    }

    public Boolean getMustUnderstand() { 
      return this.mustUnderstand;
    }

    public void setMustUnderstand(Boolean value) { 
      this.mustUnderstand = value;
    }

    public org.hl7.fhir.instance.model.Type getValue() { 
      return this.value;
    }

    public void setValue(org.hl7.fhir.instance.model.Type value) { 
      this.value = value;
    }

    public List<Extension> getExtension() { 
      return this.extension;
    }


}

