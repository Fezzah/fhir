package org.hl7.fhir.definitions.parsers;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.definitions.model.ConceptDomain;
import org.hl7.fhir.definitions.model.DefinedCode;
import org.hl7.fhir.definitions.model.DefinedStringPattern;
import org.hl7.fhir.definitions.model.Definitions;
import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.PrimitiveType;
import org.hl7.fhir.definitions.model.TypeDefn;
import org.hl7.fhir.definitions.parsers.XLSXmlParser.Sheet;
import org.hl7.fhir.utilities.IniFile;
import org.hl7.fhir.utilities.Logger;
import org.hl7.fhir.utilities.Utilities;

/**
 * This class parses the master source for FHIR into a single definitions object model
 * 
 * The class knows where to find things, and what order to load them in
 * 
 * @author Grahame
 *
 */
public class SourceParser {

  private Logger logger;
  private IniFile ini;
  private Definitions definitions;
  private String srcDir;
  private String imgDir;
  private String termDir;
  public String dtDir;
  private Map<String, String> csvSrcs;
    
  public SourceParser(Logger logger, String root, Definitions definitions) {
    csvSrcs = new HashMap<String, String>();
    this.logger = logger;

    this.definitions = definitions;    
    
    char sl = File.separatorChar;
    srcDir = root+sl+"source"+sl;
    ini = new IniFile(srcDir+ "fhir.ini");
    
    termDir = srcDir+"terminologies"+sl;
    dtDir = srcDir+"datatypes"+sl;
    imgDir = root+sl+"images"+sl;
  }

  
  public void parse() throws Exception {
    logger.log("Loading");
    loadConceptDomains();
    loadPrimitives();

    for (String n : ini.getPropertyNames("types")) 
      loadDataType(n, definitions.getTypes());
    for (String n : ini.getPropertyNames("structures")) 
      loadDataType(n, definitions.getStructures());
    for (String n : ini.getPropertyNames("infrastructure")) 
      loadDataType(n, definitions.getInfrastructure());
    for (String n : ini.getPropertyNames("resources")) 
      loadResource(n, definitions.getResources());
    for (String n : ini.getPropertyNames("special-resources")) 
      loadResource(n, definitions.getSpecialResources());
    for (String n : ini.getPropertyNames("future-resources")) {
      DefinedCode cd = new DefinedCode(ini.getStringProperty("future-resources", n), "Yet to be defined", n);
      definitions.getKnownResources().put(n, cd);
      definitions.getFutureResources().put(n, cd);
    }
  }


  private void loadConceptDomains() throws Exception {
    logger.log("Load Concept Domains");
    ConceptDomainsParser parser = new ConceptDomainsParser(new FileInputStream(new File(termDir+"concept-domains.csv")));
    List<ConceptDomain> cds = parser.parse();
    for (ConceptDomain cd : cds)
    definitions.getConceptDomains().put(cd.getName(), cd);
    
    for (ConceptDomain cd : definitions.getConceptDomains().values()) {
      if (cd.getBindingType() == ConceptDomain.BindingType.CodeList) {
        File file = new File(termDir+cd.getBinding()+".csv");
        if (!file.exists())
          throw new Exception("code source file not found for "+cd.getName()+": "+file.getAbsolutePath());
        CodeListParser cparser = new CodeListParser(new FileInputStream(file));
        cparser.parse(cd.getCodes());
      }
    }

  }

  private void loadPrimitives() throws Exception {
    XLSXmlParser xls = new XLSXmlParser(new FileInputStream(dtDir+"primitives.xml"), "primitives");
    Sheet sheet = xls.getSheets().get("Imports");
    for (int row = 0; row < sheet.rows.size(); row++) {
      processImport(sheet, row);
    }
    sheet = xls.getSheets().get("String Patterns");
    for (int row = 0; row < sheet.rows.size(); row++) {
      processStringPattern(sheet, row);
    }
  }

  
  private void processImport(Sheet sheet, int row) throws Exception {
    PrimitiveType prim = new PrimitiveType();
    prim.setCode(sheet.getColumn(row, "Data Type"));
    prim.setDefinition(sheet.getColumn(row, "Definition"));
    prim.setComment(sheet.getColumn(row, "Comments"));
    prim.setSchemaType(sheet.getColumn(row, "Schema"));
    TypeDefn td = new TypeDefn();
    td.setName(prim.getCode());
    definitions.getKnownTypes().add(td);
    definitions.getPrimitives().put(prim.getCode(), prim);    
  }

  private void processStringPattern(Sheet sheet, int row) throws Exception {
    DefinedStringPattern prim = new DefinedStringPattern();
    prim.setCode(sheet.getColumn(row, "Data Type"));
    prim.setDefinition(sheet.getColumn(row, "Definition"));
    prim.setComment(sheet.getColumn(row, "Comments"));
    prim.setRegex(sheet.getColumn(row, "RegEx"));
    TypeDefn td = new TypeDefn();
    td.setName(prim.getCode());
    definitions.getKnownTypes().add(td);
    definitions.getPrimitives().put(prim.getCode(), prim);    
  }


  private void loadDataType(String n, Map<String, ElementDefn> map) throws Exception {
    TypeParser tp = new TypeParser();
    List<TypeDefn> ts = tp.parse(n);
    definitions.getKnownTypes().addAll(ts);

    TypeDefn t = ts.get(0);
    File csv = new File(dtDir+t.getName()+".xml");
    if (csv.exists()) {
      SpreadsheetParser p = new SpreadsheetParser(new FileInputStream(csv), csv.getName());
      ElementDefn el = p.parse();
      map.put(t.getName(), el);
    } else {
      String p = ini.getStringProperty("types", n);
      csv = new File(dtDir+p+".xml");
      if (!csv.exists()) 
        throw new Exception("unable to find a definition for "+n+" in "+p);
      XLSXmlParser xls = new XLSXmlParser(new FileInputStream(csv), csv.getAbsolutePath());
      Sheet sheet = xls.getSheets().get("Restrictions");
      boolean found = false;
      for (int i = 0; i < sheet.rows.size(); i++) {
        if (sheet.getColumn(i, "Name").equals(n)) {
          found = true;
          definitions.getConstraints().put(n, new DefinedCode(n, sheet.getColumn(i, "Name"), p));
        }
      }
      if (!found)
        throw new Exception("Unable to find definition for "+n);
    }
  }

  private void loadResource(String n, Map<String, ElementDefn> map) throws Exception {
    File spreadsheet = new File(srcDir+n+File.separatorChar+n+".xml");
    SpreadsheetParser sparser = new SpreadsheetParser(new FileInputStream(spreadsheet), spreadsheet.getName());
    ElementDefn root = sparser.parse();
    definitions.getKnownResources().put(root.getName(), new DefinedCode(root.getName(), root.getDefinition(), n));
    definitions.getDefinedResources().put(root.getName(), root);   
    map.put(root.getName(), root);   
  }


  public void checkConditions(List<String> errors) throws Exception {
    Utilities.checkFolder(srcDir, errors);
    Utilities.checkFolder(termDir, errors);
    Utilities.checkFolder(imgDir, errors);
    Utilities.checkFile("required", termDir, "concept-domains.csv", errors);
    Utilities.checkFile("required", dtDir, "primitives.xml", errors);

    for (String n : ini.getPropertyNames("types"))
      if (ini.getStringProperty("types", n).equals("")) {
        TypeDefn t = new TypeParser().parse(n).get(0);
        Utilities.checkFile("type definition", dtDir, t.getName()+".xml", errors);
      }
    for (String n : ini.getPropertyNames("structures"))
      Utilities.checkFile("structure definition", dtDir, n+".xml", errors);
    for (String n : ini.getPropertyNames("infrastructure"))
      Utilities.checkFile("infrastructure definition", dtDir, n+".xml", errors);
    
    for (String n : ini.getPropertyNames("resources")) {
      Utilities.checkFile("definition", srcDir+n+File.separatorChar, n+".xml", errors);
      Utilities.checkFile("resource htm", srcDir+n+File.separatorChar, n+".htm", errors);
      Utilities.checkFile("example xml", srcDir+n+File.separatorChar, "example.xml", errors);
      Utilities.checkFile("resource uml", imgDir, n+".png", errors);    
    }
    for (String n : ini.getPropertyNames("special-resources")) {
      Utilities.checkFile("definition", srcDir+n+File.separatorChar, n+".xml", errors);
      Utilities.checkFile("resource htm", srcDir+n+File.separatorChar, n+".htm", errors);
      Utilities.checkFile("example xml", srcDir+n+File.separatorChar, "example.xml", errors);
      Utilities.checkFile("resource uml", imgDir, n+".png", errors);    
    }

  }

}