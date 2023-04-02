package org.dbdoclet.xiphias;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import org.dbdoclet.service.ResourceServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class XPathServicesTests {

	// private static Log logger = LogFactory.getLog(XmlServicesTests.class,
	// Logger.INFO);

	private URL xsdUrl;

	@BeforeEach
	public void startUp() {
		xsdUrl = ResourceServices.getResourceAsUrl("/x-docu/5.0/x-docu.xsd");
	}

	@Test
	public void testXInclude() {

		try {
			Document doc = XmlServices.parse(new File(ResourceServices
					.getResourceAsUrl("/xml/XIncludeMain.xml").getPath()),
					true, xsdUrl);
			assertNotNull(doc);

			ArrayList<Node> list = XPathServices.getNodes(doc, "xi",
					"http://www.w3.org/2001/XInclude", "//xi:include");
			assertEquals(list.size(), 1);

			System.out.println((list.get(0)));

		} catch (Exception oops) {
			oops.printStackTrace();
			fail();
		}
	}

	@Test
	public void testXInclude_2() {

		try {

			Document doc = XmlServices.parse(new File(ResourceServices
					.getResourceAsUrl("/xml/Lektion.xml").getPath()), true,
					xsdUrl);
			assertNotNull(doc);

			ArrayList<String> list = XPathServices.getValues(doc, "xi",
					"http://www.w3.org/2001/XInclude", "//xi:include/@href");
			assertEquals(2, list.size());

			System.out.println((list.get(0)));

		} catch (Exception oops) {
			oops.printStackTrace();
			fail();
		}
	}

}
