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

import org.dbdoclet.xiphias.dom.DocumentFragmentImpl;
import org.dbdoclet.xiphias.dom.NodeImpl;
import org.dbdoclet.xiphias.dom.NodeListImpl;

public class Table extends Inline2Element {

	private static String tag = "table";
	private static HashMap<String, HashMap<String, String>> validParentMap;
	static {

		validParentMap = new HashMap<String, HashMap<String, String>>();
		validParentMap.put(Applet.getTag(), Applet.getAttributeMap());
		validParentMap.put(Blockquote.getTag(), HtmlElement.getAttributeMap());
		validParentMap.put(Body.getTag(), HtmlElement.getAttributeMap());
		validParentMap.put(Button.getTag(), Button.getAttributeMap());
		validParentMap.put(Center.getTag(), HtmlElement.getAttributeMap());
		validParentMap.put(Dd.getTag(), HtmlElement.getAttributeMap());
		validParentMap.put(Del.getTag(), Del.getAttributeMap());
		validParentMap.put(Div.getTag(), HtmlElement.getAttributeMap());
		validParentMap.put(Fieldset.getTag(), Fieldset.getAttributeMap());
		validParentMap.put(Form.getTag(), Form.getAttributeMap());
		validParentMap.put(Iframe.getTag(), Iframe.getAttributeMap());
		validParentMap.put(Ins.getTag(), Ins.getAttributeMap());
		validParentMap.put(Li.getTag(), HtmlElement.getAttributeMap());
		validParentMap.put(Map.getTag(), Map.getAttributeMap());
		validParentMap.put(Noframes.getTag(), HtmlElement.getAttributeMap());
		validParentMap.put(Noscript.getTag(), HtmlElement.getAttributeMap());
		validParentMap.put(HtmlObject.getTag(), HtmlObject.getAttributeMap());
		validParentMap.put(Td.getTag(), HtmlElement.getAttributeMap());
		validParentMap.put(Th.getTag(), HtmlElement.getAttributeMap());
	}

	public static String getTag() {

		return tag;
	}

	private boolean hasHead = false;
	private boolean hasFoot = false;
	private String caption = "";

	private final ArrayList<String> widthList = new ArrayList<String>();

	public Table() {

		setNodeName(tag);
		setFormatType(FORMAT_BLOCK);
	}

	@Override
	public void closed() {

		boolean hasRows = false;

		if (hasChildNodes() == true && getNumberOfChildNodes() > 0) {

			for (NodeImpl child : getTrafoChildNodes()) {

				if (child instanceof HtmlElement) {

					HtmlElement elem = (HtmlElement) child;

					if (elem instanceof Tr || elem instanceof Tbody) {
						hasRows = true;
					}
				}
			}
		}

		if (hasRows == false) {
			appendChild(new Tr().appendChild(new Td()));
		}
	}

	private String cmpWidth(String width1, String width2) {

		if (((width1 == null) || (width1.length() == 0))
				&& ((width2 == null) || (width2.length() == 0))) {

			return "";
		} // end of if ()

		if ((width1 == null) || (width1.length() == 0)) {

			return width2;
		}

		if ((width2 == null) || (width2.length() == 0)) {

			return width1;
		}

		if (width1.endsWith("%") && !width2.endsWith("%")) {

			return width1;
		}

		if (width2.endsWith("%") && !width1.endsWith("%")) {

			return width2;
		}

		int w1 = widthToNumber(width1);
		int w2 = widthToNumber(width2);

		if (w1 > w2) {
			return width1;
		} else {
			return width2;
		}
	}

	public String getCaption() {
		return caption;
	}

	public ArrayList<String> getColWidths() {
		getNumOfCols();
		return widthList;
	}

	public int getNumOfCols() {

		int n;

		int cols = 0;
		widthList.clear();

		for (NodeImpl child : getTrafoChildNodes()) {

			if (child instanceof Caption) {
				caption = child.getTextContent();
			}

			if (child instanceof Thead) {

				hasHead = true;

				for (NodeImpl row : child.getTrafoChildNodes()) {

					if (row instanceof Tr) {

						n = getNumOfColsInRow((Tr) row);

						if (n > cols) {
							cols = n;
						}
					}
				}
			}

			if (child instanceof Tfoot) {

				hasFoot = true;

				for (NodeImpl row : child.getTrafoChildNodes()) {

					if (row instanceof Tr) {

						n = getNumOfColsInRow((Tr) row);

						if (n > cols) {
							cols = n;
						}
					}
				}
			}

			if (child instanceof Tbody) {

				for (NodeImpl row : child.getTrafoChildNodes()) {

					if (row instanceof Tr) {

						n = getNumOfColsInRow((Tr) row);

						if (n > cols) {
							cols = n;
						}
					}
				}
			}

			if (child instanceof Tr) {

				n = getNumOfColsInRow((Tr) child);

				if (n > cols) {
					cols = n;
				}
			}
		}

		if (cols < 0) {
			return 0;
		}

		return cols;
	}

	private int getNumOfColsInRow(Tr row) {

		int index = 0;
		int colspans = 0;

		String width;
		String val;

		NodeListImpl cols = row.getTrafoChildNodes();
		widthList.ensureCapacity(cols.size());

		for (NodeImpl node : cols) {

			if (node instanceof TableColumnElement) {

				TableColumnElement col = (TableColumnElement) node;

				width = col.getWidth();

				if (widthList.size() >= (index + 1)) {
					val = widthList.get(index);
				} else {
					val = "";
				}

				if (widthList.size() <= index) {
					widthList.add(index, cmpWidth(val, width));
				} else {
					widthList.set(index, cmpWidth(val, width));
				}

				index++;

				col.setIndex(index + colspans);

				if (col.getColspan() > 1) {
					
					/* Eine Spalte wird standardmäßig hinzugefügt. Deshalb muß eine von colspan abgezogen werden. */
					colspans += col.getColspan() - 1;
				}
			}
		}

		return index;
	}

	public boolean hasBorder() {

		String attr = getAttribute("border");

		if ((attr == null) || (attr.length() == 0) || attr.equals("0")) {

			return false;
		} else {

			return true;
		}
	}

	public boolean hasFoot() {

		return hasFoot;
	}

	public boolean hasHead() {

		return hasHead;
	}

	@Override
	public boolean validate() {

		if (validate(validParentMap)) {
			return true;
		}

		if (getParentNode() instanceof DocumentFragmentImpl) {
			return true;
		}

		return false;
	}

	private int widthToNumber(String width) {

		StringBuffer buffer = new StringBuffer();
		char c;

		for (int i = 0; i < width.length(); i++) {

			c = width.charAt(i);

			if (Character.isDigit(c)) {
				buffer.append(c);
			} else {
				break;
			}
		}

		int w;

		try {
			w = Integer.parseInt(buffer.toString());
		} catch (NumberFormatException oops) {
			w = 1;
		}

		return w;
	}
}
