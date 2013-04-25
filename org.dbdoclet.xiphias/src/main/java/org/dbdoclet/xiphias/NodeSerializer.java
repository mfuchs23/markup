package org.dbdoclet.xiphias;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dbdoclet.Sfv;
import org.dbdoclet.progress.ProgressEvent;
import org.dbdoclet.progress.ProgressListener;
import org.dbdoclet.xiphias.dom.DocumentImpl;
import org.dbdoclet.xiphias.dom.ElementImpl;
import org.dbdoclet.xiphias.dom.NodeImpl;
import org.dbdoclet.xiphias.dom.TextImpl;
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

	private static Log logger = LogFactory.getLog(NodeSerializer.class);

	private ArrayList<ProgressListener> listeners;
	private int literalContext = 0;

	public static String toXML(Node node) {

		try {

			StringWriter buffer = new StringWriter();

			NodeSerializer serializer = new NodeSerializer();
			serializer.write(node, buffer);
			return buffer.toString();

		} catch (IOException oops) {

			return oops.getMessage();
		}
	}

	public static void writeDocumentType(DocumentType docType, Writer out)
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

	public void setProgressListeners(ArrayList<ProgressListener> listeners) {
		this.listeners = listeners;
	}

	public void write(Node node, File file) throws IOException {
		write(node, file, "UTF-8");
	}

	public void write(Node node, File file, String encoding) throws IOException {

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

			fos = new FileOutputStream(file);
			out = new OutputStreamWriter(fos, encoding);
			write(node, out, "");

		} finally {

			/*
			 * if (fos != null) { fos.close(); }
			 */

			if (out != null) {
				out.close();
			}
		}
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

		NodeList nodes;

		ProgressEvent event = new ProgressEvent(node.toString());
		fireProgressEvent(event);

		// logger.debug("node=" + node);

		switch (node.getNodeType()) {

		case Node.DOCUMENT_FRAGMENT_NODE:

			nodes = node.getChildNodes();

			if (nodes != null) {
				for (int i = 0; i < nodes.getLength(); i++) {
					write(nodes.item(i), out, "");
					out.write(Sfv.LSEP);
				}
			}

			break;

		case Node.DOCUMENT_NODE:

			Document tdoc = (Document) node;
			Element documentElement = tdoc.getDocumentElement();

			if (documentElement != null) {

				if (tdoc instanceof DocumentImpl) {
					out.write(((DocumentImpl) tdoc).createXmlDeclaration());
				} else {
					out.write("<?xml version='1.0'?>" + Sfv.LSEP);
				}

				DocumentType docType = tdoc.getDoctype();

				if (docType != null) {
					writeDocumentType(docType, out);
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

			break;

		case Node.DOCUMENT_TYPE_NODE:
			writeDocumentType((DocumentType) node, out);
			break;

		case Node.ENTITY_NODE:
			Entity entity = (Entity) node;
			out.write("&" + entity.getNodeName() + ";");
			break;

		case Node.ENTITY_REFERENCE_NODE:
			EntityReference entityReference = (EntityReference) node;
			out.write("&"
					+ resolveEntityReference(entityReference.getNodeName())
					+ ";");
			break;

		case Node.ELEMENT_NODE:

			try {
				writeElement(node, out, inMixedContent, indent);
			} catch (StackOverflowError oops) {
				logger.fatal("[NodeSerializer.write] StackOverflowError. Possibly recursive structure detected!!! Node: "
						+ node.toString());
			}

			break;

		case Node.TEXT_NODE:

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

			break;

		/*
		 * case Node.CDATA_SECTION_NODE:
		 * 
		 * CDATASection cdata = (CDATASection) node; out.write("<![CDATA[" +
		 * cdata.getData() + "]]>"); break;
		 */

		case Node.COMMENT_NODE:

			Comment comment = (Comment) node;
			out.write(indent + "<!--" + comment.getData() + "-->");
			out.write(Sfv.LSEP);
			break;

		case Node.PROCESSING_INSTRUCTION_NODE:

			ProcessingInstruction pi = (ProcessingInstruction) node;
			out.write(indent + "<?" + pi.getTarget() + " " + pi.getData()
					+ "?>");
			out.write(Sfv.LSEP);
			break;
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

	public void write(Node node, Writer out, String indent) throws IOException {

		write(node, out, false, indent);
	}

	private void fireProgressEvent(ProgressEvent event) {

		if (listeners != null) {
			for (ProgressListener listener : listeners) {
				listener.progress(event);
			}
		}
	}

	private void writeElement(Node node, Writer out, boolean inMixedContent,
			String indent) throws IOException {

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
				write(children.item(i), out, hasMixedContent, indent + "  ");
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

			if (inMixedContent == false) {
				out.write(Sfv.LSEP);
			}
		}

		if (elemImpl != null && elemImpl.isLiteral()) {
			literalContext--;
		}
	}
}
