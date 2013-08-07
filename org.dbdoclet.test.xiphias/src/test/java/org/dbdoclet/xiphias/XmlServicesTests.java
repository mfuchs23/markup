package org.dbdoclet.xiphias;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.File;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.dbdoclet.service.ResourceServices;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

public class XmlServicesTests {

	private URL xsdUrl;

	@Before
	public void startUp() {
		xsdUrl = ResourceServices.getResourceAsUrl("/x-docu/5.0/x-docu.xsd");

	}

	@Test
	public void testParseNoSchema() {

		try {
			URL xmlUrl = ResourceServices
					.getResourceAsUrl("/xml/KeinSchema.xml");
			Document doc = XmlServices.parse(new File(xmlUrl.getPath()), true,
					xsdUrl);
			assertNotNull(doc);

		} catch (Exception oops) {
			oops.printStackTrace();
			fail();
		}
	}

	@Test
	public void testParseWithXsd() {

		try {
			URL xmlUrl = ResourceServices.getResourceAsUrl("/xml/MitXsd.xml");
			Document doc = XmlServices.parse(new File(xmlUrl.getPath()), true,
					xsdUrl);
			assertNotNull(doc);

		} catch (Exception oops) {
			oops.printStackTrace();
			fail();
		}
	}

	@Test
	public void testWrite() {

		try {

			URL xmlUrl = ResourceServices.getResourceAsUrl("/xml/Driver.xsl");
			Document doc = XmlServices.loadDocument(new File(xmlUrl.getPath()));
			NodeSerializer serializer = new NodeSerializer();
			serializer.write(doc.getDocumentElement(), new File(
					"build/TestWrite.xml"));
			assertNotNull(doc);

		} catch (Exception oops) {
			oops.printStackTrace();
			fail();
		}
	}

	@Test
	public void testExpandEntity() {

		try {

			URL xmlUrl = ResourceServices.getResourceAsUrl("/xml/Driver.xsl");
			File file = new File(xmlUrl.getPath());
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			factory.setExpandEntityReferences(false);
			factory.setValidating(true);
			DocumentBuilder parser = factory.newDocumentBuilder();
			Document doc = parser.parse(file);
			NodeSerializer serializer = new NodeSerializer();
			serializer.write(doc.getDocumentElement(), new File(
					"build/TestWrite.xml"));
			assertNotNull(doc);

		} catch (Exception oops) {
			oops.printStackTrace();
			fail();
		}
	}
}
