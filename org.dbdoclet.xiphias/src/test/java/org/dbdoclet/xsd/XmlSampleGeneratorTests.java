package org.dbdoclet.xsd;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;

import org.dbdoclet.service.FileServices;
import org.dbdoclet.xiphias.XmlValidationResult;
import org.dbdoclet.xiphias.XsdServices;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;

public class XmlSampleGeneratorTests {

	@Test
	@Disabled
	public void testDocBookMaximal() {

		XmlSampleGenerator xsg;

		try {

			File xsdFile = new File(
					"src/test/resources/xsd/docbook/docbook.xsd");
			xsg = new XmlSampleGenerator(xsdFile);

			Element[] roots = xsg.getRootElements();

			for (Element root : roots) {

				String xmlBuffer = xsg.createSample(root,
						XmlSampleGenerator.Type.MAXIMAL);
				File xmlFile = new File("build/xml/docbook/"
						+ root.getTagName() + "-Maximal.xml");
				FileServices.writeFromString(xmlFile, xmlBuffer);

				XmlValidationResult result = XsdServices.validate(xmlFile,
						xsdFile);

				if (result.failed()) {
					fail(result.createTextReport());
				}
			}

		} catch (Exception oops) {

			oops.printStackTrace();
			fail(oops.getMessage());
		}
	}

	@Test
	@Disabled
	public void testGsmHabmMaximal() {

		XmlSampleGenerator xsg;

		try {

			File xsdFile = new File(
					"src/test/resources/xsd/gsm/habm/EM-DS-Design-Transfer-V1-0.xsd");
			xsg = new XmlSampleGenerator(xsdFile);

			Element[] roots = xsg.getRootElements();

			for (Element root : roots) {

				String xmlBuffer = xsg.createSample(root,
						XmlSampleGenerator.Type.MAXIMAL);
				File xmlFile = new File("build/xml/gsm/habm/"
						+ root.getTagName() + "-Maximal.xml");
				FileServices.writeFromString(xmlFile, xmlBuffer);

				XmlValidationResult result = XsdServices.validate(xmlFile,
						xsdFile);

				if (result.failed()) {
					fail(result.createTextReport());
				}
			}

		} catch (Exception oops) {

			oops.printStackTrace();
			fail(oops.getMessage());
		}
	}

	@Test
	@Disabled
	public void testIrMaximal() {

		XmlSampleGenerator xsg;

		try {

			File xsdFile = new File(
					"src/test/resources/xsd/ir/DPMAregisterTrademarkIr.xsd");
			xsg = new XmlSampleGenerator(xsdFile);

			Element[] roots = xsg.getRootElements();

			for (Element root : roots) {

				String xmlBuffer = xsg.createSample(root,
						XmlSampleGenerator.Type.MAXIMAL);
				File xmlFile = new File("build/xml/ir/" + root.getTagName()
						+ "-Maximal.xml");
				FileServices.writeFromString(xmlFile, xmlBuffer);

				XmlValidationResult result = XsdServices.validate(xmlFile,
						xsdFile);

				if (result.failed()) {
					fail(result.createTextReport());
				}
			}

		} catch (Exception oops) {

			oops.printStackTrace();
			fail(oops.getMessage());
		}
	}

	@Test
	@Disabled
	public void testHabmMaximal() {

		XmlSampleGenerator xsg;

		try {

			File xsdFile = new File(
					"src/test/resources/xsd/habm/CTM-D-TRANSFER-V3-4-4-1.xsd");
			xsg = new XmlSampleGenerator(xsdFile);

			Element[] roots = xsg.getRootElements();

			for (Element root : roots) {

				String xmlBuffer = xsg.createSample(root,
						XmlSampleGenerator.Type.MAXIMAL);
				File xmlFile = new File("build/xml/habm/" + root.getTagName()
						+ "-Maximal.xml");
				FileServices.writeFromString(xmlFile, xmlBuffer);

				XmlValidationResult result = XsdServices.validate(xmlFile,
						xsdFile);

				if (result.failed()) {
					fail(result.createTextReport());
				}
			}

		} catch (Exception oops) {

			oops.printStackTrace();
			fail(oops.getMessage());
		}
	}

	@Test
	@Disabled
	public void testHabmRandom() {

		XmlSampleGenerator xsg;

		try {

			File xsdFile = new File(
					"src/test/resources/xsd/habm/CTM-D-TRANSFER-V3-4-4-1.xsd");

			xsg = new XmlSampleGenerator(xsdFile);
			xsg.setVerboseEnabled(true);
			xsg.createRandom(new File("build/xml/habm/"), 200);

		} catch (Exception oops) {

			oops.printStackTrace();
			fail(oops.getMessage());
		}
	}

	@Test
	@Disabled
	public void testMarkeXsg_1() {

		XmlSampleGenerator xsg;

		try {
			xsg = new XmlSampleGenerator(new File(
					"./src/test/resources/xsd/marke/DPMARegisterSchema.xsd"));
			@SuppressWarnings("unused")
			String xmlBuffer = xsg.createSample();
			// System.out.println(xmlBuffer);
		} catch (Exception oops) {
			oops.printStackTrace();
			fail(oops.getMessage());
		}
	}

	@SuppressWarnings("unused")
	@Test
	@Disabled
	public void testGsmXsg_1() {
		XmlSampleGenerator xsg;
		try {
			xsg = new XmlSampleGenerator(new File(
					"./src/test/resources/xsd/gsm/DPMARegisterGsm.xsd"));
			String xmlBuffer = xsg.createSample();
			// System.out.println(xmlBuffer);
		} catch (Exception oops) {
			oops.printStackTrace();
			fail(oops.getMessage());
		}
	}

	@SuppressWarnings("unused")
	@Test
	@Disabled
	public void testPatentXsg_1() {

		XmlSampleGenerator xsg;

		try {

			xsg = new XmlSampleGenerator(new File(
					"./src/test/resources/xsd/patent/DPMAregisterPatent.xsd"));
			String xmlBuffer = xsg.createSample();
			// System.out.println(xmlBuffer);

		} catch (Exception oops) {

			oops.printStackTrace();
			fail(oops.getMessage());
		}
	}

	@Test
	@Disabled
	public void testMarkeMaximal() {

		XmlSampleGenerator xsg;

		try {

			File xsdFile = new File(
					"src/test/resources/xsd/marke/DPMAregisterMarke.xsd");
			xsg = new XmlSampleGenerator(xsdFile);
			Element[] roots = xsg.getRootElements();
			for (Element root : roots) {
				String xmlBuffer = xsg.createSample(root,
						XmlSampleGenerator.Type.MAXIMAL);
				File xmlFile = new File("build/xml/marke/" + root.getTagName()
						+ "-Maximal.xml");
				FileServices.writeFromString(xmlFile, xmlBuffer);

				XmlValidationResult result = XsdServices.validate(xmlFile,
						xsdFile);

				if (result.failed()) {
					fail(result.createTextReport());
				}
			}
		} catch (Exception oops) {
			oops.printStackTrace();
			fail(oops.getMessage());
		}
	}

	@Test
	@Disabled
	public void testPatentMaximal() {

		XmlSampleGenerator xsg;

		try {

			File xsdFile = new File(
					"src/test/resources/xsd/patent/DPMAregisterPatent.xsd");
			xsg = new XmlSampleGenerator(xsdFile);

			Element[] roots = xsg.getRootElements();

			for (Element root : roots) {

				String xmlBuffer = xsg.createSample(root,
						XmlSampleGenerator.Type.MAXIMAL);
				File xmlFile = new File("build/xml/patent/" + root.getTagName()
						+ "-Maximal.xml");
				FileServices.writeFromString(xmlFile, xmlBuffer);

				XmlValidationResult result = XsdServices.validate(xmlFile,
						xsdFile);

				if (result.failed()) {
					fail(result.createTextReport());
				}
			}

		} catch (Exception oops) {

			oops.printStackTrace();
			fail(oops.getMessage());
		}
	}

	@Test
	@Disabled
	public void testPatentMinimal() {

		XmlSampleGenerator xsg;

		try {

			File xsdFile = new File(
					"src/test/resources/xsd/patent/DPMAregisterPatent.xsd");
			xsg = new XmlSampleGenerator(xsdFile);

			Element[] roots = xsg.getRootElements();

			for (Element root : roots) {
				String xmlBuffer = xsg.createSample(root,
						XmlSampleGenerator.Type.MINIMAL);
				File xmlFile = new File("build/xml/patent/" + root.getTagName()
						+ "-Minimal.xml");
				FileServices.writeFromString(xmlFile, xmlBuffer);

				XmlValidationResult result = XsdServices.validate(xmlFile,
						xsdFile);

				if (result.failed()) {
					fail(result.createTextReport());
				}
			}

		} catch (Exception oops) {

			oops.printStackTrace();
			fail(oops.getMessage());
		}
	}

	@Test
	@Disabled
	public void testPatentRandom() {

		XmlSampleGenerator xsg;

		try {

			File xsdFile = new File(
					"src/test/resources/xsd/patent/DPMAregisterPatent.xsd");

			xsg = new XmlSampleGenerator(xsdFile);
			xsg.setVerboseEnabled(true);
			xsg.createRandom(new File("build/xml/patent/"), 1);

		} catch (Exception oops) {

			oops.printStackTrace();
			fail(oops.getMessage());
		}
	}
}
