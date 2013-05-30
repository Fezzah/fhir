package org.hl7.fhir.instance.formats;

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

// Generated on Thu, May 30, 2013 06:48+1000 for FHIR v0.09

import org.hl7.fhir.instance.model.Integer;
import org.hl7.fhir.instance.model.DateTime;
import org.hl7.fhir.instance.model.Code;
import org.hl7.fhir.instance.model.Date;
import org.hl7.fhir.instance.model.Decimal;
import org.hl7.fhir.instance.model.Uri;
import org.hl7.fhir.instance.model.Id;
import org.hl7.fhir.instance.model.Base64Binary;
import org.hl7.fhir.instance.model.Oid;
import org.hl7.fhir.instance.model.String_;
import org.hl7.fhir.instance.model.Boolean;
import org.hl7.fhir.instance.model.Uuid;
import org.hl7.fhir.instance.model.Instant;
import org.hl7.fhir.instance.model.*;
import org.json.JSONObject;
import org.json.JSONArray;

public class JsonParser extends JsonParserBase {

  protected void parseElementProperties(JSONObject json, Element element) throws Exception {
    super.parseElementProperties(json, element);
    if (json.has("extension")) {
      JSONArray array = json.getJSONArray("extension");
      for (int i = 0; i < array.length(); i++) {
        element.getExtensions().add(parseExtension(array.getJSONObject(i)));
      }
    };
  }

  protected void parseTypeProperties(JSONObject json, Element element) throws Exception {
    parseElementProperties(json, element);
  }

  @SuppressWarnings("unchecked")
  private <E extends Enum<E>> Enumeration<E> parseEnumeration(JSONObject json, E item, EnumFactory e) throws Exception {
    Enumeration<E> res = new Enumeration<E>();
    parseElementProperties(json, res);
    if (json.has("value"))
    res.setValue((E) e.fromCode(json.getString("value")));
    return res;
  }

  private Integer parseInteger(JSONObject json) throws Exception {
    Integer res = new Integer();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseIntegerPrimitive(json.getString("value")));
    return res;
  }

  private DateTime parseDateTime(JSONObject json) throws Exception {
    DateTime res = new DateTime();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseDateTimePrimitive(json.getString("value")));
    return res;
  }

  private Code parseCode(JSONObject json) throws Exception {
    Code res = new Code();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseCodePrimitive(json.getString("value")));
    return res;
  }

  private Date parseDate(JSONObject json) throws Exception {
    Date res = new Date();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseDatePrimitive(json.getString("value")));
    return res;
  }

  private Decimal parseDecimal(JSONObject json) throws Exception {
    Decimal res = new Decimal();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseDecimalPrimitive(json.getString("value")));
    return res;
  }

  private Uri parseUri(JSONObject json) throws Exception {
    Uri res = new Uri();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseUriPrimitive(json.getString("value")));
    return res;
  }

  private Id parseId(JSONObject json) throws Exception {
    Id res = new Id();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseIdPrimitive(json.getString("value")));
    return res;
  }

  private Base64Binary parseBase64Binary(JSONObject json) throws Exception {
    Base64Binary res = new Base64Binary();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseBase64BinaryPrimitive(json.getString("value")));
    return res;
  }

  private Oid parseOid(JSONObject json) throws Exception {
    Oid res = new Oid();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseOidPrimitive(json.getString("value")));
    return res;
  }

  private String_ parseString(JSONObject json) throws Exception {
    String_ res = new String_();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseStringPrimitive(json.getString("value")));
    return res;
  }

  private Boolean parseBoolean(JSONObject json) throws Exception {
    Boolean res = new Boolean();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseBooleanPrimitive(json.getString("value")));
    return res;
  }

  private Uuid parseUuid(JSONObject json) throws Exception {
    Uuid res = new Uuid();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseUuidPrimitive(json.getString("value")));
    return res;
  }

  private Instant parseInstant(JSONObject json) throws Exception {
    Instant res = new Instant();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseInstantPrimitive(json.getString("value")));
    return res;
  }

  private Extension parseExtension(JSONObject json) throws Exception {
    Extension res = new Extension();
    parseElementProperties(json, res);
    if (json.has("url"))
      res.setUrl(parseUri(json.getJSONObject("url")));
    if (json.has("isModifier"))
      res.setIsModifier(parseBoolean(json.getJSONObject("isModifier")));
    Type value = parseType("value", json);
    if (value != null)
      res.setValue(value);
    if (json.has("extension")) {
      JSONArray array = json.getJSONArray("extension");
      for (int i = 0; i < array.length(); i++) {
        res.getExtension().add(parseExtension(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private Narrative parseNarrative(JSONObject json) throws Exception {
    Narrative res = new Narrative();
    parseElementProperties(json, res);
    if (json.has("status"))
      res.setStatus(parseEnumeration(json.getJSONObject("status"), Narrative.NarrativeStatus.Null, new Narrative().new NarrativeStatusEnumFactory()));
    if (json.has("div"))
      res.setDiv(parseXhtml(json.getString("div")));
    if (json.has("blob")) {
      JSONArray array = json.getJSONArray("blob");
      for (int i = 0; i < array.length(); i++) {
        res.getBlob().add(parseNarrativeNarrativeBlobComponent(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private Narrative.NarrativeBlobComponent parseNarrativeNarrativeBlobComponent(JSONObject json, Narrative owner) throws Exception {
    Narrative.NarrativeBlobComponent res = owner.new NarrativeBlobComponent();
    parseElementProperties(json, res);
    if (json.has("mimeType"))
      res.setMimeType(parseCode(json.getJSONObject("mimeType")));
    if (json.has("content"))
      res.setContent(parseBase64Binary(json.getJSONObject("content")));
    return res;
  }

  private Period parsePeriod(JSONObject json) throws Exception {
    Period res = new Period();
    parseTypeProperties(json, res);
    if (json.has("start"))
      res.setStart(parseDateTime(json.getJSONObject("start")));
    if (json.has("end"))
      res.setEnd(parseDateTime(json.getJSONObject("end")));
    return res;
  }

  private Coding parseCoding(JSONObject json) throws Exception {
    Coding res = new Coding();
    parseTypeProperties(json, res);
    if (json.has("system"))
      res.setSystem(parseUri(json.getJSONObject("system")));
    if (json.has("code"))
      res.setCode(parseCode(json.getJSONObject("code")));
    if (json.has("display"))
      res.setDisplay(parseString(json.getJSONObject("display")));
    return res;
  }

  private Range parseRange(JSONObject json) throws Exception {
    Range res = new Range();
    parseTypeProperties(json, res);
    if (json.has("low"))
      res.setLow(parseQuantity(json.getJSONObject("low")));
    if (json.has("high"))
      res.setHigh(parseQuantity(json.getJSONObject("high")));
    return res;
  }

  private Quantity parseQuantity(JSONObject json) throws Exception {
    Quantity res = new Quantity();
    parseTypeProperties(json, res);
    if (json.has("value"))
      res.setValue(parseDecimal(json.getJSONObject("value")));
    if (json.has("comparator"))
      res.setComparator(parseEnumeration(json.getJSONObject("comparator"), Quantity.QuantityComparator.Null, new Quantity().new QuantityComparatorEnumFactory()));
    if (json.has("units"))
      res.setUnits(parseString(json.getJSONObject("units")));
    if (json.has("system"))
      res.setSystem(parseUri(json.getJSONObject("system")));
    if (json.has("code"))
      res.setCode(parseCode(json.getJSONObject("code")));
    return res;
  }

  private Choice parseChoice(JSONObject json) throws Exception {
    Choice res = new Choice();
    parseTypeProperties(json, res);
    if (json.has("code"))
      res.setCode(parseCode(json.getJSONObject("code")));
    if (json.has("option")) {
      JSONArray array = json.getJSONArray("option");
      for (int i = 0; i < array.length(); i++) {
        res.getOption().add(parseChoiceChoiceOptionComponent(array.getJSONObject(i), res));
      }
    };
    if (json.has("isOrdered"))
      res.setIsOrdered(parseBoolean(json.getJSONObject("isOrdered")));
    return res;
  }

  private Choice.ChoiceOptionComponent parseChoiceChoiceOptionComponent(JSONObject json, Choice owner) throws Exception {
    Choice.ChoiceOptionComponent res = owner.new ChoiceOptionComponent();
    parseElementProperties(json, res);
    if (json.has("code"))
      res.setCode(parseCode(json.getJSONObject("code")));
    if (json.has("display"))
      res.setDisplay(parseString(json.getJSONObject("display")));
    return res;
  }

  private Attachment parseAttachment(JSONObject json) throws Exception {
    Attachment res = new Attachment();
    parseTypeProperties(json, res);
    if (json.has("contentType"))
      res.setContentType(parseCode(json.getJSONObject("contentType")));
    if (json.has("language"))
      res.setLanguage(parseCode(json.getJSONObject("language")));
    if (json.has("data"))
      res.setData(parseBase64Binary(json.getJSONObject("data")));
    if (json.has("url"))
      res.setUrl(parseUri(json.getJSONObject("url")));
    if (json.has("size"))
      res.setSize(parseInteger(json.getJSONObject("size")));
    if (json.has("hash"))
      res.setHash(parseBase64Binary(json.getJSONObject("hash")));
    if (json.has("title"))
      res.setTitle(parseString(json.getJSONObject("title")));
    return res;
  }

  private Ratio parseRatio(JSONObject json) throws Exception {
    Ratio res = new Ratio();
    parseTypeProperties(json, res);
    if (json.has("numerator"))
      res.setNumerator(parseQuantity(json.getJSONObject("numerator")));
    if (json.has("denominator"))
      res.setDenominator(parseQuantity(json.getJSONObject("denominator")));
    return res;
  }

  private Array parseArray(JSONObject json) throws Exception {
    Array res = new Array();
    parseTypeProperties(json, res);
    if (json.has("origin"))
      res.setOrigin(parseQuantity(json.getJSONObject("origin")));
    if (json.has("period"))
      res.setPeriod(parseDecimal(json.getJSONObject("period")));
    if (json.has("factor"))
      res.setFactor(parseDecimal(json.getJSONObject("factor")));
    if (json.has("lowerLimit"))
      res.setLowerLimit(parseDecimal(json.getJSONObject("lowerLimit")));
    if (json.has("upperLimit"))
      res.setUpperLimit(parseDecimal(json.getJSONObject("upperLimit")));
    if (json.has("dimensions"))
      res.setDimensions(parseInteger(json.getJSONObject("dimensions")));
    if (json.has("data"))
      res.setData(parseString(json.getJSONObject("data")));
    return res;
  }

  private ResourceReference parseResourceReference(JSONObject json) throws Exception {
    ResourceReference res = new ResourceReference();
    parseTypeProperties(json, res);
    if (json.has("type"))
      res.setType(parseCode(json.getJSONObject("type")));
    if (json.has("reference"))
      res.setReference(parseString(json.getJSONObject("reference")));
    if (json.has("display"))
      res.setDisplay(parseString(json.getJSONObject("display")));
    return res;
  }

  private CodeableConcept parseCodeableConcept(JSONObject json) throws Exception {
    CodeableConcept res = new CodeableConcept();
    parseTypeProperties(json, res);
    if (json.has("coding")) {
      JSONArray array = json.getJSONArray("coding");
      for (int i = 0; i < array.length(); i++) {
        res.getCoding().add(parseCoding(array.getJSONObject(i)));
      }
    };
    if (json.has("text"))
      res.setText(parseString(json.getJSONObject("text")));
    if (json.has("primary"))
      res.setPrimary(parseString(json.getJSONObject("primary")));
    return res;
  }

  private Identifier parseIdentifier(JSONObject json) throws Exception {
    Identifier res = new Identifier();
    parseTypeProperties(json, res);
    if (json.has("use"))
      res.setUse(parseEnumeration(json.getJSONObject("use"), Identifier.IdentifierUse.Null, new Identifier().new IdentifierUseEnumFactory()));
    if (json.has("label"))
      res.setLabel(parseString(json.getJSONObject("label")));
    if (json.has("system"))
      res.setSystem(parseUri(json.getJSONObject("system")));
    if (json.has("key"))
      res.setKey(parseString(json.getJSONObject("key")));
    if (json.has("period"))
      res.setPeriod(parsePeriod(json.getJSONObject("period")));
    if (json.has("assigner"))
      res.setAssigner(parseResourceReference(json.getJSONObject("assigner")));
    return res;
  }

  private Age parseAge(JSONObject json) throws Exception {
    Age res = new Age();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseDecimal(json.getJSONObject("value")));
    if (json.has("comparator"))
      res.setComparator(parseEnumeration(json.getJSONObject("comparator"), Quantity.QuantityComparator.Null, new Quantity().new QuantityComparatorEnumFactory()));
    if (json.has("units"))
      res.setUnits(parseString(json.getJSONObject("units")));
    if (json.has("system"))
      res.setSystem(parseUri(json.getJSONObject("system")));
    if (json.has("code"))
      res.setCode(parseCode(json.getJSONObject("code")));
    return res;
  }

  private Count parseCount(JSONObject json) throws Exception {
    Count res = new Count();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseDecimal(json.getJSONObject("value")));
    if (json.has("comparator"))
      res.setComparator(parseEnumeration(json.getJSONObject("comparator"), Quantity.QuantityComparator.Null, new Quantity().new QuantityComparatorEnumFactory()));
    if (json.has("units"))
      res.setUnits(parseString(json.getJSONObject("units")));
    if (json.has("system"))
      res.setSystem(parseUri(json.getJSONObject("system")));
    if (json.has("code"))
      res.setCode(parseCode(json.getJSONObject("code")));
    return res;
  }

  private Money parseMoney(JSONObject json) throws Exception {
    Money res = new Money();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseDecimal(json.getJSONObject("value")));
    if (json.has("comparator"))
      res.setComparator(parseEnumeration(json.getJSONObject("comparator"), Quantity.QuantityComparator.Null, new Quantity().new QuantityComparatorEnumFactory()));
    if (json.has("units"))
      res.setUnits(parseString(json.getJSONObject("units")));
    if (json.has("system"))
      res.setSystem(parseUri(json.getJSONObject("system")));
    if (json.has("code"))
      res.setCode(parseCode(json.getJSONObject("code")));
    return res;
  }

  private Distance parseDistance(JSONObject json) throws Exception {
    Distance res = new Distance();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseDecimal(json.getJSONObject("value")));
    if (json.has("comparator"))
      res.setComparator(parseEnumeration(json.getJSONObject("comparator"), Quantity.QuantityComparator.Null, new Quantity().new QuantityComparatorEnumFactory()));
    if (json.has("units"))
      res.setUnits(parseString(json.getJSONObject("units")));
    if (json.has("system"))
      res.setSystem(parseUri(json.getJSONObject("system")));
    if (json.has("code"))
      res.setCode(parseCode(json.getJSONObject("code")));
    return res;
  }

  private Duration parseDuration(JSONObject json) throws Exception {
    Duration res = new Duration();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseDecimal(json.getJSONObject("value")));
    if (json.has("comparator"))
      res.setComparator(parseEnumeration(json.getJSONObject("comparator"), Quantity.QuantityComparator.Null, new Quantity().new QuantityComparatorEnumFactory()));
    if (json.has("units"))
      res.setUnits(parseString(json.getJSONObject("units")));
    if (json.has("system"))
      res.setSystem(parseUri(json.getJSONObject("system")));
    if (json.has("code"))
      res.setCode(parseCode(json.getJSONObject("code")));
    return res;
  }

  private Schedule parseSchedule(JSONObject json) throws Exception {
    Schedule res = new Schedule();
    parseElementProperties(json, res);
    if (json.has("event")) {
      JSONArray array = json.getJSONArray("event");
      for (int i = 0; i < array.length(); i++) {
        res.getEvent().add(parsePeriod(array.getJSONObject(i)));
      }
    };
    if (json.has("repeat"))
      res.setRepeat(parseScheduleScheduleRepeatComponent(json.getJSONObject("repeat"), res));
    return res;
  }

  private Schedule.ScheduleRepeatComponent parseScheduleScheduleRepeatComponent(JSONObject json, Schedule owner) throws Exception {
    Schedule.ScheduleRepeatComponent res = owner.new ScheduleRepeatComponent();
    parseElementProperties(json, res);
    if (json.has("frequency"))
      res.setFrequency(parseInteger(json.getJSONObject("frequency")));
    if (json.has("when"))
      res.setWhen(parseEnumeration(json.getJSONObject("when"), Schedule.EventTiming.Null, new Schedule().new EventTimingEnumFactory()));
    if (json.has("duration"))
      res.setDuration(parseDecimal(json.getJSONObject("duration")));
    if (json.has("units"))
      res.setUnits(parseEnumeration(json.getJSONObject("units"), Schedule.UnitsOfTime.Null, new Schedule().new UnitsOfTimeEnumFactory()));
    if (json.has("count"))
      res.setCount(parseInteger(json.getJSONObject("count")));
    if (json.has("end"))
      res.setEnd(parseDateTime(json.getJSONObject("end")));
    return res;
  }

  private Contact parseContact(JSONObject json) throws Exception {
    Contact res = new Contact();
    parseElementProperties(json, res);
    if (json.has("system"))
      res.setSystem(parseEnumeration(json.getJSONObject("system"), Contact.ContactSystem.Null, new Contact().new ContactSystemEnumFactory()));
    if (json.has("value"))
      res.setValue(parseString(json.getJSONObject("value")));
    if (json.has("use"))
      res.setUse(parseEnumeration(json.getJSONObject("use"), Contact.ContactUse.Null, new Contact().new ContactUseEnumFactory()));
    if (json.has("period"))
      res.setPeriod(parsePeriod(json.getJSONObject("period")));
    return res;
  }

  private Address parseAddress(JSONObject json) throws Exception {
    Address res = new Address();
    parseElementProperties(json, res);
    if (json.has("use"))
      res.setUse(parseEnumeration(json.getJSONObject("use"), Address.AddressUse.Null, new Address().new AddressUseEnumFactory()));
    if (json.has("text"))
      res.setText(parseString(json.getJSONObject("text")));
    if (json.has("line")) {
      JSONArray array = json.getJSONArray("line");
      for (int i = 0; i < array.length(); i++) {
        res.getLine().add(parseString(array.getJSONObject(i)));
      }
    };
    if (json.has("city"))
      res.setCity(parseString(json.getJSONObject("city")));
    if (json.has("state"))
      res.setState(parseString(json.getJSONObject("state")));
    if (json.has("zip"))
      res.setZip(parseString(json.getJSONObject("zip")));
    if (json.has("country"))
      res.setCountry(parseString(json.getJSONObject("country")));
    if (json.has("period"))
      res.setPeriod(parsePeriod(json.getJSONObject("period")));
    return res;
  }

  private HumanName parseHumanName(JSONObject json) throws Exception {
    HumanName res = new HumanName();
    parseElementProperties(json, res);
    if (json.has("use"))
      res.setUse(parseEnumeration(json.getJSONObject("use"), HumanName.NameUse.Null, new HumanName().new NameUseEnumFactory()));
    if (json.has("text"))
      res.setText(parseString(json.getJSONObject("text")));
    if (json.has("family")) {
      JSONArray array = json.getJSONArray("family");
      for (int i = 0; i < array.length(); i++) {
        res.getFamily().add(parseString(array.getJSONObject(i)));
      }
    };
    if (json.has("given")) {
      JSONArray array = json.getJSONArray("given");
      for (int i = 0; i < array.length(); i++) {
        res.getGiven().add(parseString(array.getJSONObject(i)));
      }
    };
    if (json.has("prefix")) {
      JSONArray array = json.getJSONArray("prefix");
      for (int i = 0; i < array.length(); i++) {
        res.getPrefix().add(parseString(array.getJSONObject(i)));
      }
    };
    if (json.has("suffix")) {
      JSONArray array = json.getJSONArray("suffix");
      for (int i = 0; i < array.length(); i++) {
        res.getSuffix().add(parseString(array.getJSONObject(i)));
      }
    };
    if (json.has("period"))
      res.setPeriod(parsePeriod(json.getJSONObject("period")));
    return res;
  }

  private ActivityDefinition parseActivityDefinition(JSONObject json) throws Exception {
    ActivityDefinition res = new ActivityDefinition();
    parseElementProperties(json, res);
    if (json.has("category"))
      res.setCategory(parseEnumeration(json.getJSONObject("category"), ActivityDefinition.ActivityDefinitionCategory.Null, new ActivityDefinition().new ActivityDefinitionCategoryEnumFactory()));
    if (json.has("code"))
      res.setCode(parseCodeableConcept(json.getJSONObject("code")));
    Type timing = parseType("timing", json);
    if (timing != null)
      res.setTiming(timing);
    if (json.has("location"))
      res.setLocation(parseResourceReference(json.getJSONObject("location")));
    if (json.has("performer")) {
      JSONArray array = json.getJSONArray("performer");
      for (int i = 0; i < array.length(); i++) {
        res.getPerformer().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    if (json.has("product"))
      res.setProduct(parseResourceReference(json.getJSONObject("product")));
    if (json.has("quantity"))
      res.setQuantity(parseQuantity(json.getJSONObject("quantity")));
    if (json.has("details"))
      res.setDetails(parseString(json.getJSONObject("details")));
    return res;
  }

  private Demographics parseDemographics(JSONObject json) throws Exception {
    Demographics res = new Demographics();
    parseElementProperties(json, res);
    if (json.has("identifier")) {
      JSONArray array = json.getJSONArray("identifier");
      for (int i = 0; i < array.length(); i++) {
        res.getIdentifier().add(parseIdentifier(array.getJSONObject(i)));
      }
    };
    if (json.has("name")) {
      JSONArray array = json.getJSONArray("name");
      for (int i = 0; i < array.length(); i++) {
        res.getName().add(parseHumanName(array.getJSONObject(i)));
      }
    };
    if (json.has("telecom")) {
      JSONArray array = json.getJSONArray("telecom");
      for (int i = 0; i < array.length(); i++) {
        res.getTelecom().add(parseContact(array.getJSONObject(i)));
      }
    };
    if (json.has("gender"))
      res.setGender(parseCoding(json.getJSONObject("gender")));
    if (json.has("birthDate"))
      res.setBirthDate(parseDateTime(json.getJSONObject("birthDate")));
    if (json.has("deceased"))
      res.setDeceased(parseBoolean(json.getJSONObject("deceased")));
    if (json.has("address")) {
      JSONArray array = json.getJSONArray("address");
      for (int i = 0; i < array.length(); i++) {
        res.getAddress().add(parseAddress(array.getJSONObject(i)));
      }
    };
    if (json.has("photo")) {
      JSONArray array = json.getJSONArray("photo");
      for (int i = 0; i < array.length(); i++) {
        res.getPhoto().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    if (json.has("maritalStatus"))
      res.setMaritalStatus(parseCodeableConcept(json.getJSONObject("maritalStatus")));
    if (json.has("language")) {
      JSONArray array = json.getJSONArray("language");
      for (int i = 0; i < array.length(); i++) {
        res.getLanguage().add(parseDemographicsDemographicsLanguageComponent(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private Demographics.DemographicsLanguageComponent parseDemographicsDemographicsLanguageComponent(JSONObject json, Demographics owner) throws Exception {
    Demographics.DemographicsLanguageComponent res = owner.new DemographicsLanguageComponent();
    parseElementProperties(json, res);
    if (json.has("language"))
      res.setLanguage(parseCodeableConcept(json.getJSONObject("language")));
    if (json.has("mode"))
      res.setMode(parseCodeableConcept(json.getJSONObject("mode")));
    if (json.has("proficiencyLevel"))
      res.setProficiencyLevel(parseCodeableConcept(json.getJSONObject("proficiencyLevel")));
    if (json.has("preference"))
      res.setPreference(parseBoolean(json.getJSONObject("preference")));
    return res;
  }

  protected void parseResourceProperties(JSONObject json, Resource res) throws Exception {
    parseElementProperties(json, res); 
    if (json.has("language"))
      res.setLanguage(parseCode(json.getJSONObject("language")));
    if (json.has("text"))
      res.setText(parseNarrative(json.getJSONObject("text")));
    if (json.has("contained")) {
      JSONArray array = json.getJSONArray("contained");
      for (int i = 0; i < array.length(); i++) {
        res.getContained().add(parseResource(array.getJSONObject(i)));
      }
    };
  }

  private AdverseReaction parseAdverseReaction(JSONObject json) throws Exception {
    AdverseReaction res = new AdverseReaction();
    parseResourceProperties(json, res);
    if (json.has("reactionDate"))
      res.setReactionDate(parseDateTime(json.getJSONObject("reactionDate")));
    if (json.has("subject"))
      res.setSubject(parseResourceReference(json.getJSONObject("subject")));
    if (json.has("didNotOccurFlag"))
      res.setDidNotOccurFlag(parseBoolean(json.getJSONObject("didNotOccurFlag")));
    if (json.has("recorder"))
      res.setRecorder(parseResourceReference(json.getJSONObject("recorder")));
    if (json.has("symptom")) {
      JSONArray array = json.getJSONArray("symptom");
      for (int i = 0; i < array.length(); i++) {
        res.getSymptom().add(parseAdverseReactionAdverseReactionSymptomComponent(array.getJSONObject(i), res));
      }
    };
    if (json.has("exposure")) {
      JSONArray array = json.getJSONArray("exposure");
      for (int i = 0; i < array.length(); i++) {
        res.getExposure().add(parseAdverseReactionAdverseReactionExposureComponent(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private AdverseReaction.AdverseReactionSymptomComponent parseAdverseReactionAdverseReactionSymptomComponent(JSONObject json, AdverseReaction owner) throws Exception {
    AdverseReaction.AdverseReactionSymptomComponent res = owner.new AdverseReactionSymptomComponent();
    parseElementProperties(json, res);
    if (json.has("code"))
      res.setCode(parseCodeableConcept(json.getJSONObject("code")));
    if (json.has("severity"))
      res.setSeverity(parseEnumeration(json.getJSONObject("severity"), AdverseReaction.ReactionSeverity.Null, new AdverseReaction().new ReactionSeverityEnumFactory()));
    return res;
  }

  private AdverseReaction.AdverseReactionExposureComponent parseAdverseReactionAdverseReactionExposureComponent(JSONObject json, AdverseReaction owner) throws Exception {
    AdverseReaction.AdverseReactionExposureComponent res = owner.new AdverseReactionExposureComponent();
    parseElementProperties(json, res);
    if (json.has("exposureDate"))
      res.setExposureDate(parseDateTime(json.getJSONObject("exposureDate")));
    if (json.has("exposureType"))
      res.setExposureType(parseEnumeration(json.getJSONObject("exposureType"), AdverseReaction.ExposureType.Null, new AdverseReaction().new ExposureTypeEnumFactory()));
    if (json.has("causalityExpectation"))
      res.setCausalityExpectation(parseEnumeration(json.getJSONObject("causalityExpectation"), AdverseReaction.CausalityExpectation.Null, new AdverseReaction().new CausalityExpectationEnumFactory()));
    if (json.has("substance"))
      res.setSubstance(parseResourceReference(json.getJSONObject("substance")));
    return res;
  }

  private Alert parseAlert(JSONObject json) throws Exception {
    Alert res = new Alert();
    parseResourceProperties(json, res);
    if (json.has("category"))
      res.setCategory(parseCodeableConcept(json.getJSONObject("category")));
    if (json.has("status"))
      res.setStatus(parseEnumeration(json.getJSONObject("status"), Alert.AlertStatus.Null, new Alert().new AlertStatusEnumFactory()));
    if (json.has("subject"))
      res.setSubject(parseResourceReference(json.getJSONObject("subject")));
    if (json.has("author"))
      res.setAuthor(parseResourceReference(json.getJSONObject("author")));
    if (json.has("dateRecorded"))
      res.setDateRecorded(parseDate(json.getJSONObject("dateRecorded")));
    if (json.has("note"))
      res.setNote(parseString(json.getJSONObject("note")));
    return res;
  }

  private AllergyIntolerance parseAllergyIntolerance(JSONObject json) throws Exception {
    AllergyIntolerance res = new AllergyIntolerance();
    parseResourceProperties(json, res);
    if (json.has("identifier"))
      res.setIdentifier(parseIdentifier(json.getJSONObject("identifier")));
    if (json.has("criticality"))
      res.setCriticality(parseEnumeration(json.getJSONObject("criticality"), AllergyIntolerance.Criticality.Null, new AllergyIntolerance().new CriticalityEnumFactory()));
    if (json.has("sensitivityType"))
      res.setSensitivityType(parseEnumeration(json.getJSONObject("sensitivityType"), AllergyIntolerance.Sensitivitytype.Null, new AllergyIntolerance().new SensitivitytypeEnumFactory()));
    if (json.has("recordedDate"))
      res.setRecordedDate(parseDateTime(json.getJSONObject("recordedDate")));
    if (json.has("status"))
      res.setStatus(parseEnumeration(json.getJSONObject("status"), AllergyIntolerance.Sensitivitystatus.Null, new AllergyIntolerance().new SensitivitystatusEnumFactory()));
    if (json.has("subject"))
      res.setSubject(parseResourceReference(json.getJSONObject("subject")));
    if (json.has("recorder"))
      res.setRecorder(parseResourceReference(json.getJSONObject("recorder")));
    if (json.has("substance"))
      res.setSubstance(parseResourceReference(json.getJSONObject("substance")));
    if (json.has("reactions")) {
      JSONArray array = json.getJSONArray("reactions");
      for (int i = 0; i < array.length(); i++) {
        res.getReactions().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    if (json.has("sensitivityTest")) {
      JSONArray array = json.getJSONArray("sensitivityTest");
      for (int i = 0; i < array.length(); i++) {
        res.getSensitivityTest().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private CarePlan parseCarePlan(JSONObject json) throws Exception {
    CarePlan res = new CarePlan();
    parseResourceProperties(json, res);
    if (json.has("identifier"))
      res.setIdentifier(parseIdentifier(json.getJSONObject("identifier")));
    if (json.has("patient"))
      res.setPatient(parseResourceReference(json.getJSONObject("patient")));
    if (json.has("status"))
      res.setStatus(parseEnumeration(json.getJSONObject("status"), CarePlan.CarePlanStatus.Null, new CarePlan().new CarePlanStatusEnumFactory()));
    if (json.has("period"))
      res.setPeriod(parsePeriod(json.getJSONObject("period")));
    if (json.has("modified"))
      res.setModified(parseDateTime(json.getJSONObject("modified")));
    if (json.has("concern")) {
      JSONArray array = json.getJSONArray("concern");
      for (int i = 0; i < array.length(); i++) {
        res.getConcern().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    if (json.has("participant")) {
      JSONArray array = json.getJSONArray("participant");
      for (int i = 0; i < array.length(); i++) {
        res.getParticipant().add(parseCarePlanCarePlanParticipantComponent(array.getJSONObject(i), res));
      }
    };
    if (json.has("goal")) {
      JSONArray array = json.getJSONArray("goal");
      for (int i = 0; i < array.length(); i++) {
        res.getGoal().add(parseCarePlanCarePlanGoalComponent(array.getJSONObject(i), res));
      }
    };
    if (json.has("activity")) {
      JSONArray array = json.getJSONArray("activity");
      for (int i = 0; i < array.length(); i++) {
        res.getActivity().add(parseCarePlanCarePlanActivityComponent(array.getJSONObject(i), res));
      }
    };
    if (json.has("notes"))
      res.setNotes(parseString(json.getJSONObject("notes")));
    return res;
  }

  private CarePlan.CarePlanParticipantComponent parseCarePlanCarePlanParticipantComponent(JSONObject json, CarePlan owner) throws Exception {
    CarePlan.CarePlanParticipantComponent res = owner.new CarePlanParticipantComponent();
    parseElementProperties(json, res);
    if (json.has("role"))
      res.setRole(parseCodeableConcept(json.getJSONObject("role")));
    if (json.has("member"))
      res.setMember(parseResourceReference(json.getJSONObject("member")));
    return res;
  }

  private CarePlan.CarePlanGoalComponent parseCarePlanCarePlanGoalComponent(JSONObject json, CarePlan owner) throws Exception {
    CarePlan.CarePlanGoalComponent res = owner.new CarePlanGoalComponent();
    parseElementProperties(json, res);
    if (json.has("description"))
      res.setDescription(parseString(json.getJSONObject("description")));
    if (json.has("status"))
      res.setStatus(parseEnumeration(json.getJSONObject("status"), CarePlan.CarePlanGoalStatus.Null, new CarePlan().new CarePlanGoalStatusEnumFactory()));
    if (json.has("notes"))
      res.setNotes(parseString(json.getJSONObject("notes")));
    return res;
  }

  private CarePlan.CarePlanActivityComponent parseCarePlanCarePlanActivityComponent(JSONObject json, CarePlan owner) throws Exception {
    CarePlan.CarePlanActivityComponent res = owner.new CarePlanActivityComponent();
    parseElementProperties(json, res);
    if (json.has("category"))
      res.setCategory(parseEnumeration(json.getJSONObject("category"), CarePlan.CarePlanActivityCategory.Null, new CarePlan().new CarePlanActivityCategoryEnumFactory()));
    if (json.has("code"))
      res.setCode(parseCodeableConcept(json.getJSONObject("code")));
    if (json.has("status"))
      res.setStatus(parseEnumeration(json.getJSONObject("status"), CarePlan.CarePlanActivityStatus.Null, new CarePlan().new CarePlanActivityStatusEnumFactory()));
    if (json.has("prohibited"))
      res.setProhibited(parseBoolean(json.getJSONObject("prohibited")));
    Type timing = parseType("timing", json);
    if (timing != null)
      res.setTiming(timing);
    if (json.has("location"))
      res.setLocation(parseResourceReference(json.getJSONObject("location")));
    if (json.has("performer")) {
      JSONArray array = json.getJSONArray("performer");
      for (int i = 0; i < array.length(); i++) {
        res.getPerformer().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    if (json.has("product"))
      res.setProduct(parseResourceReference(json.getJSONObject("product")));
    if (json.has("dailyAmount"))
      res.setDailyAmount(parseQuantity(json.getJSONObject("dailyAmount")));
    if (json.has("quantity"))
      res.setQuantity(parseQuantity(json.getJSONObject("quantity")));
    if (json.has("details"))
      res.setDetails(parseString(json.getJSONObject("details")));
    if (json.has("actionTaken")) {
      JSONArray array = json.getJSONArray("actionTaken");
      for (int i = 0; i < array.length(); i++) {
        res.getActionTaken().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    if (json.has("notes"))
      res.setNotes(parseString(json.getJSONObject("notes")));
    return res;
  }

  private Conformance parseConformance(JSONObject json) throws Exception {
    Conformance res = new Conformance();
    parseResourceProperties(json, res);
    if (json.has("identifier"))
      res.setIdentifier(parseString(json.getJSONObject("identifier")));
    if (json.has("version"))
      res.setVersion(parseString(json.getJSONObject("version")));
    if (json.has("date"))
      res.setDate(parseDateTime(json.getJSONObject("date")));
    if (json.has("publisher"))
      res.setPublisher(parseString(json.getJSONObject("publisher")));
    if (json.has("telecom")) {
      JSONArray array = json.getJSONArray("telecom");
      for (int i = 0; i < array.length(); i++) {
        res.getTelecom().add(parseContact(array.getJSONObject(i)));
      }
    };
    if (json.has("software"))
      res.setSoftware(parseConformanceConformanceSoftwareComponent(json.getJSONObject("software"), res));
    if (json.has("implementation"))
      res.setImplementation(parseConformanceConformanceImplementationComponent(json.getJSONObject("implementation"), res));
    if (json.has("proposal"))
      res.setProposal(parseConformanceConformanceProposalComponent(json.getJSONObject("proposal"), res));
    if (json.has("fhirVersion"))
      res.setFhirVersion(parseId(json.getJSONObject("fhirVersion")));
    if (json.has("acceptUnknown"))
      res.setAcceptUnknown(parseBoolean(json.getJSONObject("acceptUnknown")));
    if (json.has("format")) {
      JSONArray array = json.getJSONArray("format");
      for (int i = 0; i < array.length(); i++) {
        res.getFormat().add(parseCode(array.getJSONObject(i)));
      }
    };
    if (json.has("rest")) {
      JSONArray array = json.getJSONArray("rest");
      for (int i = 0; i < array.length(); i++) {
        res.getRest().add(parseConformanceConformanceRestComponent(array.getJSONObject(i), res));
      }
    };
    if (json.has("messaging")) {
      JSONArray array = json.getJSONArray("messaging");
      for (int i = 0; i < array.length(); i++) {
        res.getMessaging().add(parseConformanceConformanceMessagingComponent(array.getJSONObject(i), res));
      }
    };
    if (json.has("document")) {
      JSONArray array = json.getJSONArray("document");
      for (int i = 0; i < array.length(); i++) {
        res.getDocument().add(parseConformanceConformanceDocumentComponent(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private Conformance.ConformanceSoftwareComponent parseConformanceConformanceSoftwareComponent(JSONObject json, Conformance owner) throws Exception {
    Conformance.ConformanceSoftwareComponent res = owner.new ConformanceSoftwareComponent();
    parseElementProperties(json, res);
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("version"))
      res.setVersion(parseString(json.getJSONObject("version")));
    if (json.has("releaseDate"))
      res.setReleaseDate(parseDateTime(json.getJSONObject("releaseDate")));
    return res;
  }

  private Conformance.ConformanceImplementationComponent parseConformanceConformanceImplementationComponent(JSONObject json, Conformance owner) throws Exception {
    Conformance.ConformanceImplementationComponent res = owner.new ConformanceImplementationComponent();
    parseElementProperties(json, res);
    if (json.has("description"))
      res.setDescription(parseString(json.getJSONObject("description")));
    if (json.has("url"))
      res.setUrl(parseUri(json.getJSONObject("url")));
    if (json.has("software"))
      res.setSoftware(parseConformanceConformanceSoftwareComponent(json.getJSONObject("software"), owner));
    return res;
  }

  private Conformance.ConformanceProposalComponent parseConformanceConformanceProposalComponent(JSONObject json, Conformance owner) throws Exception {
    Conformance.ConformanceProposalComponent res = owner.new ConformanceProposalComponent();
    parseElementProperties(json, res);
    if (json.has("description"))
      res.setDescription(parseString(json.getJSONObject("description")));
    return res;
  }

  private Conformance.ConformanceRestComponent parseConformanceConformanceRestComponent(JSONObject json, Conformance owner) throws Exception {
    Conformance.ConformanceRestComponent res = owner.new ConformanceRestComponent();
    parseElementProperties(json, res);
    if (json.has("mode"))
      res.setMode(parseEnumeration(json.getJSONObject("mode"), Conformance.RestfulConformanceMode.Null, new Conformance().new RestfulConformanceModeEnumFactory()));
    if (json.has("documentation"))
      res.setDocumentation(parseString(json.getJSONObject("documentation")));
    if (json.has("security"))
      res.setSecurity(parseConformanceConformanceRestSecurityComponent(json.getJSONObject("security"), owner));
    if (json.has("resource")) {
      JSONArray array = json.getJSONArray("resource");
      for (int i = 0; i < array.length(); i++) {
        res.getResource().add(parseConformanceConformanceRestResourceComponent(array.getJSONObject(i), owner));
      }
    };
    if (json.has("batch"))
      res.setBatch(parseBoolean(json.getJSONObject("batch")));
    if (json.has("history"))
      res.setHistory(parseBoolean(json.getJSONObject("history")));
    return res;
  }

  private Conformance.ConformanceRestSecurityComponent parseConformanceConformanceRestSecurityComponent(JSONObject json, Conformance owner) throws Exception {
    Conformance.ConformanceRestSecurityComponent res = owner.new ConformanceRestSecurityComponent();
    parseElementProperties(json, res);
    if (json.has("service")) {
      JSONArray array = json.getJSONArray("service");
      for (int i = 0; i < array.length(); i++) {
        res.getService().add(parseCodeableConcept(array.getJSONObject(i)));
      }
    };
    if (json.has("description"))
      res.setDescription(parseString(json.getJSONObject("description")));
    if (json.has("certificate")) {
      JSONArray array = json.getJSONArray("certificate");
      for (int i = 0; i < array.length(); i++) {
        res.getCertificate().add(parseConformanceConformanceRestSecurityCertificateComponent(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private Conformance.ConformanceRestSecurityCertificateComponent parseConformanceConformanceRestSecurityCertificateComponent(JSONObject json, Conformance owner) throws Exception {
    Conformance.ConformanceRestSecurityCertificateComponent res = owner.new ConformanceRestSecurityCertificateComponent();
    parseElementProperties(json, res);
    if (json.has("type"))
      res.setType(parseCode(json.getJSONObject("type")));
    if (json.has("blob"))
      res.setBlob(parseBase64Binary(json.getJSONObject("blob")));
    return res;
  }

  private Conformance.ConformanceRestResourceComponent parseConformanceConformanceRestResourceComponent(JSONObject json, Conformance owner) throws Exception {
    Conformance.ConformanceRestResourceComponent res = owner.new ConformanceRestResourceComponent();
    parseElementProperties(json, res);
    if (json.has("type"))
      res.setType(parseCode(json.getJSONObject("type")));
    if (json.has("profile"))
      res.setProfile(parseResourceReference(json.getJSONObject("profile")));
    if (json.has("operation")) {
      JSONArray array = json.getJSONArray("operation");
      for (int i = 0; i < array.length(); i++) {
        res.getOperation().add(parseConformanceConformanceRestResourceOperationComponent(array.getJSONObject(i), owner));
      }
    };
    if (json.has("readHistory"))
      res.setReadHistory(parseBoolean(json.getJSONObject("readHistory")));
    if (json.has("searchInclude")) {
      JSONArray array = json.getJSONArray("searchInclude");
      for (int i = 0; i < array.length(); i++) {
        res.getSearchInclude().add(parseString(array.getJSONObject(i)));
      }
    };
    if (json.has("searchParam")) {
      JSONArray array = json.getJSONArray("searchParam");
      for (int i = 0; i < array.length(); i++) {
        res.getSearchParam().add(parseConformanceConformanceRestResourceSearchParamComponent(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private Conformance.ConformanceRestResourceOperationComponent parseConformanceConformanceRestResourceOperationComponent(JSONObject json, Conformance owner) throws Exception {
    Conformance.ConformanceRestResourceOperationComponent res = owner.new ConformanceRestResourceOperationComponent();
    parseElementProperties(json, res);
    if (json.has("code"))
      res.setCode(parseEnumeration(json.getJSONObject("code"), Conformance.RestfulOperation.Null, new Conformance().new RestfulOperationEnumFactory()));
    if (json.has("documentation"))
      res.setDocumentation(parseString(json.getJSONObject("documentation")));
    return res;
  }

  private Conformance.ConformanceRestResourceSearchParamComponent parseConformanceConformanceRestResourceSearchParamComponent(JSONObject json, Conformance owner) throws Exception {
    Conformance.ConformanceRestResourceSearchParamComponent res = owner.new ConformanceRestResourceSearchParamComponent();
    parseElementProperties(json, res);
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("source"))
      res.setSource(parseUri(json.getJSONObject("source")));
    if (json.has("type"))
      res.setType(parseEnumeration(json.getJSONObject("type"), Conformance.SearchParamType.Null, new Conformance().new SearchParamTypeEnumFactory()));
    if (json.has("documentation"))
      res.setDocumentation(parseString(json.getJSONObject("documentation")));
    if (json.has("target")) {
      JSONArray array = json.getJSONArray("target");
      for (int i = 0; i < array.length(); i++) {
        res.getTarget().add(parseCode(array.getJSONObject(i)));
      }
    };
    if (json.has("chain")) {
      JSONArray array = json.getJSONArray("chain");
      for (int i = 0; i < array.length(); i++) {
        res.getChain().add(parseString(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private Conformance.ConformanceMessagingComponent parseConformanceConformanceMessagingComponent(JSONObject json, Conformance owner) throws Exception {
    Conformance.ConformanceMessagingComponent res = owner.new ConformanceMessagingComponent();
    parseElementProperties(json, res);
    if (json.has("endpoint"))
      res.setEndpoint(parseUri(json.getJSONObject("endpoint")));
    if (json.has("reliableCache"))
      res.setReliableCache(parseInteger(json.getJSONObject("reliableCache")));
    if (json.has("documentation"))
      res.setDocumentation(parseString(json.getJSONObject("documentation")));
    if (json.has("event")) {
      JSONArray array = json.getJSONArray("event");
      for (int i = 0; i < array.length(); i++) {
        res.getEvent().add(parseConformanceConformanceMessagingEventComponent(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private Conformance.ConformanceMessagingEventComponent parseConformanceConformanceMessagingEventComponent(JSONObject json, Conformance owner) throws Exception {
    Conformance.ConformanceMessagingEventComponent res = owner.new ConformanceMessagingEventComponent();
    parseElementProperties(json, res);
    if (json.has("code"))
      res.setCode(parseCode(json.getJSONObject("code")));
    if (json.has("mode"))
      res.setMode(parseEnumeration(json.getJSONObject("mode"), Conformance.MessageConformanceEventMode.Null, new Conformance().new MessageConformanceEventModeEnumFactory()));
    if (json.has("protocol")) {
      JSONArray array = json.getJSONArray("protocol");
      for (int i = 0; i < array.length(); i++) {
        res.getProtocol().add(parseCoding(array.getJSONObject(i)));
      }
    };
    if (json.has("focus"))
      res.setFocus(parseCode(json.getJSONObject("focus")));
    if (json.has("request"))
      res.setRequest(parseUri(json.getJSONObject("request")));
    if (json.has("response"))
      res.setResponse(parseUri(json.getJSONObject("response")));
    if (json.has("documentation"))
      res.setDocumentation(parseString(json.getJSONObject("documentation")));
    return res;
  }

  private Conformance.ConformanceDocumentComponent parseConformanceConformanceDocumentComponent(JSONObject json, Conformance owner) throws Exception {
    Conformance.ConformanceDocumentComponent res = owner.new ConformanceDocumentComponent();
    parseElementProperties(json, res);
    if (json.has("mode"))
      res.setMode(parseEnumeration(json.getJSONObject("mode"), Conformance.DocumentMode.Null, new Conformance().new DocumentModeEnumFactory()));
    if (json.has("documentation"))
      res.setDocumentation(parseString(json.getJSONObject("documentation")));
    if (json.has("profile"))
      res.setProfile(parseUri(json.getJSONObject("profile")));
    return res;
  }

  private Coverage parseCoverage(JSONObject json) throws Exception {
    Coverage res = new Coverage();
    parseResourceProperties(json, res);
    if (json.has("issuer"))
      res.setIssuer(parseResourceReference(json.getJSONObject("issuer")));
    if (json.has("period"))
      res.setPeriod(parsePeriod(json.getJSONObject("period")));
    if (json.has("type"))
      res.setType(parseCoding(json.getJSONObject("type")));
    if (json.has("identifier"))
      res.setIdentifier(parseIdentifier(json.getJSONObject("identifier")));
    if (json.has("group"))
      res.setGroup(parseIdentifier(json.getJSONObject("group")));
    if (json.has("plan"))
      res.setPlan(parseIdentifier(json.getJSONObject("plan")));
    if (json.has("subplan"))
      res.setSubplan(parseIdentifier(json.getJSONObject("subplan")));
    if (json.has("dependent"))
      res.setDependent(parseInteger(json.getJSONObject("dependent")));
    if (json.has("sequence"))
      res.setSequence(parseInteger(json.getJSONObject("sequence")));
    if (json.has("subscriber"))
      res.setSubscriber(parseCoverageCoverageSubscriberComponent(json.getJSONObject("subscriber"), res));
    return res;
  }

  private Coverage.CoverageSubscriberComponent parseCoverageCoverageSubscriberComponent(JSONObject json, Coverage owner) throws Exception {
    Coverage.CoverageSubscriberComponent res = owner.new CoverageSubscriberComponent();
    parseElementProperties(json, res);
    if (json.has("name"))
      res.setName(parseHumanName(json.getJSONObject("name")));
    if (json.has("address"))
      res.setAddress(parseAddress(json.getJSONObject("address")));
    if (json.has("birthdate"))
      res.setBirthdate(parseDate(json.getJSONObject("birthdate")));
    return res;
  }

  private Device parseDevice(JSONObject json) throws Exception {
    Device res = new Device();
    parseResourceProperties(json, res);
    if (json.has("type"))
      res.setType(parseCodeableConcept(json.getJSONObject("type")));
    if (json.has("manufacturer"))
      res.setManufacturer(parseString(json.getJSONObject("manufacturer")));
    if (json.has("model"))
      res.setModel(parseString(json.getJSONObject("model")));
    if (json.has("version"))
      res.setVersion(parseString(json.getJSONObject("version")));
    if (json.has("identity"))
      res.setIdentity(parseDeviceDeviceIdentityComponent(json.getJSONObject("identity"), res));
    if (json.has("owner"))
      res.setOwner(parseResourceReference(json.getJSONObject("owner")));
    if (json.has("assignedId")) {
      JSONArray array = json.getJSONArray("assignedId");
      for (int i = 0; i < array.length(); i++) {
        res.getAssignedId().add(parseIdentifier(array.getJSONObject(i)));
      }
    };
    if (json.has("location"))
      res.setLocation(parseResourceReference(json.getJSONObject("location")));
    if (json.has("patient"))
      res.setPatient(parseResourceReference(json.getJSONObject("patient")));
    if (json.has("contact")) {
      JSONArray array = json.getJSONArray("contact");
      for (int i = 0; i < array.length(); i++) {
        res.getContact().add(parseContact(array.getJSONObject(i)));
      }
    };
    if (json.has("url"))
      res.setUrl(parseUri(json.getJSONObject("url")));
    return res;
  }

  private Device.DeviceIdentityComponent parseDeviceDeviceIdentityComponent(JSONObject json, Device owner) throws Exception {
    Device.DeviceIdentityComponent res = owner.new DeviceIdentityComponent();
    parseElementProperties(json, res);
    if (json.has("gtin"))
      res.setGtin(parseString(json.getJSONObject("gtin")));
    if (json.has("lot"))
      res.setLot(parseString(json.getJSONObject("lot")));
    if (json.has("serialNumber"))
      res.setSerialNumber(parseString(json.getJSONObject("serialNumber")));
    if (json.has("expiry"))
      res.setExpiry(parseDate(json.getJSONObject("expiry")));
    return res;
  }

  private DeviceCapabilities parseDeviceCapabilities(JSONObject json) throws Exception {
    DeviceCapabilities res = new DeviceCapabilities();
    parseResourceProperties(json, res);
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("type"))
      res.setType(parseCodeableConcept(json.getJSONObject("type")));
    if (json.has("manufacturer"))
      res.setManufacturer(parseString(json.getJSONObject("manufacturer")));
    if (json.has("identity"))
      res.setIdentity(parseResourceReference(json.getJSONObject("identity")));
    if (json.has("virtualDevice")) {
      JSONArray array = json.getJSONArray("virtualDevice");
      for (int i = 0; i < array.length(); i++) {
        res.getVirtualDevice().add(parseDeviceCapabilitiesDeviceCapabilitiesVirtualDeviceComponent(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private DeviceCapabilities.DeviceCapabilitiesVirtualDeviceComponent parseDeviceCapabilitiesDeviceCapabilitiesVirtualDeviceComponent(JSONObject json, DeviceCapabilities owner) throws Exception {
    DeviceCapabilities.DeviceCapabilitiesVirtualDeviceComponent res = owner.new DeviceCapabilitiesVirtualDeviceComponent();
    parseElementProperties(json, res);
    if (json.has("code"))
      res.setCode(parseCodeableConcept(json.getJSONObject("code")));
    if (json.has("channel")) {
      JSONArray array = json.getJSONArray("channel");
      for (int i = 0; i < array.length(); i++) {
        res.getChannel().add(parseDeviceCapabilitiesDeviceCapabilitiesVirtualDeviceChannelComponent(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private DeviceCapabilities.DeviceCapabilitiesVirtualDeviceChannelComponent parseDeviceCapabilitiesDeviceCapabilitiesVirtualDeviceChannelComponent(JSONObject json, DeviceCapabilities owner) throws Exception {
    DeviceCapabilities.DeviceCapabilitiesVirtualDeviceChannelComponent res = owner.new DeviceCapabilitiesVirtualDeviceChannelComponent();
    parseElementProperties(json, res);
    if (json.has("code"))
      res.setCode(parseCodeableConcept(json.getJSONObject("code")));
    if (json.has("metric")) {
      JSONArray array = json.getJSONArray("metric");
      for (int i = 0; i < array.length(); i++) {
        res.getMetric().add(parseDeviceCapabilitiesDeviceCapabilitiesVirtualDeviceChannelMetricComponent(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private DeviceCapabilities.DeviceCapabilitiesVirtualDeviceChannelMetricComponent parseDeviceCapabilitiesDeviceCapabilitiesVirtualDeviceChannelMetricComponent(JSONObject json, DeviceCapabilities owner) throws Exception {
    DeviceCapabilities.DeviceCapabilitiesVirtualDeviceChannelMetricComponent res = owner.new DeviceCapabilitiesVirtualDeviceChannelMetricComponent();
    parseElementProperties(json, res);
    if (json.has("code"))
      res.setCode(parseCodeableConcept(json.getJSONObject("code")));
    if (json.has("key"))
      res.setKey(parseString(json.getJSONObject("key")));
    if (json.has("info"))
      res.setInfo(parseDeviceCapabilitiesDeviceCapabilitiesVirtualDeviceChannelMetricInfoComponent(json.getJSONObject("info"), owner));
    if (json.has("facet")) {
      JSONArray array = json.getJSONArray("facet");
      for (int i = 0; i < array.length(); i++) {
        res.getFacet().add(parseDeviceCapabilitiesDeviceCapabilitiesVirtualDeviceChannelMetricFacetComponent(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private DeviceCapabilities.DeviceCapabilitiesVirtualDeviceChannelMetricInfoComponent parseDeviceCapabilitiesDeviceCapabilitiesVirtualDeviceChannelMetricInfoComponent(JSONObject json, DeviceCapabilities owner) throws Exception {
    DeviceCapabilities.DeviceCapabilitiesVirtualDeviceChannelMetricInfoComponent res = owner.new DeviceCapabilitiesVirtualDeviceChannelMetricInfoComponent();
    parseElementProperties(json, res);
    if (json.has("type"))
      res.setType(parseEnumeration(json.getJSONObject("type"), DeviceCapabilities.DeviceDataType.Null, new DeviceCapabilities().new DeviceDataTypeEnumFactory()));
    if (json.has("units"))
      res.setUnits(parseString(json.getJSONObject("units")));
    if (json.has("ucum"))
      res.setUcum(parseCode(json.getJSONObject("ucum")));
    if (json.has("array"))
      res.setArray(parseArray(json.getJSONObject("array")));
    if (json.has("system"))
      res.setSystem(parseUri(json.getJSONObject("system")));
    return res;
  }

  private DeviceCapabilities.DeviceCapabilitiesVirtualDeviceChannelMetricFacetComponent parseDeviceCapabilitiesDeviceCapabilitiesVirtualDeviceChannelMetricFacetComponent(JSONObject json, DeviceCapabilities owner) throws Exception {
    DeviceCapabilities.DeviceCapabilitiesVirtualDeviceChannelMetricFacetComponent res = owner.new DeviceCapabilitiesVirtualDeviceChannelMetricFacetComponent();
    parseElementProperties(json, res);
    if (json.has("code"))
      res.setCode(parseCodeableConcept(json.getJSONObject("code")));
    if (json.has("scale"))
      res.setScale(parseDecimal(json.getJSONObject("scale")));
    if (json.has("key"))
      res.setKey(parseString(json.getJSONObject("key")));
    if (json.has("info"))
      res.setInfo(parseDeviceCapabilitiesDeviceCapabilitiesVirtualDeviceChannelMetricInfoComponent(json.getJSONObject("info"), owner));
    return res;
  }

  private DeviceLog parseDeviceLog(JSONObject json) throws Exception {
    DeviceLog res = new DeviceLog();
    parseResourceProperties(json, res);
    if (json.has("instant"))
      res.setInstant(parseInstant(json.getJSONObject("instant")));
    if (json.has("capabilities"))
      res.setCapabilities(parseResourceReference(json.getJSONObject("capabilities")));
    if (json.has("subject"))
      res.setSubject(parseResourceReference(json.getJSONObject("subject")));
    if (json.has("item")) {
      JSONArray array = json.getJSONArray("item");
      for (int i = 0; i < array.length(); i++) {
        res.getItem().add(parseDeviceLogDeviceLogItemComponent(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private DeviceLog.DeviceLogItemComponent parseDeviceLogDeviceLogItemComponent(JSONObject json, DeviceLog owner) throws Exception {
    DeviceLog.DeviceLogItemComponent res = owner.new DeviceLogItemComponent();
    parseElementProperties(json, res);
    if (json.has("key"))
      res.setKey(parseString(json.getJSONObject("key")));
    if (json.has("value"))
      res.setValue(parseString(json.getJSONObject("value")));
    if (json.has("flag")) {
      JSONArray array = json.getJSONArray("flag");
      for (int i = 0; i < array.length(); i++) {
        res.getFlag().add(parseEnumeration(array.getJSONObject(i), DeviceLog.DeviceValueFlag.Null, new DeviceLog().new DeviceValueFlagEnumFactory()));
      }
    };
    return res;
  }

  private DeviceObservation parseDeviceObservation(JSONObject json) throws Exception {
    DeviceObservation res = new DeviceObservation();
    parseResourceProperties(json, res);
    if (json.has("code"))
      res.setCode(parseCodeableConcept(json.getJSONObject("code")));
    if (json.has("identifier")) {
      JSONArray array = json.getJSONArray("identifier");
      for (int i = 0; i < array.length(); i++) {
        res.getIdentifier().add(parseIdentifier(array.getJSONObject(i)));
      }
    };
    if (json.has("issued"))
      res.setIssued(parseInstant(json.getJSONObject("issued")));
    if (json.has("subject"))
      res.setSubject(parseResourceReference(json.getJSONObject("subject")));
    if (json.has("device"))
      res.setDevice(parseResourceReference(json.getJSONObject("device")));
    if (json.has("measurement")) {
      JSONArray array = json.getJSONArray("measurement");
      for (int i = 0; i < array.length(); i++) {
        res.getMeasurement().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private DiagnosticOrder parseDiagnosticOrder(JSONObject json) throws Exception {
    DiagnosticOrder res = new DiagnosticOrder();
    parseResourceProperties(json, res);
    if (json.has("subject"))
      res.setSubject(parseResourceReference(json.getJSONObject("subject")));
    if (json.has("orderer"))
      res.setOrderer(parseResourceReference(json.getJSONObject("orderer")));
    if (json.has("identifier")) {
      JSONArray array = json.getJSONArray("identifier");
      for (int i = 0; i < array.length(); i++) {
        res.getIdentifier().add(parseIdentifier(array.getJSONObject(i)));
      }
    };
    if (json.has("visit"))
      res.setVisit(parseResourceReference(json.getJSONObject("visit")));
    if (json.has("clinicalNotes"))
      res.setClinicalNotes(parseString(json.getJSONObject("clinicalNotes")));
    if (json.has("specimen")) {
      JSONArray array = json.getJSONArray("specimen");
      for (int i = 0; i < array.length(); i++) {
        res.getSpecimen().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    if (json.has("status"))
      res.setStatus(parseEnumeration(json.getJSONObject("status"), DiagnosticOrder.DiagnosticOrderStatus.Null, new DiagnosticOrder().new DiagnosticOrderStatusEnumFactory()));
    if (json.has("event")) {
      JSONArray array = json.getJSONArray("event");
      for (int i = 0; i < array.length(); i++) {
        res.getEvent().add(parseDiagnosticOrderDiagnosticOrderEventComponent(array.getJSONObject(i), res));
      }
    };
    if (json.has("item")) {
      JSONArray array = json.getJSONArray("item");
      for (int i = 0; i < array.length(); i++) {
        res.getItem().add(parseDiagnosticOrderDiagnosticOrderItemComponent(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private DiagnosticOrder.DiagnosticOrderEventComponent parseDiagnosticOrderDiagnosticOrderEventComponent(JSONObject json, DiagnosticOrder owner) throws Exception {
    DiagnosticOrder.DiagnosticOrderEventComponent res = owner.new DiagnosticOrderEventComponent();
    parseElementProperties(json, res);
    if (json.has("status"))
      res.setStatus(parseEnumeration(json.getJSONObject("status"), DiagnosticOrder.DiagnosticOrderStatus.Null, new DiagnosticOrder().new DiagnosticOrderStatusEnumFactory()));
    if (json.has("date"))
      res.setDate(parseDateTime(json.getJSONObject("date")));
    if (json.has("actor"))
      res.setActor(parseResourceReference(json.getJSONObject("actor")));
    return res;
  }

  private DiagnosticOrder.DiagnosticOrderItemComponent parseDiagnosticOrderDiagnosticOrderItemComponent(JSONObject json, DiagnosticOrder owner) throws Exception {
    DiagnosticOrder.DiagnosticOrderItemComponent res = owner.new DiagnosticOrderItemComponent();
    parseElementProperties(json, res);
    if (json.has("code"))
      res.setCode(parseCodeableConcept(json.getJSONObject("code")));
    if (json.has("specimen")) {
      JSONArray array = json.getJSONArray("specimen");
      for (int i = 0; i < array.length(); i++) {
        res.getSpecimen().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    if (json.has("bodySite"))
      res.setBodySite(parseCodeableConcept(json.getJSONObject("bodySite")));
    if (json.has("status"))
      res.setStatus(parseEnumeration(json.getJSONObject("status"), DiagnosticOrder.DiagnosticOrderStatus.Null, new DiagnosticOrder().new DiagnosticOrderStatusEnumFactory()));
    if (json.has("event")) {
      JSONArray array = json.getJSONArray("event");
      for (int i = 0; i < array.length(); i++) {
        res.getEvent().add(parseDiagnosticOrderDiagnosticOrderEventComponent(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private DiagnosticReport parseDiagnosticReport(JSONObject json) throws Exception {
    DiagnosticReport res = new DiagnosticReport();
    parseResourceProperties(json, res);
    if (json.has("status"))
      res.setStatus(parseEnumeration(json.getJSONObject("status"), DiagnosticReport.ObservationStatus.Null, new DiagnosticReport().new ObservationStatusEnumFactory()));
    if (json.has("issued"))
      res.setIssued(parseInstant(json.getJSONObject("issued")));
    if (json.has("subject"))
      res.setSubject(parseResourceReference(json.getJSONObject("subject")));
    if (json.has("performer"))
      res.setPerformer(parseResourceReference(json.getJSONObject("performer")));
    if (json.has("reportId"))
      res.setReportId(parseIdentifier(json.getJSONObject("reportId")));
    if (json.has("requestDetail")) {
      JSONArray array = json.getJSONArray("requestDetail");
      for (int i = 0; i < array.length(); i++) {
        res.getRequestDetail().add(parseDiagnosticReportDiagnosticReportRequestDetailComponent(array.getJSONObject(i), res));
      }
    };
    if (json.has("serviceCategory"))
      res.setServiceCategory(parseCodeableConcept(json.getJSONObject("serviceCategory")));
    if (json.has("diagnosticTime"))
      res.setDiagnosticTime(parseDateTime(json.getJSONObject("diagnosticTime")));
    if (json.has("results"))
      res.setResults(parseDiagnosticReportResultGroupComponent(json.getJSONObject("results"), res));
    if (json.has("image")) {
      JSONArray array = json.getJSONArray("image");
      for (int i = 0; i < array.length(); i++) {
        res.getImage().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    if (json.has("conclusion"))
      res.setConclusion(parseString(json.getJSONObject("conclusion")));
    if (json.has("codedDiagnosis")) {
      JSONArray array = json.getJSONArray("codedDiagnosis");
      for (int i = 0; i < array.length(); i++) {
        res.getCodedDiagnosis().add(parseCodeableConcept(array.getJSONObject(i)));
      }
    };
    if (json.has("representation")) {
      JSONArray array = json.getJSONArray("representation");
      for (int i = 0; i < array.length(); i++) {
        res.getRepresentation().add(parseAttachment(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private DiagnosticReport.DiagnosticReportRequestDetailComponent parseDiagnosticReportDiagnosticReportRequestDetailComponent(JSONObject json, DiagnosticReport owner) throws Exception {
    DiagnosticReport.DiagnosticReportRequestDetailComponent res = owner.new DiagnosticReportRequestDetailComponent();
    parseElementProperties(json, res);
    if (json.has("visit"))
      res.setVisit(parseResourceReference(json.getJSONObject("visit")));
    if (json.has("requestOrderId"))
      res.setRequestOrderId(parseIdentifier(json.getJSONObject("requestOrderId")));
    if (json.has("receiverOrderId"))
      res.setReceiverOrderId(parseIdentifier(json.getJSONObject("receiverOrderId")));
    if (json.has("requestTest")) {
      JSONArray array = json.getJSONArray("requestTest");
      for (int i = 0; i < array.length(); i++) {
        res.getRequestTest().add(parseCodeableConcept(array.getJSONObject(i)));
      }
    };
    if (json.has("bodySite"))
      res.setBodySite(parseCodeableConcept(json.getJSONObject("bodySite")));
    if (json.has("requester"))
      res.setRequester(parseResourceReference(json.getJSONObject("requester")));
    if (json.has("clinicalInfo"))
      res.setClinicalInfo(parseString(json.getJSONObject("clinicalInfo")));
    return res;
  }

  private DiagnosticReport.ResultGroupComponent parseDiagnosticReportResultGroupComponent(JSONObject json, DiagnosticReport owner) throws Exception {
    DiagnosticReport.ResultGroupComponent res = owner.new ResultGroupComponent();
    parseElementProperties(json, res);
    if (json.has("name"))
      res.setName(parseCodeableConcept(json.getJSONObject("name")));
    if (json.has("specimen"))
      res.setSpecimen(parseResourceReference(json.getJSONObject("specimen")));
    if (json.has("group")) {
      JSONArray array = json.getJSONArray("group");
      for (int i = 0; i < array.length(); i++) {
        res.getGroup().add(parseDiagnosticReportResultGroupComponent(array.getJSONObject(i), owner));
      }
    };
    if (json.has("result")) {
      JSONArray array = json.getJSONArray("result");
      for (int i = 0; i < array.length(); i++) {
        res.getResult().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private Document parseDocument(JSONObject json) throws Exception {
    Document res = new Document();
    parseResourceProperties(json, res);
    if (json.has("identifier"))
      res.setIdentifier(parseIdentifier(json.getJSONObject("identifier")));
    if (json.has("versionIdentifier"))
      res.setVersionIdentifier(parseIdentifier(json.getJSONObject("versionIdentifier")));
    if (json.has("created"))
      res.setCreated(parseInstant(json.getJSONObject("created")));
    if (json.has("class"))
      res.setClass_(parseCoding(json.getJSONObject("class")));
    if (json.has("type"))
      res.setType(parseCodeableConcept(json.getJSONObject("type")));
    if (json.has("title"))
      res.setTitle(parseString(json.getJSONObject("title")));
    if (json.has("confidentiality"))
      res.setConfidentiality(parseCoding(json.getJSONObject("confidentiality")));
    if (json.has("subject"))
      res.setSubject(parseResourceReference(json.getJSONObject("subject")));
    if (json.has("author")) {
      JSONArray array = json.getJSONArray("author");
      for (int i = 0; i < array.length(); i++) {
        res.getAuthor().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    if (json.has("attester")) {
      JSONArray array = json.getJSONArray("attester");
      for (int i = 0; i < array.length(); i++) {
        res.getAttester().add(parseDocumentDocumentAttesterComponent(array.getJSONObject(i), res));
      }
    };
    if (json.has("custodian"))
      res.setCustodian(parseResourceReference(json.getJSONObject("custodian")));
    if (json.has("event"))
      res.setEvent(parseDocumentDocumentEventComponent(json.getJSONObject("event"), res));
    if (json.has("visit"))
      res.setVisit(parseResourceReference(json.getJSONObject("visit")));
    if (json.has("replaces"))
      res.setReplaces(parseId(json.getJSONObject("replaces")));
    if (json.has("provenance")) {
      JSONArray array = json.getJSONArray("provenance");
      for (int i = 0; i < array.length(); i++) {
        res.getProvenance().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    if (json.has("stylesheet"))
      res.setStylesheet(parseAttachment(json.getJSONObject("stylesheet")));
    if (json.has("representation"))
      res.setRepresentation(parseAttachment(json.getJSONObject("representation")));
    if (json.has("section")) {
      JSONArray array = json.getJSONArray("section");
      for (int i = 0; i < array.length(); i++) {
        res.getSection().add(parseDocumentSectionComponent(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private Document.DocumentAttesterComponent parseDocumentDocumentAttesterComponent(JSONObject json, Document owner) throws Exception {
    Document.DocumentAttesterComponent res = owner.new DocumentAttesterComponent();
    parseElementProperties(json, res);
    if (json.has("mode"))
      res.setMode(parseEnumeration(json.getJSONObject("mode"), Document.DocumentAttestationMode.Null, new Document().new DocumentAttestationModeEnumFactory()));
    if (json.has("time"))
      res.setTime(parseDateTime(json.getJSONObject("time")));
    if (json.has("party"))
      res.setParty(parseResourceReference(json.getJSONObject("party")));
    return res;
  }

  private Document.DocumentEventComponent parseDocumentDocumentEventComponent(JSONObject json, Document owner) throws Exception {
    Document.DocumentEventComponent res = owner.new DocumentEventComponent();
    parseElementProperties(json, res);
    if (json.has("code")) {
      JSONArray array = json.getJSONArray("code");
      for (int i = 0; i < array.length(); i++) {
        res.getCode().add(parseCodeableConcept(array.getJSONObject(i)));
      }
    };
    if (json.has("period"))
      res.setPeriod(parsePeriod(json.getJSONObject("period")));
    if (json.has("detail")) {
      JSONArray array = json.getJSONArray("detail");
      for (int i = 0; i < array.length(); i++) {
        res.getDetail().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private Document.SectionComponent parseDocumentSectionComponent(JSONObject json, Document owner) throws Exception {
    Document.SectionComponent res = owner.new SectionComponent();
    parseElementProperties(json, res);
    if (json.has("code"))
      res.setCode(parseCodeableConcept(json.getJSONObject("code")));
    if (json.has("subject"))
      res.setSubject(parseResourceReference(json.getJSONObject("subject")));
    if (json.has("content"))
      res.setContent(parseResourceReference(json.getJSONObject("content")));
    if (json.has("section")) {
      JSONArray array = json.getJSONArray("section");
      for (int i = 0; i < array.length(); i++) {
        res.getSection().add(parseDocumentSectionComponent(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private DocumentReference parseDocumentReference(JSONObject json) throws Exception {
    DocumentReference res = new DocumentReference();
    parseResourceProperties(json, res);
    if (json.has("masterIdentifier"))
      res.setMasterIdentifier(parseIdentifier(json.getJSONObject("masterIdentifier")));
    if (json.has("identifier")) {
      JSONArray array = json.getJSONArray("identifier");
      for (int i = 0; i < array.length(); i++) {
        res.getIdentifier().add(parseIdentifier(array.getJSONObject(i)));
      }
    };
    if (json.has("subject"))
      res.setSubject(parseResourceReference(json.getJSONObject("subject")));
    if (json.has("type"))
      res.setType(parseCodeableConcept(json.getJSONObject("type")));
    if (json.has("author")) {
      JSONArray array = json.getJSONArray("author");
      for (int i = 0; i < array.length(); i++) {
        res.getAuthor().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    if (json.has("custodian"))
      res.setCustodian(parseResourceReference(json.getJSONObject("custodian")));
    if (json.has("authenticator"))
      res.setAuthenticator(parseResourceReference(json.getJSONObject("authenticator")));
    if (json.has("created"))
      res.setCreated(parseDateTime(json.getJSONObject("created")));
    if (json.has("indexed"))
      res.setIndexed(parseInstant(json.getJSONObject("indexed")));
    if (json.has("status"))
      res.setStatus(parseEnumeration(json.getJSONObject("status"), DocumentReference.DocumentReferenceStatus.Null, new DocumentReference().new DocumentReferenceStatusEnumFactory()));
    if (json.has("docStatus"))
      res.setDocStatus(parseCodeableConcept(json.getJSONObject("docStatus")));
    if (json.has("supercedes"))
      res.setSupercedes(parseResourceReference(json.getJSONObject("supercedes")));
    if (json.has("description"))
      res.setDescription(parseString(json.getJSONObject("description")));
    if (json.has("confidentiality"))
      res.setConfidentiality(parseCodeableConcept(json.getJSONObject("confidentiality")));
    if (json.has("primaryLanguage"))
      res.setPrimaryLanguage(parseCode(json.getJSONObject("primaryLanguage")));
    if (json.has("mimeType"))
      res.setMimeType(parseCode(json.getJSONObject("mimeType")));
    if (json.has("format"))
      res.setFormat(parseCodeableConcept(json.getJSONObject("format")));
    if (json.has("size"))
      res.setSize(parseInteger(json.getJSONObject("size")));
    if (json.has("hash"))
      res.setHash(parseString(json.getJSONObject("hash")));
    if (json.has("location"))
      res.setLocation(parseUri(json.getJSONObject("location")));
    if (json.has("service"))
      res.setService(parseDocumentReferenceDocumentReferenceServiceComponent(json.getJSONObject("service"), res));
    if (json.has("context"))
      res.setContext(parseDocumentReferenceDocumentReferenceContextComponent(json.getJSONObject("context"), res));
    return res;
  }

  private DocumentReference.DocumentReferenceServiceComponent parseDocumentReferenceDocumentReferenceServiceComponent(JSONObject json, DocumentReference owner) throws Exception {
    DocumentReference.DocumentReferenceServiceComponent res = owner.new DocumentReferenceServiceComponent();
    parseElementProperties(json, res);
    if (json.has("type"))
      res.setType(parseCodeableConcept(json.getJSONObject("type")));
    if (json.has("parameter")) {
      JSONArray array = json.getJSONArray("parameter");
      for (int i = 0; i < array.length(); i++) {
        res.getParameter().add(parseDocumentReferenceDocumentReferenceServiceParameterComponent(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private DocumentReference.DocumentReferenceServiceParameterComponent parseDocumentReferenceDocumentReferenceServiceParameterComponent(JSONObject json, DocumentReference owner) throws Exception {
    DocumentReference.DocumentReferenceServiceParameterComponent res = owner.new DocumentReferenceServiceParameterComponent();
    parseElementProperties(json, res);
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("value"))
      res.setValue(parseString(json.getJSONObject("value")));
    return res;
  }

  private DocumentReference.DocumentReferenceContextComponent parseDocumentReferenceDocumentReferenceContextComponent(JSONObject json, DocumentReference owner) throws Exception {
    DocumentReference.DocumentReferenceContextComponent res = owner.new DocumentReferenceContextComponent();
    parseElementProperties(json, res);
    if (json.has("code")) {
      JSONArray array = json.getJSONArray("code");
      for (int i = 0; i < array.length(); i++) {
        res.getCode().add(parseCodeableConcept(array.getJSONObject(i)));
      }
    };
    if (json.has("period"))
      res.setPeriod(parsePeriod(json.getJSONObject("period")));
    if (json.has("facilityType"))
      res.setFacilityType(parseCodeableConcept(json.getJSONObject("facilityType")));
    return res;
  }

  private FamilyHistory parseFamilyHistory(JSONObject json) throws Exception {
    FamilyHistory res = new FamilyHistory();
    parseResourceProperties(json, res);
    if (json.has("subject"))
      res.setSubject(parseResourceReference(json.getJSONObject("subject")));
    if (json.has("relation")) {
      JSONArray array = json.getJSONArray("relation");
      for (int i = 0; i < array.length(); i++) {
        res.getRelation().add(parseFamilyHistoryFamilyHistoryRelationComponent(array.getJSONObject(i), res));
      }
    };
    if (json.has("note"))
      res.setNote(parseString(json.getJSONObject("note")));
    return res;
  }

  private FamilyHistory.FamilyHistoryRelationComponent parseFamilyHistoryFamilyHistoryRelationComponent(JSONObject json, FamilyHistory owner) throws Exception {
    FamilyHistory.FamilyHistoryRelationComponent res = owner.new FamilyHistoryRelationComponent();
    parseElementProperties(json, res);
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("relationship"))
      res.setRelationship(parseCodeableConcept(json.getJSONObject("relationship")));
    Type deceased = parseType("deceased", json);
    if (deceased != null)
      res.setDeceased(deceased);
    if (json.has("note"))
      res.setNote(parseString(json.getJSONObject("note")));
    if (json.has("condition")) {
      JSONArray array = json.getJSONArray("condition");
      for (int i = 0; i < array.length(); i++) {
        res.getCondition().add(parseFamilyHistoryFamilyHistoryRelationConditionComponent(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private FamilyHistory.FamilyHistoryRelationConditionComponent parseFamilyHistoryFamilyHistoryRelationConditionComponent(JSONObject json, FamilyHistory owner) throws Exception {
    FamilyHistory.FamilyHistoryRelationConditionComponent res = owner.new FamilyHistoryRelationConditionComponent();
    parseElementProperties(json, res);
    if (json.has("type"))
      res.setType(parseCodeableConcept(json.getJSONObject("type")));
    if (json.has("outcome"))
      res.setOutcome(parseCodeableConcept(json.getJSONObject("outcome")));
    Type onset = parseType("onset", json);
    if (onset != null)
      res.setOnset(onset);
    if (json.has("note"))
      res.setNote(parseString(json.getJSONObject("note")));
    return res;
  }

  private Group parseGroup(JSONObject json) throws Exception {
    Group res = new Group();
    parseResourceProperties(json, res);
    if (json.has("identifier"))
      res.setIdentifier(parseIdentifier(json.getJSONObject("identifier")));
    if (json.has("type"))
      res.setType(parseEnumeration(json.getJSONObject("type"), Group.GroupType.Null, new Group().new GroupTypeEnumFactory()));
    if (json.has("actual"))
      res.setActual(parseBoolean(json.getJSONObject("actual")));
    if (json.has("code"))
      res.setCode(parseCodeableConcept(json.getJSONObject("code")));
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("quantity"))
      res.setQuantity(parseInteger(json.getJSONObject("quantity")));
    if (json.has("characteristic")) {
      JSONArray array = json.getJSONArray("characteristic");
      for (int i = 0; i < array.length(); i++) {
        res.getCharacteristic().add(parseGroupGroupCharacteristicComponent(array.getJSONObject(i), res));
      }
    };
    if (json.has("member")) {
      JSONArray array = json.getJSONArray("member");
      for (int i = 0; i < array.length(); i++) {
        res.getMember().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private Group.GroupCharacteristicComponent parseGroupGroupCharacteristicComponent(JSONObject json, Group owner) throws Exception {
    Group.GroupCharacteristicComponent res = owner.new GroupCharacteristicComponent();
    parseElementProperties(json, res);
    if (json.has("type"))
      res.setType(parseCodeableConcept(json.getJSONObject("type")));
    Type value = parseType("value", json);
    if (value != null)
      res.setValue(value);
    if (json.has("exclude"))
      res.setExclude(parseBoolean(json.getJSONObject("exclude")));
    return res;
  }

  private ImagingStudy parseImagingStudy(JSONObject json) throws Exception {
    ImagingStudy res = new ImagingStudy();
    parseResourceProperties(json, res);
    if (json.has("dateTime"))
      res.setDateTime(parseDateTime(json.getJSONObject("dateTime")));
    if (json.has("subject"))
      res.setSubject(parseResourceReference(json.getJSONObject("subject")));
    if (json.has("uid"))
      res.setUid(parseOid(json.getJSONObject("uid")));
    if (json.has("accessionNo"))
      res.setAccessionNo(parseIdentifier(json.getJSONObject("accessionNo")));
    if (json.has("identifier")) {
      JSONArray array = json.getJSONArray("identifier");
      for (int i = 0; i < array.length(); i++) {
        res.getIdentifier().add(parseIdentifier(array.getJSONObject(i)));
      }
    };
    if (json.has("referrer"))
      res.setReferrer(parseResourceReference(json.getJSONObject("referrer")));
    if (json.has("availability"))
      res.setAvailability(parseEnumeration(json.getJSONObject("availability"), ImagingStudy.InstanceAvailability.Null, new ImagingStudy().new InstanceAvailabilityEnumFactory()));
    if (json.has("url"))
      res.setUrl(parseUri(json.getJSONObject("url")));
    if (json.has("numberOfSeries"))
      res.setNumberOfSeries(parseInteger(json.getJSONObject("numberOfSeries")));
    if (json.has("numberOfInstances"))
      res.setNumberOfInstances(parseInteger(json.getJSONObject("numberOfInstances")));
    if (json.has("clinicalInformation"))
      res.setClinicalInformation(parseString(json.getJSONObject("clinicalInformation")));
    if (json.has("procedure")) {
      JSONArray array = json.getJSONArray("procedure");
      for (int i = 0; i < array.length(); i++) {
        res.getProcedure().add(parseCoding(array.getJSONObject(i)));
      }
    };
    if (json.has("interpreter"))
      res.setInterpreter(parseResourceReference(json.getJSONObject("interpreter")));
    if (json.has("description"))
      res.setDescription(parseString(json.getJSONObject("description")));
    if (json.has("series")) {
      JSONArray array = json.getJSONArray("series");
      for (int i = 0; i < array.length(); i++) {
        res.getSeries().add(parseImagingStudyImagingStudySeriesComponent(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private ImagingStudy.ImagingStudySeriesComponent parseImagingStudyImagingStudySeriesComponent(JSONObject json, ImagingStudy owner) throws Exception {
    ImagingStudy.ImagingStudySeriesComponent res = owner.new ImagingStudySeriesComponent();
    parseElementProperties(json, res);
    if (json.has("number"))
      res.setNumber(parseInteger(json.getJSONObject("number")));
    if (json.has("modality"))
      res.setModality(parseEnumeration(json.getJSONObject("modality"), ImagingStudy.ImageModality.Null, new ImagingStudy().new ImageModalityEnumFactory()));
    if (json.has("uid"))
      res.setUid(parseOid(json.getJSONObject("uid")));
    if (json.has("description"))
      res.setDescription(parseString(json.getJSONObject("description")));
    if (json.has("numberOfInstances"))
      res.setNumberOfInstances(parseInteger(json.getJSONObject("numberOfInstances")));
    if (json.has("availability"))
      res.setAvailability(parseEnumeration(json.getJSONObject("availability"), ImagingStudy.InstanceAvailability.Null, new ImagingStudy().new InstanceAvailabilityEnumFactory()));
    if (json.has("url"))
      res.setUrl(parseUri(json.getJSONObject("url")));
    if (json.has("locationUID"))
      res.setLocationUID(parseOid(json.getJSONObject("locationUID")));
    if (json.has("bodySite"))
      res.setBodySite(parseCoding(json.getJSONObject("bodySite")));
    if (json.has("dateTime"))
      res.setDateTime(parseDateTime(json.getJSONObject("dateTime")));
    if (json.has("instance")) {
      JSONArray array = json.getJSONArray("instance");
      for (int i = 0; i < array.length(); i++) {
        res.getInstance().add(parseImagingStudyImagingStudySeriesInstanceComponent(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private ImagingStudy.ImagingStudySeriesInstanceComponent parseImagingStudyImagingStudySeriesInstanceComponent(JSONObject json, ImagingStudy owner) throws Exception {
    ImagingStudy.ImagingStudySeriesInstanceComponent res = owner.new ImagingStudySeriesInstanceComponent();
    parseElementProperties(json, res);
    if (json.has("number"))
      res.setNumber(parseInteger(json.getJSONObject("number")));
    if (json.has("uid"))
      res.setUid(parseOid(json.getJSONObject("uid")));
    if (json.has("sopclass"))
      res.setSopclass(parseOid(json.getJSONObject("sopclass")));
    if (json.has("definition"))
      res.setDefinition(parseString(json.getJSONObject("definition")));
    if (json.has("title"))
      res.setTitle(parseString(json.getJSONObject("title")));
    if (json.has("availability"))
      res.setAvailability(parseEnumeration(json.getJSONObject("availability"), ImagingStudy.InstanceAvailability.Null, new ImagingStudy().new InstanceAvailabilityEnumFactory()));
    if (json.has("dateTime"))
      res.setDateTime(parseDateTime(json.getJSONObject("dateTime")));
    if (json.has("image"))
      res.setImage(parseImagingStudyImagingStudySeriesInstanceImageComponent(json.getJSONObject("image"), owner));
    if (json.has("url"))
      res.setUrl(parseUri(json.getJSONObject("url")));
    if (json.has("attachment"))
      res.setAttachment(parseResourceReference(json.getJSONObject("attachment")));
    return res;
  }

  private ImagingStudy.ImagingStudySeriesInstanceImageComponent parseImagingStudyImagingStudySeriesInstanceImageComponent(JSONObject json, ImagingStudy owner) throws Exception {
    ImagingStudy.ImagingStudySeriesInstanceImageComponent res = owner.new ImagingStudySeriesInstanceImageComponent();
    parseElementProperties(json, res);
    if (json.has("rows"))
      res.setRows(parseInteger(json.getJSONObject("rows")));
    if (json.has("columns"))
      res.setColumns(parseInteger(json.getJSONObject("columns")));
    if (json.has("bitsAllocated"))
      res.setBitsAllocated(parseInteger(json.getJSONObject("bitsAllocated")));
    if (json.has("numberOfFrames"))
      res.setNumberOfFrames(parseInteger(json.getJSONObject("numberOfFrames")));
    return res;
  }

  private Immunization parseImmunization(JSONObject json) throws Exception {
    Immunization res = new Immunization();
    parseResourceProperties(json, res);
    if (json.has("subject"))
      res.setSubject(parseResourceReference(json.getJSONObject("subject")));
    if (json.has("requester"))
      res.setRequester(parseResourceReference(json.getJSONObject("requester")));
    if (json.has("performer"))
      res.setPerformer(parseResourceReference(json.getJSONObject("performer")));
    if (json.has("manufacturer"))
      res.setManufacturer(parseResourceReference(json.getJSONObject("manufacturer")));
    if (json.has("location"))
      res.setLocation(parseResourceReference(json.getJSONObject("location")));
    if (json.has("date"))
      res.setDate(parseDateTime(json.getJSONObject("date")));
    if (json.has("reported"))
      res.setReported(parseBoolean(json.getJSONObject("reported")));
    if (json.has("vaccineType"))
      res.setVaccineType(parseCodeableConcept(json.getJSONObject("vaccineType")));
    if (json.has("lotNumber"))
      res.setLotNumber(parseString(json.getJSONObject("lotNumber")));
    if (json.has("expirationDate"))
      res.setExpirationDate(parseDate(json.getJSONObject("expirationDate")));
    if (json.has("site"))
      res.setSite(parseCodeableConcept(json.getJSONObject("site")));
    if (json.has("route"))
      res.setRoute(parseCodeableConcept(json.getJSONObject("route")));
    if (json.has("doseQuantity"))
      res.setDoseQuantity(parseQuantity(json.getJSONObject("doseQuantity")));
    if (json.has("refusal"))
      res.setRefusal(parseImmunizationImmunizationRefusalComponent(json.getJSONObject("refusal"), res));
    if (json.has("reaction")) {
      JSONArray array = json.getJSONArray("reaction");
      for (int i = 0; i < array.length(); i++) {
        res.getReaction().add(parseImmunizationImmunizationReactionComponent(array.getJSONObject(i), res));
      }
    };
    if (json.has("vaccinationProtocol"))
      res.setVaccinationProtocol(parseImmunizationImmunizationVaccinationProtocolComponent(json.getJSONObject("vaccinationProtocol"), res));
    return res;
  }

  private Immunization.ImmunizationRefusalComponent parseImmunizationImmunizationRefusalComponent(JSONObject json, Immunization owner) throws Exception {
    Immunization.ImmunizationRefusalComponent res = owner.new ImmunizationRefusalComponent();
    parseElementProperties(json, res);
    if (json.has("reason"))
      res.setReason(parseCodeableConcept(json.getJSONObject("reason")));
    return res;
  }

  private Immunization.ImmunizationReactionComponent parseImmunizationImmunizationReactionComponent(JSONObject json, Immunization owner) throws Exception {
    Immunization.ImmunizationReactionComponent res = owner.new ImmunizationReactionComponent();
    parseElementProperties(json, res);
    if (json.has("date"))
      res.setDate(parseDateTime(json.getJSONObject("date")));
    if (json.has("detail"))
      res.setDetail(parseResourceReference(json.getJSONObject("detail")));
    if (json.has("reported"))
      res.setReported(parseBoolean(json.getJSONObject("reported")));
    return res;
  }

  private Immunization.ImmunizationVaccinationProtocolComponent parseImmunizationImmunizationVaccinationProtocolComponent(JSONObject json, Immunization owner) throws Exception {
    Immunization.ImmunizationVaccinationProtocolComponent res = owner.new ImmunizationVaccinationProtocolComponent();
    parseElementProperties(json, res);
    if (json.has("doseSequence"))
      res.setDoseSequence(parseInteger(json.getJSONObject("doseSequence")));
    if (json.has("description"))
      res.setDescription(parseString(json.getJSONObject("description")));
    if (json.has("authority"))
      res.setAuthority(parseResourceReference(json.getJSONObject("authority")));
    if (json.has("series"))
      res.setSeries(parseString(json.getJSONObject("series")));
    if (json.has("seriesDoses"))
      res.setSeriesDoses(parseInteger(json.getJSONObject("seriesDoses")));
    if (json.has("doseTarget"))
      res.setDoseTarget(parseCodeableConcept(json.getJSONObject("doseTarget")));
    if (json.has("doseStatus"))
      res.setDoseStatus(parseCodeableConcept(json.getJSONObject("doseStatus")));
    if (json.has("doseStatusReason"))
      res.setDoseStatusReason(parseCodeableConcept(json.getJSONObject("doseStatusReason")));
    return res;
  }

  private ImmunizationProfile parseImmunizationProfile(JSONObject json) throws Exception {
    ImmunizationProfile res = new ImmunizationProfile();
    parseResourceProperties(json, res);
    if (json.has("subject"))
      res.setSubject(parseResourceReference(json.getJSONObject("subject")));
    if (json.has("recommendation")) {
      JSONArray array = json.getJSONArray("recommendation");
      for (int i = 0; i < array.length(); i++) {
        res.getRecommendation().add(parseImmunizationProfileImmunizationProfileRecommendationComponent(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private ImmunizationProfile.ImmunizationProfileRecommendationComponent parseImmunizationProfileImmunizationProfileRecommendationComponent(JSONObject json, ImmunizationProfile owner) throws Exception {
    ImmunizationProfile.ImmunizationProfileRecommendationComponent res = owner.new ImmunizationProfileRecommendationComponent();
    parseElementProperties(json, res);
    if (json.has("recommendationDate"))
      res.setRecommendationDate(parseDateTime(json.getJSONObject("recommendationDate")));
    if (json.has("vaccineType"))
      res.setVaccineType(parseCodeableConcept(json.getJSONObject("vaccineType")));
    if (json.has("doseNumber"))
      res.setDoseNumber(parseInteger(json.getJSONObject("doseNumber")));
    if (json.has("forecastStatus"))
      res.setForecastStatus(parseEnumeration(json.getJSONObject("forecastStatus"), ImmunizationProfile.ImmunizationForecastStatus.Null, new ImmunizationProfile().new ImmunizationForecastStatusEnumFactory()));
    if (json.has("dateCriterion")) {
      JSONArray array = json.getJSONArray("dateCriterion");
      for (int i = 0; i < array.length(); i++) {
        res.getDateCriterion().add(parseImmunizationProfileImmunizationProfileRecommendationDateCriterionComponent(array.getJSONObject(i), owner));
      }
    };
    if (json.has("protocol"))
      res.setProtocol(parseImmunizationProfileImmunizationProfileRecommendationProtocolComponent(json.getJSONObject("protocol"), owner));
    if (json.has("supportingImmunization")) {
      JSONArray array = json.getJSONArray("supportingImmunization");
      for (int i = 0; i < array.length(); i++) {
        res.getSupportingImmunization().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    if (json.has("supportingAdverseEventReport")) {
      JSONArray array = json.getJSONArray("supportingAdverseEventReport");
      for (int i = 0; i < array.length(); i++) {
        res.getSupportingAdverseEventReport().add(parseImmunizationProfileImmunizationProfileRecommendationSupportingAdverseEventReportComponent(array.getJSONObject(i), owner));
      }
    };
    if (json.has("supportingPatientObservation")) {
      JSONArray array = json.getJSONArray("supportingPatientObservation");
      for (int i = 0; i < array.length(); i++) {
        res.getSupportingPatientObservation().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private ImmunizationProfile.ImmunizationProfileRecommendationDateCriterionComponent parseImmunizationProfileImmunizationProfileRecommendationDateCriterionComponent(JSONObject json, ImmunizationProfile owner) throws Exception {
    ImmunizationProfile.ImmunizationProfileRecommendationDateCriterionComponent res = owner.new ImmunizationProfileRecommendationDateCriterionComponent();
    parseElementProperties(json, res);
    if (json.has("code"))
      res.setCode(parseCodeableConcept(json.getJSONObject("code")));
    if (json.has("value"))
      res.setValue(parseDateTime(json.getJSONObject("value")));
    return res;
  }

  private ImmunizationProfile.ImmunizationProfileRecommendationProtocolComponent parseImmunizationProfileImmunizationProfileRecommendationProtocolComponent(JSONObject json, ImmunizationProfile owner) throws Exception {
    ImmunizationProfile.ImmunizationProfileRecommendationProtocolComponent res = owner.new ImmunizationProfileRecommendationProtocolComponent();
    parseElementProperties(json, res);
    if (json.has("doseSequence"))
      res.setDoseSequence(parseInteger(json.getJSONObject("doseSequence")));
    if (json.has("description"))
      res.setDescription(parseString(json.getJSONObject("description")));
    if (json.has("authority"))
      res.setAuthority(parseResourceReference(json.getJSONObject("authority")));
    if (json.has("series"))
      res.setSeries(parseString(json.getJSONObject("series")));
    return res;
  }

  private ImmunizationProfile.ImmunizationProfileRecommendationSupportingAdverseEventReportComponent parseImmunizationProfileImmunizationProfileRecommendationSupportingAdverseEventReportComponent(JSONObject json, ImmunizationProfile owner) throws Exception {
    ImmunizationProfile.ImmunizationProfileRecommendationSupportingAdverseEventReportComponent res = owner.new ImmunizationProfileRecommendationSupportingAdverseEventReportComponent();
    parseElementProperties(json, res);
    if (json.has("identifier")) {
      JSONArray array = json.getJSONArray("identifier");
      for (int i = 0; i < array.length(); i++) {
        res.getIdentifier().add(parseId(array.getJSONObject(i)));
      }
    };
    if (json.has("reportType"))
      res.setReportType(parseCodeableConcept(json.getJSONObject("reportType")));
    if (json.has("reportDate"))
      res.setReportDate(parseDateTime(json.getJSONObject("reportDate")));
    if (json.has("text"))
      res.setText(parseString(json.getJSONObject("text")));
    if (json.has("reaction")) {
      JSONArray array = json.getJSONArray("reaction");
      for (int i = 0; i < array.length(); i++) {
        res.getReaction().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private List_ parseList_(JSONObject json) throws Exception {
    List_ res = new List_();
    parseResourceProperties(json, res);
    if (json.has("code"))
      res.setCode(parseCodeableConcept(json.getJSONObject("code")));
    if (json.has("source"))
      res.setSource(parseResourceReference(json.getJSONObject("source")));
    if (json.has("date"))
      res.setDate(parseDateTime(json.getJSONObject("date")));
    if (json.has("ordered"))
      res.setOrdered(parseBoolean(json.getJSONObject("ordered")));
    if (json.has("mode"))
      res.setMode(parseEnumeration(json.getJSONObject("mode"), List_.ListMode.Null, new List_().new ListModeEnumFactory()));
    if (json.has("entry")) {
      JSONArray array = json.getJSONArray("entry");
      for (int i = 0; i < array.length(); i++) {
        res.getEntry().add(parseList_ListEntryComponent(array.getJSONObject(i), res));
      }
    };
    if (json.has("emptyReason"))
      res.setEmptyReason(parseCodeableConcept(json.getJSONObject("emptyReason")));
    return res;
  }

  private List_.ListEntryComponent parseList_ListEntryComponent(JSONObject json, List_ owner) throws Exception {
    List_.ListEntryComponent res = owner.new ListEntryComponent();
    parseElementProperties(json, res);
    if (json.has("flag")) {
      JSONArray array = json.getJSONArray("flag");
      for (int i = 0; i < array.length(); i++) {
        res.getFlag().add(parseCodeableConcept(array.getJSONObject(i)));
      }
    };
    if (json.has("deleted"))
      res.setDeleted(parseBoolean(json.getJSONObject("deleted")));
    if (json.has("item"))
      res.setItem(parseResourceReference(json.getJSONObject("item")));
    return res;
  }

  private Location parseLocation(JSONObject json) throws Exception {
    Location res = new Location();
    parseResourceProperties(json, res);
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("description"))
      res.setDescription(parseString(json.getJSONObject("description")));
    if (json.has("type")) {
      JSONArray array = json.getJSONArray("type");
      for (int i = 0; i < array.length(); i++) {
        res.getType().add(parseCodeableConcept(array.getJSONObject(i)));
      }
    };
    if (json.has("telecom"))
      res.setTelecom(parseContact(json.getJSONObject("telecom")));
    if (json.has("address"))
      res.setAddress(parseAddress(json.getJSONObject("address")));
    if (json.has("position"))
      res.setPosition(parseLocationLocationPositionComponent(json.getJSONObject("position"), res));
    if (json.has("provider"))
      res.setProvider(parseResourceReference(json.getJSONObject("provider")));
    if (json.has("active"))
      res.setActive(parseBoolean(json.getJSONObject("active")));
    if (json.has("partOf"))
      res.setPartOf(parseResourceReference(json.getJSONObject("partOf")));
    return res;
  }

  private Location.LocationPositionComponent parseLocationLocationPositionComponent(JSONObject json, Location owner) throws Exception {
    Location.LocationPositionComponent res = owner.new LocationPositionComponent();
    parseElementProperties(json, res);
    if (json.has("longitude"))
      res.setLongitude(parseDecimal(json.getJSONObject("longitude")));
    if (json.has("latitude"))
      res.setLatitude(parseDecimal(json.getJSONObject("latitude")));
    if (json.has("altitude"))
      res.setAltitude(parseDecimal(json.getJSONObject("altitude")));
    return res;
  }

  private Medication parseMedication(JSONObject json) throws Exception {
    Medication res = new Medication();
    parseResourceProperties(json, res);
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("code"))
      res.setCode(parseCodeableConcept(json.getJSONObject("code")));
    if (json.has("isBrand"))
      res.setIsBrand(parseBoolean(json.getJSONObject("isBrand")));
    if (json.has("manufacturer"))
      res.setManufacturer(parseResourceReference(json.getJSONObject("manufacturer")));
    if (json.has("kind"))
      res.setKind(parseEnumeration(json.getJSONObject("kind"), Medication.MedicationKind.Null, new Medication().new MedicationKindEnumFactory()));
    if (json.has("product"))
      res.setProduct(parseMedicationMedicationProductComponent(json.getJSONObject("product"), res));
    if (json.has("package"))
      res.setPackage(parseMedicationMedicationPackageComponent(json.getJSONObject("package"), res));
    return res;
  }

  private Medication.MedicationProductComponent parseMedicationMedicationProductComponent(JSONObject json, Medication owner) throws Exception {
    Medication.MedicationProductComponent res = owner.new MedicationProductComponent();
    parseElementProperties(json, res);
    if (json.has("form"))
      res.setForm(parseCodeableConcept(json.getJSONObject("form")));
    if (json.has("ingredient")) {
      JSONArray array = json.getJSONArray("ingredient");
      for (int i = 0; i < array.length(); i++) {
        res.getIngredient().add(parseMedicationMedicationProductIngredientComponent(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private Medication.MedicationProductIngredientComponent parseMedicationMedicationProductIngredientComponent(JSONObject json, Medication owner) throws Exception {
    Medication.MedicationProductIngredientComponent res = owner.new MedicationProductIngredientComponent();
    parseElementProperties(json, res);
    if (json.has("item"))
      res.setItem(parseResourceReference(json.getJSONObject("item")));
    if (json.has("amount"))
      res.setAmount(parseRatio(json.getJSONObject("amount")));
    return res;
  }

  private Medication.MedicationPackageComponent parseMedicationMedicationPackageComponent(JSONObject json, Medication owner) throws Exception {
    Medication.MedicationPackageComponent res = owner.new MedicationPackageComponent();
    parseElementProperties(json, res);
    if (json.has("container"))
      res.setContainer(parseCodeableConcept(json.getJSONObject("container")));
    if (json.has("content")) {
      JSONArray array = json.getJSONArray("content");
      for (int i = 0; i < array.length(); i++) {
        res.getContent().add(parseMedicationMedicationPackageContentComponent(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private Medication.MedicationPackageContentComponent parseMedicationMedicationPackageContentComponent(JSONObject json, Medication owner) throws Exception {
    Medication.MedicationPackageContentComponent res = owner.new MedicationPackageContentComponent();
    parseElementProperties(json, res);
    if (json.has("item"))
      res.setItem(parseResourceReference(json.getJSONObject("item")));
    if (json.has("amount"))
      res.setAmount(parseQuantity(json.getJSONObject("amount")));
    return res;
  }

  private MedicationAdministration parseMedicationAdministration(JSONObject json) throws Exception {
    MedicationAdministration res = new MedicationAdministration();
    parseResourceProperties(json, res);
    if (json.has("externalID")) {
      JSONArray array = json.getJSONArray("externalID");
      for (int i = 0; i < array.length(); i++) {
        res.getExternalID().add(parseIdentifier(array.getJSONObject(i)));
      }
    };
    if (json.has("status"))
      res.setStatus(parseEnumeration(json.getJSONObject("status"), MedicationAdministration.MedicationAdminStatus.Null, new MedicationAdministration().new MedicationAdminStatusEnumFactory()));
    if (json.has("patient"))
      res.setPatient(parseResourceReference(json.getJSONObject("patient")));
    if (json.has("practitioner"))
      res.setPractitioner(parseResourceReference(json.getJSONObject("practitioner")));
    if (json.has("visit"))
      res.setVisit(parseResourceReference(json.getJSONObject("visit")));
    if (json.has("prescription"))
      res.setPrescription(parseResourceReference(json.getJSONObject("prescription")));
    if (json.has("wasNotGiven"))
      res.setWasNotGiven(parseBoolean(json.getJSONObject("wasNotGiven")));
    if (json.has("reasonNotGiven")) {
      JSONArray array = json.getJSONArray("reasonNotGiven");
      for (int i = 0; i < array.length(); i++) {
        res.getReasonNotGiven().add(parseCodeableConcept(array.getJSONObject(i)));
      }
    };
    if (json.has("whenGiven"))
      res.setWhenGiven(parsePeriod(json.getJSONObject("whenGiven")));
    if (json.has("medication"))
      res.setMedication(parseResourceReference(json.getJSONObject("medication")));
    if (json.has("administrationDevice")) {
      JSONArray array = json.getJSONArray("administrationDevice");
      for (int i = 0; i < array.length(); i++) {
        res.getAdministrationDevice().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    if (json.has("dosage")) {
      JSONArray array = json.getJSONArray("dosage");
      for (int i = 0; i < array.length(); i++) {
        res.getDosage().add(parseMedicationAdministrationMedicationAdministrationDosageComponent(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private MedicationAdministration.MedicationAdministrationDosageComponent parseMedicationAdministrationMedicationAdministrationDosageComponent(JSONObject json, MedicationAdministration owner) throws Exception {
    MedicationAdministration.MedicationAdministrationDosageComponent res = owner.new MedicationAdministrationDosageComponent();
    parseElementProperties(json, res);
    if (json.has("timing"))
      res.setTiming(parseSchedule(json.getJSONObject("timing")));
    if (json.has("site"))
      res.setSite(parseCodeableConcept(json.getJSONObject("site")));
    if (json.has("route"))
      res.setRoute(parseCodeableConcept(json.getJSONObject("route")));
    if (json.has("method"))
      res.setMethod(parseCodeableConcept(json.getJSONObject("method")));
    if (json.has("quantity"))
      res.setQuantity(parseQuantity(json.getJSONObject("quantity")));
    if (json.has("rate"))
      res.setRate(parseRatio(json.getJSONObject("rate")));
    if (json.has("maxDosePerPeriod"))
      res.setMaxDosePerPeriod(parseRatio(json.getJSONObject("maxDosePerPeriod")));
    return res;
  }

  private MedicationDispense parseMedicationDispense(JSONObject json) throws Exception {
    MedicationDispense res = new MedicationDispense();
    parseResourceProperties(json, res);
    if (json.has("externalID"))
      res.setExternalID(parseIdentifier(json.getJSONObject("externalID")));
    if (json.has("status"))
      res.setStatus(parseCodeableConcept(json.getJSONObject("status")));
    if (json.has("patient"))
      res.setPatient(parseResourceReference(json.getJSONObject("patient")));
    if (json.has("dispenser"))
      res.setDispenser(parseResourceReference(json.getJSONObject("dispenser")));
    if (json.has("visit"))
      res.setVisit(parseResourceReference(json.getJSONObject("visit")));
    if (json.has("authorizingPrescription")) {
      JSONArray array = json.getJSONArray("authorizingPrescription");
      for (int i = 0; i < array.length(); i++) {
        res.getAuthorizingPrescription().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    if (json.has("dispense")) {
      JSONArray array = json.getJSONArray("dispense");
      for (int i = 0; i < array.length(); i++) {
        res.getDispense().add(parseMedicationDispenseMedicationDispenseDispenseComponent(array.getJSONObject(i), res));
      }
    };
    if (json.has("substitution"))
      res.setSubstitution(parseMedicationDispenseMedicationDispenseSubstitutionComponent(json.getJSONObject("substitution"), res));
    return res;
  }

  private MedicationDispense.MedicationDispenseDispenseComponent parseMedicationDispenseMedicationDispenseDispenseComponent(JSONObject json, MedicationDispense owner) throws Exception {
    MedicationDispense.MedicationDispenseDispenseComponent res = owner.new MedicationDispenseDispenseComponent();
    parseElementProperties(json, res);
    if (json.has("externalID"))
      res.setExternalID(parseIdentifier(json.getJSONObject("externalID")));
    if (json.has("status"))
      res.setStatus(parseCodeableConcept(json.getJSONObject("status")));
    if (json.has("type"))
      res.setType(parseCodeableConcept(json.getJSONObject("type")));
    if (json.has("quantity"))
      res.setQuantity(parseQuantity(json.getJSONObject("quantity")));
    if (json.has("medication"))
      res.setMedication(parseResourceReference(json.getJSONObject("medication")));
    if (json.has("whenPrepared"))
      res.setWhenPrepared(parsePeriod(json.getJSONObject("whenPrepared")));
    if (json.has("whenHandedOver"))
      res.setWhenHandedOver(parsePeriod(json.getJSONObject("whenHandedOver")));
    if (json.has("destination"))
      res.setDestination(parseResourceReference(json.getJSONObject("destination")));
    if (json.has("receiver")) {
      JSONArray array = json.getJSONArray("receiver");
      for (int i = 0; i < array.length(); i++) {
        res.getReceiver().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    if (json.has("dosage")) {
      JSONArray array = json.getJSONArray("dosage");
      for (int i = 0; i < array.length(); i++) {
        res.getDosage().add(parseMedicationDispenseMedicationDispenseDispenseDosageComponent(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private MedicationDispense.MedicationDispenseDispenseDosageComponent parseMedicationDispenseMedicationDispenseDispenseDosageComponent(JSONObject json, MedicationDispense owner) throws Exception {
    MedicationDispense.MedicationDispenseDispenseDosageComponent res = owner.new MedicationDispenseDispenseDosageComponent();
    parseElementProperties(json, res);
    if (json.has("timing"))
      res.setTiming(parseSchedule(json.getJSONObject("timing")));
    if (json.has("site"))
      res.setSite(parseCodeableConcept(json.getJSONObject("site")));
    if (json.has("route"))
      res.setRoute(parseCodeableConcept(json.getJSONObject("route")));
    if (json.has("method"))
      res.setMethod(parseCodeableConcept(json.getJSONObject("method")));
    if (json.has("quantity"))
      res.setQuantity(parseQuantity(json.getJSONObject("quantity")));
    if (json.has("rate"))
      res.setRate(parseRatio(json.getJSONObject("rate")));
    if (json.has("maxDosePerPeriod"))
      res.setMaxDosePerPeriod(parseRatio(json.getJSONObject("maxDosePerPeriod")));
    return res;
  }

  private MedicationDispense.MedicationDispenseSubstitutionComponent parseMedicationDispenseMedicationDispenseSubstitutionComponent(JSONObject json, MedicationDispense owner) throws Exception {
    MedicationDispense.MedicationDispenseSubstitutionComponent res = owner.new MedicationDispenseSubstitutionComponent();
    parseElementProperties(json, res);
    if (json.has("type"))
      res.setType(parseCodeableConcept(json.getJSONObject("type")));
    if (json.has("reason")) {
      JSONArray array = json.getJSONArray("reason");
      for (int i = 0; i < array.length(); i++) {
        res.getReason().add(parseCodeableConcept(array.getJSONObject(i)));
      }
    };
    if (json.has("responsibleParty")) {
      JSONArray array = json.getJSONArray("responsibleParty");
      for (int i = 0; i < array.length(); i++) {
        res.getResponsibleParty().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private MedicationPrescription parseMedicationPrescription(JSONObject json) throws Exception {
    MedicationPrescription res = new MedicationPrescription();
    parseResourceProperties(json, res);
    if (json.has("externalID")) {
      JSONArray array = json.getJSONArray("externalID");
      for (int i = 0; i < array.length(); i++) {
        res.getExternalID().add(parseIdentifier(array.getJSONObject(i)));
      }
    };
    if (json.has("dateWritten"))
      res.setDateWritten(parseDateTime(json.getJSONObject("dateWritten")));
    if (json.has("status"))
      res.setStatus(parseCodeableConcept(json.getJSONObject("status")));
    if (json.has("patient"))
      res.setPatient(parseResourceReference(json.getJSONObject("patient")));
    if (json.has("prescriber"))
      res.setPrescriber(parseResourceReference(json.getJSONObject("prescriber")));
    if (json.has("encounter"))
      res.setEncounter(parseResourceReference(json.getJSONObject("encounter")));
    Type reasonForPrescribing = parseType("reasonForPrescribing", json);
    if (reasonForPrescribing != null)
      res.setReasonForPrescribing(reasonForPrescribing);
    if (json.has("medication"))
      res.setMedication(parseResourceReference(json.getJSONObject("medication")));
    if (json.has("dosageInstructions")) {
      JSONArray array = json.getJSONArray("dosageInstructions");
      for (int i = 0; i < array.length(); i++) {
        res.getDosageInstructions().add(parseMedicationPrescriptionMedicationPrescriptionDosageInstructionsComponent(array.getJSONObject(i), res));
      }
    };
    if (json.has("dispense"))
      res.setDispense(parseMedicationPrescriptionMedicationPrescriptionDispenseComponent(json.getJSONObject("dispense"), res));
    if (json.has("substitution"))
      res.setSubstitution(parseMedicationPrescriptionMedicationPrescriptionSubstitutionComponent(json.getJSONObject("substitution"), res));
    return res;
  }

  private MedicationPrescription.MedicationPrescriptionDosageInstructionsComponent parseMedicationPrescriptionMedicationPrescriptionDosageInstructionsComponent(JSONObject json, MedicationPrescription owner) throws Exception {
    MedicationPrescription.MedicationPrescriptionDosageInstructionsComponent res = owner.new MedicationPrescriptionDosageInstructionsComponent();
    parseElementProperties(json, res);
    if (json.has("dosageInstructionsText"))
      res.setDosageInstructionsText(parseString(json.getJSONObject("dosageInstructionsText")));
    Type additionalInstructions = parseType("additionalInstructions", json);
    if (additionalInstructions != null)
      res.setAdditionalInstructions(additionalInstructions);
    if (json.has("timing"))
      res.setTiming(parseSchedule(json.getJSONObject("timing")));
    if (json.has("site"))
      res.setSite(parseCodeableConcept(json.getJSONObject("site")));
    if (json.has("route"))
      res.setRoute(parseCodeableConcept(json.getJSONObject("route")));
    if (json.has("method"))
      res.setMethod(parseCodeableConcept(json.getJSONObject("method")));
    if (json.has("doseQuantity"))
      res.setDoseQuantity(parseQuantity(json.getJSONObject("doseQuantity")));
    if (json.has("rate"))
      res.setRate(parseRatio(json.getJSONObject("rate")));
    if (json.has("maxDosePerPeriod"))
      res.setMaxDosePerPeriod(parseRatio(json.getJSONObject("maxDosePerPeriod")));
    return res;
  }

  private MedicationPrescription.MedicationPrescriptionDispenseComponent parseMedicationPrescriptionMedicationPrescriptionDispenseComponent(JSONObject json, MedicationPrescription owner) throws Exception {
    MedicationPrescription.MedicationPrescriptionDispenseComponent res = owner.new MedicationPrescriptionDispenseComponent();
    parseElementProperties(json, res);
    if (json.has("validityPeriod"))
      res.setValidityPeriod(parsePeriod(json.getJSONObject("validityPeriod")));
    if (json.has("numberOfRepeatsAllowed"))
      res.setNumberOfRepeatsAllowed(parseInteger(json.getJSONObject("numberOfRepeatsAllowed")));
    if (json.has("quantity"))
      res.setQuantity(parseQuantity(json.getJSONObject("quantity")));
    if (json.has("expectedSupplyDuration"))
      res.setExpectedSupplyDuration(parseDuration(json.getJSONObject("expectedSupplyDuration")));
    return res;
  }

  private MedicationPrescription.MedicationPrescriptionSubstitutionComponent parseMedicationPrescriptionMedicationPrescriptionSubstitutionComponent(JSONObject json, MedicationPrescription owner) throws Exception {
    MedicationPrescription.MedicationPrescriptionSubstitutionComponent res = owner.new MedicationPrescriptionSubstitutionComponent();
    parseElementProperties(json, res);
    if (json.has("type"))
      res.setType(parseCodeableConcept(json.getJSONObject("type")));
    if (json.has("reason"))
      res.setReason(parseCodeableConcept(json.getJSONObject("reason")));
    return res;
  }

  private MedicationStatement parseMedicationStatement(JSONObject json) throws Exception {
    MedicationStatement res = new MedicationStatement();
    parseResourceProperties(json, res);
    if (json.has("identifier")) {
      JSONArray array = json.getJSONArray("identifier");
      for (int i = 0; i < array.length(); i++) {
        res.getIdentifier().add(parseIdentifier(array.getJSONObject(i)));
      }
    };
    if (json.has("patient"))
      res.setPatient(parseResourceReference(json.getJSONObject("patient")));
    if (json.has("wasNotGiven"))
      res.setWasNotGiven(parseBoolean(json.getJSONObject("wasNotGiven")));
    if (json.has("reasonNotGiven")) {
      JSONArray array = json.getJSONArray("reasonNotGiven");
      for (int i = 0; i < array.length(); i++) {
        res.getReasonNotGiven().add(parseCodeableConcept(array.getJSONObject(i)));
      }
    };
    if (json.has("whenGiven"))
      res.setWhenGiven(parsePeriod(json.getJSONObject("whenGiven")));
    if (json.has("medication"))
      res.setMedication(parseResourceReference(json.getJSONObject("medication")));
    if (json.has("administrationDevice")) {
      JSONArray array = json.getJSONArray("administrationDevice");
      for (int i = 0; i < array.length(); i++) {
        res.getAdministrationDevice().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    if (json.has("dosage")) {
      JSONArray array = json.getJSONArray("dosage");
      for (int i = 0; i < array.length(); i++) {
        res.getDosage().add(parseMedicationStatementMedicationStatementDosageComponent(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private MedicationStatement.MedicationStatementDosageComponent parseMedicationStatementMedicationStatementDosageComponent(JSONObject json, MedicationStatement owner) throws Exception {
    MedicationStatement.MedicationStatementDosageComponent res = owner.new MedicationStatementDosageComponent();
    parseElementProperties(json, res);
    if (json.has("timing"))
      res.setTiming(parseSchedule(json.getJSONObject("timing")));
    if (json.has("site"))
      res.setSite(parseCodeableConcept(json.getJSONObject("site")));
    if (json.has("route"))
      res.setRoute(parseCodeableConcept(json.getJSONObject("route")));
    if (json.has("method"))
      res.setMethod(parseCodeableConcept(json.getJSONObject("method")));
    if (json.has("quantity"))
      res.setQuantity(parseQuantity(json.getJSONObject("quantity")));
    if (json.has("rate"))
      res.setRate(parseRatio(json.getJSONObject("rate")));
    if (json.has("maxDosePerPeriod"))
      res.setMaxDosePerPeriod(parseRatio(json.getJSONObject("maxDosePerPeriod")));
    return res;
  }

  private Message parseMessage(JSONObject json) throws Exception {
    Message res = new Message();
    parseResourceProperties(json, res);
    if (json.has("identifier"))
      res.setIdentifier(parseId(json.getJSONObject("identifier")));
    if (json.has("timestamp"))
      res.setTimestamp(parseInstant(json.getJSONObject("timestamp")));
    if (json.has("event"))
      res.setEvent(parseCode(json.getJSONObject("event")));
    if (json.has("response"))
      res.setResponse(parseMessageMessageResponseComponent(json.getJSONObject("response"), res));
    if (json.has("source"))
      res.setSource(parseMessageMessageSourceComponent(json.getJSONObject("source"), res));
    if (json.has("destination"))
      res.setDestination(parseMessageMessageDestinationComponent(json.getJSONObject("destination"), res));
    if (json.has("enterer"))
      res.setEnterer(parseResourceReference(json.getJSONObject("enterer")));
    if (json.has("author"))
      res.setAuthor(parseResourceReference(json.getJSONObject("author")));
    if (json.has("receiver"))
      res.setReceiver(parseResourceReference(json.getJSONObject("receiver")));
    if (json.has("responsible"))
      res.setResponsible(parseResourceReference(json.getJSONObject("responsible")));
    if (json.has("effective"))
      res.setEffective(parsePeriod(json.getJSONObject("effective")));
    if (json.has("reason"))
      res.setReason(parseCodeableConcept(json.getJSONObject("reason")));
    if (json.has("data")) {
      JSONArray array = json.getJSONArray("data");
      for (int i = 0; i < array.length(); i++) {
        res.getData().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private Message.MessageResponseComponent parseMessageMessageResponseComponent(JSONObject json, Message owner) throws Exception {
    Message.MessageResponseComponent res = owner.new MessageResponseComponent();
    parseElementProperties(json, res);
    if (json.has("identifier"))
      res.setIdentifier(parseId(json.getJSONObject("identifier")));
    if (json.has("code"))
      res.setCode(parseEnumeration(json.getJSONObject("code"), Message.ResponseCode.Null, new Message().new ResponseCodeEnumFactory()));
    if (json.has("details"))
      res.setDetails(parseResourceReference(json.getJSONObject("details")));
    return res;
  }

  private Message.MessageSourceComponent parseMessageMessageSourceComponent(JSONObject json, Message owner) throws Exception {
    Message.MessageSourceComponent res = owner.new MessageSourceComponent();
    parseElementProperties(json, res);
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("software"))
      res.setSoftware(parseString(json.getJSONObject("software")));
    if (json.has("version"))
      res.setVersion(parseString(json.getJSONObject("version")));
    if (json.has("contact"))
      res.setContact(parseContact(json.getJSONObject("contact")));
    if (json.has("endpoint"))
      res.setEndpoint(parseUri(json.getJSONObject("endpoint")));
    return res;
  }

  private Message.MessageDestinationComponent parseMessageMessageDestinationComponent(JSONObject json, Message owner) throws Exception {
    Message.MessageDestinationComponent res = owner.new MessageDestinationComponent();
    parseElementProperties(json, res);
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("target"))
      res.setTarget(parseResourceReference(json.getJSONObject("target")));
    if (json.has("endpoint"))
      res.setEndpoint(parseUri(json.getJSONObject("endpoint")));
    return res;
  }

  private Observation parseObservation(JSONObject json) throws Exception {
    Observation res = new Observation();
    parseResourceProperties(json, res);
    if (json.has("name"))
      res.setName(parseCodeableConcept(json.getJSONObject("name")));
    Type value = parseType("value", json);
    if (value != null)
      res.setValue(value);
    if (json.has("interpretation"))
      res.setInterpretation(parseCodeableConcept(json.getJSONObject("interpretation")));
    if (json.has("comments"))
      res.setComments(parseString(json.getJSONObject("comments")));
    Type applies = parseType("applies", json);
    if (applies != null)
      res.setApplies(applies);
    if (json.has("issued"))
      res.setIssued(parseInstant(json.getJSONObject("issued")));
    if (json.has("status"))
      res.setStatus(parseEnumeration(json.getJSONObject("status"), Observation.ObservationStatus.Null, new Observation().new ObservationStatusEnumFactory()));
    if (json.has("reliability"))
      res.setReliability(parseEnumeration(json.getJSONObject("reliability"), Observation.ObservationReliability.Null, new Observation().new ObservationReliabilityEnumFactory()));
    if (json.has("bodySite"))
      res.setBodySite(parseCodeableConcept(json.getJSONObject("bodySite")));
    if (json.has("method"))
      res.setMethod(parseCodeableConcept(json.getJSONObject("method")));
    if (json.has("identifier"))
      res.setIdentifier(parseIdentifier(json.getJSONObject("identifier")));
    if (json.has("subject"))
      res.setSubject(parseResourceReference(json.getJSONObject("subject")));
    if (json.has("performer"))
      res.setPerformer(parseResourceReference(json.getJSONObject("performer")));
    if (json.has("referenceRange")) {
      JSONArray array = json.getJSONArray("referenceRange");
      for (int i = 0; i < array.length(); i++) {
        res.getReferenceRange().add(parseObservationObservationReferenceRangeComponent(array.getJSONObject(i), res));
      }
    };
    if (json.has("component")) {
      JSONArray array = json.getJSONArray("component");
      for (int i = 0; i < array.length(); i++) {
        res.getComponent().add(parseObservationObservationComponentComponent(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private Observation.ObservationReferenceRangeComponent parseObservationObservationReferenceRangeComponent(JSONObject json, Observation owner) throws Exception {
    Observation.ObservationReferenceRangeComponent res = owner.new ObservationReferenceRangeComponent();
    parseElementProperties(json, res);
    if (json.has("meaning"))
      res.setMeaning(parseCodeableConcept(json.getJSONObject("meaning")));
    Type range = parseType("range", json);
    if (range != null)
      res.setRange(range);
    return res;
  }

  private Observation.ObservationComponentComponent parseObservationObservationComponentComponent(JSONObject json, Observation owner) throws Exception {
    Observation.ObservationComponentComponent res = owner.new ObservationComponentComponent();
    parseElementProperties(json, res);
    if (json.has("name"))
      res.setName(parseCodeableConcept(json.getJSONObject("name")));
    Type value = parseType("value", json);
    if (value != null)
      res.setValue(value);
    return res;
  }

  private OperationOutcome parseOperationOutcome(JSONObject json) throws Exception {
    OperationOutcome res = new OperationOutcome();
    parseResourceProperties(json, res);
    if (json.has("issue")) {
      JSONArray array = json.getJSONArray("issue");
      for (int i = 0; i < array.length(); i++) {
        res.getIssue().add(parseOperationOutcomeOperationOutcomeIssueComponent(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private OperationOutcome.OperationOutcomeIssueComponent parseOperationOutcomeOperationOutcomeIssueComponent(JSONObject json, OperationOutcome owner) throws Exception {
    OperationOutcome.OperationOutcomeIssueComponent res = owner.new OperationOutcomeIssueComponent();
    parseElementProperties(json, res);
    if (json.has("severity"))
      res.setSeverity(parseEnumeration(json.getJSONObject("severity"), OperationOutcome.IssueSeverity.Null, new OperationOutcome().new IssueSeverityEnumFactory()));
    if (json.has("type"))
      res.setType(parseCoding(json.getJSONObject("type")));
    if (json.has("details"))
      res.setDetails(parseString(json.getJSONObject("details")));
    if (json.has("location")) {
      JSONArray array = json.getJSONArray("location");
      for (int i = 0; i < array.length(); i++) {
        res.getLocation().add(parseString(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private Order parseOrder(JSONObject json) throws Exception {
    Order res = new Order();
    parseResourceProperties(json, res);
    if (json.has("date"))
      res.setDate(parseDateTime(json.getJSONObject("date")));
    if (json.has("subject"))
      res.setSubject(parseResourceReference(json.getJSONObject("subject")));
    if (json.has("source"))
      res.setSource(parseResourceReference(json.getJSONObject("source")));
    if (json.has("target"))
      res.setTarget(parseResourceReference(json.getJSONObject("target")));
    if (json.has("reason"))
      res.setReason(parseString(json.getJSONObject("reason")));
    if (json.has("authority"))
      res.setAuthority(parseResourceReference(json.getJSONObject("authority")));
    if (json.has("payment"))
      res.setPayment(parseResourceReference(json.getJSONObject("payment")));
    if (json.has("when"))
      res.setWhen(parseOrderOrderWhenComponent(json.getJSONObject("when"), res));
    if (json.has("detail")) {
      JSONArray array = json.getJSONArray("detail");
      for (int i = 0; i < array.length(); i++) {
        res.getDetail().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private Order.OrderWhenComponent parseOrderOrderWhenComponent(JSONObject json, Order owner) throws Exception {
    Order.OrderWhenComponent res = owner.new OrderWhenComponent();
    parseElementProperties(json, res);
    if (json.has("code"))
      res.setCode(parseCodeableConcept(json.getJSONObject("code")));
    if (json.has("schedule"))
      res.setSchedule(parseSchedule(json.getJSONObject("schedule")));
    return res;
  }

  private OrderResponse parseOrderResponse(JSONObject json) throws Exception {
    OrderResponse res = new OrderResponse();
    parseResourceProperties(json, res);
    if (json.has("request"))
      res.setRequest(parseResourceReference(json.getJSONObject("request")));
    if (json.has("date"))
      res.setDate(parseDateTime(json.getJSONObject("date")));
    if (json.has("who"))
      res.setWho(parseResourceReference(json.getJSONObject("who")));
    if (json.has("authority"))
      res.setAuthority(parseResourceReference(json.getJSONObject("authority")));
    if (json.has("cost"))
      res.setCost(parseMoney(json.getJSONObject("cost")));
    if (json.has("code"))
      res.setCode(parseEnumeration(json.getJSONObject("code"), OrderResponse.OrderOutcomeCode.Null, new OrderResponse().new OrderOutcomeCodeEnumFactory()));
    if (json.has("description"))
      res.setDescription(parseString(json.getJSONObject("description")));
    if (json.has("fulfillment")) {
      JSONArray array = json.getJSONArray("fulfillment");
      for (int i = 0; i < array.length(); i++) {
        res.getFulfillment().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private Organization parseOrganization(JSONObject json) throws Exception {
    Organization res = new Organization();
    parseResourceProperties(json, res);
    if (json.has("identifier")) {
      JSONArray array = json.getJSONArray("identifier");
      for (int i = 0; i < array.length(); i++) {
        res.getIdentifier().add(parseIdentifier(array.getJSONObject(i)));
      }
    };
    if (json.has("name")) {
      JSONArray array = json.getJSONArray("name");
      for (int i = 0; i < array.length(); i++) {
        res.getName().add(parseString(array.getJSONObject(i)));
      }
    };
    if (json.has("type"))
      res.setType(parseCodeableConcept(json.getJSONObject("type")));
    if (json.has("address")) {
      JSONArray array = json.getJSONArray("address");
      for (int i = 0; i < array.length(); i++) {
        res.getAddress().add(parseAddress(array.getJSONObject(i)));
      }
    };
    if (json.has("telecom")) {
      JSONArray array = json.getJSONArray("telecom");
      for (int i = 0; i < array.length(); i++) {
        res.getTelecom().add(parseContact(array.getJSONObject(i)));
      }
    };
    if (json.has("active"))
      res.setActive(parseBoolean(json.getJSONObject("active")));
    if (json.has("accreditation")) {
      JSONArray array = json.getJSONArray("accreditation");
      for (int i = 0; i < array.length(); i++) {
        res.getAccreditation().add(parseOrganizationOrganizationAccreditationComponent(array.getJSONObject(i), res));
      }
    };
    if (json.has("partOf"))
      res.setPartOf(parseResourceReference(json.getJSONObject("partOf")));
    if (json.has("contactEntity")) {
      JSONArray array = json.getJSONArray("contactEntity");
      for (int i = 0; i < array.length(); i++) {
        res.getContactEntity().add(parseOrganizationOrganizationContactEntityComponent(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private Organization.OrganizationAccreditationComponent parseOrganizationOrganizationAccreditationComponent(JSONObject json, Organization owner) throws Exception {
    Organization.OrganizationAccreditationComponent res = owner.new OrganizationAccreditationComponent();
    parseElementProperties(json, res);
    if (json.has("identifier"))
      res.setIdentifier(parseIdentifier(json.getJSONObject("identifier")));
    if (json.has("code"))
      res.setCode(parseCodeableConcept(json.getJSONObject("code")));
    if (json.has("issuer"))
      res.setIssuer(parseResourceReference(json.getJSONObject("issuer")));
    if (json.has("period"))
      res.setPeriod(parsePeriod(json.getJSONObject("period")));
    return res;
  }

  private Organization.OrganizationContactEntityComponent parseOrganizationOrganizationContactEntityComponent(JSONObject json, Organization owner) throws Exception {
    Organization.OrganizationContactEntityComponent res = owner.new OrganizationContactEntityComponent();
    parseElementProperties(json, res);
    if (json.has("type"))
      res.setType(parseCodeableConcept(json.getJSONObject("type")));
    if (json.has("name"))
      res.setName(parseHumanName(json.getJSONObject("name")));
    if (json.has("telecom")) {
      JSONArray array = json.getJSONArray("telecom");
      for (int i = 0; i < array.length(); i++) {
        res.getTelecom().add(parseContact(array.getJSONObject(i)));
      }
    };
    if (json.has("address"))
      res.setAddress(parseAddress(json.getJSONObject("address")));
    return res;
  }

  private Other parseOther(JSONObject json) throws Exception {
    Other res = new Other();
    parseResourceProperties(json, res);
    if (json.has("code"))
      res.setCode(parseCodeableConcept(json.getJSONObject("code")));
    return res;
  }

  private Patient parsePatient(JSONObject json) throws Exception {
    Patient res = new Patient();
    parseResourceProperties(json, res);
    if (json.has("link")) {
      JSONArray array = json.getJSONArray("link");
      for (int i = 0; i < array.length(); i++) {
        res.getLink().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    if (json.has("active"))
      res.setActive(parseBoolean(json.getJSONObject("active")));
    if (json.has("identifier")) {
      JSONArray array = json.getJSONArray("identifier");
      for (int i = 0; i < array.length(); i++) {
        res.getIdentifier().add(parseIdentifier(array.getJSONObject(i)));
      }
    };
    if (json.has("details"))
      res.setDetails(parseDemographics(json.getJSONObject("details")));
    if (json.has("contact")) {
      JSONArray array = json.getJSONArray("contact");
      for (int i = 0; i < array.length(); i++) {
        res.getContact().add(parsePatientContactComponent(array.getJSONObject(i), res));
      }
    };
    if (json.has("animal"))
      res.setAnimal(parsePatientAnimalComponent(json.getJSONObject("animal"), res));
    if (json.has("provider"))
      res.setProvider(parseResourceReference(json.getJSONObject("provider")));
    Type multipleBirth = parseType("multipleBirth", json);
    if (multipleBirth != null)
      res.setMultipleBirth(multipleBirth);
    if (json.has("deceasedDate"))
      res.setDeceasedDate(parseDateTime(json.getJSONObject("deceasedDate")));
    return res;
  }

  private Patient.ContactComponent parsePatientContactComponent(JSONObject json, Patient owner) throws Exception {
    Patient.ContactComponent res = owner.new ContactComponent();
    parseElementProperties(json, res);
    if (json.has("relationship")) {
      JSONArray array = json.getJSONArray("relationship");
      for (int i = 0; i < array.length(); i++) {
        res.getRelationship().add(parseCodeableConcept(array.getJSONObject(i)));
      }
    };
    if (json.has("details"))
      res.setDetails(parseDemographics(json.getJSONObject("details")));
    if (json.has("organization"))
      res.setOrganization(parseResourceReference(json.getJSONObject("organization")));
    return res;
  }

  private Patient.AnimalComponent parsePatientAnimalComponent(JSONObject json, Patient owner) throws Exception {
    Patient.AnimalComponent res = owner.new AnimalComponent();
    parseElementProperties(json, res);
    if (json.has("species"))
      res.setSpecies(parseCodeableConcept(json.getJSONObject("species")));
    if (json.has("breed"))
      res.setBreed(parseCodeableConcept(json.getJSONObject("breed")));
    if (json.has("genderStatus"))
      res.setGenderStatus(parseCodeableConcept(json.getJSONObject("genderStatus")));
    return res;
  }

  private Picture parsePicture(JSONObject json) throws Exception {
    Picture res = new Picture();
    parseResourceProperties(json, res);
    if (json.has("subject"))
      res.setSubject(parseResourceReference(json.getJSONObject("subject")));
    if (json.has("dateTime"))
      res.setDateTime(parseDateTime(json.getJSONObject("dateTime")));
    if (json.has("operator"))
      res.setOperator(parseResourceReference(json.getJSONObject("operator")));
    if (json.has("identifier"))
      res.setIdentifier(parseIdentifier(json.getJSONObject("identifier")));
    if (json.has("accessionNo"))
      res.setAccessionNo(parseIdentifier(json.getJSONObject("accessionNo")));
    if (json.has("studyId"))
      res.setStudyId(parseIdentifier(json.getJSONObject("studyId")));
    if (json.has("seriesId"))
      res.setSeriesId(parseIdentifier(json.getJSONObject("seriesId")));
    if (json.has("method"))
      res.setMethod(parseCodeableConcept(json.getJSONObject("method")));
    if (json.has("requester"))
      res.setRequester(parseResourceReference(json.getJSONObject("requester")));
    if (json.has("modality"))
      res.setModality(parseEnumeration(json.getJSONObject("modality"), Picture.ImageModality.Null, new Picture().new ImageModalityEnumFactory()));
    if (json.has("deviceName"))
      res.setDeviceName(parseString(json.getJSONObject("deviceName")));
    if (json.has("height"))
      res.setHeight(parseInteger(json.getJSONObject("height")));
    if (json.has("width"))
      res.setWidth(parseInteger(json.getJSONObject("width")));
    if (json.has("bits"))
      res.setBits(parseInteger(json.getJSONObject("bits")));
    if (json.has("frames"))
      res.setFrames(parseInteger(json.getJSONObject("frames")));
    if (json.has("frameDelay"))
      res.setFrameDelay(parseDuration(json.getJSONObject("frameDelay")));
    if (json.has("view"))
      res.setView(parseCodeableConcept(json.getJSONObject("view")));
    if (json.has("content"))
      res.setContent(parseAttachment(json.getJSONObject("content")));
    return res;
  }

  private Practitioner parsePractitioner(JSONObject json) throws Exception {
    Practitioner res = new Practitioner();
    parseResourceProperties(json, res);
    if (json.has("identifier")) {
      JSONArray array = json.getJSONArray("identifier");
      for (int i = 0; i < array.length(); i++) {
        res.getIdentifier().add(parseIdentifier(array.getJSONObject(i)));
      }
    };
    if (json.has("details"))
      res.setDetails(parseDemographics(json.getJSONObject("details")));
    if (json.has("organization"))
      res.setOrganization(parseResourceReference(json.getJSONObject("organization")));
    if (json.has("role")) {
      JSONArray array = json.getJSONArray("role");
      for (int i = 0; i < array.length(); i++) {
        res.getRole().add(parseCodeableConcept(array.getJSONObject(i)));
      }
    };
    if (json.has("specialty")) {
      JSONArray array = json.getJSONArray("specialty");
      for (int i = 0; i < array.length(); i++) {
        res.getSpecialty().add(parseCodeableConcept(array.getJSONObject(i)));
      }
    };
    if (json.has("period"))
      res.setPeriod(parsePeriod(json.getJSONObject("period")));
    if (json.has("qualification")) {
      JSONArray array = json.getJSONArray("qualification");
      for (int i = 0; i < array.length(); i++) {
        res.getQualification().add(parsePractitionerPractitionerQualificationComponent(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private Practitioner.PractitionerQualificationComponent parsePractitionerPractitionerQualificationComponent(JSONObject json, Practitioner owner) throws Exception {
    Practitioner.PractitionerQualificationComponent res = owner.new PractitionerQualificationComponent();
    parseElementProperties(json, res);
    if (json.has("code"))
      res.setCode(parseCodeableConcept(json.getJSONObject("code")));
    if (json.has("period"))
      res.setPeriod(parsePeriod(json.getJSONObject("period")));
    if (json.has("issuer"))
      res.setIssuer(parseResourceReference(json.getJSONObject("issuer")));
    return res;
  }

  private Problem parseProblem(JSONObject json) throws Exception {
    Problem res = new Problem();
    parseResourceProperties(json, res);
    if (json.has("subject"))
      res.setSubject(parseResourceReference(json.getJSONObject("subject")));
    if (json.has("visit"))
      res.setVisit(parseResourceReference(json.getJSONObject("visit")));
    if (json.has("asserter"))
      res.setAsserter(parseResourceReference(json.getJSONObject("asserter")));
    if (json.has("dateAsserted"))
      res.setDateAsserted(parseDate(json.getJSONObject("dateAsserted")));
    if (json.has("code"))
      res.setCode(parseCodeableConcept(json.getJSONObject("code")));
    if (json.has("category"))
      res.setCategory(parseCodeableConcept(json.getJSONObject("category")));
    if (json.has("status"))
      res.setStatus(parseEnumeration(json.getJSONObject("status"), Problem.ProblemStatus.Null, new Problem().new ProblemStatusEnumFactory()));
    if (json.has("certainty"))
      res.setCertainty(parseCodeableConcept(json.getJSONObject("certainty")));
    if (json.has("severity"))
      res.setSeverity(parseCodeableConcept(json.getJSONObject("severity")));
    Type onset = parseType("onset", json);
    if (onset != null)
      res.setOnset(onset);
    Type abatement = parseType("abatement", json);
    if (abatement != null)
      res.setAbatement(abatement);
    if (json.has("stage"))
      res.setStage(parseProblemProblemStageComponent(json.getJSONObject("stage"), res));
    if (json.has("evidence")) {
      JSONArray array = json.getJSONArray("evidence");
      for (int i = 0; i < array.length(); i++) {
        res.getEvidence().add(parseProblemProblemEvidenceComponent(array.getJSONObject(i), res));
      }
    };
    if (json.has("location")) {
      JSONArray array = json.getJSONArray("location");
      for (int i = 0; i < array.length(); i++) {
        res.getLocation().add(parseProblemProblemLocationComponent(array.getJSONObject(i), res));
      }
    };
    if (json.has("relatedItem")) {
      JSONArray array = json.getJSONArray("relatedItem");
      for (int i = 0; i < array.length(); i++) {
        res.getRelatedItem().add(parseProblemProblemRelatedItemComponent(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private Problem.ProblemStageComponent parseProblemProblemStageComponent(JSONObject json, Problem owner) throws Exception {
    Problem.ProblemStageComponent res = owner.new ProblemStageComponent();
    parseElementProperties(json, res);
    if (json.has("summary"))
      res.setSummary(parseCodeableConcept(json.getJSONObject("summary")));
    if (json.has("assessment")) {
      JSONArray array = json.getJSONArray("assessment");
      for (int i = 0; i < array.length(); i++) {
        res.getAssessment().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private Problem.ProblemEvidenceComponent parseProblemProblemEvidenceComponent(JSONObject json, Problem owner) throws Exception {
    Problem.ProblemEvidenceComponent res = owner.new ProblemEvidenceComponent();
    parseElementProperties(json, res);
    if (json.has("code"))
      res.setCode(parseCodeableConcept(json.getJSONObject("code")));
    if (json.has("details")) {
      JSONArray array = json.getJSONArray("details");
      for (int i = 0; i < array.length(); i++) {
        res.getDetails().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private Problem.ProblemLocationComponent parseProblemProblemLocationComponent(JSONObject json, Problem owner) throws Exception {
    Problem.ProblemLocationComponent res = owner.new ProblemLocationComponent();
    parseElementProperties(json, res);
    if (json.has("code"))
      res.setCode(parseCodeableConcept(json.getJSONObject("code")));
    if (json.has("details"))
      res.setDetails(parseString(json.getJSONObject("details")));
    return res;
  }

  private Problem.ProblemRelatedItemComponent parseProblemProblemRelatedItemComponent(JSONObject json, Problem owner) throws Exception {
    Problem.ProblemRelatedItemComponent res = owner.new ProblemRelatedItemComponent();
    parseElementProperties(json, res);
    if (json.has("type"))
      res.setType(parseEnumeration(json.getJSONObject("type"), Problem.ProblemRelationshipType.Null, new Problem().new ProblemRelationshipTypeEnumFactory()));
    if (json.has("target"))
      res.setTarget(parseResourceReference(json.getJSONObject("target")));
    return res;
  }

  private Procedure parseProcedure(JSONObject json) throws Exception {
    Procedure res = new Procedure();
    parseResourceProperties(json, res);
    if (json.has("subject"))
      res.setSubject(parseResourceReference(json.getJSONObject("subject")));
    if (json.has("description"))
      res.setDescription(parseProcedureProcedureDescriptionComponent(json.getJSONObject("description"), res));
    if (json.has("indication"))
      res.setIndication(parseString(json.getJSONObject("indication")));
    if (json.has("performer")) {
      JSONArray array = json.getJSONArray("performer");
      for (int i = 0; i < array.length(); i++) {
        res.getPerformer().add(parseProcedureProcedurePerformerComponent(array.getJSONObject(i), res));
      }
    };
    if (json.has("date"))
      res.setDate(parsePeriod(json.getJSONObject("date")));
    if (json.has("visit"))
      res.setVisit(parseResourceReference(json.getJSONObject("visit")));
    if (json.has("outcome"))
      res.setOutcome(parseString(json.getJSONObject("outcome")));
    if (json.has("report")) {
      JSONArray array = json.getJSONArray("report");
      for (int i = 0; i < array.length(); i++) {
        res.getReport().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    if (json.has("complication"))
      res.setComplication(parseString(json.getJSONObject("complication")));
    if (json.has("followUp"))
      res.setFollowUp(parseString(json.getJSONObject("followUp")));
    if (json.has("relatedItem")) {
      JSONArray array = json.getJSONArray("relatedItem");
      for (int i = 0; i < array.length(); i++) {
        res.getRelatedItem().add(parseProcedureProcedureRelatedItemComponent(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private Procedure.ProcedureDescriptionComponent parseProcedureProcedureDescriptionComponent(JSONObject json, Procedure owner) throws Exception {
    Procedure.ProcedureDescriptionComponent res = owner.new ProcedureDescriptionComponent();
    parseElementProperties(json, res);
    if (json.has("type"))
      res.setType(parseCodeableConcept(json.getJSONObject("type")));
    if (json.has("notes"))
      res.setNotes(parseString(json.getJSONObject("notes")));
    if (json.has("bodySite")) {
      JSONArray array = json.getJSONArray("bodySite");
      for (int i = 0; i < array.length(); i++) {
        res.getBodySite().add(parseCodeableConcept(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private Procedure.ProcedurePerformerComponent parseProcedureProcedurePerformerComponent(JSONObject json, Procedure owner) throws Exception {
    Procedure.ProcedurePerformerComponent res = owner.new ProcedurePerformerComponent();
    parseElementProperties(json, res);
    if (json.has("person"))
      res.setPerson(parseResourceReference(json.getJSONObject("person")));
    if (json.has("role"))
      res.setRole(parseCodeableConcept(json.getJSONObject("role")));
    return res;
  }

  private Procedure.ProcedureRelatedItemComponent parseProcedureProcedureRelatedItemComponent(JSONObject json, Procedure owner) throws Exception {
    Procedure.ProcedureRelatedItemComponent res = owner.new ProcedureRelatedItemComponent();
    parseElementProperties(json, res);
    if (json.has("type"))
      res.setType(parseEnumeration(json.getJSONObject("type"), Procedure.ProcedureRelationshipType.Null, new Procedure().new ProcedureRelationshipTypeEnumFactory()));
    if (json.has("target"))
      res.setTarget(parseResourceReference(json.getJSONObject("target")));
    return res;
  }

  private Profile parseProfile(JSONObject json) throws Exception {
    Profile res = new Profile();
    parseResourceProperties(json, res);
    if (json.has("identifier"))
      res.setIdentifier(parseString(json.getJSONObject("identifier")));
    if (json.has("version"))
      res.setVersion(parseString(json.getJSONObject("version")));
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("publisher"))
      res.setPublisher(parseString(json.getJSONObject("publisher")));
    if (json.has("telecom")) {
      JSONArray array = json.getJSONArray("telecom");
      for (int i = 0; i < array.length(); i++) {
        res.getTelecom().add(parseContact(array.getJSONObject(i)));
      }
    };
    if (json.has("description"))
      res.setDescription(parseString(json.getJSONObject("description")));
    if (json.has("code")) {
      JSONArray array = json.getJSONArray("code");
      for (int i = 0; i < array.length(); i++) {
        res.getCode().add(parseCoding(array.getJSONObject(i)));
      }
    };
    if (json.has("status"))
      res.setStatus(parseProfileProfileStatusComponent(json.getJSONObject("status"), res));
    if (json.has("import")) {
      JSONArray array = json.getJSONArray("import");
      for (int i = 0; i < array.length(); i++) {
        res.getImport().add(parseProfileProfileImportComponent(array.getJSONObject(i), res));
      }
    };
    if (json.has("bundle"))
      res.setBundle(parseCode(json.getJSONObject("bundle")));
    if (json.has("structure")) {
      JSONArray array = json.getJSONArray("structure");
      for (int i = 0; i < array.length(); i++) {
        res.getStructure().add(parseProfileProfileStructureComponent(array.getJSONObject(i), res));
      }
    };
    if (json.has("extensionDefn")) {
      JSONArray array = json.getJSONArray("extensionDefn");
      for (int i = 0; i < array.length(); i++) {
        res.getExtensionDefn().add(parseProfileProfileExtensionDefnComponent(array.getJSONObject(i), res));
      }
    };
    if (json.has("binding")) {
      JSONArray array = json.getJSONArray("binding");
      for (int i = 0; i < array.length(); i++) {
        res.getBinding().add(parseProfileProfileBindingComponent(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private Profile.ProfileStatusComponent parseProfileProfileStatusComponent(JSONObject json, Profile owner) throws Exception {
    Profile.ProfileStatusComponent res = owner.new ProfileStatusComponent();
    parseElementProperties(json, res);
    if (json.has("code"))
      res.setCode(parseEnumeration(json.getJSONObject("code"), Profile.ResourceProfileStatus.Null, new Profile().new ResourceProfileStatusEnumFactory()));
    if (json.has("date"))
      res.setDate(parseDateTime(json.getJSONObject("date")));
    if (json.has("comment"))
      res.setComment(parseString(json.getJSONObject("comment")));
    return res;
  }

  private Profile.ProfileImportComponent parseProfileProfileImportComponent(JSONObject json, Profile owner) throws Exception {
    Profile.ProfileImportComponent res = owner.new ProfileImportComponent();
    parseElementProperties(json, res);
    if (json.has("uri"))
      res.setUri(parseUri(json.getJSONObject("uri")));
    if (json.has("prefix"))
      res.setPrefix(parseString(json.getJSONObject("prefix")));
    return res;
  }

  private Profile.ProfileStructureComponent parseProfileProfileStructureComponent(JSONObject json, Profile owner) throws Exception {
    Profile.ProfileStructureComponent res = owner.new ProfileStructureComponent();
    parseElementProperties(json, res);
    if (json.has("type"))
      res.setType(parseCode(json.getJSONObject("type")));
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("purpose"))
      res.setPurpose(parseString(json.getJSONObject("purpose")));
    if (json.has("profile"))
      res.setProfile(parseUri(json.getJSONObject("profile")));
    if (json.has("element")) {
      JSONArray array = json.getJSONArray("element");
      for (int i = 0; i < array.length(); i++) {
        res.getElement().add(parseProfileElementComponent(array.getJSONObject(i), owner));
      }
    };
    if (json.has("searchParam")) {
      JSONArray array = json.getJSONArray("searchParam");
      for (int i = 0; i < array.length(); i++) {
        res.getSearchParam().add(parseProfileProfileStructureSearchParamComponent(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private Profile.ElementComponent parseProfileElementComponent(JSONObject json, Profile owner) throws Exception {
    Profile.ElementComponent res = owner.new ElementComponent();
    parseElementProperties(json, res);
    if (json.has("path"))
      res.setPath(parseString(json.getJSONObject("path")));
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("definition"))
      res.setDefinition(parseProfileElementDefinitionComponent(json.getJSONObject("definition"), owner));
    if (json.has("bundled"))
      res.setBundled(parseBoolean(json.getJSONObject("bundled")));
    return res;
  }

  private Profile.ElementDefinitionComponent parseProfileElementDefinitionComponent(JSONObject json, Profile owner) throws Exception {
    Profile.ElementDefinitionComponent res = owner.new ElementDefinitionComponent();
    parseElementProperties(json, res);
    if (json.has("short"))
      res.setShort(parseString(json.getJSONObject("short")));
    if (json.has("formal"))
      res.setFormal(parseString(json.getJSONObject("formal")));
    if (json.has("comments"))
      res.setComments(parseString(json.getJSONObject("comments")));
    if (json.has("requirements"))
      res.setRequirements(parseString(json.getJSONObject("requirements")));
    if (json.has("synonym")) {
      JSONArray array = json.getJSONArray("synonym");
      for (int i = 0; i < array.length(); i++) {
        res.getSynonym().add(parseString(array.getJSONObject(i)));
      }
    };
    if (json.has("min"))
      res.setMin(parseInteger(json.getJSONObject("min")));
    if (json.has("max"))
      res.setMax(parseString(json.getJSONObject("max")));
    if (json.has("type")) {
      JSONArray array = json.getJSONArray("type");
      for (int i = 0; i < array.length(); i++) {
        res.getType().add(parseProfileTypeRefComponent(array.getJSONObject(i), owner));
      }
    };
    if (json.has("nameReference"))
      res.setNameReference(parseString(json.getJSONObject("nameReference")));
    Type value = parseType("value", json);
    if (value != null)
      res.setValue(value);
    if (json.has("maxLength"))
      res.setMaxLength(parseInteger(json.getJSONObject("maxLength")));
    if (json.has("condition")) {
      JSONArray array = json.getJSONArray("condition");
      for (int i = 0; i < array.length(); i++) {
        res.getCondition().add(parseId(array.getJSONObject(i)));
      }
    };
    if (json.has("constraint")) {
      JSONArray array = json.getJSONArray("constraint");
      for (int i = 0; i < array.length(); i++) {
        res.getConstraint().add(parseProfileElementDefinitionConstraintComponent(array.getJSONObject(i), owner));
      }
    };
    if (json.has("mustSupport"))
      res.setMustSupport(parseBoolean(json.getJSONObject("mustSupport")));
    if (json.has("mustUnderstand"))
      res.setMustUnderstand(parseBoolean(json.getJSONObject("mustUnderstand")));
    if (json.has("binding"))
      res.setBinding(parseString(json.getJSONObject("binding")));
    if (json.has("mapping")) {
      JSONArray array = json.getJSONArray("mapping");
      for (int i = 0; i < array.length(); i++) {
        res.getMapping().add(parseProfileElementDefinitionMappingComponent(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private Profile.TypeRefComponent parseProfileTypeRefComponent(JSONObject json, Profile owner) throws Exception {
    Profile.TypeRefComponent res = owner.new TypeRefComponent();
    parseElementProperties(json, res);
    if (json.has("code"))
      res.setCode(parseCode(json.getJSONObject("code")));
    if (json.has("profile"))
      res.setProfile(parseUri(json.getJSONObject("profile")));
    return res;
  }

  private Profile.ElementDefinitionConstraintComponent parseProfileElementDefinitionConstraintComponent(JSONObject json, Profile owner) throws Exception {
    Profile.ElementDefinitionConstraintComponent res = owner.new ElementDefinitionConstraintComponent();
    parseElementProperties(json, res);
    if (json.has("key"))
      res.setKey(parseId(json.getJSONObject("key")));
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("severity"))
      res.setSeverity(parseEnumeration(json.getJSONObject("severity"), Profile.ConstraintSeverity.Null, new Profile().new ConstraintSeverityEnumFactory()));
    if (json.has("human"))
      res.setHuman(parseString(json.getJSONObject("human")));
    if (json.has("xpath"))
      res.setXpath(parseString(json.getJSONObject("xpath")));
    if (json.has("ocl"))
      res.setOcl(parseString(json.getJSONObject("ocl")));
    return res;
  }

  private Profile.ElementDefinitionMappingComponent parseProfileElementDefinitionMappingComponent(JSONObject json, Profile owner) throws Exception {
    Profile.ElementDefinitionMappingComponent res = owner.new ElementDefinitionMappingComponent();
    parseElementProperties(json, res);
    if (json.has("target"))
      res.setTarget(parseString(json.getJSONObject("target")));
    if (json.has("map"))
      res.setMap(parseString(json.getJSONObject("map")));
    return res;
  }

  private Profile.ProfileStructureSearchParamComponent parseProfileProfileStructureSearchParamComponent(JSONObject json, Profile owner) throws Exception {
    Profile.ProfileStructureSearchParamComponent res = owner.new ProfileStructureSearchParamComponent();
    parseElementProperties(json, res);
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("type"))
      res.setType(parseEnumeration(json.getJSONObject("type"), Profile.SearchParamType.Null, new Profile().new SearchParamTypeEnumFactory()));
    if (json.has("documentation"))
      res.setDocumentation(parseString(json.getJSONObject("documentation")));
    return res;
  }

  private Profile.ProfileExtensionDefnComponent parseProfileProfileExtensionDefnComponent(JSONObject json, Profile owner) throws Exception {
    Profile.ProfileExtensionDefnComponent res = owner.new ProfileExtensionDefnComponent();
    parseElementProperties(json, res);
    if (json.has("code"))
      res.setCode(parseId(json.getJSONObject("code")));
    if (json.has("contextType"))
      res.setContextType(parseEnumeration(json.getJSONObject("contextType"), Profile.ExtensionContext.Null, new Profile().new ExtensionContextEnumFactory()));
    if (json.has("context")) {
      JSONArray array = json.getJSONArray("context");
      for (int i = 0; i < array.length(); i++) {
        res.getContext().add(parseString(array.getJSONObject(i)));
      }
    };
    if (json.has("definition"))
      res.setDefinition(parseProfileElementDefinitionComponent(json.getJSONObject("definition"), owner));
    return res;
  }

  private Profile.ProfileBindingComponent parseProfileProfileBindingComponent(JSONObject json, Profile owner) throws Exception {
    Profile.ProfileBindingComponent res = owner.new ProfileBindingComponent();
    parseElementProperties(json, res);
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("definition"))
      res.setDefinition(parseString(json.getJSONObject("definition")));
    if (json.has("type"))
      res.setType(parseEnumeration(json.getJSONObject("type"), Profile.BindingType.Null, new Profile().new BindingTypeEnumFactory()));
    if (json.has("isExtensible"))
      res.setIsExtensible(parseBoolean(json.getJSONObject("isExtensible")));
    if (json.has("conformance"))
      res.setConformance(parseEnumeration(json.getJSONObject("conformance"), Profile.BindingConformance.Null, new Profile().new BindingConformanceEnumFactory()));
    Type reference = parseType("reference", json);
    if (reference != null)
      res.setReference(reference);
    return res;
  }

  private Protocol parseProtocol(JSONObject json) throws Exception {
    Protocol res = new Protocol();
    parseResourceProperties(json, res);
    if (json.has("title"))
      res.setTitle(parseString(json.getJSONObject("title")));
    if (json.has("type"))
      res.setType(parseEnumeration(json.getJSONObject("type"), Protocol.ProtocolType.Null, new Protocol().new ProtocolTypeEnumFactory()));
    if (json.has("status"))
      res.setStatus(parseEnumeration(json.getJSONObject("status"), Protocol.ProtocolStatus.Null, new Protocol().new ProtocolStatusEnumFactory()));
    if (json.has("author"))
      res.setAuthor(parseResourceReference(json.getJSONObject("author")));
    if (json.has("purpose"))
      res.setPurpose(parseString(json.getJSONObject("purpose")));
    if (json.has("subject"))
      res.setSubject(parseResourceReference(json.getJSONObject("subject")));
    if (json.has("group"))
      res.setGroup(parseResourceReference(json.getJSONObject("group")));
    if (json.has("step")) {
      JSONArray array = json.getJSONArray("step");
      for (int i = 0; i < array.length(); i++) {
        res.getStep().add(parseProtocolProtocolStepComponent(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private Protocol.ProtocolStepComponent parseProtocolProtocolStepComponent(JSONObject json, Protocol owner) throws Exception {
    Protocol.ProtocolStepComponent res = owner.new ProtocolStepComponent();
    parseElementProperties(json, res);
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("description"))
      res.setDescription(parseString(json.getJSONObject("description")));
    if (json.has("duration"))
      res.setDuration(parseDuration(json.getJSONObject("duration")));
    if (json.has("precondition"))
      res.setPrecondition(parseProtocolProtocolStepPreconditionComponent(json.getJSONObject("precondition"), owner));
    if (json.has("exit"))
      res.setExit(parseProtocolProtocolStepPreconditionComponent(json.getJSONObject("exit"), owner));
    if (json.has("firstActivity"))
      res.setFirstActivity(parseString(json.getJSONObject("firstActivity")));
    if (json.has("activity")) {
      JSONArray array = json.getJSONArray("activity");
      for (int i = 0; i < array.length(); i++) {
        res.getActivity().add(parseProtocolProtocolStepActivityComponent(array.getJSONObject(i), owner));
      }
    };
    if (json.has("next")) {
      JSONArray array = json.getJSONArray("next");
      for (int i = 0; i < array.length(); i++) {
        res.getNext().add(parseProtocolProtocolStepNextComponent(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private Protocol.ProtocolStepPreconditionComponent parseProtocolProtocolStepPreconditionComponent(JSONObject json, Protocol owner) throws Exception {
    Protocol.ProtocolStepPreconditionComponent res = owner.new ProtocolStepPreconditionComponent();
    parseElementProperties(json, res);
    if (json.has("description"))
      res.setDescription(parseString(json.getJSONObject("description")));
    if (json.has("condition"))
      res.setCondition(parseProtocolProtocolStepPreconditionConditionComponent(json.getJSONObject("condition"), owner));
    if (json.has("intersection")) {
      JSONArray array = json.getJSONArray("intersection");
      for (int i = 0; i < array.length(); i++) {
        res.getIntersection().add(parseProtocolProtocolStepPreconditionComponent(array.getJSONObject(i), owner));
      }
    };
    if (json.has("union")) {
      JSONArray array = json.getJSONArray("union");
      for (int i = 0; i < array.length(); i++) {
        res.getUnion().add(parseProtocolProtocolStepPreconditionComponent(array.getJSONObject(i), owner));
      }
    };
    if (json.has("exclude")) {
      JSONArray array = json.getJSONArray("exclude");
      for (int i = 0; i < array.length(); i++) {
        res.getExclude().add(parseProtocolProtocolStepPreconditionComponent(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private Protocol.ProtocolStepPreconditionConditionComponent parseProtocolProtocolStepPreconditionConditionComponent(JSONObject json, Protocol owner) throws Exception {
    Protocol.ProtocolStepPreconditionConditionComponent res = owner.new ProtocolStepPreconditionConditionComponent();
    parseElementProperties(json, res);
    if (json.has("type"))
      res.setType(parseCodeableConcept(json.getJSONObject("type")));
    Type value = parseType("value", json);
    if (value != null)
      res.setValue(value);
    return res;
  }

  private Protocol.ProtocolStepActivityComponent parseProtocolProtocolStepActivityComponent(JSONObject json, Protocol owner) throws Exception {
    Protocol.ProtocolStepActivityComponent res = owner.new ProtocolStepActivityComponent();
    parseElementProperties(json, res);
    if (json.has("alternative")) {
      JSONArray array = json.getJSONArray("alternative");
      for (int i = 0; i < array.length(); i++) {
        res.getAlternative().add(parseString(array.getJSONObject(i)));
      }
    };
    if (json.has("component")) {
      JSONArray array = json.getJSONArray("component");
      for (int i = 0; i < array.length(); i++) {
        res.getComponent().add(parseProtocolProtocolStepActivityComponentComponent(array.getJSONObject(i), owner));
      }
    };
    if (json.has("following")) {
      JSONArray array = json.getJSONArray("following");
      for (int i = 0; i < array.length(); i++) {
        res.getFollowing().add(parseString(array.getJSONObject(i)));
      }
    };
    if (json.has("wait"))
      res.setWait(parseDuration(json.getJSONObject("wait")));
    if (json.has("detail"))
      res.setDetail(parseActivityDefinition(json.getJSONObject("detail")));
    return res;
  }

  private Protocol.ProtocolStepActivityComponentComponent parseProtocolProtocolStepActivityComponentComponent(JSONObject json, Protocol owner) throws Exception {
    Protocol.ProtocolStepActivityComponentComponent res = owner.new ProtocolStepActivityComponentComponent();
    parseElementProperties(json, res);
    if (json.has("sequence"))
      res.setSequence(parseInteger(json.getJSONObject("sequence")));
    if (json.has("activity"))
      res.setActivity(parseString(json.getJSONObject("activity")));
    return res;
  }

  private Protocol.ProtocolStepNextComponent parseProtocolProtocolStepNextComponent(JSONObject json, Protocol owner) throws Exception {
    Protocol.ProtocolStepNextComponent res = owner.new ProtocolStepNextComponent();
    parseElementProperties(json, res);
    if (json.has("description"))
      res.setDescription(parseString(json.getJSONObject("description")));
    if (json.has("id"))
      res.setId(parseString(json.getJSONObject("id")));
    if (json.has("condition"))
      res.setCondition(parseProtocolProtocolStepPreconditionComponent(json.getJSONObject("condition"), owner));
    return res;
  }

  private Provenance parseProvenance(JSONObject json) throws Exception {
    Provenance res = new Provenance();
    parseResourceProperties(json, res);
    if (json.has("target")) {
      JSONArray array = json.getJSONArray("target");
      for (int i = 0; i < array.length(); i++) {
        res.getTarget().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    if (json.has("activity"))
      res.setActivity(parseProvenanceProvenanceActivityComponent(json.getJSONObject("activity"), res));
    if (json.has("party")) {
      JSONArray array = json.getJSONArray("party");
      for (int i = 0; i < array.length(); i++) {
        res.getParty().add(parseProvenanceProvenancePartyComponent(array.getJSONObject(i), res));
      }
    };
    if (json.has("signature"))
      res.setSignature(parseString(json.getJSONObject("signature")));
    return res;
  }

  private Provenance.ProvenanceActivityComponent parseProvenanceProvenanceActivityComponent(JSONObject json, Provenance owner) throws Exception {
    Provenance.ProvenanceActivityComponent res = owner.new ProvenanceActivityComponent();
    parseElementProperties(json, res);
    if (json.has("period"))
      res.setPeriod(parsePeriod(json.getJSONObject("period")));
    if (json.has("recorded"))
      res.setRecorded(parseInstant(json.getJSONObject("recorded")));
    if (json.has("reason"))
      res.setReason(parseCodeableConcept(json.getJSONObject("reason")));
    if (json.has("location"))
      res.setLocation(parseResourceReference(json.getJSONObject("location")));
    if (json.has("policy"))
      res.setPolicy(parseUri(json.getJSONObject("policy")));
    return res;
  }

  private Provenance.ProvenancePartyComponent parseProvenanceProvenancePartyComponent(JSONObject json, Provenance owner) throws Exception {
    Provenance.ProvenancePartyComponent res = owner.new ProvenancePartyComponent();
    parseElementProperties(json, res);
    if (json.has("role"))
      res.setRole(parseCoding(json.getJSONObject("role")));
    if (json.has("type"))
      res.setType(parseCoding(json.getJSONObject("type")));
    if (json.has("identifier"))
      res.setIdentifier(parseUri(json.getJSONObject("identifier")));
    if (json.has("description"))
      res.setDescription(parseString(json.getJSONObject("description")));
    return res;
  }

  private Query parseQuery(JSONObject json) throws Exception {
    Query res = new Query();
    parseResourceProperties(json, res);
    if (json.has("id"))
      res.setId(parseUri(json.getJSONObject("id")));
    if (json.has("parameter")) {
      JSONArray array = json.getJSONArray("parameter");
      for (int i = 0; i < array.length(); i++) {
        res.getParameter().add(parseQueryQueryParameterComponent(array.getJSONObject(i), res));
      }
    };
    if (json.has("response"))
      res.setResponse(parseQueryQueryResponseComponent(json.getJSONObject("response"), res));
    return res;
  }

  private Query.QueryParameterComponent parseQueryQueryParameterComponent(JSONObject json, Query owner) throws Exception {
    Query.QueryParameterComponent res = owner.new QueryParameterComponent();
    parseElementProperties(json, res);
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("value"))
      res.setValue(parseString(json.getJSONObject("value")));
    return res;
  }

  private Query.QueryResponseComponent parseQueryQueryResponseComponent(JSONObject json, Query owner) throws Exception {
    Query.QueryResponseComponent res = owner.new QueryResponseComponent();
    parseElementProperties(json, res);
    if (json.has("id"))
      res.setId(parseUri(json.getJSONObject("id")));
    if (json.has("outcome"))
      res.setOutcome(parseEnumeration(json.getJSONObject("outcome"), Query.QueryOutcome.Null, new Query().new QueryOutcomeEnumFactory()));
    if (json.has("total"))
      res.setTotal(parseInteger(json.getJSONObject("total")));
    if (json.has("parameter")) {
      JSONArray array = json.getJSONArray("parameter");
      for (int i = 0; i < array.length(); i++) {
        res.getParameter().add(parseQueryQueryParameterComponent(array.getJSONObject(i), owner));
      }
    };
    if (json.has("first"))
      res.setFirst(parseQueryQueryResponseFirstComponent(json.getJSONObject("first"), owner));
    if (json.has("previous"))
      res.setPrevious(parseQueryQueryResponsePreviousComponent(json.getJSONObject("previous"), owner));
    if (json.has("next"))
      res.setNext(parseQueryQueryResponseNextComponent(json.getJSONObject("next"), owner));
    if (json.has("last"))
      res.setLast(parseQueryQueryResponseLastComponent(json.getJSONObject("last"), owner));
    if (json.has("reference")) {
      JSONArray array = json.getJSONArray("reference");
      for (int i = 0; i < array.length(); i++) {
        res.getReference().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private Query.QueryResponseFirstComponent parseQueryQueryResponseFirstComponent(JSONObject json, Query owner) throws Exception {
    Query.QueryResponseFirstComponent res = owner.new QueryResponseFirstComponent();
    parseElementProperties(json, res);
    if (json.has("parameter")) {
      JSONArray array = json.getJSONArray("parameter");
      for (int i = 0; i < array.length(); i++) {
        res.getParameter().add(parseQueryQueryParameterComponent(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private Query.QueryResponsePreviousComponent parseQueryQueryResponsePreviousComponent(JSONObject json, Query owner) throws Exception {
    Query.QueryResponsePreviousComponent res = owner.new QueryResponsePreviousComponent();
    parseElementProperties(json, res);
    if (json.has("parameter")) {
      JSONArray array = json.getJSONArray("parameter");
      for (int i = 0; i < array.length(); i++) {
        res.getParameter().add(parseQueryQueryParameterComponent(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private Query.QueryResponseNextComponent parseQueryQueryResponseNextComponent(JSONObject json, Query owner) throws Exception {
    Query.QueryResponseNextComponent res = owner.new QueryResponseNextComponent();
    parseElementProperties(json, res);
    if (json.has("parameter")) {
      JSONArray array = json.getJSONArray("parameter");
      for (int i = 0; i < array.length(); i++) {
        res.getParameter().add(parseQueryQueryParameterComponent(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private Query.QueryResponseLastComponent parseQueryQueryResponseLastComponent(JSONObject json, Query owner) throws Exception {
    Query.QueryResponseLastComponent res = owner.new QueryResponseLastComponent();
    parseElementProperties(json, res);
    if (json.has("parameter")) {
      JSONArray array = json.getJSONArray("parameter");
      for (int i = 0; i < array.length(); i++) {
        res.getParameter().add(parseQueryQueryParameterComponent(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private Questionnaire parseQuestionnaire(JSONObject json) throws Exception {
    Questionnaire res = new Questionnaire();
    parseResourceProperties(json, res);
    if (json.has("status"))
      res.setStatus(parseEnumeration(json.getJSONObject("status"), Questionnaire.ObservationStatus.Null, new Questionnaire().new ObservationStatusEnumFactory()));
    if (json.has("authored"))
      res.setAuthored(parseInstant(json.getJSONObject("authored")));
    if (json.has("subject"))
      res.setSubject(parseResourceReference(json.getJSONObject("subject")));
    if (json.has("author"))
      res.setAuthor(parseResourceReference(json.getJSONObject("author")));
    if (json.has("source"))
      res.setSource(parseResourceReference(json.getJSONObject("source")));
    if (json.has("name"))
      res.setName(parseCodeableConcept(json.getJSONObject("name")));
    if (json.has("identifier"))
      res.setIdentifier(parseIdentifier(json.getJSONObject("identifier")));
    if (json.has("visit"))
      res.setVisit(parseResourceReference(json.getJSONObject("visit")));
    if (json.has("answer")) {
      JSONArray array = json.getJSONArray("answer");
      for (int i = 0; i < array.length(); i++) {
        res.getAnswer().add(parseQuestionnaireAnswerComponent(array.getJSONObject(i), res));
      }
    };
    if (json.has("section")) {
      JSONArray array = json.getJSONArray("section");
      for (int i = 0; i < array.length(); i++) {
        res.getSection().add(parseQuestionnaireSectionComponent(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private Questionnaire.AnswerComponent parseQuestionnaireAnswerComponent(JSONObject json, Questionnaire owner) throws Exception {
    Questionnaire.AnswerComponent res = owner.new AnswerComponent();
    parseElementProperties(json, res);
    if (json.has("name"))
      res.setName(parseCodeableConcept(json.getJSONObject("name")));
    Type value = parseType("value", json);
    if (value != null)
      res.setValue(value);
    if (json.has("evidence"))
      res.setEvidence(parseResourceReference(json.getJSONObject("evidence")));
    if (json.has("remarks"))
      res.setRemarks(parseString(json.getJSONObject("remarks")));
    return res;
  }

  private Questionnaire.SectionComponent parseQuestionnaireSectionComponent(JSONObject json, Questionnaire owner) throws Exception {
    Questionnaire.SectionComponent res = owner.new SectionComponent();
    parseElementProperties(json, res);
    if (json.has("name"))
      res.setName(parseCodeableConcept(json.getJSONObject("name")));
    if (json.has("answer")) {
      JSONArray array = json.getJSONArray("answer");
      for (int i = 0; i < array.length(); i++) {
        res.getAnswer().add(parseQuestionnaireAnswerComponent(array.getJSONObject(i), owner));
      }
    };
    if (json.has("section")) {
      JSONArray array = json.getJSONArray("section");
      for (int i = 0; i < array.length(); i++) {
        res.getSection().add(parseQuestionnaireSectionComponent(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private SecurityEvent parseSecurityEvent(JSONObject json) throws Exception {
    SecurityEvent res = new SecurityEvent();
    parseResourceProperties(json, res);
    if (json.has("event"))
      res.setEvent(parseSecurityEventSecurityEventEventComponent(json.getJSONObject("event"), res));
    if (json.has("participant")) {
      JSONArray array = json.getJSONArray("participant");
      for (int i = 0; i < array.length(); i++) {
        res.getParticipant().add(parseSecurityEventSecurityEventParticipantComponent(array.getJSONObject(i), res));
      }
    };
    if (json.has("source"))
      res.setSource(parseSecurityEventSecurityEventSourceComponent(json.getJSONObject("source"), res));
    if (json.has("object")) {
      JSONArray array = json.getJSONArray("object");
      for (int i = 0; i < array.length(); i++) {
        res.getObject().add(parseSecurityEventSecurityEventObjectComponent(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private SecurityEvent.SecurityEventEventComponent parseSecurityEventSecurityEventEventComponent(JSONObject json, SecurityEvent owner) throws Exception {
    SecurityEvent.SecurityEventEventComponent res = owner.new SecurityEventEventComponent();
    parseElementProperties(json, res);
    if (json.has("identifier"))
      res.setIdentifier(parseCoding(json.getJSONObject("identifier")));
    if (json.has("action"))
      res.setAction(parseEnumeration(json.getJSONObject("action"), SecurityEvent.SecurityEventEventAction.Null, new SecurityEvent().new SecurityEventEventActionEnumFactory()));
    if (json.has("dateTime"))
      res.setDateTime(parseInstant(json.getJSONObject("dateTime")));
    if (json.has("outcome"))
      res.setOutcome(parseEnumeration(json.getJSONObject("outcome"), SecurityEvent.SecurityEventEventOutcome.Null, new SecurityEvent().new SecurityEventEventOutcomeEnumFactory()));
    if (json.has("code")) {
      JSONArray array = json.getJSONArray("code");
      for (int i = 0; i < array.length(); i++) {
        res.getCode().add(parseCoding(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private SecurityEvent.SecurityEventParticipantComponent parseSecurityEventSecurityEventParticipantComponent(JSONObject json, SecurityEvent owner) throws Exception {
    SecurityEvent.SecurityEventParticipantComponent res = owner.new SecurityEventParticipantComponent();
    parseElementProperties(json, res);
    if (json.has("userId"))
      res.setUserId(parseString(json.getJSONObject("userId")));
    if (json.has("otherUserId"))
      res.setOtherUserId(parseString(json.getJSONObject("otherUserId")));
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("requestor"))
      res.setRequestor(parseBoolean(json.getJSONObject("requestor")));
    if (json.has("role")) {
      JSONArray array = json.getJSONArray("role");
      for (int i = 0; i < array.length(); i++) {
        res.getRole().add(parseCoding(array.getJSONObject(i)));
      }
    };
    if (json.has("mediaId"))
      res.setMediaId(parseCodeableConcept(json.getJSONObject("mediaId")));
    if (json.has("network"))
      res.setNetwork(parseSecurityEventSecurityEventParticipantNetworkComponent(json.getJSONObject("network"), owner));
    return res;
  }

  private SecurityEvent.SecurityEventParticipantNetworkComponent parseSecurityEventSecurityEventParticipantNetworkComponent(JSONObject json, SecurityEvent owner) throws Exception {
    SecurityEvent.SecurityEventParticipantNetworkComponent res = owner.new SecurityEventParticipantNetworkComponent();
    parseElementProperties(json, res);
    if (json.has("type"))
      res.setType(parseEnumeration(json.getJSONObject("type"), SecurityEvent.NetworkType.Null, new SecurityEvent().new NetworkTypeEnumFactory()));
    if (json.has("identifier"))
      res.setIdentifier(parseString(json.getJSONObject("identifier")));
    return res;
  }

  private SecurityEvent.SecurityEventSourceComponent parseSecurityEventSecurityEventSourceComponent(JSONObject json, SecurityEvent owner) throws Exception {
    SecurityEvent.SecurityEventSourceComponent res = owner.new SecurityEventSourceComponent();
    parseElementProperties(json, res);
    if (json.has("site"))
      res.setSite(parseString(json.getJSONObject("site")));
    if (json.has("identifier"))
      res.setIdentifier(parseString(json.getJSONObject("identifier")));
    if (json.has("type")) {
      JSONArray array = json.getJSONArray("type");
      for (int i = 0; i < array.length(); i++) {
        res.getType().add(parseCoding(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private SecurityEvent.SecurityEventObjectComponent parseSecurityEventSecurityEventObjectComponent(JSONObject json, SecurityEvent owner) throws Exception {
    SecurityEvent.SecurityEventObjectComponent res = owner.new SecurityEventObjectComponent();
    parseElementProperties(json, res);
    if (json.has("type"))
      res.setType(parseEnumeration(json.getJSONObject("type"), SecurityEvent.ObjectType.Null, new SecurityEvent().new ObjectTypeEnumFactory()));
    if (json.has("role"))
      res.setRole(parseEnumeration(json.getJSONObject("role"), SecurityEvent.ObjectRole.Null, new SecurityEvent().new ObjectRoleEnumFactory()));
    if (json.has("lifecycle"))
      res.setLifecycle(parseEnumeration(json.getJSONObject("lifecycle"), SecurityEvent.ObjectLifecycle.Null, new SecurityEvent().new ObjectLifecycleEnumFactory()));
    if (json.has("idType"))
      res.setIdType(parseCoding(json.getJSONObject("idType")));
    if (json.has("identifier"))
      res.setIdentifier(parseString(json.getJSONObject("identifier")));
    if (json.has("sensitivity"))
      res.setSensitivity(parseString(json.getJSONObject("sensitivity")));
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("query"))
      res.setQuery(parseBase64Binary(json.getJSONObject("query")));
    return res;
  }

  private Specimen parseSpecimen(JSONObject json) throws Exception {
    Specimen res = new Specimen();
    parseResourceProperties(json, res);
    if (json.has("identifier"))
      res.setIdentifier(parseIdentifier(json.getJSONObject("identifier")));
    return res;
  }

  private Study parseStudy(JSONObject json) throws Exception {
    Study res = new Study();
    parseResourceProperties(json, res);
    if (json.has("identifier")) {
      JSONArray array = json.getJSONArray("identifier");
      for (int i = 0; i < array.length(); i++) {
        res.getIdentifier().add(parseIdentifier(array.getJSONObject(i)));
      }
    };
    if (json.has("sponsor"))
      res.setSponsor(parseString(json.getJSONObject("sponsor")));
    if (json.has("title"))
      res.setTitle(parseString(json.getJSONObject("title")));
    if (json.has("description"))
      res.setDescription(parseString(json.getJSONObject("description")));
    if (json.has("type"))
      res.setType(parseCodeableConcept(json.getJSONObject("type")));
    if (json.has("condition")) {
      JSONArray array = json.getJSONArray("condition");
      for (int i = 0; i < array.length(); i++) {
        res.getCondition().add(parseCodeableConcept(array.getJSONObject(i)));
      }
    };
    if (json.has("treatment")) {
      JSONArray array = json.getJSONArray("treatment");
      for (int i = 0; i < array.length(); i++) {
        res.getTreatment().add(parseStudyStudyTreatmentComponent(array.getJSONObject(i), res));
      }
    };
    if (json.has("controlType")) {
      JSONArray array = json.getJSONArray("controlType");
      for (int i = 0; i < array.length(); i++) {
        res.getControlType().add(parseCodeableConcept(array.getJSONObject(i)));
      }
    };
    if (json.has("objective")) {
      JSONArray array = json.getJSONArray("objective");
      for (int i = 0; i < array.length(); i++) {
        res.getObjective().add(parseString(array.getJSONObject(i)));
      }
    };
    if (json.has("outcomeMeasure")) {
      JSONArray array = json.getJSONArray("outcomeMeasure");
      for (int i = 0; i < array.length(); i++) {
        res.getOutcomeMeasure().add(parseString(array.getJSONObject(i)));
      }
    };
    if (json.has("eligibility")) {
      JSONArray array = json.getJSONArray("eligibility");
      for (int i = 0; i < array.length(); i++) {
        res.getEligibility().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    if (json.has("period"))
      res.setPeriod(parsePeriod(json.getJSONObject("period")));
    if (json.has("duration"))
      res.setDuration(parseDuration(json.getJSONObject("duration")));
    if (json.has("plannedEnrollment"))
      res.setPlannedEnrollment(parseInteger(json.getJSONObject("plannedEnrollment")));
    if (json.has("intervention"))
      res.setIntervention(parseStudyStudyInterventionComponent(json.getJSONObject("intervention"), res));
    if (json.has("protocol")) {
      JSONArray array = json.getJSONArray("protocol");
      for (int i = 0; i < array.length(); i++) {
        res.getProtocol().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    if (json.has("dataStructure"))
      res.setDataStructure(parseResourceReference(json.getJSONObject("dataStructure")));
    if (json.has("data")) {
      JSONArray array = json.getJSONArray("data");
      for (int i = 0; i < array.length(); i++) {
        res.getData().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private Study.StudyTreatmentComponent parseStudyStudyTreatmentComponent(JSONObject json, Study owner) throws Exception {
    Study.StudyTreatmentComponent res = owner.new StudyTreatmentComponent();
    parseElementProperties(json, res);
    if (json.has("role"))
      res.setRole(parseEnumeration(json.getJSONObject("role"), Study.StudyTreatmentRole.Null, new Study().new StudyTreatmentRoleEnumFactory()));
    if (json.has("detail"))
      res.setDetail(parseActivityDefinition(json.getJSONObject("detail")));
    return res;
  }

  private Study.StudyInterventionComponent parseStudyStudyInterventionComponent(JSONObject json, Study owner) throws Exception {
    Study.StudyInterventionComponent res = owner.new StudyInterventionComponent();
    parseElementProperties(json, res);
    if (json.has("type"))
      res.setType(parseCodeableConcept(json.getJSONObject("type")));
    if (json.has("model"))
      res.setModel(parseCodeableConcept(json.getJSONObject("model")));
    if (json.has("randomized"))
      res.setRandomized(parseBoolean(json.getJSONObject("randomized")));
    if (json.has("blindingScheme"))
      res.setBlindingScheme(parseCodeableConcept(json.getJSONObject("blindingScheme")));
    Type randomizationQuotient = parseType("randomizationQuotient", json);
    if (randomizationQuotient != null)
      res.setRandomizationQuotient(randomizationQuotient);
    return res;
  }

  private Substance parseSubstance(JSONObject json) throws Exception {
    Substance res = new Substance();
    parseResourceProperties(json, res);
    if (json.has("identifier"))
      res.setIdentifier(parseIdentifier(json.getJSONObject("identifier")));
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("type"))
      res.setType(parseCoding(json.getJSONObject("type")));
    return res;
  }

  private Test parseTest(JSONObject json) throws Exception {
    Test res = new Test();
    parseResourceProperties(json, res);
    if (json.has("stringErr")) {
      JSONArray array = json.getJSONArray("stringErr");
      for (int i = 0; i < array.length(); i++) {
        res.getStringErr().add(parseString(array.getJSONObject(i)));
      }
    };
    if (json.has("stringCorr")) {
      JSONArray array = json.getJSONArray("stringCorr");
      for (int i = 0; i < array.length(); i++) {
        res.getStringCorr().add(parseString(array.getJSONObject(i)));
      }
    };
    if (json.has("booleanErr")) {
      JSONArray array = json.getJSONArray("booleanErr");
      for (int i = 0; i < array.length(); i++) {
        res.getBooleanErr().add(parseBoolean(array.getJSONObject(i)));
      }
    };
    if (json.has("booleanCorr")) {
      JSONArray array = json.getJSONArray("booleanCorr");
      for (int i = 0; i < array.length(); i++) {
        res.getBooleanCorr().add(parseBoolean(array.getJSONObject(i)));
      }
    };
    if (json.has("integerErr")) {
      JSONArray array = json.getJSONArray("integerErr");
      for (int i = 0; i < array.length(); i++) {
        res.getIntegerErr().add(parseInteger(array.getJSONObject(i)));
      }
    };
    if (json.has("integerCorr")) {
      JSONArray array = json.getJSONArray("integerCorr");
      for (int i = 0; i < array.length(); i++) {
        res.getIntegerCorr().add(parseInteger(array.getJSONObject(i)));
      }
    };
    if (json.has("decimalErr")) {
      JSONArray array = json.getJSONArray("decimalErr");
      for (int i = 0; i < array.length(); i++) {
        res.getDecimalErr().add(parseDecimal(array.getJSONObject(i)));
      }
    };
    if (json.has("decimalCorr")) {
      JSONArray array = json.getJSONArray("decimalCorr");
      for (int i = 0; i < array.length(); i++) {
        res.getDecimalCorr().add(parseDecimal(array.getJSONObject(i)));
      }
    };
    if (json.has("b64Err")) {
      JSONArray array = json.getJSONArray("b64Err");
      for (int i = 0; i < array.length(); i++) {
        res.getB64Err().add(parseBase64Binary(array.getJSONObject(i)));
      }
    };
    if (json.has("b64Corr")) {
      JSONArray array = json.getJSONArray("b64Corr");
      for (int i = 0; i < array.length(); i++) {
        res.getB64Corr().add(parseBase64Binary(array.getJSONObject(i)));
      }
    };
    if (json.has("instantErr")) {
      JSONArray array = json.getJSONArray("instantErr");
      for (int i = 0; i < array.length(); i++) {
        res.getInstantErr().add(parseInstant(array.getJSONObject(i)));
      }
    };
    if (json.has("instantCorr")) {
      JSONArray array = json.getJSONArray("instantCorr");
      for (int i = 0; i < array.length(); i++) {
        res.getInstantCorr().add(parseInstant(array.getJSONObject(i)));
      }
    };
    if (json.has("uriErr")) {
      JSONArray array = json.getJSONArray("uriErr");
      for (int i = 0; i < array.length(); i++) {
        res.getUriErr().add(parseUri(array.getJSONObject(i)));
      }
    };
    if (json.has("uriCorr")) {
      JSONArray array = json.getJSONArray("uriCorr");
      for (int i = 0; i < array.length(); i++) {
        res.getUriCorr().add(parseUri(array.getJSONObject(i)));
      }
    };
    if (json.has("idrefSingle"))
      res.setIdrefSingle(parseString(json.getJSONObject("idrefSingle")));
    return res;
  }

  private ValueSet parseValueSet(JSONObject json) throws Exception {
    ValueSet res = new ValueSet();
    parseResourceProperties(json, res);
    if (json.has("identifier"))
      res.setIdentifier(parseString(json.getJSONObject("identifier")));
    if (json.has("version"))
      res.setVersion(parseString(json.getJSONObject("version")));
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("publisher"))
      res.setPublisher(parseString(json.getJSONObject("publisher")));
    if (json.has("telecom")) {
      JSONArray array = json.getJSONArray("telecom");
      for (int i = 0; i < array.length(); i++) {
        res.getTelecom().add(parseContact(array.getJSONObject(i)));
      }
    };
    if (json.has("description"))
      res.setDescription(parseString(json.getJSONObject("description")));
    if (json.has("status"))
      res.setStatus(parseEnumeration(json.getJSONObject("status"), ValueSet.ValuesetStatus.Null, new ValueSet().new ValuesetStatusEnumFactory()));
    if (json.has("date"))
      res.setDate(parseDateTime(json.getJSONObject("date")));
    if (json.has("define"))
      res.setDefine(parseValueSetValueSetDefineComponent(json.getJSONObject("define"), res));
    if (json.has("compose"))
      res.setCompose(parseValueSetValueSetComposeComponent(json.getJSONObject("compose"), res));
    if (json.has("expansion"))
      res.setExpansion(parseValueSetValueSetExpansionComponent(json.getJSONObject("expansion"), res));
    return res;
  }

  private ValueSet.ValueSetDefineComponent parseValueSetValueSetDefineComponent(JSONObject json, ValueSet owner) throws Exception {
    ValueSet.ValueSetDefineComponent res = owner.new ValueSetDefineComponent();
    parseElementProperties(json, res);
    if (json.has("system"))
      res.setSystem(parseUri(json.getJSONObject("system")));
    if (json.has("concept")) {
      JSONArray array = json.getJSONArray("concept");
      for (int i = 0; i < array.length(); i++) {
        res.getConcept().add(parseValueSetValueSetDefineConceptComponent(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private ValueSet.ValueSetDefineConceptComponent parseValueSetValueSetDefineConceptComponent(JSONObject json, ValueSet owner) throws Exception {
    ValueSet.ValueSetDefineConceptComponent res = owner.new ValueSetDefineConceptComponent();
    parseElementProperties(json, res);
    if (json.has("code"))
      res.setCode(parseCode(json.getJSONObject("code")));
    if (json.has("abstract"))
      res.setAbstract(parseBoolean(json.getJSONObject("abstract")));
    if (json.has("display"))
      res.setDisplay(parseString(json.getJSONObject("display")));
    if (json.has("definition"))
      res.setDefinition(parseString(json.getJSONObject("definition")));
    if (json.has("concept")) {
      JSONArray array = json.getJSONArray("concept");
      for (int i = 0; i < array.length(); i++) {
        res.getConcept().add(parseValueSetValueSetDefineConceptComponent(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private ValueSet.ValueSetComposeComponent parseValueSetValueSetComposeComponent(JSONObject json, ValueSet owner) throws Exception {
    ValueSet.ValueSetComposeComponent res = owner.new ValueSetComposeComponent();
    parseElementProperties(json, res);
    if (json.has("import")) {
      JSONArray array = json.getJSONArray("import");
      for (int i = 0; i < array.length(); i++) {
        res.getImport().add(parseUri(array.getJSONObject(i)));
      }
    };
    if (json.has("include")) {
      JSONArray array = json.getJSONArray("include");
      for (int i = 0; i < array.length(); i++) {
        res.getInclude().add(parseValueSetConceptSetComponent(array.getJSONObject(i), owner));
      }
    };
    if (json.has("exclude")) {
      JSONArray array = json.getJSONArray("exclude");
      for (int i = 0; i < array.length(); i++) {
        res.getExclude().add(parseValueSetConceptSetComponent(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private ValueSet.ConceptSetComponent parseValueSetConceptSetComponent(JSONObject json, ValueSet owner) throws Exception {
    ValueSet.ConceptSetComponent res = owner.new ConceptSetComponent();
    parseElementProperties(json, res);
    if (json.has("system"))
      res.setSystem(parseUri(json.getJSONObject("system")));
    if (json.has("version"))
      res.setVersion(parseString(json.getJSONObject("version")));
    if (json.has("mode"))
      res.setMode(parseEnumeration(json.getJSONObject("mode"), ValueSet.CodeSelectionMode.Null, new ValueSet().new CodeSelectionModeEnumFactory()));
    if (json.has("code")) {
      JSONArray array = json.getJSONArray("code");
      for (int i = 0; i < array.length(); i++) {
        res.getCode().add(parseCode(array.getJSONObject(i)));
      }
    };
    if (json.has("filter")) {
      JSONArray array = json.getJSONArray("filter");
      for (int i = 0; i < array.length(); i++) {
        res.getFilter().add(parseValueSetConceptSetFilterComponent(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private ValueSet.ConceptSetFilterComponent parseValueSetConceptSetFilterComponent(JSONObject json, ValueSet owner) throws Exception {
    ValueSet.ConceptSetFilterComponent res = owner.new ConceptSetFilterComponent();
    parseElementProperties(json, res);
    if (json.has("property"))
      res.setProperty(parseCode(json.getJSONObject("property")));
    if (json.has("op"))
      res.setOp(parseEnumeration(json.getJSONObject("op"), ValueSet.FilterOperator.Null, new ValueSet().new FilterOperatorEnumFactory()));
    if (json.has("value"))
      res.setValue(parseCode(json.getJSONObject("value")));
    return res;
  }

  private ValueSet.ValueSetExpansionComponent parseValueSetValueSetExpansionComponent(JSONObject json, ValueSet owner) throws Exception {
    ValueSet.ValueSetExpansionComponent res = owner.new ValueSetExpansionComponent();
    parseElementProperties(json, res);
    if (json.has("timestamp"))
      res.setTimestamp(parseInstant(json.getJSONObject("timestamp")));
    if (json.has("contains")) {
      JSONArray array = json.getJSONArray("contains");
      for (int i = 0; i < array.length(); i++) {
        res.getContains().add(parseValueSetValueSetExpansionContainsComponent(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private ValueSet.ValueSetExpansionContainsComponent parseValueSetValueSetExpansionContainsComponent(JSONObject json, ValueSet owner) throws Exception {
    ValueSet.ValueSetExpansionContainsComponent res = owner.new ValueSetExpansionContainsComponent();
    parseElementProperties(json, res);
    if (json.has("system"))
      res.setSystem(parseUri(json.getJSONObject("system")));
    if (json.has("code"))
      res.setCode(parseCode(json.getJSONObject("code")));
    if (json.has("display"))
      res.setDisplay(parseString(json.getJSONObject("display")));
    if (json.has("contains")) {
      JSONArray array = json.getJSONArray("contains");
      for (int i = 0; i < array.length(); i++) {
        res.getContains().add(parseValueSetValueSetExpansionContainsComponent(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private Visit parseVisit(JSONObject json) throws Exception {
    Visit res = new Visit();
    parseResourceProperties(json, res);
    if (json.has("identifier")) {
      JSONArray array = json.getJSONArray("identifier");
      for (int i = 0; i < array.length(); i++) {
        res.getIdentifier().add(parseIdentifier(array.getJSONObject(i)));
      }
    };
    if (json.has("status"))
      res.setStatus(parseEnumeration(json.getJSONObject("status"), Visit.EncounterState.Null, new Visit().new EncounterStateEnumFactory()));
    if (json.has("class"))
      res.setClass_(parseEnumeration(json.getJSONObject("class"), Visit.EncounterClass.Null, new Visit().new EncounterClassEnumFactory()));
    if (json.has("type"))
      res.setType(parseCodeableConcept(json.getJSONObject("type")));
    if (json.has("subject"))
      res.setSubject(parseResourceReference(json.getJSONObject("subject")));
    if (json.has("participant")) {
      JSONArray array = json.getJSONArray("participant");
      for (int i = 0; i < array.length(); i++) {
        res.getParticipant().add(parseVisitVisitParticipantComponent(array.getJSONObject(i), res));
      }
    };
    if (json.has("fulfills"))
      res.setFulfills(parseResourceReference(json.getJSONObject("fulfills")));
    if (json.has("length"))
      res.setLength(parseDuration(json.getJSONObject("length")));
    Type reason = parseType("reason", json);
    if (reason != null)
      res.setReason(reason);
    if (json.has("indication"))
      res.setIndication(parseResourceReference(json.getJSONObject("indication")));
    if (json.has("priority"))
      res.setPriority(parseCodeableConcept(json.getJSONObject("priority")));
    if (json.has("hospitalization"))
      res.setHospitalization(parseVisitVisitHospitalizationComponent(json.getJSONObject("hospitalization"), res));
    if (json.has("location")) {
      JSONArray array = json.getJSONArray("location");
      for (int i = 0; i < array.length(); i++) {
        res.getLocation().add(parseVisitVisitLocationComponent(array.getJSONObject(i), res));
      }
    };
    if (json.has("serviceProvider"))
      res.setServiceProvider(parseResourceReference(json.getJSONObject("serviceProvider")));
    return res;
  }

  private Visit.VisitParticipantComponent parseVisitVisitParticipantComponent(JSONObject json, Visit owner) throws Exception {
    Visit.VisitParticipantComponent res = owner.new VisitParticipantComponent();
    parseElementProperties(json, res);
    if (json.has("type")) {
      JSONArray array = json.getJSONArray("type");
      for (int i = 0; i < array.length(); i++) {
        res.getType().add(parseCodeableConcept(array.getJSONObject(i)));
      }
    };
    if (json.has("practitioner"))
      res.setPractitioner(parseResourceReference(json.getJSONObject("practitioner")));
    return res;
  }

  private Visit.VisitHospitalizationComponent parseVisitVisitHospitalizationComponent(JSONObject json, Visit owner) throws Exception {
    Visit.VisitHospitalizationComponent res = owner.new VisitHospitalizationComponent();
    parseElementProperties(json, res);
    if (json.has("preAdmissionIdentifier"))
      res.setPreAdmissionIdentifier(parseIdentifier(json.getJSONObject("preAdmissionIdentifier")));
    if (json.has("preAdmissionTest"))
      res.setPreAdmissionTest(parseCodeableConcept(json.getJSONObject("preAdmissionTest")));
    if (json.has("origin"))
      res.setOrigin(parseResourceReference(json.getJSONObject("origin")));
    if (json.has("admitSource"))
      res.setAdmitSource(parseCodeableConcept(json.getJSONObject("admitSource")));
    if (json.has("period"))
      res.setPeriod(parsePeriod(json.getJSONObject("period")));
    if (json.has("accomodation")) {
      JSONArray array = json.getJSONArray("accomodation");
      for (int i = 0; i < array.length(); i++) {
        res.getAccomodation().add(parseVisitVisitHospitalizationAccomodationComponent(array.getJSONObject(i), owner));
      }
    };
    if (json.has("diet"))
      res.setDiet(parseCodeableConcept(json.getJSONObject("diet")));
    if (json.has("specialCourtesy")) {
      JSONArray array = json.getJSONArray("specialCourtesy");
      for (int i = 0; i < array.length(); i++) {
        res.getSpecialCourtesy().add(parseCodeableConcept(array.getJSONObject(i)));
      }
    };
    if (json.has("specialArrangement")) {
      JSONArray array = json.getJSONArray("specialArrangement");
      for (int i = 0; i < array.length(); i++) {
        res.getSpecialArrangement().add(parseCodeableConcept(array.getJSONObject(i)));
      }
    };
    if (json.has("destination"))
      res.setDestination(parseResourceReference(json.getJSONObject("destination")));
    if (json.has("dischargeDisposition"))
      res.setDischargeDisposition(parseCodeableConcept(json.getJSONObject("dischargeDisposition")));
    if (json.has("reAdmission"))
      res.setReAdmission(parseBoolean(json.getJSONObject("reAdmission")));
    return res;
  }

  private Visit.VisitHospitalizationAccomodationComponent parseVisitVisitHospitalizationAccomodationComponent(JSONObject json, Visit owner) throws Exception {
    Visit.VisitHospitalizationAccomodationComponent res = owner.new VisitHospitalizationAccomodationComponent();
    parseElementProperties(json, res);
    if (json.has("bed"))
      res.setBed(parseResourceReference(json.getJSONObject("bed")));
    if (json.has("period"))
      res.setPeriod(parsePeriod(json.getJSONObject("period")));
    return res;
  }

  private Visit.VisitLocationComponent parseVisitVisitLocationComponent(JSONObject json, Visit owner) throws Exception {
    Visit.VisitLocationComponent res = owner.new VisitLocationComponent();
    parseElementProperties(json, res);
    if (json.has("location"))
      res.setLocation(parseResourceReference(json.getJSONObject("location")));
    if (json.has("period"))
      res.setPeriod(parsePeriod(json.getJSONObject("period")));
    return res;
  }

  @Override
  protected Resource parseResource(JSONObject json) throws Exception {
    if (json.has("AdverseReaction"))
      return parseAdverseReaction(json.getJSONObject("AdverseReaction"));
    else if (json.has("Alert"))
      return parseAlert(json.getJSONObject("Alert"));
    else if (json.has("AllergyIntolerance"))
      return parseAllergyIntolerance(json.getJSONObject("AllergyIntolerance"));
    else if (json.has("CarePlan"))
      return parseCarePlan(json.getJSONObject("CarePlan"));
    else if (json.has("Conformance"))
      return parseConformance(json.getJSONObject("Conformance"));
    else if (json.has("Coverage"))
      return parseCoverage(json.getJSONObject("Coverage"));
    else if (json.has("Device"))
      return parseDevice(json.getJSONObject("Device"));
    else if (json.has("DeviceCapabilities"))
      return parseDeviceCapabilities(json.getJSONObject("DeviceCapabilities"));
    else if (json.has("DeviceLog"))
      return parseDeviceLog(json.getJSONObject("DeviceLog"));
    else if (json.has("DeviceObservation"))
      return parseDeviceObservation(json.getJSONObject("DeviceObservation"));
    else if (json.has("DiagnosticOrder"))
      return parseDiagnosticOrder(json.getJSONObject("DiagnosticOrder"));
    else if (json.has("DiagnosticReport"))
      return parseDiagnosticReport(json.getJSONObject("DiagnosticReport"));
    else if (json.has("Document"))
      return parseDocument(json.getJSONObject("Document"));
    else if (json.has("DocumentReference"))
      return parseDocumentReference(json.getJSONObject("DocumentReference"));
    else if (json.has("FamilyHistory"))
      return parseFamilyHistory(json.getJSONObject("FamilyHistory"));
    else if (json.has("Group"))
      return parseGroup(json.getJSONObject("Group"));
    else if (json.has("ImagingStudy"))
      return parseImagingStudy(json.getJSONObject("ImagingStudy"));
    else if (json.has("Immunization"))
      return parseImmunization(json.getJSONObject("Immunization"));
    else if (json.has("ImmunizationProfile"))
      return parseImmunizationProfile(json.getJSONObject("ImmunizationProfile"));
    else if (json.has("List"))
      return parseList_(json.getJSONObject("List"));
    else if (json.has("Location"))
      return parseLocation(json.getJSONObject("Location"));
    else if (json.has("Medication"))
      return parseMedication(json.getJSONObject("Medication"));
    else if (json.has("MedicationAdministration"))
      return parseMedicationAdministration(json.getJSONObject("MedicationAdministration"));
    else if (json.has("MedicationDispense"))
      return parseMedicationDispense(json.getJSONObject("MedicationDispense"));
    else if (json.has("MedicationPrescription"))
      return parseMedicationPrescription(json.getJSONObject("MedicationPrescription"));
    else if (json.has("MedicationStatement"))
      return parseMedicationStatement(json.getJSONObject("MedicationStatement"));
    else if (json.has("Message"))
      return parseMessage(json.getJSONObject("Message"));
    else if (json.has("Observation"))
      return parseObservation(json.getJSONObject("Observation"));
    else if (json.has("OperationOutcome"))
      return parseOperationOutcome(json.getJSONObject("OperationOutcome"));
    else if (json.has("Order"))
      return parseOrder(json.getJSONObject("Order"));
    else if (json.has("OrderResponse"))
      return parseOrderResponse(json.getJSONObject("OrderResponse"));
    else if (json.has("Organization"))
      return parseOrganization(json.getJSONObject("Organization"));
    else if (json.has("Other"))
      return parseOther(json.getJSONObject("Other"));
    else if (json.has("Patient"))
      return parsePatient(json.getJSONObject("Patient"));
    else if (json.has("Picture"))
      return parsePicture(json.getJSONObject("Picture"));
    else if (json.has("Practitioner"))
      return parsePractitioner(json.getJSONObject("Practitioner"));
    else if (json.has("Problem"))
      return parseProblem(json.getJSONObject("Problem"));
    else if (json.has("Procedure"))
      return parseProcedure(json.getJSONObject("Procedure"));
    else if (json.has("Profile"))
      return parseProfile(json.getJSONObject("Profile"));
    else if (json.has("Protocol"))
      return parseProtocol(json.getJSONObject("Protocol"));
    else if (json.has("Provenance"))
      return parseProvenance(json.getJSONObject("Provenance"));
    else if (json.has("Query"))
      return parseQuery(json.getJSONObject("Query"));
    else if (json.has("Questionnaire"))
      return parseQuestionnaire(json.getJSONObject("Questionnaire"));
    else if (json.has("SecurityEvent"))
      return parseSecurityEvent(json.getJSONObject("SecurityEvent"));
    else if (json.has("Specimen"))
      return parseSpecimen(json.getJSONObject("Specimen"));
    else if (json.has("Study"))
      return parseStudy(json.getJSONObject("Study"));
    else if (json.has("Substance"))
      return parseSubstance(json.getJSONObject("Substance"));
    else if (json.has("Test"))
      return parseTest(json.getJSONObject("Test"));
    else if (json.has("ValueSet"))
      return parseValueSet(json.getJSONObject("ValueSet"));
    else if (json.has("Visit"))
      return parseVisit(json.getJSONObject("Visit"));
    else if (json.has("Binary"))
      return parseBinary(json.getJSONObject("Binary"));
    throw new Exception("Unknown.Unrecognised resource type");
  }

  protected Type parseType(String prefix, JSONObject json) throws Exception {
    if (json.has(prefix+"Period"))
      return parsePeriod(json.getJSONObject(prefix+"Period"));
    else if (json.has(prefix+"Coding"))
      return parseCoding(json.getJSONObject(prefix+"Coding"));
    else if (json.has(prefix+"Range"))
      return parseRange(json.getJSONObject(prefix+"Range"));
    else if (json.has(prefix+"Quantity"))
      return parseQuantity(json.getJSONObject(prefix+"Quantity"));
    else if (json.has(prefix+"Choice"))
      return parseChoice(json.getJSONObject(prefix+"Choice"));
    else if (json.has(prefix+"Attachment"))
      return parseAttachment(json.getJSONObject(prefix+"Attachment"));
    else if (json.has(prefix+"Ratio"))
      return parseRatio(json.getJSONObject(prefix+"Ratio"));
    else if (json.has(prefix+"Array"))
      return parseArray(json.getJSONObject(prefix+"Array"));
    else if (json.has(prefix+"ResourceReference"))
      return parseResourceReference(json.getJSONObject(prefix+"ResourceReference"));
    else if (json.has(prefix+"CodeableConcept"))
      return parseCodeableConcept(json.getJSONObject(prefix+"CodeableConcept"));
    else if (json.has(prefix+"Identifier"))
      return parseIdentifier(json.getJSONObject(prefix+"Identifier"));
    else if (json.has(prefix+"Age"))
      return parseAge(json.getJSONObject(prefix+"Age"));
    else if (json.has(prefix+"Count"))
      return parseCount(json.getJSONObject(prefix+"Count"));
    else if (json.has(prefix+"Money"))
      return parseMoney(json.getJSONObject(prefix+"Money"));
    else if (json.has(prefix+"Distance"))
      return parseDistance(json.getJSONObject(prefix+"Distance"));
    else if (json.has(prefix+"Duration"))
      return parseDuration(json.getJSONObject(prefix+"Duration"));
    else if (json.has(prefix+"Schedule"))
      return parseSchedule(json.getJSONObject(prefix+"Schedule"));
    else if (json.has(prefix+"Contact"))
      return parseContact(json.getJSONObject(prefix+"Contact"));
    else if (json.has(prefix+"Address"))
      return parseAddress(json.getJSONObject(prefix+"Address"));
    else if (json.has(prefix+"HumanName"))
      return parseHumanName(json.getJSONObject(prefix+"HumanName"));
    else if (json.has(prefix+"ActivityDefinition"))
      return parseActivityDefinition(json.getJSONObject(prefix+"ActivityDefinition"));
    else if (json.has(prefix+"Demographics"))
      return parseDemographics(json.getJSONObject(prefix+"Demographics"));
    else if (json.has(prefix+"Integer"))
      return parseInteger(json.getJSONObject(prefix+"Integer"));
    else if (json.has(prefix+"DateTime"))
      return parseDateTime(json.getJSONObject(prefix+"DateTime"));
    else if (json.has(prefix+"Code"))
      return parseCode(json.getJSONObject(prefix+"Code"));
    else if (json.has(prefix+"Date"))
      return parseDate(json.getJSONObject(prefix+"Date"));
    else if (json.has(prefix+"Decimal"))
      return parseDecimal(json.getJSONObject(prefix+"Decimal"));
    else if (json.has(prefix+"Uri"))
      return parseUri(json.getJSONObject(prefix+"Uri"));
    else if (json.has(prefix+"Id"))
      return parseId(json.getJSONObject(prefix+"Id"));
    else if (json.has(prefix+"Base64Binary"))
      return parseBase64Binary(json.getJSONObject(prefix+"Base64Binary"));
    else if (json.has(prefix+"Oid"))
      return parseOid(json.getJSONObject(prefix+"Oid"));
    else if (json.has(prefix+"String"))
      return parseString(json.getJSONObject(prefix+"String"));
    else if (json.has(prefix+"Boolean"))
      return parseBoolean(json.getJSONObject(prefix+"Boolean"));
    else if (json.has(prefix+"Uuid"))
      return parseUuid(json.getJSONObject(prefix+"Uuid"));
    else if (json.has(prefix+"Instant"))
      return parseInstant(json.getJSONObject(prefix+"Instant"));
    return null;
  }

  private boolean hasTypeName(JSONObject json, String prefix) {
        if (json.has(prefix+"Period"))
      return true;
    if (json.has(prefix+"Coding"))
      return true;
    if (json.has(prefix+"Range"))
      return true;
    if (json.has(prefix+"Quantity"))
      return true;
    if (json.has(prefix+"Choice"))
      return true;
    if (json.has(prefix+"Attachment"))
      return true;
    if (json.has(prefix+"Ratio"))
      return true;
    if (json.has(prefix+"Array"))
      return true;
    if (json.has(prefix+"ResourceReference"))
      return true;
    if (json.has(prefix+"CodeableConcept"))
      return true;
    if (json.has(prefix+"Identifier"))
      return true;
    if (json.has(prefix+"Age"))
      return true;
    if (json.has(prefix+"Count"))
      return true;
    if (json.has(prefix+"Money"))
      return true;
    if (json.has(prefix+"Distance"))
      return true;
    if (json.has(prefix+"Duration"))
      return true;
    if (json.has(prefix+"Schedule"))
      return true;
    if (json.has(prefix+"Contact"))
      return true;
    if (json.has(prefix+"Address"))
      return true;
    if (json.has(prefix+"HumanName"))
      return true;
    if (json.has(prefix+"ActivityDefinition"))
      return true;
    if (json.has(prefix+"Demographics"))
      return true;
    if (json.has(prefix+"AdverseReaction"))
      return true;
    if (json.has(prefix+"Alert"))
      return true;
    if (json.has(prefix+"AllergyIntolerance"))
      return true;
    if (json.has(prefix+"CarePlan"))
      return true;
    if (json.has(prefix+"Conformance"))
      return true;
    if (json.has(prefix+"Coverage"))
      return true;
    if (json.has(prefix+"Device"))
      return true;
    if (json.has(prefix+"DeviceCapabilities"))
      return true;
    if (json.has(prefix+"DeviceLog"))
      return true;
    if (json.has(prefix+"DeviceObservation"))
      return true;
    if (json.has(prefix+"DiagnosticOrder"))
      return true;
    if (json.has(prefix+"DiagnosticReport"))
      return true;
    if (json.has(prefix+"Document"))
      return true;
    if (json.has(prefix+"DocumentReference"))
      return true;
    if (json.has(prefix+"FamilyHistory"))
      return true;
    if (json.has(prefix+"Group"))
      return true;
    if (json.has(prefix+"ImagingStudy"))
      return true;
    if (json.has(prefix+"Immunization"))
      return true;
    if (json.has(prefix+"ImmunizationProfile"))
      return true;
    if (json.has(prefix+"List"))
      return true;
    if (json.has(prefix+"Location"))
      return true;
    if (json.has(prefix+"Medication"))
      return true;
    if (json.has(prefix+"MedicationAdministration"))
      return true;
    if (json.has(prefix+"MedicationDispense"))
      return true;
    if (json.has(prefix+"MedicationPrescription"))
      return true;
    if (json.has(prefix+"MedicationStatement"))
      return true;
    if (json.has(prefix+"Message"))
      return true;
    if (json.has(prefix+"Observation"))
      return true;
    if (json.has(prefix+"OperationOutcome"))
      return true;
    if (json.has(prefix+"Order"))
      return true;
    if (json.has(prefix+"OrderResponse"))
      return true;
    if (json.has(prefix+"Organization"))
      return true;
    if (json.has(prefix+"Other"))
      return true;
    if (json.has(prefix+"Patient"))
      return true;
    if (json.has(prefix+"Picture"))
      return true;
    if (json.has(prefix+"Practitioner"))
      return true;
    if (json.has(prefix+"Problem"))
      return true;
    if (json.has(prefix+"Procedure"))
      return true;
    if (json.has(prefix+"Profile"))
      return true;
    if (json.has(prefix+"Protocol"))
      return true;
    if (json.has(prefix+"Provenance"))
      return true;
    if (json.has(prefix+"Query"))
      return true;
    if (json.has(prefix+"Questionnaire"))
      return true;
    if (json.has(prefix+"SecurityEvent"))
      return true;
    if (json.has(prefix+"Specimen"))
      return true;
    if (json.has(prefix+"Study"))
      return true;
    if (json.has(prefix+"Substance"))
      return true;
    if (json.has(prefix+"Test"))
      return true;
    if (json.has(prefix+"ValueSet"))
      return true;
    if (json.has(prefix+"Visit"))
      return true;
    if (json.has(prefix+"Integer"))
      return true;
    if (json.has(prefix+"DateTime"))
      return true;
    if (json.has(prefix+"Code"))
      return true;
    if (json.has(prefix+"Date"))
      return true;
    if (json.has(prefix+"Decimal"))
      return true;
    if (json.has(prefix+"Uri"))
      return true;
    if (json.has(prefix+"Id"))
      return true;
    if (json.has(prefix+"Base64Binary"))
      return true;
    if (json.has(prefix+"Oid"))
      return true;
    if (json.has(prefix+"String"))
      return true;
    if (json.has(prefix+"Boolean"))
      return true;
    if (json.has(prefix+"Uuid"))
      return true;
    if (json.has(prefix+"Instant"))
      return true;
    return false;
  }
}

