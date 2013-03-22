package org.hl7.fhir.definitions.validation;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.ResourceDefn;
import org.hl7.fhir.definitions.parsers.TypeParser;
import org.hl7.fhir.instance.model.Profile;
import org.hl7.fhir.instance.model.Profile.Constraint;
import org.hl7.fhir.instance.model.Profile.Element_;
import org.hl7.fhir.instance.model.Profile.Type;

/**
 * Given a candidate profile, and the actual base profile for a resource, check that the candidate is valid.
 * 
 * Note that this is only appropriate for use during the build process. For a general purpose profile validator,
 * see org.hl7.fhir.instance.validation
 * 
 * Rules for 
 * @author Grahame
 *
 */
public class ProfileValidator {

  public class TypeState {
    private String prefix;
    private Profile.Constraint type;
    public TypeState(String prefix, Constraint type) {
      super();
      this.prefix = prefix;
      this.type = type;
    }
    public String getPrefix() {
      return prefix;
    }
    public Profile.Constraint getType() {
      return type;
    }

  }

  private Map<Profile.Element_, ArrayList<ElementDefn>> map = new HashMap<Profile.Element_, ArrayList<ElementDefn>>();
  
  private ResourceDefn candidate;
  private Profile profile;
  private Profile types;
  private ArrayList<String> errors;

  private Stack<TypeState> typePoints = new Stack<ProfileValidator.TypeState>();

  public void setCandidate(ResourceDefn candidate) {
    this.candidate = candidate; 
  }

  public void setProfile(Profile profile) {
    this.profile = profile;
  }

  
  public Profile getTypes() {
    return types;
  }

  public void setTypes(Profile types) {
    this.types = types;
  }

  public List<String> evaluate() throws Exception {
    map.clear();
    errors = new ArrayList<String>();
     if (candidate == null)
       errors.add("no base resource provided");
     else if (profile == null) 
       errors.add("no profile provided");
     else {
       // what we need to do is map the profile definitions against the resource
       // first, we check the stated names against the resource names, and map to the backbone
       matchElement(candidate, null, candidate.getRoot(), candidate.getName());
       
       // now, we run through the resource, adding anything that the profile omitted back to the profile
       // (because profiles are open)
       fillOutElement(candidate.getRoot(), candidate.getName());
       
       // then we walk the profile checking that the constraints are valid
       inspectConstraints(candidate, candidate.getName());

       // finally, we walk the resource ensuring that anything that is mandatory is not constrained out in the profile
     }
    return errors;
  }

  private void fillOutElement(ElementDefn profileElement, String path) {
    int i = 0;
    for (Element_ e : collectChildren(path)) {
      ElementDefn m = null;
      String tn = terminalName(e);
      if (i < profileElement.getElements().size()) {
        m = profileElement.getElements().get(i);
        String mn = m.getName();
//        if (mn.contains("[x]") || tn.contains("[x]"))
//          System.out.println("Unsure how to compare mn and tn: '"+mn+"' / '"+tn+"'");
        if (!mn.equals(tn) && !(tn.contains("[x]") && mn.substring(0, tn.indexOf("[x]")).equals(tn.substring(0, tn.indexOf("[x]"))))) {
          m = null;
        }
      }
      if (m == null) {
        ElementDefn n = new ElementDefn();
        filloutElementDefn(n, e);
        profileElement.getElements().add(i, n);
      }
      else
        fillOutElement(m, path+"."+m.getName());
      i++;
      while (m != null && i < profileElement.getElements().size()) {
        m = profileElement.getElements().get(i);
        String mn = m.getName();
        if (!mn.equals(tn)) 
          m = null;
        else
          i++;
      } 
    }
  }

  private String terminalName(Element_ e) {
    String res = e.getPath().getValue().substring(e.getPath().getValue().lastIndexOf(".")+1);
    return res;
  }

  private List<Element_> collectChildren(String path) {
    List<Element_> results = new ArrayList<Element_>();
    for (Element_ r : profile.getConstraint().get(0).getElement())
      if (r.getPath().getValue().startsWith(path+".") && !r.getPath().getValue().substring(path.length()+1).contains(".")) 
        results.add(r);
    return results;
  }
  
  private void filloutElementDefn(ElementDefn n, Element_ e) {
    n.setName(terminalName(e));
    n.setInherited(true);
    n.setComments(e.getDefinition().getComments() == null ? null : e.getDefinition().getComments().getValue());
    n.setBindingName(e.getDefinition().getBinding() == null ? null : e.getDefinition().getBinding().getValue());
    n.setShortDefn(e.getDefinition().getShort().getValue());
    n.setDefinition(e.getDefinition().getFormal().getValue());
    n.setMaxCardinality("*".equals(e.getDefinition().getMax().getValue()) ? null : Integer.parseInt(e.getDefinition().getMax().getValue()));
    n.setMinCardinality(e.getDefinition().getMin().getValue());
    n.setMustUnderstand(e.getDefinition().getMustSupport() == null ? false : e.getDefinition().getMustSupport().getValue());
    for (Type t : e.getDefinition().getType()) {
      TypeParser tp = new TypeParser();
      try {
        n.getTypes().addAll(tp.parse(t.getCode().getValue()));
      } catch (Exception ex) {
        errors.add("invalid type "+t+" on "+e.getPath()+" in underlying resource definition");
      }
    }
//    n.getTypes().addAll(e.gett)
//  todo
//    n.setRimMapping(e.get);
//    n.setV2Mapping(e.get);
    for (Element_ c : collectChildren(e.getPath().getValue())) {
      ElementDefn nc = new ElementDefn();
      filloutElementDefn(nc, c);
      n.getElements().add(nc);
    }
////    todo: children
  }

  
  private void inspectConstraints(ResourceDefn profile2, String name) {
    
    
  }

  private void matchElement(ResourceDefn resource, ElementDefn parent, ElementDefn element, String path) throws Exception {
    Element_ e = getConstraintByPath(path);
    boolean xPoint = false;
    if (e == null && parent != null && hasTypeProfile(parent.typeCode())) {
      typePoints.push(new TypeState(path.substring(0, path.lastIndexOf(".")), getTypeProfile(parent.typeCode())));
      xPoint = true;
      e = getConstraintByPath(path);
    }
    
    if (e == null)
      errors.add("Profile element '"+path+"' not found");
    else {
      element.setDerivation(e);
      completeFromDerivation(element, e);
      ArrayList<ElementDefn> a;
      if (map.containsKey(e))
        a = map.get(e);
      else {
        a = new ArrayList<ElementDefn>();
        map.put(e, a);
      }
      a.add(element);
    }
    for (ElementDefn c : element.getElements()) {
      matchElement(resource, element, c, path+"."+c.getName());
    }
    if (xPoint) {
      typePoints.pop();
    }
  }

  private Constraint getTypeProfile(String type) {
    for (Constraint p : types.getConstraint()) {
      if (p.getType().getValue().equals(type))
        return p;
    }
    return null;
  }

  private boolean hasTypeProfile(String type) {
    for (Constraint p : types.getConstraint()) {
      if (p.getType().getValue().equals(type))
        return true;
    }
    return false;
  }

  private void completeFromDerivation(ElementDefn target, Element_ source) {
    if (!target.hasComments())
      target.setComments(source.getDefinition().getComments() == null ? null : source.getDefinition().getComments().getValue());
    if (!target.hasBindingName())
      target.setBindingName(source.getDefinition().getBinding() == null ? null : source.getDefinition().getBinding().getValue());
    if (!target.hasShortDefn())
      target.setShortDefn(source.getDefinition().getShort().getValue());
    if (!target.hasDefinition())
      target.setDefinition(source.getDefinition().getFormal().getValue());    
  }

  private Element_ getConstraintByPath(String path) {
    if (typePoints.empty()) {
      for (Element_ e : profile.getConstraint().get(0).getElement()) {
        String p = e.getPath().getValue();
        if (p.equals(path) || (p.endsWith("[x]") && path.length() > p.length() && p.substring(0, p.length()-3).equals(path.substring(0, p.length()-3)) && isType(path.substring(p.length()-3))))
          return e;
      }
    } else {
      for (Element_ e : typePoints.firstElement().getType().getElement()) {
        if (e.getPath().getValue().contains(".")) { // skip the first one
          String p = typePoints.firstElement().getPrefix()+"."+e.getPath().getValue().substring(e.getPath().getValue().indexOf(".")+1);
          if (p.equals(path) || (p.endsWith("[x]") && path.length() > p.length() && p.substring(0, p.length()-3).equals(path.substring(0, p.length()-3)) && isType(path.substring(p.length()-3))))
            return e;
        }        
      }
    }
    return null;
  }

  private boolean isType(String t) {
    if (hasTypeProfile(t))
      return true;
    if (t.equals("Boolean") || t.equals("Integer") || t.equals("Decimal") || t.equals("Base64Binary") || t.equals("Instant") ||
        t.equals("String") || t.equals("Uri") || t.equals("Date") || t.equals("DateTime") || t.equals("Oid") || t.equals("Uuid") || t.equals("Code") || t.equals("Id"))
      return true;
    return false;
  }

}
