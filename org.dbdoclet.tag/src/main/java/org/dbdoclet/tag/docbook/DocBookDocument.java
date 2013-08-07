/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;

import org.dbdoclet.xiphias.XmlConstants;
import org.dbdoclet.xiphias.dom.DocumentImpl;

public class DocBookDocument extends DocumentImpl {

    public void setDocumentElement(DocBookElement documentElement) {

        if (documentElement == null) {
            throw new IllegalArgumentException("The argument documentElement must not be null!");
        }

        super.setDocumentElement(documentElement);
        
        if (documentElement.isDocBook5()) {

            documentElement.setAttribute("xmlns", XmlConstants.NAMESPACE_DOCBOOK);
            documentElement.setAttribute("xmlns:xl", XmlConstants.NAMESPACE_XLINK);
            documentElement.setAttribute("xmlns:xi", XmlConstants.NAMESPACE_XINCLUDE);
            documentElement.setAttribute("version", "5.0");
        }
    }
}
