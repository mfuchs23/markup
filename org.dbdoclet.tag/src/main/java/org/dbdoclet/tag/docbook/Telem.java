/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;

import org.dbdoclet.xiphias.dom.ElementImpl;


public class Telem extends DocBookElement {

    Telem(String name) {
        super(name);
    }

    public DocBookElement addRow(DocBookElement elem) {

        elem.setFormatType(ElementImpl.FORMAT_INLINE);
        appendChild(new Row().appendChild(new Entry().appendChild(elem)));

        return this;
    }

    public DocBookElement addRow(Entry entry) {

        appendChild(new Row().appendChild(entry));

        return this;
    }

    public DocBookElement addRow(String str1) {

        appendChild(new Row().appendChild(new Entry().appendChild(
								  new Para(str1).setFormatType(ElementImpl.FORMAT_INLINE))));

        return this;
    }

    public DocBookElement addRow(String str1, String str2) {

        appendChild(new Row().appendChild(new Entry().appendChild(
								  new Para(str1).setFormatType(ElementImpl.FORMAT_INLINE)))
		    .appendChild(new Entry().appendChild(
							 new Para(str2).setFormatType(ElementImpl.FORMAT_INLINE))));

        return this;
    }

    public DocBookElement addRow(String str1, String str2, String str3) {

        appendChild(new Row().appendChild(new Entry().appendChild(
								  new Para(str1).setFormatType(ElementImpl.FORMAT_INLINE)))
		    .appendChild(new Entry().appendChild(
							 new Para(str2).setFormatType(ElementImpl.FORMAT_INLINE)))
		    .appendChild(new Entry().appendChild(
							 new Para(str3).setFormatType(ElementImpl.FORMAT_INLINE))));

        return this;
    }
}
