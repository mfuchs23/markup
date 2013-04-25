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

public class PanTitle extends PanElement {

    private static final String tag = "title";

    public PanTitle(String title) {

	super(tag);
	setFormatType(FORMAT_BLOCK);

	appendChild(new TextImpl(title));
    }
}
