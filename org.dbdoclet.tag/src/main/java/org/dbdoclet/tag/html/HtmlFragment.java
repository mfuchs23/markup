/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.html;

import org.dbdoclet.xiphias.dom.DocumentFragmentImpl;

public class HtmlFragment extends DocumentFragmentImpl {

    public HtmlFragment() {

        super();
        setNodeType(DOCUMENT_FRAGMENT_NODE);
        setParentNode(null);
    }
}
