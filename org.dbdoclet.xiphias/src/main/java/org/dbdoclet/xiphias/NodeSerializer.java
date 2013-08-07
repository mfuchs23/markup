package org.dbdoclet.xiphias;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dbdoclet.Sfv;
import org.dbdoclet.progress.ProgressEvent;
import org.dbdoclet.progress.ProgressListener;
import org.dbdoclet.xiphias.dom.DocumentImpl;
import org.dbdoclet.xiphias.dom.ElementImpl;
import org.dbdoclet.xiphias.dom.NodeImpl;
import org.dbdoclet.xiphias.dom.TextImpl;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.Entity;
import org.w3c.dom.EntityReference;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;

public class NodeSerializer {

	private static final String INDENT = "  ";

	private static Log logger = LogFactory.getLog(NodeSerializer.class);

	private HashMap<String, Integer> chunkElementSet;
	private HashMap<Node, Writer> chunkOutMap;
	private Stack<Integer> chunkElementStack;
	private ArrayList<ProgressListener> listeners;
	private int literalContext = 0;
	private String encoding = "UTF-8";
	private File systemId;

	private Element documentElement;

	public NodeSerializer() {
		chunkElementSet = new HashMap<String, Integer>();
		chunkOutMap = new HashMap<Node, Writer>();
		chunkElementStack = new Stack<Integer>();
	}

	private Writer addChunk(String indent, Node node, Writer out)
			throws IOException {

		if (systemId == null) {
			return out;
		}

		File baseDir = systemId.getParentFile();

		String tagName = node.getNodeName();
		
		int maxDepth = chunkElementSet.get(tagName);
		int depth = getDepth(node);

		/* Die Schachtelungstiefe ist tiefer als der eingestellte Wert für die maximale Tiefe. 
		 * Es wird kein Chunk erstellt.
		 */
		if (depth > maxDepth) {
			return out;
		}
		
		int pos = getChunkIndex(node);
		chunkElementStack.push(new Integer(pos));
		
		String fileName = "";
		
		for (Integer i : chunkElementStack) {
			
			if (fileName.equals("")) {
				fileName = String.valueOf(i);
			} else {
				fileName = String.format("%s.%d", fileName, i);
			}
		}
		
		fileName = String.format("%s-%s.xml", tagName, fileName);

		File incFile = new File(baseDir, fileName);
		logger.debug(String.format("Creating chunk file %s", fileName));

		out.write(indent + "<xi:include href=\""
				+ XmlServices.textToXml(fileName) + "\"/>\n");

		out = new OutputStreamWriter(new FileOutputStream(incFile), encoding);
		writeXmlDeclaration(out);

		if (node instanceof Element) {

			Element element = (Element) node;

			if (documentElement != null) {
				W3cServices.copyNamespaces(documentElement, element);
			}
			
			String version = documentElement.getAttribute("version");			
			if (version != null) {
				element.setAttribute("version", version);
			}
			
			if (W3cServices.hasNamespace(element, XmlConstants.NAMESPACE_XINCLUDE) == false) {
				W3cServices.setAttribute(node, "xmlns:xi", XmlConstants.NAMESPACE_XINCLUDE);
			}
		}

		chunkOutMap.put(node, out);
		return out;
	}

	private int getChunkIndex(Node node) {
	
		Node parentNode = node.getParentNode();
		
		if (parentNode == null) {
			return 0;
		}
		
		NodeList childList = parentNode.getChildNodes();
		int pos = 0;

		for (int i = 0; i < childList.getLength(); i++) {
			
			Node child = childList.item(i);
			if (chunkElementSet.get(child.getNodeName()) != null) {
				pos++;
			}
			
			if (child == node) {
				break;
			}
		}
		
		return pos;
	}

	private int getDepth(Node node) {

		int depth = 0;
		String tagName = node.getNodeName();

		if (tagName == null) {
			return depth;
		}

		Node parentNode = node;

		while (parentNode != null) {

			if (tagName.equals(parentNode.getNodeName())) {
				depth++;
			}

			parentNode = parentNode.getParentNode();
		}

		return depth;
	}

	public void addChunkElement(String nodeName) {
		addChunkElement(nodeName, 1);
	}

	public void addChunkElement(String nodeName, int depth) {
		chunkElementSet.put(nodeName, depth);
	}

	public void addProgressListener(ProgressListener listener) {

		if (listener == null) {
			return;
		}

		if (listeners == null) {
			listeners = new ArrayList<ProgressListener>();
		}

		listeners.add(listener);
	}

	public void addProgressListeners(ArrayList<ProgressListener> newListeners) {

		if (newListeners == null) {
			return;
		}

		if (listeners == null) {
			listeners = new ArrayList<ProgressListener>();
		}

		listeners.addAll(newListeners);
	}

	private void fireProgressEvent(ProgressEvent event) {

		if (listeners != null) {
			for (ProgressListener listener : listeners) {
				listener.progress(event);
			}
		}
	}

	private boolean isInsideLiteralElement() {
		if (literalContext > 0) {
			return true;
		}
		return false;
	}

	protected boolean isInsideLiteralElement(Text text) {

		Node parent = text.getParentNode();

		while (parent != null) {

			if (parent instanceof ElementImpl) {
				ElementImpl elem = (ElementImpl) parent;
				if (elem.isLiteral()) {
					return true;
				}
			}
		}

		return false;
	}

	private String resolveEntityReference(String entityName) {

		if (entityName == null) {
			return null;
		}

		if (entityName.equals("linefeed")) {
			return "#x0A";
		}

		return entityName;
	}

	public void setProgressListeners(ArrayList<ProgressListener> listeners) {
		this.listeners = listeners;
	}

	public String toXML(Node node) {

		try {

			StringWriter buffer = new StringWriter();

			NodeSerializer serializer = new NodeSerializer();
			serializer.write(node, buffer);
			return buffer.toString();

		} catch (IOException oops) {

			return oops.getMessage();
		}
	}

	public void write(Node node, File file) throws IOException {

		if (node == null) {
			throw new IllegalArgumentException(
					"The argument node must not be null!");
		}

		if (file == null) {
			throw new IllegalArgumentException(
					"The argument file must not be null!");
		}

		FileOutputStream fos = null;
		OutputStreamWriter out = null;

		try {

			this.systemId = file;
			fos = new FileOutputStream(file);
			out = new OutputStreamWriter(fos, encoding);
			write(node, out, "");

		} finally {

			if (out != null) {
				out.close();
			}

			this.systemId = null;
			this.encoding = "UTF-8";
			this.documentElement = null;
		}
	}

	public void write(Node node, OutputStream out) throws IOException {
		write(node, new OutputStreamWriter(out));
	}

	public void write(Node node, Writer out) throws IOException {
		write(node, out, "");
	}

	public void write(Node node, Writer out, boolean inMixedContent,
			String indent) throws IOException {

		if (node == null) {
			throw new IllegalArgumentException(
					"The argument node must not be null!");
		}

		if (out == null) {
			throw new IllegalArgumentException(
					"The argument out must not be null!");
		}

		ProgressEvent event = new ProgressEvent(node.toString());
		fireProgressEvent(event);

		if (chunkElementSet.get(node.getNodeName()) != null) {
			out = addChunk(indent, node, out);
			indent = "";
		}

		// logger.debug("node=" + node);

		switch (node.getNodeType()) {

		case Node.DOCUMENT_FRAGMENT_NODE:
			writeFragmentNode(node, out);
			break;

		case Node.DOCUMENT_NODE:
			writeDocumentNode(node, out);
			break;

		case Node.DOCUMENT_TYPE_NODE:
			writeDocumentTypeNode((DocumentType) node, out);
			break;

		case Node.ENTITY_NODE:
			writeEntityNode(node, out);
			break;

		case Node.ENTITY_REFERENCE_NODE:
			writeEntityReferenceNode(node, out);
			break;

		case Node.ELEMENT_NODE:

			try {
				writeElementNode(node, out, inMixedContent, indent);
			} catch (StackOverflowError oops) {
				logger.fatal("[NodeSerializer.write] StackOverflowError. Self referencing recursive structure detected!!! Node: "
						+ node.toString());
			}

			break;

		case Node.TEXT_NODE:
			writeTextNode(node, out);
			break;

		case Node.CDATA_SECTION_NODE:
			writeDataSectionNode(node, out);
			break;

		case Node.COMMENT_NODE:
			writeCommentNode(node, out, indent);
			break;

		case Node.PROCESSING_INSTRUCTION_NODE:
			writeProcessingInstructionNode(node, out, indent);
			break;
		}

		closeChunk(node);
	}

	private void closeChunk(Node node) throws IOException {

		Writer out = chunkOutMap.get(node);

		if (out != null) {

			logger.debug(String.format("Closing chunk for Node %s:%s",
					node.getNodeName(), node.hashCode()));
			
			out.close();
			
			if (chunkElementStack.empty() == false) {
				chunkElementStack.pop();
			}
		}		
	}

	public void write(Node node, Writer out, String indent) throws IOException {
		write(node, out, false, indent);
	}

	private void writeCommentNode(Node node, Writer out, String indent)
			throws IOException {
		Comment comment = (Comment) node;
		out.write(indent + "<!--" + comment.getData() + "-->");
		out.write(Sfv.LSEP);
	}

	private void writeDataSectionNode(Node node, Writer out) throws IOException {
		CDATASection cdata = (CDATASection) node;
		out.write("<![CDATA[" + cdata.getData() + "]]>");
	}

	private void writeDocumentNode(Node node, Writer out) throws IOException {

		Document tdoc = (Document) node;
		Element documentElement = tdoc.getDocumentElement();

		if (documentElement != null) {

			this.documentElement = documentElement;

			if (tdoc instanceof DocumentImpl) {
				out.write(((DocumentImpl) tdoc).createXmlDeclaration());
			} else {
				writeXmlDeclaration(out);
			}

			DocumentType docType = tdoc.getDoctype();

			if (docType != null) {
				writeDocumentTypeNode(docType, out);
			}
			
			if (W3cServices.hasNamespace(documentElement, XmlConstants.NAMESPACE_XINCLUDE) == false) {
				documentElement.setAttribute("xmlns:xi",
						XmlConstants.NAMESPACE_XINCLUDE);
			}
			
			write(documentElement, out, "");

			
		} else {

			NodeList children = tdoc.getChildNodes();

			if (children != null && children.getLength() != 0) {
				for (int i = 0; i < children.getLength(); i++) {
					write(children.item(i), out, "");
					out.write(Sfv.LSEP);
				}
			}
		}
	}

	private void writeXmlDeclaration(Writer out) throws IOException {
		out.write("<?xml version='1.0' encoding='" + encoding + "'?>"
				+ Sfv.LSEP);
	}

	public void writeDocumentTypeNode(DocumentType docType, Writer out)
			throws IOException {

		out.write("<!DOCTYPE " + docType.getName());

		if (docType.getPublicId() != null
				&& docType.getPublicId().trim().length() > 0) {
			out.write(" PUBLIC '" + docType.getPublicId() + "'");
		} else {
			out.write(" SYSTEM");
		}

		out.write(" '" + docType.getSystemId() + "'");

		NamedNodeMap entityMap = docType.getEntities();

		if (entityMap != null && entityMap.getLength() > 0) {

			out.write("[\n");

			for (int i = 0; i < entityMap.getLength(); i++) {
				Entity entity = (Entity) entityMap.item(i);
				out.write("<!ENTITY " + entity.getNodeName() + " SYSTEM \""
						+ entity.getSystemId() + "\">\n");
			}

			out.write("]");
		}

		out.write(">");
		out.write(Sfv.LSEP);
	}

	private void writeElementNode(Node node, Writer out,
			boolean inMixedContent, String indent) throws IOException {

		Element elem = (Element) node;
		String name = elem.getNodeName();

		ElementImpl elemImpl = null;
		if (elem instanceof ElementImpl) {
			elemImpl = (ElementImpl) elem;
		}

		if (inMixedContent == false) {
			out.write(indent + "<" + name);
		} else {
			out.write("<" + name);
		}

		if (elemImpl != null) {

			out.write(elemImpl.getAttributesAsText());

			if (elemImpl.isLiteral()) {
				literalContext++;
			}

		} else {
			out.write(W3cServices.getAttributesAsText(elem));
		}

		NodeList children = elem.getChildNodes();

		if (children != null && children.getLength() != 0) {

			out.write(">");

			boolean hasMixedContent = false;

			for (int i = 0; i < children.getLength(); i++) {

				Node child = children.item(i);

				if (child.getNodeType() == Node.ENTITY_REFERENCE_NODE) {
					hasMixedContent = true;
				}

				if (child.getNodeType() == Node.TEXT_NODE) {

					String buffer = child.getTextContent();

					if (buffer != null && buffer.trim().length() > 0) {
						hasMixedContent = true;
					}
				}
			}

			if (elemImpl != null) {
				if (elemImpl.getFormatType() != NodeImpl.FORMAT_BLOCK) {
					hasMixedContent = true;
				}
			}

			if (hasMixedContent == false) {
				out.write(Sfv.LSEP);
			}

			for (int i = 0; i < children.getLength(); i++) {
				write(children.item(i), out, hasMixedContent, indent + INDENT);
			}

			if (hasMixedContent == false) {

				out.write(indent + "</" + name + ">");
				out.write(Sfv.LSEP);

			} else {

				out.write("</" + name + ">");

				if (inMixedContent == false) {
					out.write(Sfv.LSEP);
				}
			}

		} else {

			out.write("/>");

			if (inMixedContent == false
					&& (elemImpl == null || elemImpl.getFormatType() != NodeImpl.FORMAT_INLINE)) {
				out.write(Sfv.LSEP);
			}
		}

		if (elemImpl != null && elemImpl.isLiteral()) {
			literalContext--;
		}
	}

	private void writeEntityNode(Node node, Writer out) throws IOException {
		Entity entity = (Entity) node;
		out.write("&" + entity.getNodeName() + ";");
	}

	private void writeEntityReferenceNode(Node node, Writer out)
			throws IOException {
		EntityReference entityReference = (EntityReference) node;
		out.write("&" + resolveEntityReference(entityReference.getNodeName())
				+ ";");
	}

	private void writeFragmentNode(Node node, Writer out) throws IOException {
		NodeList nodes;
		nodes = node.getChildNodes();

		if (nodes != null) {
			for (int i = 0; i < nodes.getLength(); i++) {
				write(nodes.item(i), out, "");
			}
		}
	}

	private void writeProcessingInstructionNode(Node node, Writer out,
			String indent) throws IOException {
		ProcessingInstruction pi = (ProcessingInstruction) node;
		out.write(indent + "<?" + pi.getTarget() + " " + pi.getData() + "?>");
		out.write(Sfv.LSEP);
	}

	private void writeTextNode(Node node, Writer out) throws IOException {
		Text text = (Text) node;
		String data = text.getData();

		// logger.info("text=[" + data + "]");

		if (data != null) {

			if (isInsideLiteralElement() == false) {
				data = XmlServices.normalizeText(data);
			}
		}

		if (text instanceof TextImpl) {

			if (((TextImpl) text).isRawData() == true) {
				out.write(data);
			} else {
				out.write(XmlServices.textToXml(data));
			}

		} else {
			out.write(XmlServices.textToXml(data));
		}
	}

	public void setSystemId(File systemId) {
		this.systemId = systemId;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
}
