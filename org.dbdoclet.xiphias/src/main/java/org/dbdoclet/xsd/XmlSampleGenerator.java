package org.dbdoclet.xsd;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dbdoclet.option.DirectoryOption;
import org.dbdoclet.option.FileOption;
import org.dbdoclet.option.OptionList;
import org.dbdoclet.service.FileServices;
import org.dbdoclet.service.StringServices;
import org.dbdoclet.xiphias.NodeSerializer;
import org.dbdoclet.xiphias.XmlServices;
import org.dbdoclet.xiphias.XmlValidationResult;
import org.dbdoclet.xiphias.XsdServices;
import org.dbdoclet.xiphias.dom.DocumentImpl;
import org.dbdoclet.xiphias.dom.ElementImpl;
import org.dbdoclet.xsd.sage.SampleData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlSampleGenerator {

	public enum Type {
		MAXIMAL, MINIMAL, RANDOM;
	}

	private static Log logger = LogFactory.getLog("XmlSampleGenerator");

	private static String[] TEXTE = new String[] {
			"Aber die Sonne duldet kein Weißes, // Überall regt sich Bildung und Streben, // Alles will sie mit Farben beleben; // Doch an Blumen fehlts im Revier, // Sie nimmt geputzte Menschen dafür.",
			"Allein der Vortrag macht des Redners Glück.",
			"Bedenkt, Ihr habet weiches Holz zu spalten.",
			"Bescheidne Wahrheit sprech ich dir. // Wenn sich der Mensch, die kleine Narrenwelt, // Gewöhnlich für ein Ganzes hält.",
			"Das also war des Pudels Kern!",
			"Denn was man schwarz auf weiß besitzt, // Kann man getrost nach Hause tragen.",
			"Die Botschaft hör ich wohl, allein mir fehlt der Glaube.",
			"Es irrt der Mensch, solang er strebt.",
			"Ich bin der Geist, der stets verneint! // Und das mit Recht; denn alles, was entsteht, // Ist wert, daß es zugrunde geht; // Drum besser wär's, daß nichts entstünde. // So ist denn alles, was ihr Sünde, // Zerstörung, kurz das Böse nennt, // Mein eigentliches Element.",
			"(Ich bin) Ein Teil von jener Kraft, // Die stets das Böse will und stets das Gute schafft.",
			"Gewöhnlich glaubt der Mensch, wenn er nur Worte hört, // Es müsse sich dabei doch auch was denken lassen.",
			"Grau, teurer Freund, ist alle Theorie // Und grün des Lebens goldner Baum.",
			"Habe nun, ach! Philosophie, // Juristerei und Medizin, // Und leider auch Theologie! // Durchaus studiert, mit heißem Bemühn. // Da steh ich nun, ich armer Tor! // Und bin so klug als wie zuvor.",
			"Heinrich! Mir graut's vor dir.",
			"Hier bin ich Mensch, hier darf ich's sein!",
			"Hier ist ein Saft, der eilig trunken macht.",
			"Im Anfang war die Tat!",
			"Mit Worten lässt sich trefflich streiten.",
			"Was glänzt, ist für den Augenblick geboren; // Das Echte bleibt der Nachwelt unverloren.",
			"Auch aus Steinen, die einem in den Weg gelegt werden, kann man Schönes bauen.",
			"Wir erschrecken über unsere eigenen Sünden, wenn wir sie an anderen erblicken.",
			"Wer nicht mehr liebt und nicht mehr irrt, der lasse sich begraben.",
			"Wenn man alle Gesetze studieren wollte, so hätte man gar keine Zeit, sie zu übertreten.",
			"Es hört doch jeder nur, was er versteht.",
			"Man kann die Erfahrung nicht früh genug machen, wie entbehrlich man in der Welt ist.",
			"Gegner glauben uns zu widerlegen, indem sie ihre Meinung wiederholen und die unsre nicht achten.",
			"Wenn man von den Leuten Pflichten fordert und ihnen keine Rechte zugestehen will, muss man sie gut bezahlen.",
			"Du sprichst ein großes Wort gelassen aus.", "" };

	private TreeMap<String, Element> elementMap;
	private Random rand;
	private File resourceDirectory;
	private TreeMap<String, SampleData> sdMap;
	private Type type;
	private boolean verbose;
	private XmlSchema xmlSchema;
	private final File xsdFile;

	public XmlSampleGenerator(File xsdFile) throws IOException, SAXException,
			ParserConfigurationException {

		if (xsdFile == null) {
			throw new IllegalArgumentException(
					"The argument file must not be null!");
		}

		this.xsdFile = xsdFile;

		rand = new Random();
		sdMap = new TreeMap<String, SampleData>();
		xmlSchema = new XmlSchema(xsdFile);
		elementMap = new TreeMap<String, Element>();
	}

	public static void main(String[] args) {

		OptionList options = new OptionList(args);

		DirectoryOption optDataDirectory = new DirectoryOption("data", "r");
		optDataDirectory.isRequired(true);
		optDataDirectory.isExisting(true);
		options.add(optDataDirectory);

		DirectoryOption optDestinationDirectory = new DirectoryOption("dest",
				"d");
		optDestinationDirectory.isRequired(true);
		optDestinationDirectory.isExisting(true);
		optDestinationDirectory.setCreatePath(true);
		options.add(optDestinationDirectory);

		FileOption optSchemaFile = new FileOption("xsd", "s");
		optSchemaFile.isRequired(true);
		optSchemaFile.isExisting(true);
		options.add(optSchemaFile);

		if (options.validate() == false) {
			System.out.println(options.getError());
			System.exit(-1);
		}

		XmlSampleGenerator xsg;

		try {

			xsg = new XmlSampleGenerator(optSchemaFile.getValue());
			xsg.setResourceDirectory(optDataDirectory.getValue());
			xsg.setVerboseEnabled(true);
			xsg.createRandom(optDestinationDirectory.getValue(), 250);

		} catch (Exception oops) {
			oops.printStackTrace();
		}
	}

	public void createRandom(File destDir, int count) throws IOException {

		Element[] roots = getRootElements();

		for (int i = 0; i < count; i++) {

			for (Element root : roots) {

				String xmlBuffer;

				if (i % 10 == 0) {
					xmlBuffer = createSample(root,
							XmlSampleGenerator.Type.MAXIMAL);
				} else {
					xmlBuffer = createSample(root,
							XmlSampleGenerator.Type.RANDOM);
				}

				File xmlFile = new File(FileServices.appendFileName(destDir,
						root.getTagName() + "-" + (i + 1) + ".xml"));

				println("Creating %s.", xmlFile.getCanonicalPath());

				FileServices.writeFromString(xmlFile, xmlBuffer);

				XmlValidationResult result = XsdServices.validate(xmlFile,
						xsdFile);

				if (result.failed()) {
					System.err.println(result.createTextReport());
				}
			}
		}

		File statFile = new File(FileServices.appendFileName(destDir,
				"xgstat.csv"));

		PrintWriter writer = new PrintWriter(new FileWriter(statFile));

		for (String id : sdMap.keySet()) {

			SampleData sd = sdMap.get(id);
			Map<String, Integer> stMap = sd.getStatistics();

			for (String value : stMap.keySet()) {
				if (value.indexOf(' ') != -1) {
					writer.println(String.format("%s~\"%s\"~%d", id, value,
							stMap.get(value)));
				} else {
					writer.println(String.format("%s~%s~%d", id, value,
							stMap.get(value)));
				}
			}
		}

		writer.close();
	}

	public String createSample() throws IOException {

		Element[] rootElements = getRootElements();

		if (rootElements.length > 0) {
			return createSample(rootElements[0], Type.RANDOM);
		}

		return "";
	}

	public String createSample(Element rootElement, Type type) throws IOException {

		this.type = type;

		DocumentImpl doc = new DocumentImpl();
		ElementImpl documentElement = doc.createElement(rootElement
				.getTagName());

		NamedNodeMap attributeMap = rootElement.getAttributes();

		if (attributeMap != null) {
			for (int i = 0; i < attributeMap.getLength(); i++) {

				Node attribute = attributeMap.item(i);
				documentElement.setAttribute(attribute.getNodeName(),
						attribute.getNodeValue());
			}
		}

		doc.setDocumentElement(documentElement);
		Document masterDoc = xmlSchema.getMasterDocument(rootElement);
		elementMap.put(rootElement.getTagName(), rootElement);

		traverse(masterDoc.getDocumentElement(), documentElement, doc);
		postProcess(documentElement.getTagName());

		return new NodeSerializer().toXML(doc);
	}

	public Element[] getRootElements() {

		Element[] rootElements = xmlSchema.getRootElements();
		return rootElements;
	}

	public void setVerboseEnabled(boolean verbose) {
		this.verbose = verbose;
	}

	public void traverse(Element masterElement, Element element, Document doc) {

		if (masterElement != null) {

			NodeList masterChildList = masterElement.getChildNodes();

			for (int i = 0; i < masterChildList.getLength(); i++) {

				Node masterChild = masterChildList.item(i);

				if (masterChild instanceof Element) {

					Element masterChildElement = (Element) masterChild;
					XsdMetaData xsdData = (XsdMetaData) masterChildElement
							.getUserData("xsd");

					if (type == Type.MINIMAL && xsdData.isOptional()) {
						continue;
					}

					if (type == Type.RANDOM && xsdData.isOptional()) {

						if (rand.nextBoolean() == false) {
							continue;
						}
					}

					Element child = doc.createElement(masterChildElement
							.getTagName());
					element.appendChild(child);

					elementMap.put(masterChildElement.getTagName(),
							masterChildElement);
					createContents(doc, masterChildElement, child);
					createAttributes(doc, masterChildElement, child);
					createBO(masterChildElement);
					traverse(masterChildElement, child, doc);
				}
			}
		}
	}

	private void createAttributes(Document doc, Element masterChildElement,
			Element child) {

		NamedNodeMap amap = masterChildElement.getAttributes();

		for (int i = 0; i < amap.getLength(); i++) {

			Node attr = amap.item(i);
			child.setAttribute(attr.getNodeName(),
					getAttributeValue(masterChildElement, attr));
		}
	}

	private void createBO(Element element) {

		String className = element.getTagName();
		String type = "String";

		type = getBoType(element);

		StringBuilder buffer = new StringBuilder();
		buffer.append("package de.dpma.register.marke.hbm.type;\n\n");
		buffer.append("import de.dpma.register.commons.type.AbstractBO;\n");
		buffer.append("import de.dpma.register.commons.type.Container;\n");
		buffer.append("import de.dpma.register.marke.hbm.MessageConstants;\n");
		buffer.append("import de.dpma.register.marke.hbm.SortConstants;\n");

		if (type.equals("Date")) {
			buffer.append("import java.util.Date;\n");
		}

		NodeList childList = element.getChildNodes();

		buffer.append("\n");
		buffer.append("/**\n");
		buffer.append(" * Das Fachobjekt " + className + ". Generiert am "
				+ DateFormat.getDateTimeInstance().format(new Date()) + ".\n");
		buffer.append(" */\n");
		buffer.append("public class " + className + " extends AbstractBO<"
				+ type + ">");

		if (childList.getLength() > 0) {
			buffer.append(" implements Container");
		}

		buffer.append(" {\n\n");

		buffer.append("  private static final long serialVersionUID = 1L;\n\n");

		for (int i = 0; i < childList.getLength(); i++) {

			Element field = (Element) childList.item(i);
			String fieldType = field.getTagName();

			buffer.append("  private " + fieldType + " "
					+ toFieldName(fieldType) + ";\n");
		}

		buffer.append("\n  " + className + "() {\n");
		buffer.append("    setResourceKey(MessageConstants.BO_"
				+ className.toUpperCase() + ");\n");
		buffer.append("    setSortKey(SortConstants.SORT_"
				+ className.toUpperCase() + ");\n");
		buffer.append("  }\n");

		for (int i = 0; i < childList.getLength(); i++) {

			Element field = (Element) childList.item(i);
			String fieldType = field.getTagName();
			String var = toFieldName(fieldType);

			buffer.append("\n  public void set" + fieldType + "(" + fieldType
					+ " " + var + ") {\n");
			buffer.append("    this." + toFieldName(fieldType) + " = " + var
					+ ";\n");
			buffer.append("    setChild(" + var + ");\n");
			buffer.append("  }\n\n");
			buffer.append("  public " + fieldType + " get" + fieldType
					+ "() {\n");
			buffer.append("    return " + var + ";\n");
			buffer.append("  }\n\n");
		}

		buffer.append("}\n");

		String fileName = "build/de/dpma/register/marke/hbm/type/" + className
				+ ".java";
		File file = new File(fileName);

		try {

			FileServices.createPath(file.getParent());
			FileServices.writeFromString(file, buffer.toString());

		} catch (IOException oops) {
			oops.printStackTrace();
		}
	}

	private void createBusinessObjectFactory() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("package de.dpma.register.marke.hbm.type;\n\n");
		buffer.append("import java.util.Date;\n\n");
		buffer.append("public interface BusinessObjectFactory{\n\n");

		for (String key : elementMap.keySet()) {

			Element elem = elementMap.get(key);

			if (elem.getChildNodes().getLength() == 0) {
				buffer.append("  public " + key + " create" + key + "("
						+ getBoType(elementMap.get(key)) + " value);\n");
			} else {

				buffer.append("  public " + key + " create" + key + "();\n");
			}
		}

		buffer.append("}\n");

		String fileName = "build/de/dpma/register/marke/hbm/type/BusinessObjectFactory.java";
		File file = new File(fileName);

		try {
			FileServices.createPath(file.getParent());
			FileServices.writeFromString(file, buffer.toString());
		} catch (IOException oops) {
			oops.printStackTrace();
		}
	}

	/**
	 * Generiert den Inhalt des Elements. Für eine Element kann eine Datei mit
	 * Daten und Regeln hinterlegt werden, die die Generierung des Inhalts
	 * beeinflusst.
	 * 
	 * @param doc
	 * @param masterChildElement
	 * @param child
	 */
	private void createContents(Document doc, Element masterChildElement,
			Element child) {

		XsdMetaData xsdData = (XsdMetaData) masterChildElement
				.getUserData("xsd");

		if (xsdData != null) {

			String type = xsdData.getType();

			if (type == null) {
				return;
			}

			Integer maxLength = xsdData.getMaxLength();

			String ns = xmlSchema.getXmlSchemaNamespace();

			if (type.equals(ns + ":string") || type.equals(ns + ":NMTOKEN")
					|| type.equals(ns + ":token")) {

				if (xsdData.isEnum()) {

					child.appendChild(doc.createTextNode(getEnumText(child,
							xsdData.getEnumList())));

				} else {

					String text = getText(child, getRandomText());

					if (maxLength != null && text.length() > maxLength) {
						text = text.substring(0, maxLength);
					}

					child.appendChild(doc.createTextNode(text));
				}

				return;
			}

			if (type.equals(ns + ":date")) {
				child.appendChild(doc.createTextNode(getText(child,
						"1965-02-23")));
				return;
			}

			if (type.equals(ns + ":boolean")) {
				child.appendChild(doc.createTextNode("true"));
				return;
			}

			if (type.equals(ns + ":integer")
					|| type.equals(ns + ":nonNegativeInteger")
					|| type.equals(ns + ":unsignedInt")
					|| type.equals(ns + ":short")
					|| type.equals(ns + ":unsignedShort")) {
				child.appendChild(doc.createTextNode(getText(child,
						getRandomNumberAsText())));
				return;
			}

			// System.out.println(masterChildElement + " type=" + type);
		}
	}

	private void createDbImportProcessor(String rootTagName) {

		StringBuilder buffer = new StringBuilder();

		Element root = elementMap.get(rootTagName);
		NodeList childList = root.getChildNodes();

		for (int i = 0; i < childList.getLength(); i++) {

			Node childNode = childList.item(i);

			if (childNode instanceof Element) {

				Element child = (Element) childNode;
				String tagName = child.getTagName();

				if (child.getChildNodes().getLength() == 0) {

					String suchfeld = child.getAttribute("suchfeld");
					System.out.println("Suchfeld=" + suchfeld);

					if (suchfeld != null) {
						buffer.append("        " + tagName + " "
								+ StringServices.lowerFirstLetter(tagName)
								+ " = stammdaten.get" + tagName + "();\n");
						buffer.append("        if ("
								+ StringServices.lowerFirstLetter(tagName)
								+ " != null) {\n");

						for (String sf : suchfeld.split(",")) {
							buffer.append("            sd.set"
									+ StringServices.capFirstLetter(sf.trim()
											.toLowerCase()) + "("
									+ StringServices.lowerFirstLetter(tagName)
									+ ".getValue());\n");
						}

						buffer.append("        }\n\n");
					}
				}
			}
		}

		String fileName = "build/de/dpma/register/marke/hbm/xml/DbImportProcessorFill.java";
		File file = new File(fileName);

		try {
			FileServices.createPath(file.getParent());
			FileServices.writeFromString(file, buffer.toString());
		} catch (IOException oops) {
			oops.printStackTrace();
		}
	}

	private void createDefaultBusinessObjectFactory() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("package de.dpma.register.marke.hbm.type;\n\n");
		buffer.append("import de.dpma.register.commons.type.AbstractBO;\n\n");
		buffer.append("import java.io.Serializable;\n");
		buffer.append("import java.util.Date;\n");
		buffer.append("import java.util.HashMap;\n");
		buffer.append("import java.util.Locale;\n");
		buffer.append("import java.util.ResourceBundle;\n\n");
		buffer.append("public class DefaultBusinessObjectFactory implements BusinessObjectFactory, Serializable {\n\n");

		buffer.append("  private static final long serialVersionUID = 1L;\n");
		buffer.append("  private static HashMap<Locale, DefaultBusinessObjectFactory> instanceMap = null;\n");
		buffer.append("  private transient ResourceBundle res;\n\n");

		buffer.append("  private DefaultBusinessObjectFactory(Locale locale) {\n");
		buffer.append("    if (locale != null) {\n");
		buffer.append("      res = ResourceBundle.getBundle(\"de/dpma/register/marke/hbm/PrintResources\", locale);\n");
		buffer.append("    } else {\n");
		buffer.append("      res = ResourceBundle.getBundle(\"de/dpma/register/marke/hbm/PrintResources\");\n");
		buffer.append("    }\n");
		buffer.append("  }\n\n");
		buffer.append("  public static synchronized void dispose() {\n");
		buffer.append("    instanceMap.clear();\n");
		buffer.append("    instanceMap = null;\n");
		buffer.append("  }\n\n");
		buffer.append("  public static synchronized DefaultBusinessObjectFactory getInstance() {\n");
		buffer.append("    return DefaultBusinessObjectFactory.getInstance(Locale.getDefault());\n");
		buffer.append("  }\n\n");
		buffer.append("  public static synchronized DefaultBusinessObjectFactory getInstance(Locale locale) {\n");
		buffer.append("    if (instanceMap == null) {\n");
		buffer.append("      instanceMap = new HashMap<Locale, DefaultBusinessObjectFactory>();\n");
		buffer.append("    }\n");
		buffer.append("    DefaultBusinessObjectFactory instance = instanceMap.get(locale);\n");
		buffer.append("    if (instance == null) {\n");
		buffer.append("      instance = new DefaultBusinessObjectFactory(locale);\n");
		buffer.append("      instanceMap.put(locale, instance);\n");
		buffer.append("    }\n");
		buffer.append("    return instance;\n");
		buffer.append("  }\n\n");
		buffer.append("  private void initialize(AbstractBO<String> bo, String value) {\n\n");
		buffer.append("    if (bo == null || value == null) {\n");
		buffer.append("      return;\n");
		buffer.append("    }\n\n");
		buffer.append("    bo.setValue(value);\n");
		buffer.append("  }\n");
		buffer.append("  private void initialize(AbstractBO<Date> bo, Date value) {\n\n");
		buffer.append("    if (bo == null || value == null) {\n");
		buffer.append("      return;\n");
		buffer.append("    }\n\n");
		buffer.append("    bo.setValue(value);\n");
		buffer.append("  }\n\n");

		for (String key : elementMap.keySet()) {

			Element elem = elementMap.get(key);

			if (elem.getChildNodes().getLength() == 0) {
				buffer.append("  public " + key + " create" + key + "("
						+ getBoType(elementMap.get(key)) + " type) {\n");
				buffer.append("    " + key + " bo = new " + key + "();\n");
				buffer.append("    initialize(bo, type);\n");
				buffer.append("    return bo;\n");
				buffer.append("  }\n\n");

			} else {

				buffer.append("  public " + key + " create" + key + "() {\n");
				buffer.append("    " + key + " bo = new " + key + "();\n");
				buffer.append("    return bo;\n");
				buffer.append("  }\n\n");
			}
		}

		buffer.append("}\n");

		String fileName = "build/de/dpma/register/marke/hbm/type/DefaultBusinessObjectFactory.java";
		File file = new File(fileName);

		try {
			FileServices.createPath(file.getParent());
			FileServices.writeFromString(file, buffer.toString());
		} catch (IOException oops) {
			oops.printStackTrace();
		}
	}

	private void createMessageConstants() {

		StringBuilder buffer = new StringBuilder();
		buffer.append("package de.dpma.register.marke.hbm;\n\n");
		buffer.append("import de.dpma.register.commons.CommonsMessageConstants;\n");
		buffer.append("public interface MessageConstants extends CommonsMessageConstants {\n\n");

		for (String key : elementMap.keySet()) {
			buffer.append("  public static final String BO_"
					+ key.toUpperCase() + " = \"" + key.toUpperCase() + "\";\n");
		}

		buffer.append("}\n");

		String fileName = "build/de/dpma/register/marke/hbm/MessageConstants.java";
		File file = new File(fileName);

		try {
			FileServices.createPath(file.getParent());
			FileServices.writeFromString(file, buffer.toString());
		} catch (IOException oops) {
			oops.printStackTrace();
		}
	}

	private String createSampleDataId(String id) {

		int index = 0;

		for (int i = 0; i < 2; i++) {

			index = id.indexOf('/', index);
			index++;
		}

		if (index != -1) {
			id = id.substring(index);
		}

		return id.replaceAll("/", ".");
	}

	private void createSortConstants() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("package de.dpma.register.marke.hbm;\n\n");
		buffer.append("public interface SortConstants {\n\n");

		for (String key : elementMap.keySet()) {
			buffer.append("  public static final String SORT_"
					+ key.toUpperCase() + " = \"99999|99999\";\n");
		}

		buffer.append("}\n");

		String fileName = "build/de/dpma/register/marke/hbm/SortConstants.java";
		File file = new File(fileName);

		try {
			FileServices.createPath(file.getParent());
			FileServices.writeFromString(file, buffer.toString());
		} catch (IOException oops) {
			oops.printStackTrace();
		}
	}

	private void createStammdatenProcessor(String rootTagName) {

		StringBuilder buffer = new StringBuilder();

		Element root = elementMap.get(rootTagName);
		NodeList childList = root.getChildNodes();
		ArrayList<Element> complexTypeList = new ArrayList<Element>();

		for (int i = 0; i < childList.getLength(); i++) {

			Node childNode = childList.item(i);

			if (childNode instanceof Element) {

				Element child = (Element) childNode;
				String tagName = child.getTagName();

				if (child.getChildNodes().getLength() == 0) {

					XsdMetaData xsdData = (XsdMetaData) child
							.getUserData("xsd");

					String type = xsdData.getType();

					buffer.append("        if (tradeMarkType.get" + tagName
							+ "() != null && tradeMarkType.get" + tagName
							+ "().getValue() != null) {\n\n");
					if (type.endsWith(":date")) {

						buffer.append("            date = tradeMarkType.get"
								+ tagName
								+ "().getValue().toGregorianCalendar().getTime();\n");
						buffer.append("            " + tagName + " "
								+ StringServices.lowerFirstLetter(tagName)
								+ " = bof.create" + tagName + "(date);\n");

					} else {

						buffer.append("            text = tradeMarkType.get"
								+ tagName + "().getValue().toString();\n");
						buffer.append("            " + tagName + " "
								+ StringServices.lowerFirstLetter(tagName)
								+ " = bof.create" + tagName + "(text);\n");
					}

					buffer.append("            stammdaten.set" + tagName + "("
							+ StringServices.lowerFirstLetter(tagName) + ");\n");
					buffer.append("        }\n\n");

				} else {

					complexTypeList.add(child);
				}
			}
		}

		for (Element complexType : complexTypeList) {

			String tagName = complexType.getTagName();
			buffer.append("      fill" + tagName
					+ "(tradeMarkType, stammdaten);\n");
		}

		for (Element complexType : complexTypeList) {

			XsdMetaData xsdData = (XsdMetaData) complexType.getUserData("xsd");
			String maxOccurs = xsdData.getMaxOccurs();

			String tagName = complexType.getTagName();
			String varName = StringServices.lowerFirstLetter(complexType
					.getTagName());

			buffer.append("\n    private void  fill"
					+ tagName
					+ "(TradeMarkType tradeMarkType, Stammdaten stammdaten) {\n\n");
			buffer.append("      if (tradeMarkType.get" + tagName
					+ "() != null) {\n\n");

			if (maxOccurs != null && maxOccurs.equals("unbounded")) {

				buffer.append("        List<" + tagName
						+ "Type> list = tradeMarkType.get" + tagName + "();\n");
				buffer.append("        for (" + tagName + "Type " + varName
						+ "Type : list) {\n\n");
				buffer.append("          " + tagName + " " + varName
						+ " = bof.create" + tagName + "();\n");
				buffer.append("          stammdaten.add" + tagName + "("
						+ varName + ");\n");

			} else {

				buffer.append("          " + tagName + " " + varName
						+ " = bof.create" + tagName + "();\n");
				buffer.append("          stammdaten.set" + tagName + "("
						+ varName + ");\n");
				buffer.append("          " + tagName + "Type " + varName
						+ "Type = tradeMarkType.get" + tagName + "();\n");
			}

			childList = complexType.getChildNodes();

			for (int i = 0; i < childList.getLength(); i++) {

				Node childNode = childList.item(i);

				if (childNode instanceof Element) {

					createProcessorChild(buffer, complexType,
							(Element) childNode);
				}
			}

			if (maxOccurs != null && maxOccurs.equals("unbounded")) {
				buffer.append("        }\n");
			}

			buffer.append("      }\n");
			buffer.append("    }\n");
		}

		String fileName = "build/de/dpma/register/marke/hbm/xml/StammdatenProcessorFill.java";
		File file = new File(fileName);

		try {
			FileServices.createPath(file.getParent());
			FileServices.writeFromString(file, buffer.toString());
		} catch (IOException oops) {
			oops.printStackTrace();
		}
	}

	private void createProcessorChild(StringBuilder buffer, Element parent,
			Element child) {

		String varName = StringServices.lowerFirstLetter(parent.getTagName());

		String childTagName = child.getTagName();
		String childVarName = StringServices.lowerFirstLetter(child
				.getTagName());

		XsdMetaData childXsdData = (XsdMetaData) child.getUserData("xsd");
		String childMaxOccurs = childXsdData.getMaxOccurs();
		String childType = childXsdData.getType();

		if (childType != null && childType.equals("xs:string")) {
			childType = "TextType";
		}

		if (childMaxOccurs != null && childMaxOccurs.equals("unbounded")) {

			buffer.append("          if (" + varName + "Type.get"
					+ childTagName + "() != null)  {\n\n");

			buffer.append("            for (" + childType + " "
					+ StringServices.lowerFirstLetter(childType) + ": "
					+ varName + "Type.get" + childTagName + "()) {\n\n");
			buffer.append("              " + childTagName + " " + childVarName
					+ " = bof.create" + childTagName + "();\n");

			if (child.getChildNodes().getLength() > 0) {

				buffer.append("              " + varName + ".set" + childTagName
						+ "(" + childVarName + ");\n\n");
				
				for (int i = 0; i < child.getChildNodes().getLength(); i++) {
					createProcessorChild(buffer, child, (Element) child
							.getChildNodes().item(i));
				}

			} else {

				buffer.append("          " + varName + ".add" + childTagName
						+ "(" + childVarName + ");\n");
			}

			buffer.append("          }\n}\n");

		} else {

			NodeList gcList = child.getChildNodes();
			int gcCount = gcList.getLength();

			buffer.append("          if (" + varName + "Type.get"
					+ childTagName + "() != null) {\n\n");

			if (gcCount == 0) {

				buffer.append("            " + childTagName + " "
						+ childVarName + " = bof.create" + childTagName + "("
						+ varName + "Type.get" + childTagName + "());\n");

				buffer.append("        " + varName + ".set" + childTagName
						+ "(" + childVarName + ");\n");

			} else {

				buffer.append("            " + childTagName + " "
						+ childVarName + " = bof.create" + childTagName
						+ "();\n");
				buffer.append("        " + varName + ".set" + childTagName
						+ "(" + childVarName + ");\n");
				buffer.append("        " + childTagName + "Type " + childVarName + "Type = " + varName + "Type.get" + childTagName + "();\n\n");

				for (int i = 0; i < child.getChildNodes().getLength(); i++) {
					createProcessorChild(buffer, child, (Element) child
							.getChildNodes().item(i));
				}
			}

			buffer.append("          }\n\n");
		}
	}

	private String getAttributeValue(Element element, Node attr) {

		File dataPath = getResourceDirectory();

		String fileName;
		File dataFile = null;

		if (element != null) {

			fileName = FileServices.appendFileName(dataPath,
					element.getTagName() + ".@" + attr.getNodeName());
			dataFile = new File(fileName);

			if (dataFile.exists() == false) {
				fileName = FileServices.appendFileName(dataPath,
						"@" + attr.getNodeName());
				dataFile = new File(fileName);
			}

			if (dataFile.exists() == false) {
				dataFile = null;
			}
		}

		if (dataFile != null && dataFile.exists()) {

			try {
				return FileServices.readLine(dataFile, 0);
			} catch (IOException oops) {
				oops.printStackTrace();
			}
		}

		String value = attr.getNodeValue();

		if (value != null && value.length() > 0) {
			return value;
		}

		return "0";
	}

	private String getBoType(Element element) {

		String type = "String";

		XsdMetaData xsdData = (XsdMetaData) element.getUserData("xsd");

		if (xsdData != null) {

			String dataType = xsdData.getType();

			if (dataType != null
					&& dataType.equals(xmlSchema.getXmlSchemaNamespace()
							+ ":date")) {
				type = "Date";
			}
		}

		return type;
	}

	private String getEnumText(Element element, ArrayList<String> enumList) {

		String value = getRandomDataFileValue(element);

		if (value != null) {
			return value;
		}

		String id = XmlServices.getFullyQualifiedElementName(element);
		id = createSampleDataId(id);

		SampleData sd = sdMap.get(id);

		if (sd == null) {
			sd = new SampleData();
			sd.setValues(enumList);
			sdMap.put(id, sd);
		}

		return sd.getValue();
	}

	private String getRandomDataFileValue(Element element) {

		File dataPath = getResourceDirectory();

		String fileName;
		File dataFile = null;

		Element e = element;
		ArrayList<Element> stack = new ArrayList<Element>();

		while (e.getParentNode() != null
				&& e.getParentNode() instanceof Element) {

			stack.add(e);
			e = (Element) e.getParentNode();
		}

		Collections.reverse(stack);
		int size = stack.size();

		for (int i = 0; i < size; i++) {

			fileName = dataPath + "/";

			if (fileName.endsWith("/") == false) {
				fileName += "/";
			}

			for (Element se : stack) {
				fileName += se.getTagName() + ".";
			}

			fileName = fileName.substring(0, fileName.length() - 1);
			dataFile = new File(fileName);

			if (dataFile.exists()) {
				break;
			}

			stack.remove(0);
		}

		String id = XmlServices.getFullyQualifiedElementName(element);
		id = createSampleDataId(id);

		SampleData sd = sdMap.get(id);

		if (dataFile != null && dataFile.exists()) {

			try {

				if (sd == null) {
					sd = new SampleData(dataFile);
					sdMap.put(id, sd);
				}

				if (sd.isFollowsEnabled()) {

					String follows = sd.getOption("follows");
					SampleData fsd = sdMap.get(follows);

					if (fsd != null) {

						String value = sd.getValue(fsd.getLastIndex());

						if (value == null) {

							logger.warn("Can't find value for index "
									+ fsd.getLastIndex() + " used by follows "
									+ follows + ".");

							return fsd.getLastValue();
						}

						return value;

					} else {

						logger.warn("Can't find sample data for follows "
								+ follows + ".");
					}

				}

				return sd.getValue();

			} catch (Throwable oops) {

				System.err.println("Can't parse " + dataFile.getAbsolutePath());
				oops.printStackTrace();
			}
		}

		return null;
	}

	private String getRandomNumberAsText() {
		int num = rand.nextInt(45);
		return String.valueOf(num);
	}

	private String getRandomText() {
		StringBuilder builder = new StringBuilder();
		builder.append(TEXTE[rand.nextInt(TEXTE.length)]);
		return builder.toString();
	}

	private File getResourceDirectory() {

		if (resourceDirectory == null) {
			String dataPath = FileServices.appendPath(
					System.getProperty("user.home"), ".xmlgen");
			dataPath = FileServices.appendPath(dataPath, "data");
			return new File(dataPath);
		} else {
			return resourceDirectory;
		}
	}

	private String getText(Element element, String defaultText) {

		String value = getRandomDataFileValue(element);

		if (value != null) {
			return value;
		}

		return defaultText;
	}

	private void postProcess(String rootTagName) {

		createMessageConstants();
		createSortConstants();
		createBusinessObjectFactory();
		createDefaultBusinessObjectFactory();
		createStammdatenProcessor(rootTagName);
		createDbImportProcessor(rootTagName);
	}

	private void println(String format, Object... args) {

		if (verbose == true) {
			System.out.format(format + "\n", args);
		}
	}

	private void setResourceDirectory(File resourceDirectory) {
		this.resourceDirectory = resourceDirectory;
	}

	private String toFieldName(String name) {

		StringBuilder builder = new StringBuilder(name);
		char firstChar = builder.charAt(0);
		builder.setCharAt(0, Character.toLowerCase(firstChar));
		return builder.toString();
	}

}
