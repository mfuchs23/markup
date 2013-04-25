/*
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.html;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.dbdoclet.xiphias.dom.AttrImpl;
import org.dbdoclet.xiphias.dom.ElementImpl;
import org.dbdoclet.xiphias.dom.NodeImpl;
import org.dbdoclet.xiphias.dom.NodeStack;

public abstract class HtmlElement extends ElementImpl {

	protected static HashMap<String, HashMap<String, String>> blockElementMap = new HashMap<String, HashMap<String, String>>();
	protected static HashMap<String, HashMap<String, String>> inlineElementMap = new HashMap<String, HashMap<String, String>>();
	static {

		initBlockElementMap();
		initInlineElementMap();
	}

	public static HashMap<String, String> getAttributeMap() {
		return new HashMap<String, String>();
	}

	public static String getTag() {
		return "HTMLElement";
	}

	private static void initBlockElementMap() {

		HashMap<String, String> attributes;

		attributes = new HashMap<String, String>();
		blockElementMap.put("address", attributes);

		attributes = new HashMap<String, String>();
		blockElementMap.put("blockquote", attributes);

		attributes = new HashMap<String, String>();
		blockElementMap.put("center", attributes);

		attributes = new HashMap<String, String>();
		blockElementMap.put("dd", attributes);

		attributes = new HashMap<String, String>();
		blockElementMap.put("del", attributes);

		attributes = new HashMap<String, String>();
		blockElementMap.put("div", attributes);

		attributes = new HashMap<String, String>();
		blockElementMap.put("dt", attributes);

		attributes = new HashMap<String, String>();
		blockElementMap.put("form", attributes);

		attributes = new HashMap<String, String>();
		blockElementMap.put("h1", attributes);

		attributes = new HashMap<String, String>();
		blockElementMap.put("h2", attributes);

		attributes = new HashMap<String, String>();
		blockElementMap.put("h3", attributes);

		attributes = new HashMap<String, String>();
		blockElementMap.put("h4", attributes);

		attributes = new HashMap<String, String>();
		blockElementMap.put("h5", attributes);

		attributes = new HashMap<String, String>();
		blockElementMap.put("h6", attributes);

		attributes = new HashMap<String, String>();
		blockElementMap.put("ins", attributes);

		attributes = new HashMap<String, String>();
		blockElementMap.put("isindex", attributes);

		attributes = new HashMap<String, String>();
		blockElementMap.put("li", attributes);

		attributes = new HashMap<String, String>();
		blockElementMap.put("noframes", attributes);

		attributes = new HashMap<String, String>();
		blockElementMap.put("noscript", attributes);

		attributes = new HashMap<String, String>();
		blockElementMap.put("p", attributes);

		attributes = new HashMap<String, String>();
		blockElementMap.put("pre", attributes);

		attributes = new HashMap<String, String>();
		blockElementMap.put("td", attributes);

		attributes = new HashMap<String, String>();
		blockElementMap.put("th", attributes);
	}

	private static void initInlineElementMap() {

		HashMap<String, String> attributes;

		attributes = new HashMap<String, String>();
		inlineElementMap.put("a", attributes);

		attributes = new HashMap<String, String>();
		inlineElementMap.put("abbr", attributes);

		attributes = new HashMap<String, String>();
		inlineElementMap.put("acronym", attributes);

		attributes = new HashMap<String, String>();
		inlineElementMap.put("applet", attributes);

		attributes = new HashMap<String, String>();
		inlineElementMap.put("b", attributes);

		attributes = new HashMap<String, String>();
		inlineElementMap.put("basefont", attributes);

		attributes = new HashMap<String, String>();
		inlineElementMap.put("bdo", attributes);

		attributes = new HashMap<String, String>();
		inlineElementMap.put("big", attributes);

		attributes = new HashMap<String, String>();
		inlineElementMap.put("br", attributes);

		attributes = new HashMap<String, String>();
		inlineElementMap.put("button", attributes);

		attributes = new HashMap<String, String>();
		inlineElementMap.put("cite", attributes);

		attributes = new HashMap<String, String>();
		inlineElementMap.put("code", attributes);

		attributes = new HashMap<String, String>();
		inlineElementMap.put("dfn", attributes);

		attributes = new HashMap<String, String>();
		inlineElementMap.put("em", attributes);

		attributes = new HashMap<String, String>();
		inlineElementMap.put("font", attributes);

		attributes = new HashMap<String, String>();
		inlineElementMap.put("i", attributes);

		attributes = new HashMap<String, String>();
		inlineElementMap.put("img", attributes);

		attributes = new HashMap<String, String>();
		inlineElementMap.put("input", attributes);

		attributes = new HashMap<String, String>();
		inlineElementMap.put("iframe", attributes);

		attributes = new HashMap<String, String>();
		inlineElementMap.put("kbd", attributes);

		attributes = new HashMap<String, String>();
		inlineElementMap.put("label", attributes);

		attributes = new HashMap<String, String>();
		inlineElementMap.put("legend", attributes);

		attributes = new HashMap<String, String>();
		inlineElementMap.put("object", attributes);

		attributes = new HashMap<String, String>();
		inlineElementMap.put("q", attributes);

		attributes = new HashMap<String, String>();
		inlineElementMap.put("s", attributes);

		attributes = new HashMap<String, String>();
		inlineElementMap.put("samp", attributes);

		attributes = new HashMap<String, String>();
		inlineElementMap.put("small", attributes);

		attributes = new HashMap<String, String>();
		inlineElementMap.put("span", attributes);

		attributes = new HashMap<String, String>();
		inlineElementMap.put("strike", attributes);

		attributes = new HashMap<String, String>();
		inlineElementMap.put("strong", attributes);

		attributes = new HashMap<String, String>();
		inlineElementMap.put("sub", attributes);

		attributes = new HashMap<String, String>();
		inlineElementMap.put("sup", attributes);

		attributes = new HashMap<String, String>();
		inlineElementMap.put("tt", attributes);

		attributes = new HashMap<String, String>();
		inlineElementMap.put("u", attributes);

		attributes = new HashMap<String, String>();
		inlineElementMap.put("var", attributes);
	}

	protected NodeStack nodeStack = new NodeStack();

	public HtmlElement() {
		super();
		isCaseInsensitive(true);
	}

	public HtmlElement(String name, NodeImpl parent) {
		super(name, parent);
		isCaseInsensitive(true);
	}

	public void closed() {
		// closed()
	}

	public String getCssClass() {
		return getAttribute("class");
	}

	public String getStyle() {
		return getAttribute("style");
	}

	@Override
	public String getId() {
		return getAttribute("id");
	}

	public String getTitle() {
		return getAttribute("title");
	}

	public NodeStack getValidateStack() {

		return nodeStack;
	}

	public void init() {
		// initialize
	}

	abstract public boolean validate();

	protected boolean validate(
			HashMap<String, HashMap<String, String>> validParentMap) {

		if (validParentMap == null) {

			throw new IllegalArgumentException(
					"Parameter validParentMap is null!");
		}

		if (getParentNode() == null) {

			throw new NullPointerException("parent is null!");
		}

		if (nodeStack == null) {

			throw new NullPointerException("Variable nodeStack is null!");
		}

		nodeStack.removeAllElements();
		nodeStack.push(this);

		return true;
	}

	protected synchronized void validateAttributes(
			HashMap<String, String> attributeMap) {

		if (attributeMap == null) {

			throw new IllegalArgumentException(
					"Parameter attributeMap is null!");
		}

		Map<String, AttrImpl> attributes = getTrafoAttributes();

		if ((attributes != null) && (attributes.size() > 0)) {

			ArrayList<String> removeList = new ArrayList<String>();

			for (String name : attributes.keySet()) {

				name = name.toLowerCase();

				if (attributeMap.get(name.toLowerCase()) == null) {

					removeList.add(name);

				} else {

					String validValues = attributeMap.get(name.toLowerCase());

					if (validValues == null || validValues.trim().length() == 0) {
						continue;
					}

					AttrImpl attr = attributes.get(name);

					if (attr == null) {
						continue;
					}

					String attrValue = attr.getValue();

					boolean found = false;

					for (String validValue : validValues.split(",")) {

						validValue = validValue.trim();

						if (attrValue != null
								&& attrValue.equalsIgnoreCase(validValue)) {
							found = true;
							break;
						}
					}

					if (found == false) {
						removeList.add(name);
					}
				}
			}

			for (String name : removeList) {
				attributes.remove(name);
			}
		}
	}
}
