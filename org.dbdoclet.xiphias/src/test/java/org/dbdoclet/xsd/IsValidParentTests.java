package org.dbdoclet.xsd;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;

import org.dbdoclet.service.ResourceServices;
import org.dbdoclet.xiphias.NodeSerializer;
import org.junit.jupiter.api.Test;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class IsValidParentTests {

	@Test
	public void paraIsValidParent() throws IOException, SAXException, ParserConfigurationException {
		
		InputStream instream = ResourceServices.getResourceAsStream("/xsd/docbook/docbook.xsd");
		InputSource source = new InputSource(instream);
		source.setSystemId("/xsd/docbook/docbook.xsd");
		XmlSchema schema = new XmlSchema(source);
		
		NodeSerializer serializer = new NodeSerializer();
		System.out.println(serializer.toXML(schema.getElementByName("screen")));

		assertFalse(schema.isValidParent("sect3", "para"));
		assertTrue(schema.isValidParent("para", "sect3"));
		assertFalse(schema.isValidParent("literal", "sect3"));
		assertTrue(schema.isValidParent("literal", "screen"));
		assertFalse(schema.isValidParent("phrase", "sect3"));
		assertTrue(schema.isValidParent("phrase", "simpara"));
		
	}
	
}
