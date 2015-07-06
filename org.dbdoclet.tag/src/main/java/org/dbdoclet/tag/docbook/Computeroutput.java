/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class Computeroutput extends DocBookElement {

    Computeroutput() {

	super("computeroutput");
        setFormatType(FORMAT_INLINE);
        isLiteral(true);
    }

    Computeroutput(String text) {
        
	this();
        appendChild(text);
    }
}
