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

import org.dbdoclet.xiphias.dom.DocumentFragmentImpl;
import org.dbdoclet.xiphias.dom.ElementImpl;
import org.dbdoclet.xiphias.dom.NodeImpl;
import org.dbdoclet.xiphias.dom.NodeStack;
import org.w3c.dom.Attr;

public abstract class HtmlElement extends ElementImpl {

	protected static HashMap<String, HashMap<String, String>> blockElementMap = new HashMap<String, HashMap<String, String>>();
	protected static HashMap<String, HashMap<String, String>> inlineElementMap = new HashMap<String, HashMap<String, String>>();
	protected static HashMap<String, HashMap<String, String>> validParentMap;

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

		String[] blockElements = { Address.getTag(), Article.getTag(),
				Aside.getTag(), Blockquote.getTag(), Body.getTag(),
				Center.getTag(), Dd.getTag(), Del.getTag(), Div.getTag(),
				Dt.getTag(), Form.getTag(), H1.getTag(), H2.getTag(),
				H3.getTag(), H4.getTag(), H5.getTag(), H6.getTag(),
				Ins.getTag(), Isindex.getTag(), Li.getTag(), Noframes.getTag(),
				Noscript.getTag(), P.getTag(), Pre.getTag(), Section.getTag(),
				Td.getTag(), Th.getTag() };

		for (String blockElement : blockElements) {
			blockElementMap.put(blockElement, new HashMap<String, String>());
		}
	}

	private static void initInlineElementMap() {

		String[] inlineElements = { A.getTag(), Abbr.getTag(),
				Acronym.getTag(), Applet.getTag(), Area.getTag(), B.getTag(),
				Base.getTag(), Basefont.getTag(), Bdi.getTag(), Bdo.getTag(),
				Big.getTag(), Br.getTag(), Button.getTag(), Caption.getTag(),
				Cite.getTag(), Code.getTag(), Col.getTag(), Colgroup.getTag(),
				Command.getTag(), Datalist.getTag(), Details.getTag(),
				Dfn.getTag(), Em.getTag(), Embed.getTag(), Font.getTag(),
				I.getTag(), Img.getTag(), Input.getTag(), Iframe.getTag(),
				Kbd.getTag(), Label.getTag(), Legend.getTag(),
				HtmlObject.getTag(), Q.getTag(), S.getTag(), Samp.getTag(),
				Small.getTag(), Span.getTag(), Strike.getTag(),
				Strong.getTag(), Sub.getTag(), Sup.getTag(), Tt.getTag(),
				U.getTag(), Var.getTag() };

		for (String inlineElement : inlineElements) {
			inlineElementMap.put(inlineElement, new HashMap<String, String>());
		}
	}

	protected NodeStack nodeStack = new NodeStack();

	public HtmlElement() {
		super();
		isCaseInsensitive(true);
		init();
	}

	public HtmlElement(String name, NodeImpl parent) {
		super(name, parent);
		isCaseInsensitive(true);
		init();
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

	public boolean validate() {

		if (validate(validParentMap)) {
			return true;
		}

		if (getParentNode() instanceof DocumentFragmentImpl) {
			return true;
		}

		return false;
	}

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

		Map<String, Attr> attributes = getAttributesAsMap();

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

					Attr attr = attributes.get(name);

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
