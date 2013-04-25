/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.html;

import org.dbdoclet.xiphias.dom.DocumentImpl;
import org.dbdoclet.xiphias.dom.ElementImpl;

public class HtmlDocument extends DocumentImpl {

    private HtmlElement documentElement;

    @Override
    public HtmlElement getDocumentElement() {
	return documentElement;
    }

    @Override
    public void setDocumentElement(ElementImpl documentElement) {
        setDocumentElement((HtmlElement) documentElement);
    }
    
    public void setDocumentElement(HtmlElement documentElement) {

	if (documentElement == null) {
	    throw new IllegalArgumentException("The argument documentElement must not be null!");
	}

	if (this.documentElement != null) {
	    replaceChild(this.documentElement, documentElement);
	} else {
	    appendChild(documentElement);
	}

	this.documentElement = documentElement;
    }
}
