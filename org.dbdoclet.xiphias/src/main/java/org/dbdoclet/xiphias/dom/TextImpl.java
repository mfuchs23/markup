/* 
 * $Id$
 *
 * ### Copyright (C) 2005 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 *
 * RCS Information
 * Author..........: $Author$
 * Date............: $Date$
 * Revision........: $Revision$
 * State...........: $State$
 */
package org.dbdoclet.xiphias.dom;

import org.w3c.dom.DOMException;
import org.w3c.dom.Text;

public class TextImpl extends CharacterDataImpl implements Text {

	public TextImpl(String text, NodeImpl parent) {

		super();

		setNodeType(TEXT_NODE);
		setNodeName("#text");
		setParentNode(parent);
		setData(text);
	}

	public TextImpl(String text) {
		this(text, null);
	}

	/**
	 * The method <code>toString</code> returns the first 24 characters of the
	 * text of this node.
	 * 
	 * If the length of the text is greater than 24 characters, the text is
	 * truncated and three digits are appended.
	 * 
	 * @return a <code>String</code> value
	 */
	@Override
	public String toString() {

		String data = getData();

		if ((data == null) || (data.length() == 0)) {
			return "";
		}

		if (data.length() < 24) {
			return data.trim();
		} else {
			return data.substring(0, 23) + "...";
		}
	}

	@Override
	public String getWholeText() {
		return getData();
	}

	@Override
	public boolean isElementContentWhitespace() {
		return getData().trim().length() == 0;
	}

	@Override
	public Text replaceWholeText(String content) throws DOMException {
		setData(content);
		return this;
	}

	@Override
	public Text splitText(int offset) throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}

}
