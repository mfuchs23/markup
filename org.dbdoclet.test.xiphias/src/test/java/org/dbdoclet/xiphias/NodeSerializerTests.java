package org.dbdoclet.xiphias;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class NodeSerializerTests {

	@Test
	public void testNoChunk() throws IOException, SAXException, ParserConfigurationException {

		File file = new File("src/test/resources/xml/ChunkOutput.xml");
		Document doc = XmlServices.parse(file);
		
		new File("build").mkdirs();
		File out = new File("build/NoChunk.xml");
		NodeSerializer nodeSerializer = new NodeSerializer();
		nodeSerializer.write(doc, out, "ISO-8859-15");
	}

	@Test
	public void testChunkChapter() throws IOException, SAXException, ParserConfigurationException {

		File file = new File("src/test/resources/xml/ChunkOutput.xml");
		Document doc = XmlServices.parse(file);
		
		new File("build").mkdirs();
		File out = new File("build/ChunkOutput.xml");
		NodeSerializer nodeSerializer = new NodeSerializer();
		nodeSerializer.addChunkElement("chapter");
		nodeSerializer.write(doc, out, "ISO-8859-15");
	}

}
