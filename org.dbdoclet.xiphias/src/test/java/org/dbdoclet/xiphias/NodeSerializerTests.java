package org.dbdoclet.xiphias;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.dbdoclet.service.FileServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class NodeSerializerTests {

	private File buildDir;

	@BeforeEach
	public void startUp() throws IOException {
		buildDir = new File("build/chunk");
		FileServices.delete(buildDir);
		buildDir.mkdirs();
	}
	
	@Test
	public void testNoChunk() throws IOException, SAXException, ParserConfigurationException {

		File file = new File("src/test/resources/xml/ChunkOutput.xml");
		Document doc = XmlServices.parse(file);
		
		new File("build").mkdirs();
		File out = new File("build/NoChunk.xml");
		NodeSerializer nodeSerializer = new NodeSerializer();
		nodeSerializer.write(doc, out);
	}

	@Test
	public void testChunk_1() throws IOException, SAXException, ParserConfigurationException {

		File file = new File("src/test/resources/xml/chunk/Chunk_1.xml");
		Document doc = XmlServices.parse(file);
		
		File out = new File(buildDir, "Chunk_1.xml");
		NodeSerializer nodeSerializer = new NodeSerializer();
		nodeSerializer.addChunkElement("section");
		nodeSerializer.write(doc, out);
		
		assertExists(new File(buildDir, "Chunk_1.xml"));
		assertExists(new File(buildDir, "section-1.xml"));
		assertExists(new File(buildDir, "section-2.xml"));
		assertExists(new File(buildDir, "section-3.xml"));
	}

	@Test
	public void testChunkDepth3() throws IOException, SAXException, ParserConfigurationException {

		File file = new File("src/test/resources/xml/chunk/Chunk_1.xml");
		Document doc = XmlServices.parse(file);
		
		File out = new File(buildDir, "Chunk_1.xml");
		NodeSerializer nodeSerializer = new NodeSerializer();
		nodeSerializer.addChunkElement("section", 3);
		nodeSerializer.write(doc, out);
		
		assertExists(new File(buildDir, "Chunk_1.xml"));
		assertExists(new File(buildDir, "section-1.xml"));
		assertExists(new File(buildDir, "section-2.xml"));
		assertExists(new File(buildDir, "section-3.xml"));
	}

	private void assertExists(File file) {

		assertTrue(file.exists(),String.format("Die Datei %s wurde nicht erzeugt",  file));
	}

}
