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
package org.dbdoclet.tag;

import org.dbdoclet.xiphias.XmlServices;
import org.dbdoclet.xiphias.dom.ElementImpl;

public class XInclude extends ElementImpl {

    public XInclude(String href) {

        setNodeName("xi:include");
        setAttribute("xmlns:xi", "http://www.w3.org/2001/XInclude");
        setAttribute("href", XmlServices.textToXml(href));
    }
}
