/* 
 * ### Copyright (C) 2007 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.presentation;

import org.dbdoclet.xiphias.XmlServices;

public class PanImage extends PanElement {

    private static final String tag = "image";

    public PanImage(String src) {

	super(tag);
	setFormatType(FORMAT_BLOCK);

	setAttribute("src", XmlServices.textToXml(src));
    }
}
