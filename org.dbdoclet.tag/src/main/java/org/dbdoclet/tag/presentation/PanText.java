/* 
 * ### Copyright (C) 2007 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.presentation;

import org.dbdoclet.xiphias.dom.TextImpl;

public class PanText extends PanElement {

    private static final String tag = "text";

    public PanText(String text) {

	super(tag);
	setFormatType(FORMAT_CONTENT);

	appendChild(new TextImpl(text));
    }
}
