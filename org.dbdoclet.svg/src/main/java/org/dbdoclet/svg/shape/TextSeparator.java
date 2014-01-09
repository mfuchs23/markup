/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.svg.shape;

import java.awt.Font;

public class TextSeparator 
    implements Text {

	@Override
	public String getText() {
		return "---";
	}

	@Override
	public Font getFont() {
		return new Font("serif", Font.PLAIN, 12);
	}

	@Override
	public int getIndent() {
		return 0;
	}

}
