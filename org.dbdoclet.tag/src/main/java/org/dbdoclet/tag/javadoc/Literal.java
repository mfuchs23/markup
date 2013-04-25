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
public class Literal extends JavaDocElement {

    public Literal() {
	super();
	setNodeName("javadoc:literal");
	setFormatType(FORMAT_INLINE);
    }

    @Override
    public boolean validate() {

	nodeStack.removeAllElements();
	nodeStack.push(this);

	return true;
    }
}
