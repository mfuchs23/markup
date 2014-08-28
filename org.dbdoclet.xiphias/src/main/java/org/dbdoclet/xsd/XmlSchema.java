package org.dbdoclet.xsd;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import javax.xml.parsers.ParserConfigurationException;

import org.dbdoclet.service.FileServices;
import org.dbdoclet.service.ResourceServices;
import org.dbdoclet.xiphias.XPathServices;
import org.dbdoclet.xiphias.XmlServices;
import org.dbdoclet.xiphias.dom.DocumentImpl;
import org.dbdoclet.xiphias.dom.ElementImpl;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XmlSchema {

	private static final String XSD = "xsd";

	public static final String XML_SCHEMA_URI = "http://www.w3.org/2001/XMLSchema";
	private Element[] rootElements;
	private ArrayList<Document> xsdDocumentList;
	private HashMap<Element, Document> masterDocumentMap;
	private HashMap<String, ComplexType> complexTypeMap;
	private HashMap<String, SimpleType> simpleTypeMap;
	private HashMap<String, Group> groupMap;
	private HashMap<String, AttributeGroup> attributeGroupMap;
	private HashMap<String, String> namespaceMap;
	private HashMap<String, Element> elementMap;
	private InputSource xsdSource;

	/**
	 * Speichert den Pfad der traversierten Elemente des Typs complexType.
	 * Dadurch können Rekursionen erkannt und unterbrochen werden. Zur
	 * Identifikation der werden die Hashwerte der traversierte Objekte
	 * gespeichert.
	 */
	private Stack<Integer> complexTypeStack;

	public XmlSchema(File xsdFile) throws IOException, SAXException,
			ParserConfigurationException {

		InputSource xsdSource = new InputSource(new FileInputStream(xsdFile));
		xsdSource.setSystemId(xsdFile.getCanonicalPath());
		construct(xsdSource);
	}

	public XmlSchema(InputSource xsdSource) throws IOException, SAXException,
			ParserConfigurationException {
		construct(xsdSource);
	}

	private void construct(InputSource xsdSource) throws IOException, SAXException,
			ParserConfigurationException {

		this.xsdSource = xsdSource;
		Document xsdDocument = XmlServices.parse(xsdSource, false, null);

		namespaceMap = new HashMap<String, String>();

		Element documentElement = xsdDocument.getDocumentElement();
		NamedNodeMap attributeMap = documentElement.getAttributes();

		for (int i = 0; i < attributeMap.getLength(); i++) {

			Node attr = attributeMap.item(i);
			String name = attr.getNodeName();

			if (name.startsWith("xmlns:")) {
				namespaceMap.put(attr.getNodeValue(),
						name.substring("xmlns:".length()));
			}
		}

		xsdDocumentList = new ArrayList<Document>();
		masterDocumentMap = new HashMap<Element, Document>();
		elementMap = new HashMap<String, Element>();
		complexTypeMap = new HashMap<String, ComplexType>();
		complexTypeStack = new Stack<Integer>();
		simpleTypeMap = new HashMap<String, SimpleType>();
		groupMap = new HashMap<String, Group>();
		attributeGroupMap = new HashMap<String, AttributeGroup>();

		initialize(xsdDocument);
	}

	private static String getLocalName(Element element) {

		if (element == null) {
			return null;

		}

		String name = element.getNodeName();
		return getLocalName(name);
	}

	private static String getLocalName(String name) {

		if (name == null) {
			return null;

		}

		if (name.indexOf(':') != -1) {
			return name.substring(name.indexOf(':') + 1);
		}

		return name;
	}

	public ContentModel getContentModelForElement(String elementName) {

		Element element = elementMap.get(elementName);

		if (element != null) {

			XsdMetaData xsdData = (XsdMetaData) element.getUserData(XSD);

			if (xsdData != null) {
				return xsdData.getContentModel();
			}
		}

		return ContentModel.PCDATA;
	}

	public Document getMasterDocument(Element rootElement) {
		return masterDocumentMap.get(rootElement);
	}

	public Element getElementByName(String tagName) {
		return elementMap.get(tagName);
	}
	
	public Element[] getRootElements() {
		return rootElements;
	}

	public String getXmlSchemaNamespace() {
		return namespaceMap.get(XML_SCHEMA_URI);
	}

	public void traverse(Document doc, Element element, Node xsdNode) {

		if (xsdNode != null) {

			NodeList xsdChildList = xsdNode.getChildNodes();

			for (int i = 0; i < xsdChildList.getLength(); i++) {

				Node xsdChild = xsdChildList.item(i);

				if (xsdChild instanceof Element) {

					Element xsdElement = (Element) xsdChild;

					String tagName = getLocalName(xsdElement);

					if (tagName.equals("element")) {

						processElement(doc, element, xsdElement);
						continue;

					} else if (tagName.equals("complexType")) {

						XsdMetaData xsdData = new XsdMetaData();
						element.setUserData(XSD, xsdData, null);

						parseComplexType(doc, element, xsdElement, xsdData);

					} else if (tagName.equals("extension")) {

						String base = xsdElement.getAttribute("base");
						XsdMetaData xsdData = new XsdMetaData();
						element.setUserData(XSD, xsdData, null);

						processBase(doc, element, xsdElement, xsdData, base);

						traverse(doc, element, xsdElement);

					} else if (tagName.equals("group")) {

						String ref = xsdElement.getAttribute("ref");

						if (ref != null) {

							String prefix = getTargetNamespacePrefix(xsdElement);

							if (prefix != null) {
								ref = prefix + ":" + ref;
							}

							Group group = groupMap.get(ref);

							if (group != null) {
								traverse(doc, element, group.getElement());
							}
						}

					} else {

						traverse(doc, element, xsdChild);
					}
				}
			}
		}
	}

	private String getTargetNamespacePrefix(Element xsdElement) {
		Document ownerDocument = xsdElement.getOwnerDocument();
		Element documentElement = ownerDocument.getDocumentElement();
		String targetNamespace = documentElement
				.getAttribute("targetNamespace");
		return namespaceMap.get(targetNamespace);
	}

	private String getXmlSchemaNamespacePrefix() {
		return namespaceMap.get(XML_SCHEMA_URI);
	}

	private boolean hasNamespace(String name) {

		if (name.indexOf(':') == -1) {
			return false;
		}

		return true;
	}

	private void initialize(Document xsdDocument) throws IOException,
			SAXException, ParserConfigurationException {

		xsdDocumentList.add(xsdDocument);

		ArrayList<Node> nodeList;
		initialzeImports(xsdDocument);

		nodeList = XPathServices.getNodes(xsdDocument, "xs", XML_SCHEMA_URI,
				"/xs:schema/xs:element");
		Element schemaNode = (Element) XPathServices.getNode(xsdDocument, "xs",
				XML_SCHEMA_URI, "/xs:schema");

		String targetNamespace = schemaNode.getAttribute("targetNamespace");

		initializeComplexTypes();
		initializeSimpleTypes();
		initializeGroups();
		initializeAttributeGroups();

		rootElements = new Element[nodeList.size()];

		int index = 0;

		for (Node node : nodeList) {

			if (node instanceof Element) {

				DocumentImpl doc = new DocumentImpl();

				Element xsdElement = (Element) node;

				String name = xsdElement.getAttribute("name");
				ElementImpl rootElem = doc.createElement(name);
				elementMap.put(name, rootElem);

				if (targetNamespace != null) {
					rootElem.setAttribute("xmlns", targetNamespace);
				}

				rootElements[index++] = rootElem;

				masterDocumentMap.put(rootElem, doc);
				doc.setDocumentElement(rootElem);

				String type = xsdElement.getAttribute("type");
				XsdMetaData xsdData = new XsdMetaData();
				xsdData.setType(type);
				rootElem.setUserData(XSD, xsdData, null);

				SimpleType simpleType = simpleTypeMap.get(type);

				if (simpleType != null) {

					xsdData.setContentModel(ContentModel.PCDATA);
					parseSimpleType(doc, rootElem, simpleType.getElement(),
							xsdData);
				}

				ComplexType complexType = complexTypeMap.get(type);

				if (complexType != null) {

					if (isSimpleContent(complexType.getElement())) {

						xsdData.setContentModel(ContentModel.PCDATA);
						parseSimpleType(doc, rootElem,
								complexType.getElement(), xsdData);
					} else {

						if (complexType.isMixed()) {
							xsdData.setContentModel(ContentModel.MIXED);
						} else {
							xsdData.setContentModel(ContentModel.BLOCK);
						}

						traverse(doc, rootElem, complexType.getElement());
					}
				}

				traverse(doc, rootElem, xsdElement);
			}
		}
	}

	private void initializeAttributeGroups() {

		for (Document doc : xsdDocumentList) {

			ArrayList<Node> attributeGroupList = XPathServices.getNodes(doc,
					"xs", XML_SCHEMA_URI, "/xs:schema/xs:attributeGroup");

			for (Node node : attributeGroupList) {

				if (node instanceof Element) {

					Element element = (Element) node;

					String name = element.getAttribute("name");

					if (name != null) {

						String ns = getTargetNamespacePrefix(element);

						if (ns != null) {
							name = ns + ":" + name;
						}

						attributeGroupMap
								.put(name, new AttributeGroup(element));
					}
				}
			}
		}
	}

	private void initializeComplexTypes() {

		for (Document doc : xsdDocumentList) {

			String namespace = null;
			XsdMetaData xsdData = (XsdMetaData) doc.getUserData(XSD);

			if (xsdData != null) {

				namespace = xsdData.getImportNamespace();

				if (namespace != null) {
					namespace = namespaceMap.get(namespace);
				}
			}

			ArrayList<Node> complexTypeList = XPathServices.getNodes(doc, "xs",
					XML_SCHEMA_URI, "/xs:schema/xs:complexType");

			for (Node node : complexTypeList) {

				if (node instanceof Element) {

					Element element = (Element) node;
					String name = element.getAttribute("name");

					if (namespace != null) {
						name = namespace + ":" + name;
					}

					if (name != null) {
						complexTypeMap.put(name, new ComplexType(element));
					}
				}
			}
		}
	}

	private void initializeGroups() {

		for (Document doc : xsdDocumentList) {

			ArrayList<Node> complexTypeList = XPathServices.getNodes(doc, "xs",
					XML_SCHEMA_URI, "/xs:schema/xs:group");

			for (Node node : complexTypeList) {
				if (node instanceof Element) {

					Element element = (Element) node;

					String name = element.getAttribute("name");

					if (name != null) {

						String ns = getTargetNamespacePrefix(element);

						if (ns != null) {
							name = ns + ":" + name;
						}

						groupMap.put(name, new Group(element));
					}
				}
			}
		}
	}

	private void initializeSimpleTypes() {

		for (Document doc : xsdDocumentList) {

			String namespace = null;
			XsdMetaData xsdData = (XsdMetaData) doc.getUserData(XSD);

			if (xsdData != null) {
				namespace = xsdData.getImportNamespace();
				if (namespace != null) {
					namespace = namespaceMap.get(namespace);
				}
			}

			ArrayList<Node> simpleTypeList = XPathServices.getNodes(doc, "xs",
					XML_SCHEMA_URI, "/xs:schema/xs:simpleType");

			for (Node node : simpleTypeList) {

				if (node instanceof Element) {

					Element element = (Element) node;

					String name = element.getAttribute("name");

					if (namespace != null) {
						name = namespace + ":" + name;
					}

					if (name != null) {
						simpleTypeMap.put(name, new SimpleType(element));
					}
				}
			}
		}
	}

	private void initialzeImports(Document xsdDocument) throws IOException,
			SAXException, ParserConfigurationException {

		ArrayList<Node> nodeList = XPathServices.getNodes(xsdDocument, "xs",
				XML_SCHEMA_URI, "/xs:schema/xs:import | /xs:schema/xs:include");

		for (Node node : nodeList) {

			if (node instanceof Element) {

				Element elem = (Element) node;

				String namespace = elem.getAttribute("namespace");
				String schemaLocation = elem.getAttribute("schemaLocation");
				String path = FileServices.appendFileName(
						FileServices.getDirName(xsdSource.getSystemId()),
						schemaLocation);
				File includeFile = new File(path);

				Document doc = null;

				if (includeFile.exists()) {

					doc = XmlServices.parse(includeFile);

				} else {

					InputStream instream = ResourceServices
							.getResourceAsStream(path);

					if (instream != null) {
						InputSource source = new InputSource(instream);
						source.setSystemId(path);
						doc = XmlServices.parse(source, false, null);
					}
				}

				if (doc != null) {
					
					XsdMetaData xsdData = new XsdMetaData();
					xsdData.setImportNamespace(namespace);
					doc.setUserData(XSD, xsdData, null);
					xsdDocumentList.add(doc);
				
				} else {
					throw new IOException(String.format("Included resource %s does not exist", schemaLocation));
				}
			}
		}
	}

	private boolean isComplexType(Element xsdElement) {

		Element complexType = (Element) XPathServices.getNode(xsdElement, "xs",
				XML_SCHEMA_URI, "/xs:complexType");

		if (complexType == null) {
			return false;
		} else {
			return true;
		}
	}

	private boolean isSimpleContent(Element xsdElement) {

		Element simpleContent = (Element) XPathServices.getNode(xsdElement,
				"xs", XML_SCHEMA_URI, "/xs:simpleContent");

		if (simpleContent == null) {
			return false;
		} else {
			return true;
		}
	}

	private boolean isSimpleType(Element xsdElement) {

		Element simpleType = (Element) XPathServices.getNode(xsdElement, "xs",
				XML_SCHEMA_URI, "/xs:simpleType");

		if (simpleType == null) {
			return false;
		} else {
			return true;
		}
	}

	private void parseAttributes(Document doc, Element element,
			Element xsdElement, XsdMetaData xsdData) {

		Element attributeGroup = (Element) XPathServices.getNode(xsdElement,
				"xs", XML_SCHEMA_URI, "xs:attributeGroup");

		if (attributeGroup != null) {

			String ref = attributeGroup.getAttribute("ref");

			if (ref != null) {

				AttributeGroup agroup = attributeGroupMap.get(ref);

				if (agroup != null) {

					ArrayList<Node> attrList = XPathServices.getNodes(
							agroup.getElement(), "xs", XML_SCHEMA_URI,
							"xs:attribute");

					for (Node attrNode : attrList) {

						Element attr = (Element) attrNode;
						element.setAttribute(attr.getAttribute("name"), "");
					}
				}
			}
		}

		ArrayList<Node> attrList = XPathServices.getNodes(xsdElement, "xs",
				XML_SCHEMA_URI, "xs:attribute");

		for (Node attrNode : attrList) {

			Element attr = (Element) attrNode;

			String value = "";

			if (attr.getAttribute("fixed") != null) {
				value = attr.getAttribute("fixed");
			}

			element.setAttribute(attr.getAttribute("name"), value);
		}
	}

	/**
	 * Verarbeitung eines Elements vom Type <code>complexType</code>.
	 * 
	 * @param doc
	 * @param element
	 * @param xsdElement
	 * @param xsdData
	 */
	private boolean parseComplexType(Document doc, Element element,
			Element xsdElement, XsdMetaData xsdData) {

		// Unterbrechen von rekursiven Strukturen um eine Endlosschleife zu
		// verhindern.
		if (complexTypeStack.contains(xsdElement.hashCode())) {
			return false;
		}

		complexTypeStack.push(xsdElement.hashCode());

		String tagName = xsdElement.getTagName();

		if (tagName.equals("element") || tagName.endsWith(":element")) {
			xsdElement = (Element) XPathServices.getNode(xsdElement, "xs",
					XmlSchema.XML_SCHEMA_URI, "./xs:complexType");
		}

		if (ComplexType.isMixed(xsdElement)) {
			xsdData.setContentModel(ContentModel.MIXED);
		} else {
			xsdData.setContentModel(ContentModel.BLOCK);
		}

		parseExtension(doc, element, xsdElement, xsdData);
		parseRestriction(doc, element, xsdElement, xsdData);

		ArrayList<Node> nodeList = XPathServices.getNodes(xsdElement, "xs",
				XML_SCHEMA_URI,
				".//xs:sequence/xs:element|.//xs:choice/xs:element");

		for (Node childNode : nodeList) {

			Element child = (Element) childNode;
			processElement(doc, element, child);
		}

		complexTypeStack.pop();
		return true;
	}

	private void parseExtension(Document doc, Element element,
			Element xsdElement, XsdMetaData xsdData) {

		Element extension = (Element) XPathServices.getNode(xsdElement, "xs",
				XML_SCHEMA_URI,
				"/*/*/xs:extension | /*/xs:extension | xs:extension");

		if (extension != null) {

			String type = extension.getAttribute("base");
			processBase(doc, element, xsdElement, xsdData, type);
			parseAttributes(doc, element, extension, xsdData);
		}
	}

	private void parseRestriction(Document doc, Element element,
			Element xsdElement, XsdMetaData xsdData) {
		Element restriction = (Element) XPathServices.getNode(xsdElement, "xs",
				XML_SCHEMA_URI,
				"/*/*/xs:restriction | /*/xs:restriction | xs:restriction");

		if (restriction != null) {

			String type = restriction.getAttribute("base");
			processBase(doc, element, xsdElement, xsdData, type);

			ArrayList<Node> nodeList = XPathServices.getNodes(restriction,
					"xs", XML_SCHEMA_URI, "/xs:enumeration");

			for (Node node : nodeList) {
				xsdData.addEnumeration(((Element) node).getAttribute("value"));
			}

			Element maxLength = (Element) XPathServices.getNode(restriction,
					"xs", XML_SCHEMA_URI, "/xs:maxLength");

			if (maxLength != null) {
				xsdData.setMaxLength(new Integer((maxLength
						.getAttribute("value"))));
			}
		}
	}

	private void parseSimpleType(Document doc, Element element,
			Element xsdElement, XsdMetaData xsdData) {

		xsdData.setContentModel(ContentModel.PCDATA);

		Element union = (Element) XPathServices.getNode(xsdElement, "xs",
				XML_SCHEMA_URI, "/*/*/xs:union | /*/xs:union | xs:union");

		if (union != null) {

			String memberTypes = union.getAttribute("memberTypes");
			SimpleType memberType = simpleTypeMap.get(memberTypes);

			if (memberType != null) {
				parseSimpleType(doc, element, memberType.getElement(), xsdData);
			}
		}

		parseRestriction(doc, element, xsdElement, xsdData);
		parseExtension(doc, element, xsdElement, xsdData);
	}

	private void processBase(Document doc, Element element, Element xsdElement,
			XsdMetaData xsdData, String base) {

		if (base != null) {

			String prefix = getXmlSchemaNamespacePrefix();

			if (base != null && base.startsWith(prefix + ":") == false) {

				SimpleType simpleType = simpleTypeMap.get(base);

				if (simpleType != null) {
					parseSimpleType(doc, element, simpleType.getElement(),
							xsdData);
				}

				ComplexType complexType = complexTypeMap.get(base);

				if (complexType != null) {

					if (isSimpleContent(complexType.getElement())) {

						parseSimpleType(doc, element, complexType.getElement(),
								xsdData);

					} else {

						traverse(doc, element, complexType.getElement());
					}
				}

			} else if (base != null && base.startsWith(prefix + ":") == true) {

				xsdData.setType(base);
			}
		}
	}

	private void processElement(Document doc, Element elem, Element xsdElement) {

		String name = xsdElement.getAttribute("name");
		boolean isRef = false;
		
		if (name == null || name.length() == 0) {
			name = xsdElement.getAttribute("ref");
			isRef = true;
		} 
		
		int idx = name.indexOf(':');
		if (idx != -1) {
			name = name.substring(idx + 1);
		}
				
		Element child = doc.createElement(name);
		elem.appendChild(child);
		
		if (isRef == false) {
			elementMap.put(name, child);
		}
		
		String type = xsdElement.getAttribute("type");

		XsdMetaData xsdData = new XsdMetaData();
		xsdData.setType(type);

		String attrValue = xsdElement.getAttribute("minOccurs");
		if (attrValue != null && attrValue.trim().length() > 0) {
			xsdData.setMinOccurs(attrValue);
		}

		attrValue = xsdElement.getAttribute("maxOccurs");
		if (attrValue != null && attrValue.trim().length() > 0) {
			xsdData.setMaxOccurs(attrValue);
		}

		child.setUserData(XSD, xsdData, null);

		if (type == null || type.length() == 0) {

			if (isSimpleType(xsdElement)) {
				parseSimpleType(doc, child, xsdElement, xsdData);
			}

			if (isComplexType(xsdElement)) {
				if (parseComplexType(doc, child, xsdElement, xsdData) == false) {
					elem.removeChild(child);
				}
			}

			return;
		}

		String prefix = getTargetNamespacePrefix(xsdElement);

		if (hasNamespace(type) == false && prefix != null) {
			type = prefix + ":" + type;
		}

		SimpleType simpleType = simpleTypeMap.get(type);

		if (simpleType != null) {
			parseSimpleType(doc, child, simpleType.getElement(), xsdData);
			return;
		}

		ComplexType complexType = complexTypeMap.get(type);

		if (complexType != null) {

			if (isSimpleContent(complexType.getElement())) {
				parseSimpleType(doc, child, complexType.getElement(), xsdData);
			} else {
				traverse(doc, child, complexType.getElement());
			}

			return;
		}

		traverse(doc, child, xsdElement);
	}

	protected boolean isComplexContent(Element xsdElement) {

		Element complexContent = (Element) XPathServices.getNode(xsdElement,
				"xs", XML_SCHEMA_URI, "/xs:complexContent");

		if (complexContent == null) {
			return false;
		} else {
			return true;
		}
	}

	public boolean isValidParent(String tagChild, String tagParent) {

		if (tagChild == null || tagParent == null) {
			return false;
		}
		
		Element parentElement = getElementByName(tagParent);
		
		if (parentElement == null) {
			return false;
		}
		
		NodeList childList = parentElement.getChildNodes();
		
		for (int i = 0; i < childList.getLength(); i++) {
			Node child = childList.item(i);
			if (child != null && child.getNodeName() != null && child.getNodeName().equals(tagChild)) {
				return true;
			}	
		}
		
		return false;
	}

}
