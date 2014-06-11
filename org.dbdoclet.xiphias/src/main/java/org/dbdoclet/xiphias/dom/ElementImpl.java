/* 
 * $Id$
 *
 * ### Copyright (C) 2006 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.xiphias.dom;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dbdoclet.service.StringServices;
import org.dbdoclet.xiphias.XmlServices;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;

public class ElementImpl extends NodeImpl implements Element {

	public static final int FORMAT_BLOCK = 3;
	public static final int FORMAT_CONTENT = 2;
	public static final int FORMAT_INLINE = 1;

	private static int idCounter = 1;
	private static Log logger = LogFactory.getLog(ElementImpl.class);

	private static final Pattern xmlIdPattern = Pattern.compile("[^\\w\\.-]+");
	private static final Pattern xmlNameStartPattern = Pattern
			.compile("^[a-zA-Z_].*$");

	private Map<String, Attr> attributes = new TreeMap<>();
	
	private int formatType = FORMAT_CONTENT;
	private boolean isLiteral = false;
	public static String hardenId(String id) {

		if (id == null || id.length() == 0) {

			id = StringServices.fillInt(idCounter++, 5);
			id = "N" + id;
		}

		String buffer = new String(id);

		try {
			buffer = URLDecoder.decode(buffer, "UTF-8");
		} catch (UnsupportedEncodingException oops) {
			logger.fatal("Decoding of id '" + buffer + "' failed!", oops);
		}

		Matcher matcher = xmlIdPattern.matcher(buffer);
		buffer = matcher.replaceAll("-");

		matcher = xmlNameStartPattern.matcher(buffer);

		if (matcher.matches() == false) {
			buffer = "dbdoclet." + buffer;
		}

		return buffer;
	}

	public ElementImpl() {
		super();
		setNodeType(Node.ELEMENT_NODE);
	}

	public ElementImpl(String name) {
		super(name);
		setNodeType(Node.ELEMENT_NODE);
	}

	public ElementImpl(String name, NodeImpl parent) {
		super(name, parent);
		setNodeType(Node.ELEMENT_NODE);
	}

	private void addAttribute(Attr newAttr) {

		String key = createAttributeKey(newAttr.getNamespaceURI(), newAttr.getNodeName());
		attributes.put(key, newAttr);
	}

	public void clearAttributes() {
		attributes = new TreeMap<String, Attr>();
	}

	public void closed() {
	}
	
	private String createAttributeKey(String namespaceUri, String name) {
		
		if (name == null) {
			throw new IllegalArgumentException("The argument name must not be null!");
		}
				
		if (name.contains(":")) {
			name = name.split(":")[1];
		}
		
		String key = name;
		
		if (namespaceUri != null && namespaceUri.trim().length() > 0) {
			key = String.format("{%s %s}", namespaceUri, name);
		}
		
		return key;
	}

	/**
	 * Liefert alle Kindelement des angegebenen Typs zurück.
	 * 
	 * @param type
	 * @return ArrayList<ElementImpl>
	 */
	@SuppressWarnings("unchecked")
	public <T extends Element> ArrayList<T> findChildren(Class<T> type) {

		ArrayList<T> list = new ArrayList<T>();

		for (Element element : getChildElementList()) {

			if (type.isInstance(element)) {
				list.add((T) element);
			}
		}

		return list;
	}

	public Element findFirstElement() {
	
		ArrayList<Element> childList = getChildElementList();
		
		if (childList != null && childList.size() > 0) {
			return childList.get(0);
		}
		
		return null;
	}

	@Override
	public String getAttribute(String name) {

		if ((name == null) || name.equals("")) {
			return "";
		}

		name = name.toLowerCase();
		Attr attr = attributes.get(name);

		if (attr == null) {
			return null;
		}

		return attr.getValue();
	}

	@Override
	public Attr getAttributeNode(String name) {

		if ((name == null) || name.equals("")) {
			return null;
		}

		name = name.toLowerCase();
		return attributes.get(createAttributeKey(null, name));
	}

	@Override
	public Attr getAttributeNodeNS(String namespaceURI, String localName)
			throws DOMException {

		String key = createAttributeKey(namespaceURI, localName);
		return attributes.get(key);
	}

	@Override
	public String getAttributeNS(String namespaceURI, String localName)
			throws DOMException {
		
		Attr attr = getAttributeNodeNS(namespaceURI, localName);
		
		if (attr != null) {
			return attr.getNodeValue();
		}
		
		return null;
	}

	@Override
	public NamedNodeMap getAttributes() {

		NamedNodeMapImpl map = new NamedNodeMapImpl();

		for (Attr attr : attributes.values()) {
			map.setNamedItem(attr);
		}

		return map;
	}

	@Override
	public Map<String, Attr> getAttributesAsMap() {

		if (attributes == null) {
			attributes = new TreeMap<String, Attr>();
		}

		return attributes;
	}

	public String getAttributesAsText() {

		if ((attributes != null) && (attributes.size() > 0)) {

			validateAttributes();

			return attributes.values().stream().map(a -> {
				return a.getNodeName() + "=\"" + a.getNodeValue() + "\"";
			})
			.collect(Collectors.joining(" "));			
		}

		return "";
	}

	public boolean getBooleanAttribute(String name) {

		if ((name == null) || name.equals("")) {
			return false;
		}

		Attr attr = attributes.get(name);

		String bval = "false";

		if (attr != null) {	
			
			String value = attr.getValue();
			if (value != null && value.trim().equals("1")) {
				bval = "true";
			}
		}

		Boolean b = new Boolean(bval);
		return b.booleanValue();
	}

	@Override
	public NodeList getElementsByTagName(String name) {

		ElementByTagNameVisitor visitor = new ElementByTagNameVisitor(name);
		DOMTraverser dt = new DOMTraverser(visitor);

		try {
			dt.traverse(this);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return visitor.getElementList();
	}

	@Override
	public NodeList getElementsByTagNameNS(String namespaceURI, String localName)
			throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}

	public int getFormatType() {
		return formatType;
	}

	public String getId() {
		return getAttribute("id");
	}

	public Integer getIntAttribute(String name) {

		if ((name == null) || name.equals("")) {
			return null;
		}

		Attr attr = attributes.get(name);

		if (attr == null) {
			return null;
		}

		String value = attr.getValue();

		if (value == null || value.trim().length() == 0) {
			return null;
		}

		int number = 0;

		try {
			number = Integer.parseInt(value.trim());
		} catch (NumberFormatException oops) {

			logger.warn("Attribute " + name + " of tag " + getTagName()
					+ " is not a valid integer. It has a value of '" + value
					+ "'.");

			return null;
		}

		return number;
	}

	@Override
	public TypeInfo getSchemaTypeInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTagName() {
		return getNodeName();
	}

	@Override
	public boolean hasAttribute(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasAttributeNS(String namespaceURI, String localName)
			throws DOMException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isFirstChildElement() {

		ElementImpl parent = (ElementImpl) getParentNode();
		Element first = parent.getFirstChildElement();
		
		if (first != null && this == first) {
			return true;
		}
		
		return false;
	}

	public boolean isLiteral() {
		return isLiteral;
	}

	public NodeImpl isLiteral(boolean isLiteral) {

		this.isLiteral = isLiteral;
		return this;
	}

	@Override
	public void removeAttribute(String name) throws DOMException {

		if (name != null) {

			if (isCaseInsensitive) {
				name = name.toLowerCase();
			}

			attributes.remove(name);
		}
	}

	@Override
	public Attr removeAttributeNode(Attr oldAttr) throws DOMException {

		if (oldAttr == null) {
			return null;
		}

		return attributes.remove(oldAttr.getName());
	}

	@Override
	public void removeAttributeNS(String namespaceURI, String localName)
			throws DOMException {
		// TODO Auto-generated method stub

	}

	public void setAttribute(String name, Object value) throws DOMException {

		if (value != null) {
			setAttribute(name, value.toString());
		}
	}

	@Override
	public void setAttribute(String name, String value) throws DOMException {

		if (name != null && name.length() > 0 && value != null) {

			if (isCaseInsensitive) {
				name = name.toLowerCase();
			}

			AttrImpl attr = (AttrImpl) getDocument().createAttribute(name);
			attr.setNodeValue(value);
			attr.setOwnerElement(this);
			addAttribute(attr);
		}
	}

	@Override
	public Attr setAttributeNode(Attr newAttr) throws DOMException {

		if (newAttr == null) {
			return null;
		}
		
		String name = newAttr.getName();
		Attr oldAttr = attributes.get(name);
		addAttribute(newAttr);
		
		return oldAttr;
	}

	@Override
	public Attr setAttributeNodeNS(Attr newAttr) throws DOMException {
		return null;
	}

	@Override
	public void setAttributeNS(String namespaceUri, String qualifiedName,
			String value) throws DOMException {

		AttrImpl attr = (AttrImpl) getDocument().createAttributeNS(namespaceUri, qualifiedName);
		attr.setNodeValue(value);
		attr.setOwnerElement(this);
		addAttribute(attr);
	}

	public NodeImpl setFormatType(int formatType) {

		this.formatType = formatType;
		return this;
	}

	public void setId(int number) {
		setAttribute("id", String.valueOf(number));
	}

	public void setId(String id) {
		setAttribute("id", hardenId(id));
	}

	@Override
	public void setIdAttribute(String name, boolean isId) throws DOMException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setIdAttributeNode(Attr idAttr, boolean isId)
			throws DOMException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setIdAttributeNS(String namespaceURI, String localName,
			boolean isId) throws DOMException {
		// TODO Auto-generated method stub

	}

	public NodeImpl setTrafoAttributes(Map<String, Attr> nattrs) {

		if (nattrs == null) {
			throw new IllegalArgumentException("Parameter attributes is null!");
		}

		attributes.putAll(nattrs);

		return this;
	}

	public NodeImpl setTrafoStringAttributes(Map<String, String> tokenAttrs) {

		if (tokenAttrs == null) {
			throw new IllegalArgumentException("Parameter attributes is null!");
		}

		for (String tokenAttrName : tokenAttrs.keySet()) {

			String attrName = tokenAttrName;

			if (isCaseInsensitive) {
				attrName = attrName.toLowerCase();
			}

			AttrImpl attr = (AttrImpl) getDocument().createAttribute(attrName);
			attr.setNodeValue(tokenAttrs.get(tokenAttrName));
			addAttribute(attr);
		}

		return this;
	}
}
