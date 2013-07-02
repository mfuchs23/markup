/* 
 * ### Copyright (C) 2001-2007 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.xiphias.dom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dbdoclet.service.StringServices;
import org.dbdoclet.xiphias.XmlServices;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.w3c.dom.UserDataHandler;

/**
 * The class <code>Node</code> represents a node in a document tree.
 * 
 * @author <a href="mailto:mfuchs@unico-consulting.com">Michael Fuchs</a>
 * @version 1.0
 */
public class NodeImpl implements Node {

	public static final int FORMAT_BLOCK = 3;

	public static final int FORMAT_CONTENT = 2;
	public static final int FORMAT_INLINE = 1;
	public static final int HTML = 3;
	public static final int SGML = 1;
	public static final int XML = 2;
	public static final short XML_DECLARATION = 23;
	private static int flavour = XML;

	private static Log logger = LogFactory.getLog(NodeImpl.class);
	private static final String LSEP = System.getProperty("line.separator");

	/**
	 * The method <code>findParent</code> tries to find the nearest parent,
	 * which is of type <code>parentClass</code>.
	 * 
	 * If no parent of this type can be found <code>null</code> is returned.
	 * 
	 * @param node
	 *            a <code>Node</code> value
	 * @param parentClass
	 *            a <code>Class</code> value
	 * @return a <code>Node</code> value
	 */
	public static NodeImpl findParent(Node node, Class<?> parentClass) {

		if (node == null || parentClass == null) {
			return null;
		}

		Node parent = node.getParentNode();
		while (parent != null && !parentClass.isInstance(parent)) {
			parent = parent.getParentNode();
		}

		return (NodeImpl) parent;
	}

	public static String getTextContent(NodeImpl node) {

		String buffer = "";

		if (node instanceof TextImpl) {
			buffer += ((TextImpl) node).getData();
		}

		NodeListImpl children = node.getTrafoChildNodes();

		if (children == null) {
			return buffer;
		}

		Iterator<NodeImpl> iterator = children.iterator();
		NodeImpl o;

		while (iterator.hasNext()) {

			o = iterator.next();

			if (o == null || o instanceof CommentImpl) {
				continue;
			}

			if (o instanceof TextImpl) {

				buffer += ((TextImpl) o).getData();

			} else {

				try {
					buffer += NodeImpl.getTextContent(o);
				} catch (StackOverflowError oops) {
					logger.fatal("[NodeImpl.getTextContent] StackOverflowError. Possibly recursive structure detected!!! Node: "
							+ node.toString());
				}
			}
		}

		return buffer;
	}

	public static void setCodeType(int type) {

		switch (type) {

		case HTML:
			flavour = HTML;
			break;

		case SGML:
			flavour = SGML;
			break;

		case XML:
			flavour = XML;
			break;

		default:
			throw new IllegalArgumentException("Wrong type " + type);
		} // end of switch ()
	}

	public static void setCodeType(String type) {

		if (type == null) {

			return;
		}

		if (type.equalsIgnoreCase("xml")) {
			flavour = XML;
		} else if (type.equalsIgnoreCase("sgml")) {
			flavour = SGML;
		} else if (type.equalsIgnoreCase("html")) {
			flavour = HTML;
		} else {
			logger.error("Unknown type " + type + ". Using SGML!");
		}
	}

	public static void traverse(Node node, INodeVisitor visitor)
			throws Exception {

		if (node != null) {

			if (node instanceof Document) {
				
				Document doc = (Document) node;
				
				if (doc.getDocumentElement() != null) {
					node = doc.getDocumentElement();
				}
			}

			if (visitor != null) {
				visitor.accept(node);
			}

			NodeList childList = node.getChildNodes();

			for (int i = 0; i < childList.getLength(); i++) {
				traverse(childList.item(i), visitor);
			}
		}
	}

	private NodeListImpl childNodes = new NodeListImpl();
	private DocumentImpl document;
	private boolean isEmpty = false;
	private boolean isMute = false;
	private boolean isRawData = false;
	private String namespaceUri;
	private boolean needsPadding = false;
	private String nodeName = "node";
	private short nodeType = ELEMENT_NODE;
	private String nodeValue;

	private NodeImpl parent = null;

	private TransformInstruction transformInstruction;

	private HashMap<String, Object> userDataMap;

	private int column;

	private int line;

	protected boolean isCaseInsensitive = false;

	public NodeImpl() {
		super();
	}

	public NodeImpl(String name) {
		this(name, null);
	}

	public NodeImpl(String name, NodeImpl parent) {

		if (name != null) {
			nodeName = name;
		}

		if (isCaseInsensitive) {
			nodeName = nodeName.toLowerCase();
		}

		this.parent = parent;
	}

	@Override
	public Node appendChild(Node newChild) throws DOMException {

		if (newChild instanceof NodeImpl) {
			return appendChild((NodeImpl) newChild);
		}

		throw new IllegalArgumentException("The new child must be of type "
				+ NodeImpl.class.getName());
	}

	/**
	 * The method <code>appendChild</code> adds a child node to this node.
	 * 
	 * The parent of the child node is explicitly set to this node to this node
	 * to avoid inconsistencies in the resulting document tree.
	 * 
	 * @param node
	 *            The child node {@link NodeImpl (Node)}.
	 */
	public NodeImpl appendChild(NodeImpl node) {

		if (node == null) {
			throw new IllegalArgumentException("Variable node is null!");
		}

		if (childNodes == null) {
			throw new IllegalStateException("Variable childNodes  is null!");
		}

		node.setParentNode(this);
		childNodes.add(node);

		logger.debug("Appended child " + node + " to " + this + ".");

		return this;
	}

	public NodeImpl appendChild(String text) {

		return appendChild(text, true);
	}

	public NodeImpl appendChild(String text, boolean escape) {

		TextImpl node;

		if (escape == true) {

			node = new TextImpl(XmlServices.textToXml(text));

		} else {

			node = new TextImpl(text);
			node.isRawData(true);
		}

		node.setParentNode(this);
		childNodes.add(node);

		return this;
	}

	@Override
	public Node cloneNode(boolean deep) {
		System.err.println("Not yet implemented");
		return null;
	}

	@Override
	public short compareDocumentPosition(Node other) throws DOMException {
		System.err.println("Not yet implemented");
		return 0;
	}

	public Text findFirstText() {

		Text firstText = getFirstText();
		if (firstText != null) {
			return firstText;
		}

		for (Element element : getChildElementList()) {
			firstText = ((ElementImpl) element).findFirstText();
			if (firstText != null) {
				return firstText;
			}
		}

		return null;
	}

	public NodeImpl findChildElement(String tagName) {

		if (tagName == null) {
			throw new IllegalArgumentException(
					"The argument tagName must not be null!");
		}

		if ((childNodes == null) || (childNodes.size() < 1)) {
			return null;
		}

		NodeImpl element = null;
		String nodeName = null;

		for (int i = 0; i < childNodes.size(); i++) {

			if (childNodes.get(i) instanceof ElementImpl) {

				element = childNodes.get(i);
				nodeName = element.getNodeName();

				if (nodeName != null && nodeName.equals(tagName)) {
					return element;
				}
			}
		}

		return null;
	}

	public NodeImpl findParent(Class<?> parentClass) {

		Node parent = this.getParentNode();
		return findParent(parent, parentClass);
	}

	@Override
	public NamedNodeMap getAttributes() {

		if (this instanceof Element) {
			return ((Element) this).getAttributes();
		}
		return null;
	}

	@Override
	public String getBaseURI() {
		System.err.println("Not yet implemented");
		return null;
	}

	public ArrayList<Element> getChildElementList() {

		ArrayList<Element> list = new ArrayList<Element>();

		if (childNodes != null) {

			for (Node child : childNodes) {

				if (child instanceof Element) {
					list.add((Element) child);
				}
			}
		}

		return list;
	}

	/**
	 * The method <code>getChildNodes</code> returns a list with all children of
	 * this node..
	 * 
	 * @return an <code>ArrayList</code> value
	 */
	@Override
	public NodeList getChildNodes() {

		if (childNodes == null) {
			throw new IllegalStateException("Variable childNodes  is null!");
		}

		return childNodes;
	}

	public int getColumn() {
		return column;
	}

	public DocumentImpl getDocument() {
		return document;
	}

	public NodeListImpl getElementChildNodes() {

		if (childNodes == null) {
			throw new IllegalStateException("Variable childNodes is null!");
		}

		NodeListImpl list = new NodeListImpl();

		for (int i = 0; i < childNodes.getLength(); i++) {

			Node child = childNodes.item(i);

			if (child instanceof ElementImpl) {
				list.add((NodeImpl) child);
			}

		}

		return list;
	}

	@Override
	public Object getFeature(String feature, String version) {
		System.err.println("Not yet implemented");
		return null;
	}

	/**
	 * The method <code>getFirstChild</code> returns the first child of this
	 * node.
	 * 
	 * If this node has no children, <code>null</code> is returned.
	 * 
	 * @return a <code>Node</code> value
	 */
	@Override
	public NodeImpl getFirstChild() {

		if (childNodes == null || childNodes.size() < 1) {
			return null;
		}

		return childNodes.get(0);
	}

	/**
	 * The method <code>getFirstElement</code> returns the first child of this
	 * node that is of type <code>ELEMENT_NODE</code>.
	 * 
	 * If this node has no element child, <code>null</code> is returned.
	 * 
	 * @return The element or null, if element child can be found.
	 */
	public Element getFirstElement() {

		if ((childNodes == null) || (childNodes.size() < 1)) {
			return null;
		}

		NodeImpl element = null;

		for (int i = 0; i < childNodes.size(); i++) {

			if (childNodes.get(i) instanceof ElementImpl) {
				element = childNodes.get(i);
				break;
			}
		}

		return (Element) element;
	}

	public Text getFirstText() {

		if ((childNodes == null) || (childNodes.size() < 1)) {
			return null;
		}

		NodeImpl element = null;

		for (int i = 0; i < childNodes.size(); i++) {

			if (childNodes.get(i) instanceof Text) {
				element = childNodes.get(i);
				break;
			}
		}

		return (Text) element;
	}

	/* ========================================================== */
	/* Extensions */
	/* ========================================================== */
	public int getFlavour() {

		return flavour;
	}

	@Override
	public Node getLastChild() {

		if (childNodes == null || childNodes.size() == 0) {
			return null;
		}

		return childNodes.get(childNodes.size() - 1);
	}

	public NodeImpl getLastChild(Class<? extends NodeImpl> type) {

		if (type == null) {

			throw new IllegalArgumentException(
					"The argument type must not be null!");
		}

		if ((childNodes == null) || (childNodes.size() < 1)) {

			return null;
		}

		NodeImpl element = null;
		NodeImpl node;
		String classname;

		for (int i = 0; i < childNodes.size(); i++) {

			node = childNodes.get(i);
			classname = node.getClass().getName();

			if (classname.equals(type.getName())) {
				element = childNodes.get(i);
			}
		}

		return element;
	}

	public int getLine() {
		return line;
	}

	@Override
	public String getLocalName() {

		if (this instanceof ElementImpl || this instanceof AttrImpl
				|| this instanceof EntityImpl) {

			String qualifiedName = getNodeName();

			if (qualifiedName.indexOf(':') == -1) {
				return qualifiedName;
			} else {
				return qualifiedName.split(":")[1];
			}
		}

		return null;
	}

	@Override
	public String getNamespaceURI() {
		return namespaceUri;
	}

	@Override
	public Node getNextSibling() {
		NodeImpl parent = getTrafoParentNode();

		if (parent == null) {
			return null;
		}

		int index = 0;

		NodeListImpl children = parent.getTrafoChildNodes();
		for (NodeImpl child : children) {

			if (child == this) {
				break;
			}

			index++;
		}

		if (index < (children.size() - 1)) {
			return children.get(index + 1);
		}

		return null;
	}

	@Override
	public String getNodeName() {
		return nodeName;
	}

	@Override
	public short getNodeType() {
		return nodeType;
	}

	@Override
	public String getNodeValue() throws DOMException {
		return nodeValue;
	}

	public int getNumberOfChildNodes() {
		return childNodes.size();
	}

	@Override
	public Document getOwnerDocument() {
		System.err.println("Not yet implemented");
		return null;
	}

	@Override
	public Node getParentNode() {
		return parent;
	}

	@Override
	public String getPrefix() {

		if (this instanceof ElementImpl || this instanceof AttrImpl) {

			String qualifiedName = getNodeName();

			if (qualifiedName.indexOf(':') == -1) {
				return null;
			} else {
				return qualifiedName.split(":")[0];
			}
		}

		return null;
	}

	@Override
	public Node getPreviousSibling() {

		NodeImpl parent = getTrafoParentNode();

		if (parent == null) {
			return null;
		}

		int index = 0;

		NodeListImpl children = parent.getTrafoChildNodes();
		for (NodeImpl child : children) {

			if (child == this) {
				break;
			}

			index++;
		}

		if (index > 0) {
			return children.get(index - 1);
		}

		return null;
	}

	public NodeImpl getRoot() {

		Node parent = getParentNode();

		if (parent == null) {
			return this;
		}

		Node root = parent;

		while (parent != null) {

			parent = parent.getParentNode();

			if (parent != null) {
				root = parent;
			}
		}

		return (NodeImpl) root;
	}

	@Override
	public String getTextContent() {
		return NodeImpl.getTextContent(this);
	}

	public Map<String, AttrImpl> getTrafoAttributes() {

		if (this instanceof ElementImpl) {
			return this.getTrafoAttributes();
		}

		return null;
	}

	public NodeListImpl getTrafoChildNodes() {

		if (childNodes == null) {
			childNodes = new NodeListImpl();
		}

		return childNodes;
	}

	public NodeImpl getTrafoParentNode() {
		return parent;
	}

	public TransformInstruction getTransformInstruction() {
		return transformInstruction;
	}

	@Override
	public Object getUserData(String key) {

		if (key == null || userDataMap == null) {
			return null;
		}

		return userDataMap.get(key);
	}

	public String hardenText(String text) {

		if (text == null) {
			return "";
		}

		String buffer = StringServices.replace(text, "&", "&amp;");
		buffer = StringServices.replace(buffer, "<", "&lt;");
		buffer = StringServices.replace(buffer, ">", "&gt;");

		return buffer;
	}

	@Override
	public boolean hasAttributes() {
		System.err.println("Not yet implemented");
		return false;
	}

	/**
	 * The method <code>hasChildren</code> returns true, if the node contains
	 * any children.
	 * 
	 * @return an <code>int</code> value
	 */
	@Override
	public boolean hasChildNodes() {

		if (childNodes == null) {
			throw new IllegalStateException("Parameter childNodes is null!");
		}

		int size = childNodes.size();

		if (size > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * The method <code>hasElementChildren</code> returns true, if the node
	 * contains any children, which are elements.
	 * 
	 * @return an <code>int</code> value
	 */
	public boolean hasElementChildren() {

		if (childNodes == null) {
			throw new IllegalStateException("Parameter childNodes is null!");
		}

		NodeImpl node;

		for (int i = 0; i < childNodes.size(); i++) {

			node = childNodes.get(i);

			if (node instanceof ElementImpl) {
				return true;
			}
		}

		return false;
	}

	public boolean hasSiblingElements() {

		NodeImpl parent = (NodeImpl) getParentNode();

		if (parent == null) {
			return false;
		}

		NodeListImpl list = parent.getElementChildNodes();

		for (int i = 0; i < list.getLength(); i++) {

			Node node = list.get(i);

			if (node != this) {
				return true;
			}
		}

		return false;
	}

	public boolean hasText() {

		String text = getTextContent();

		if ((text != null) && !text.trim().equals("")) {

			return true;
		}

		return false;
	}

	public Node insertAfter(Node newChild, Node refChild) {

		if (newChild == null) {
			throw new IllegalArgumentException(
					"The argument newChild must not be null!");
		}

		if (refChild == null) {
			throw new IllegalArgumentException(
					"The argument refChild must not be null!");
		}

		NodeImpl node;
		int index = -1;

		if ((childNodes != null) && (childNodes.size() > 0)) {

			for (int i = 0; i < childNodes.size(); i++) {

				node = childNodes.get(i);

				if (node == refChild) {
					index = i;
				}
			}

			if (index > -1) {

				NodeImpl newChildImpl = (NodeImpl) newChild;
				newChildImpl.setParentNode(this);
				childNodes.add(index + 1, newChildImpl);
			}
		}

		return this;
	}

	@Override
	public Node insertBefore(Node newChild, Node refChild) throws DOMException {

		NodeListImpl childList = (NodeListImpl) getChildNodes();

		for (int i = 0; i < childList.getLength(); i++) {

			Node child = childList.item(i);

			if (child.equals(refChild)) {

				NodeImpl newChildImpl = (NodeImpl) newChild;
				newChildImpl.setParentNode(this);
				logger.debug("Inserting " + newChild + "before " + refChild);
				childList.add(i, newChildImpl);
				return this;
			}
		}

		logger.warn("InsertBefore: Couldn't find reference child " + refChild);
		return this;
	}

	/**
	 * The method <code>insertChild</code> inserts a child node at the specified
	 * index.
	 * 
	 * @param index
	 *            an <code>int</code> value
	 * @param node
	 *            a <code>Node</code> value
	 * @return a <code>Node</code> value
	 */
	public NodeImpl insertChild(int index, NodeImpl node) {

		node.setParentNode(this);
		childNodes.add(index, node);

		return this;
	}

	/**
	 * Falls die Sprache nicht zwischen Groß- und Kleinschreibung unterscheidet,
	 * muss das Attribute <code>isCaseSensitive</code> auf <code>true</code>
	 * gesetzt werden.
	 * 
	 * <p>
	 * Die Methode konvertiert bereits bestehende Daten in Kleinbuchstaben.
	 * Sollten dabei Doppeldeutigkeiten auftreten, gilt der letzte, verarbeitete
	 * Wert.
	 * 
	 * @param isCaseInsensitive
	 * @return NodeImpl
	 */
	public NodeImpl isCaseInsensitive(boolean isCaseInsensitive) {
		this.isCaseInsensitive = isCaseInsensitive;

		if (nodeName != null) {
			nodeName = nodeName.toLowerCase();
		}

		return this;
	}

	@Override
	public boolean isDefaultNamespace(String namespaceURI) {
		System.err.println("Not yet implemented");
		return false;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public NodeImpl isEmpty(boolean isEmpty) {

		this.isEmpty = isEmpty;
		return this;
	}

	@Override
	public boolean isEqualNode(Node otherNode) {
		return equals(otherNode);
	}

	public boolean isMute() {
		return isMute;
	}

	public void isMute(boolean isMute) {
		this.isMute = isMute;
	}

	public boolean isRawData() {
		return isRawData;
	}

	public void isRawData(boolean isRawData) {
		this.isRawData = isRawData;
	}

	/**
	 * The method <code>isRoot</code> returns true if this node is <em>Root</em>
	 * node.
	 * 
	 * @return a <code>boolean</code> value
	 */
	public boolean isRoot() {

		if (parent == null || this instanceof DocumentFragmentImpl) {
			return true;
		}

		return false;
	}

	@Override
	public boolean isSameNode(Node other) {
		System.err.println("Not yet implemented");
		return false;
	}

	@Override
	public boolean isSupported(String feature, String version) {
		System.err.println("Not yet implemented");
		return false;
	}

	@Override
	public String lookupNamespaceURI(String prefix) {
		System.err.println("Not yet implemented");
		return null;
	}

	@Override
	public String lookupPrefix(String namespaceURI) {
		System.err.println("Not yet implemented");
		return null;
	}

	public boolean needsPadding() {

		return needsPadding;
	}

	public NodeImpl needsPadding(boolean needsPadding) {

		this.needsPadding = needsPadding;
		return this;
	}

	@Override
	public void normalize() {
		System.err.println("Not yet implemented");
	}

	@Override
	public Node removeChild(Node node) throws DOMException {

		if (node == null) {
			throw new IllegalArgumentException("Variable node is null!");
		}

		if (childNodes == null) {
			throw new IllegalStateException("Variable childNodes  is null!");
		}

		Node child;
		Node removedChild = null;

		for (int i = 0; i < childNodes.getLength(); i++) {

			child = childNodes.item(i);

			if (child.equals(node)) {
				childNodes.remove(i);
				removedChild = child;
				break;
			}
		}

		return removedChild;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * The method <code>replaceChild</code> exchanges a node against another
	 * one.
	 * 
	 * Beware of that the parent of the old child is set to null. If either
	 * <code>oldNode</code> or <code>newNode</code> is <code>null</code>, an
	 * <code>IllegalArgumentException</code> is thrown.
	 * 
	 * @param oldChild
	 *            a <code>Node</code> value
	 * @param newChild
	 *            a <code>Node</code> value
	 * @return a <code>Node</code> value
	 */
	@Override
	public Node replaceChild(Node newChild, Node oldChild) throws DOMException {

		logger.debug("(W3C) Replacing child " + oldChild + " with child "
				+ newChild);

		NodeList childList = getChildNodes();

		for (int i = 0; i < childList.getLength(); i++) {

			Node child = childList.item(i);

			if (child.equals(oldChild)) {

				logger.debug("Found child to replace.");
				insertBefore(newChild, oldChild);
				removeChild(oldChild);
			}
		}

		return this;
	}

	public void setChildNodes(NodeList children) {

		if (children == null) {
			childNodes = new NodeListImpl();
		}

		childNodes = (NodeListImpl) children;
	}

	/**
	 * Die Methode <code>setColumn</code> setzt die Spaltennummer in der das
	 * Element ursprünglich vom Tokenizer gefunden wurde.
	 * 
	 * @param column
	 *            <code>int</code>
	 */
	public void setColumn(int column) {
		this.column = column;
	}

	public void setDocument(DocumentImpl document) {
		this.document = document;
	}

	/**
	 * Die Methode <code>setLine</code> setzt die Zeilennummer in der das
	 * Element ursprünglich vom Tokenizer gefunden wurde.
	 * 
	 * @param line
	 *            <code>int</code>
	 */
	public void setLine(int line) {
		this.line = line;
	}

	public void setMute(boolean isMute) {
		this.isMute = isMute;
	}

	public void setNamespaceURI(String namespaceUri) {
		this.namespaceUri = namespaceUri;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public void setNodeType(short nodeType) {
		this.nodeType = nodeType;
	}

	@Override
	public void setNodeValue(String nodeValue) throws DOMException {
		this.nodeValue = nodeValue;
	}

	public void setParentNode(NodeImpl parent) {

		if (this == parent) {
			throw new IllegalStateException("Self referencing " + parent);
		}

		this.parent = parent;
	}

	@Override
	public void setPrefix(String prefix) throws DOMException {
		System.err.println("Not yet implemented");
	}

	@Override
	public void setTextContent(String textContent) throws DOMException {

		childNodes.clear();

		if (textContent != null) {

			if (this instanceof TextImpl) {
				((TextImpl) this).setData(textContent);
			} else {
				appendChild(new TextImpl(textContent));
			}
		}
	}

	public void setTransformInstruction(
			TransformInstruction transformInstruction) {
		this.transformInstruction = transformInstruction;
	}

	@Override
	public Object setUserData(String key, Object data, UserDataHandler handler) {

		if (userDataMap == null) {
			userDataMap = new HashMap<String, Object>();
		}

		if (key != null) {
			userDataMap.put(key, data);
		}

		return data;
	}

	public void swapWithParent() {

		NodeList childNodes1 = childNodes;
		NodeList childNodes2 = parent.getChildNodes();

		Node hook = parent.getParentNode();

		if (hook == null) {
			return;
		}

		parent.setChildNodes(childNodes1);

		setChildNodes(childNodes2);
		removeChild(this);
		insertChild(0, parent);

		hook.replaceChild(this, parent);
	}

	@Override
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("name=");
		if (nodeName != null) {
			buffer.append(nodeName);
		}

		buffer.append(',');
		buffer.append("value=");
		if (nodeValue != null) {
			buffer.append(nodeValue);
		}

		buffer.append(",line=");
		buffer.append(getLine());

		buffer.append(",column=");
		buffer.append(getColumn());

		String text = buffer.toString();

		if (text.length() > 42) {
			text = text.substring(0, 39) + "...";
		}

		return text;
	}

	public String toTag() {

		String str = "<" + nodeName + ">";

		return str;
	}

	public String toTree(String prefix, int[] levels, int level) {

		if (level >= levels.length) {
			logger.fatal(String.format(
					"Resulting node tree has more than %d levels.",
					levels.length));
			return "";
		}

		String buffer = "";
		levels[level] = getTrafoChildNodes().size();

		buffer = "+ " + getNodeName() + "[" + hashCode() + "]:children["
				+ getTrafoChildNodes().size() + "]\n";

		String spaces = "";

		for (int i = 0; i <= level; i++) {

			if (levels[i] > 0) {
				spaces += "|  ";
			} else {
				spaces += "   ";
			}
		}

		buffer += (spaces + LSEP);

		spaces = "";

		for (int i = 0; i < level; i++) {

			if (levels[i] > 0) {
				spaces += "|  ";
			} else {
				spaces += "   ";
			}
		}

		prefix = spaces + "+--";

		for (NodeImpl node : getTrafoChildNodes()) {

			levels[level]--;

			if (node instanceof TextImpl) {

				buffer += (prefix + ((TextImpl) node).toString() + "(Text)\n");

			} else if (node instanceof ElementImpl) {

				NodeImpl elem = node;
				buffer += (prefix + elem.toTree(prefix, levels, level + 1));
			}
		}

		return buffer;
	}

	public void traverse(INodeVisitor visitor) throws Exception {
		traverse(this, visitor);
	}

	public String treeView() {

		int[] levels = new int[1024];

		return toTree("", levels, 0);
	}

	protected boolean validateAttributes() {

		// To be overwritten
		return true;
	}

	public boolean validateParentPath(
			HashMap<String, HashMap<String, String>> validParentMap) {

		NodeImpl parent = getTrafoParentNode();

		if (parent == null || isRoot() == true) {
			return true;
		}

		while (parent.isMute()) {

			parent = parent.getTrafoParentNode();

			if (parent == null) {
				return true;
			}
		}

		String path = parent.getNodeName() + " -> " + toTag();

		while (parent != null
				&& parent instanceof DocumentFragmentImpl == false) {

			if (validParentMap.get(parent.getNodeName()) == null) {
				return false;
			}

			parent = parent.getTrafoParentNode();

			if (parent != null) {

				while (parent.isMute()) {

					parent = parent.getTrafoParentNode();

					if (parent == null) {
						return true;
					}
				}

				path = parent.getNodeName() + " -> " + path;
			}
		}

		return true;
	}

	public void vanish() {

		if (parent != null) {

			NodeListImpl children = parent.getTrafoChildNodes();
			children.remove(this);
		}
	}

}
