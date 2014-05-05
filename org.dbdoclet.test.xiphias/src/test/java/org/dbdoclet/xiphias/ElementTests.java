package org.dbdoclet.xiphias;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.dbdoclet.xiphias.dom.DocumentImpl;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ElementTests {

	@Test
	public void createElement() throws IOException {

		Document doc = new DocumentImpl();
		Element book= doc.createElement("book");
		assertEquals("book", book.getTagName());
	}

	@Test
	public void createElementNS() throws IOException {

		Document doc = new DocumentImpl();
		Element book = doc.createElementNS("http://docbook.org/ns", "db:book");
		
		assertEquals("book", book.getLocalName());
	}
}
