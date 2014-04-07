/* 
 * ### Copyright (C) 2003-2009 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.xiphias.dom;

import java.util.HashMap;

import org.dbdoclet.Sfv;
import org.dbdoclet.xiphias.W3cServices;
import org.dbdoclet.xiphias.XmlConstants;
import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.EntityReference;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;

public class DocumentImpl extends NodeImpl implements Document {

	private DocumentType docType;
	private ElementImpl documentElement;
	private HashMap<String, String> namespacePrefixMap = new HashMap<>();
	private String xmlEncoding = "UTF-8";
	private String xmlVersion = "1.0";
	
	public DocumentImpl() {

		super("#document", null);
		setNodeType(DOCUMENT_NODE);

		setXmlEncoding("UTF-8");
		setXmlVersion("1.0");
		
		namespacePrefixMap.put(XmlConstants.NAMESPACE_XML, "xml");
	}

	@Override
	public Node adoptNode(Node source) throws DOMException {
		throw new IllegalStateException("Not yet implemented");
	}

	@Override
	public Attr createAttribute(String name) throws DOMException {
		
		AttrImpl attr = new AttrImpl();
		attr.setNodeName(name);
		return attr;
		
	}

	@Override
	public Attr createAttributeNS(String namespaceUri, String qualifiedName)
			throws DOMException {

		String prefix = manageNamespace(namespaceUri, qualifiedName);
		
		AttrImpl attr = new AttrImpl();
		attr.setPrefix(prefix);
		attr.setNamespaceURI(namespaceUri);
		attr.setNodeName(qualifiedName);
		return attr;
	}

	@Override
	public CDATASection createCDATASection(String data) throws DOMException {
		throw new IllegalStateException("Not yet implemented");
	}

	@Override
	public Comment createComment(String data) {
		throw new IllegalStateException("Not yet implemented");
	}

	@Override
	public DocumentFragment createDocumentFragment() {
		throw new IllegalStateException("Not yet implemented");
	}

	@Override
	public ElementImpl createElement(String tagName) throws DOMException {

		ElementImpl elem = new ElementImpl(tagName);
		elem.setDocument(this);
		elem.setFormatType(FORMAT_BLOCK);
		return elem;
	}

	@Override
	public Element createElementNS(String namespaceUri, String qualifiedName)
			throws DOMException {

		String prefix = manageNamespace(namespaceUri, qualifiedName);
		
		ElementImpl elem = new ElementImpl();
		elem.setNamespaceURI(namespaceUri);
		elem.setPrefix(prefix);
		elem.setNodeName(qualifiedName);
		return elem;
	}

	@Override
	public EntityReference createEntityReference(String name)
			throws DOMException {
		throw new IllegalStateException("Not yet implemented");
	}

	@Override
	public ProcessingInstruction createProcessingInstruction(String target,
			String data) throws DOMException {
		throw new IllegalStateException("Not yet implemented");
	}

	@Override
	public Text createTextNode(String data) {

		TextImpl text = new TextImpl(data);
		return text;
	}

	public String createXmlDeclaration() {
		return "<?xml version=\"" + xmlVersion + "\" encoding=\"" + xmlEncoding
				+ "\"?>" + Sfv.LSEP;
	}

	@Override
	public DocumentType getDoctype() {
		return docType;
	}

	@Override
	public Element getDocumentElement() {

		if (documentElement == null) {
			return (Element) getFirstElement();
		}

		return documentElement;
	}

	@Override
	public String getDocumentURI() {
		throw new IllegalStateException("Not yet implemented");
	}

	@Override
	public DOMConfiguration getDomConfig() {
		throw new IllegalStateException("Not yet implemented");
	}

	@Override
	public Element getElementById(String elementId) {
		throw new IllegalStateException("Not yet implemented");
	}

	@Override
	public NodeList getElementsByTagName(String tagname) {
		throw new IllegalStateException("Not yet implemented");
	}

	@Override
	public NodeList getElementsByTagNameNS(String namespaceURI, String localName) {
		throw new IllegalStateException("Not yet implemented");
	}

	@Override
	public DOMImplementation getImplementation() {
		throw new IllegalStateException("Not yet implemented");
	}

	@Override
	public String getInputEncoding() {
		throw new IllegalStateException("Not yet implemented");
	}

	@Override
	public boolean getStrictErrorChecking() {
		throw new IllegalStateException("Not yet implemented");
	}

	@Override
	public String getXmlEncoding() {
		return xmlEncoding;
	}

	@Override
	public boolean getXmlStandalone() {
		throw new IllegalStateException("Not yet implemented");
	}

	@Override
	public String getXmlVersion() {
		return xmlVersion;
	}

	@Override
	public Node importNode(Node importedNode, boolean deep) throws DOMException {

		Node clone = W3cServices.copyNode(this, importedNode);

		if (deep == false) {
			NodeList childList = clone.getChildNodes();
			for (int i = 0; i < childList.getLength(); i++) {
				clone.removeChild(childList.item(i));
			}
		}

		return clone;
	}

	@Override
	public void normalizeDocument() {
		throw new IllegalStateException("Not yet implemented");

	}

	@Override
	public Node renameNode(Node n, String namespaceURI, String qualifiedName)
			throws DOMException {
		throw new IllegalStateException("Not yet implemented");
	}

	public void setDoctype(DocumentType docType) {
		this.docType = docType;
	}

	public void setDocumentElement(ElementImpl documentElement) {
		this.documentElement = documentElement;

	}

	@Override
	public void setDocumentURI(String documentURI) {
		throw new IllegalStateException("Not yet implemented");

	}

	@Override
	public void setStrictErrorChecking(boolean strictErrorChecking) {
		throw new IllegalStateException("Not yet implemented");

	}

	public void setXmlEncoding(String xmlEncoding) {
		this.xmlEncoding = xmlEncoding;
	}

	@Override
	public void setXmlStandalone(boolean xmlStandalone) throws DOMException {
		throw new IllegalStateException("Not yet implemented");

	}

	@Override
	public void setXmlVersion(String xmlVersion) throws DOMException {
		this.xmlVersion = xmlVersion;

	}

	private String manageNamespace(String namespaceUri, String qualifiedName) {
		
		String prefix = null;

		if (qualifiedName.contains(":")) {
			String[] tokens = qualifiedName.split(":");
			prefix = tokens[0];
		}

		if (namespaceUri == null && prefix != null) {
			throw new DOMException(DOMException.NAMESPACE_ERR, String.format(
					"No namespace for prefix %s defined", prefix));
		}

		if (namespaceUri != null && prefix != null) {
			
			String value = namespacePrefixMap.get(namespaceUri);
			
			if (value == null) {
				namespacePrefixMap.put(namespaceUri, prefix);
			}
		}
		
		return prefix;
	}
}
