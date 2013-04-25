package org.dbdoclet.xsd;

import static org.junit.Assert.fail;

import java.io.File;

import org.dbdoclet.log.Logger;
import org.dbdoclet.service.FileServices;
import org.dbdoclet.xiphias.XmlValidationResult;
import org.dbdoclet.xiphias.XsdServices;
import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Element;

public class XmlSampleGeneratorTests {

	@Test
	@Ignore
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
	@Ignore
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
	@Ignore
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
	@Ignore
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
	@Ignore
	public void testHabmRandom() {

		XmlSampleGenerator xsg;

		try {

			File xsdFile = new File(
					"src/test/resources/xsd/habm/CTM-D-TRANSFER-V3-4-4-1.xsd");

			xsg = new XmlSampleGenerator(xsdFile);
			xsg.setVerboseEnabled(true);
			Logger.setRootLogLevel(Logger.WARN);
			xsg.createRandom(new File("build/xml/habm/"), 200);

		} catch (Exception oops) {

			oops.printStackTrace();
			fail(oops.getMessage());
		}
	}

	@Test
	@Ignore
	public void testMarkeXsg_1() {

		XmlSampleGenerator xsg;

		try {
			xsg = new XmlSampleGenerator(new File(
					"./src/test/resources/xsd/marke/DPMARegisterSchema.xsd"));
			String xmlBuffer = xsg.createSample();
			// System.out.println(xmlBuffer);
		} catch (Exception oops) {
			oops.printStackTrace();
			fail(oops.getMessage());
		}
	}

	@Test
	@Ignore
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

	@Test
	@Ignore
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
	@Ignore
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
	@Ignore
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
	@Ignore
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
	@Ignore
	public void testPatentRandom() {

		XmlSampleGenerator xsg;

		try {

			File xsdFile = new File(
					"src/test/resources/xsd/patent/DPMAregisterPatent.xsd");

			xsg = new XmlSampleGenerator(xsdFile);
			xsg.setVerboseEnabled(true);
			Logger.setRootLogLevel(Logger.WARN);
			xsg.createRandom(new File("build/xml/patent/"), 1);

		} catch (Exception oops) {

			oops.printStackTrace();
			fail(oops.getMessage());
		}
	}
}
