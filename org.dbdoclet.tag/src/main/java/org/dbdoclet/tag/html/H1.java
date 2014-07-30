/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.html;


public class H1 extends HeadingElement {

	private static final String tag = "h1";
	protected static final int level = 1;
	
	public H1() {
		setNodeName(tag);
        setFormatType(FORMAT_BLOCK);
	}

	@Override
	public int getLevel() {
		return level;
	}
}
