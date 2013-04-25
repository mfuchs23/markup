package org.dbdoclet.xiphias;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

/**
 * Die Klasse <code>XsdServices</code> bietet statische Methode zur
 * Validierung von XML-Dateien mit Hilfe von XML Schematas.
 * 
 * @author mfuchs
 */
public class RngServices { 

    public static XmlValidationResult validate(File xmlFile, File schemaFile) throws FileNotFoundException {
   
	if (schemaFile == null) {
	    throw new IllegalArgumentException("The argument schemaFile must not be null!");
	}
	
	File[] schemaFiles = new File[] { schemaFile };
	return validate(xmlFile, schemaFiles);
    }
	
    public static XmlValidationResult validate(File xmlFile, File[] schemaFiles) throws FileNotFoundException {

	if (xmlFile == null) {
	    throw new IllegalArgumentException("The argument xmlFile must not be null!");
	}
	
	if (schemaFiles == null) {
	    throw new IllegalArgumentException("The argument schemaFiles must not be null!");
	}
	
	if (xmlFile.exists() == false) {
	    throw new FileNotFoundException(xmlFile.getAbsolutePath());
	}
	
	Source[] schemaSources = new Source[schemaFiles.length];
	
	for (int i = 0; i < schemaFiles.length; i++) {
	    
	    if (schemaFiles[i].exists() == false) {
		throw new FileNotFoundException(schemaFiles[i].getAbsolutePath());
	    }

	    schemaSources[i] = new StreamSource(schemaFiles[i]);
	}
	
	Source xml = new StreamSource(xmlFile);

	return validate(xml, schemaSources);
    }

    public static XmlValidationResult validate(Source xmlSource, Source schemaSource) {
   
	Source[] schemaSources = { schemaSource };
	return validate(xmlSource, schemaSources);
    }

    /**
     * Validiert die Datei <code>xmlFile</code> gegen das XML Schema
     * <code>schema</code>.
     * 
     * @param schemaFile
     * @param xmlFile
     * @return
     * @throws IOException
     */
    public static XmlValidationResult validate(Source xmlSource, Source[] schemaSources) {

	if (xmlSource == null) {
	    throw new IllegalArgumentException("The argument xmlSource must not be null!");
	}

	if (schemaSources == null) {
	    throw new IllegalArgumentException("The argument schemaSources must not be null!");
	}

	XmlValidationResult result = new XmlValidationResult(xmlSource.getSystemId());

	try {

	    SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.RELAXNG_NS_URI);
	    Schema schema = factory.newSchema(schemaSources);

	    Validator validator = schema.newValidator();
	    validator.validate(xmlSource);

	} catch (Exception oops) {
	    result.setThrowable(oops);
	}

	return result;
    }
}
