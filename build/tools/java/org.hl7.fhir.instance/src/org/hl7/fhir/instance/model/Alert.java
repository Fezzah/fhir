package org.hl7.fhir.instance.model;

/*
  Copyright (c) 2011-2013, HL7, Inc.
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

// Generated on Fri, Jun 7, 2013 00:21+1000 for FHIR v0.09

/**
 * Prospective warnings of things that should be taken notice of when providing care to the patient
 */
public class Alert extends Resource {

    public enum AlertStatus {
        active, // A current alert that should be displayed to a user. A system may use the category to determine whoch roles should view the alert
        inactive, // The alert does not need to be displayed any more
        error, // The alert was added in error, and should no longer be displayed
        Null; // added to help the parsers
        public static AlertStatus fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return active;
        if ("inactive".equals(codeString))
          return inactive;
        if ("error".equals(codeString))
          return error;
        throw new Exception("Unknown AlertStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case active: return "active";
            case inactive: return "inactive";
            case error: return "error";
            default: return "?";
          }
        }
    }

  public class AlertStatusEnumFactory implements EnumFactory {
    public Enum<?> fromCode(String codeString) throws Exception {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return AlertStatus.active;
        if ("inactive".equals(codeString))
          return AlertStatus.inactive;
        if ("error".equals(codeString))
          return AlertStatus.error;
        throw new Exception("Unknown AlertStatus code '"+codeString+"'");
        }
    public String toCode(Enum<?> code) throws Exception {
      if (code == AlertStatus.active)
        return "active";
      if (code == AlertStatus.inactive)
        return "inactive";
      if (code == AlertStatus.error)
        return "error";
      return "?";
      }
    }

    /**
     * Allows an alert to be divided int different categories like clinical, administartive etc.
     */
    private CodeableConcept category;

    /**
     * Supports basic workflow
     */
    private Enumeration<AlertStatus> status;

    /**
     * The person who this alert concerns
     */
    private ResourceReference subject;

    /**
     * The person or device that created the alert
     */
    private ResourceReference author;

    /**
     * The textual component of the alert to display to the user
     */
    private String_ note;

    public CodeableConcept getCategory() { 
      return this.category;
    }

    public void setCategory(CodeableConcept value) { 
      this.category = value;
    }

    public Enumeration<AlertStatus> getStatus() { 
      return this.status;
    }

    public void setStatus(Enumeration<AlertStatus> value) { 
      this.status = value;
    }

    public AlertStatus getStatusSimple() { 
      return this.status == null ? null : this.status.getValue();
    }

    public void setStatusSimple(AlertStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<AlertStatus>();
        this.status.setValue(value);
    }

    public ResourceReference getSubject() { 
      return this.subject;
    }

    public void setSubject(ResourceReference value) { 
      this.subject = value;
    }

    public ResourceReference getAuthor() { 
      return this.author;
    }

    public void setAuthor(ResourceReference value) { 
      this.author = value;
    }

    public String_ getNote() { 
      return this.note;
    }

    public void setNote(String_ value) { 
      this.note = value;
    }

    public String getNoteSimple() { 
      return this.note == null ? null : this.note.getValue();
    }

    public void setNoteSimple(String value) { 
        if (this.note == null)
          this.note = new String_();
        this.note.setValue(value);
    }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Alert;
   }


}

