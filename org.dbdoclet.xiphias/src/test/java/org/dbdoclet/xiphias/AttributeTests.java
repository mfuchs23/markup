package org.dbdoclet.xiphias;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.dbdoclet.xiphias.dom.DocumentImpl;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class AttributeTests {

	@Test
	public void testXmlLang() throws IOException {

		Document doc = new DocumentImpl();
		Element book= doc.createElement("book");
		book.setAttributeNS(XmlConstants.NAMESPACE_XML, "xml:lang", "de");
		
		assertEquals("de", book.getAttributeNS(XmlConstants.NAMESPACE_XML, "lang"));
	}
}
