/* 
 * $Id$
 *
 * ### Copyright (C) 2006 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.presentation;

import org.dbdoclet.xiphias.dom.DocumentImpl;
import org.dbdoclet.xiphias.dom.ElementImpl;

public class PanDocument extends DocumentImpl {

    private ElementImpl documentElement;

    @Override
    public ElementImpl getDocumentElement() {
	return documentElement;
    }

    @Override
    public void setDocumentElement(ElementImpl documentElement) {

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
