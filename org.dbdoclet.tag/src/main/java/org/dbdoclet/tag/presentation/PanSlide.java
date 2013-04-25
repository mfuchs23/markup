/* 
 * ### Copyright (C) 2007 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.presentation;


public class PanSlide extends PanElement {

    private static final String tag = "slide";

    public PanSlide(String title) {

	super(tag);
	setFormatType(FORMAT_BLOCK);

	appendChild(new PanTitle(title));
    }
}
