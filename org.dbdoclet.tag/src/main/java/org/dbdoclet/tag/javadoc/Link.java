/* 
 * ### Copyright (C) 2001-2007 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.javadoc;


/**
 * The class <code>Link</code> represents a javadoc link tag.
 * 
 * @author <a href="mailto:mfuchs@unico-consulting.com">Michael Fuchs</a>
 * @version 1.0
 */
public class Link extends JavaDocElement {

    public Link() {
	super();
	setNodeName("javadoc:link");
	setFormatType(FORMAT_INLINE);
    }

    public String getName() {
	return getAttribute("name");
    }

    public String getRef() {
	return getAttribute("ref");
    }

    @Override
    public void init() {
    }

    @Override
    public boolean validate() {

	nodeStack.removeAllElements();
	nodeStack.push(this);
	return true;
    }
}
