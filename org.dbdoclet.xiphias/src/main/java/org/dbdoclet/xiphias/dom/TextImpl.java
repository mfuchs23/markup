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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.DOMException;
import org.w3c.dom.Text;

public class TextImpl extends CharacterDataImpl implements Text {

	private static Log logger = LogFactory.getLog(TextImpl.class);

	public TextImpl(String text, NodeImpl parent) {

		super();

		setNodeType(TEXT_NODE);
		setNodeName("#text");
		setParentNode(parent);
		setData(text);

		logger.debug("Text text=[" + text + "]");
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isElementContentWhitespace() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Text replaceWholeText(String content) throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Text splitText(int offset) throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}

}
