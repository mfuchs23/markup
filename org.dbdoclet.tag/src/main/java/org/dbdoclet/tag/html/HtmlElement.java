/*
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.html;

import java.util.HashMap;

import org.dbdoclet.xiphias.dom.ElementImpl;
import org.dbdoclet.xiphias.dom.NodeImpl;
import org.dbdoclet.xiphias.dom.NodeStack;

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

	public NodeStack getValidateStack() {

		return nodeStack;
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

	public void init() {
	}
}
