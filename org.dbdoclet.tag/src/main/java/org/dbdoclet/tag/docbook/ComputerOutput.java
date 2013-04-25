/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class ComputerOutput extends DocBookElement {

    ComputerOutput() {

	super("computeroutput");
        setFormatType(FORMAT_INLINE);
        isLiteral(true);
    }

    ComputerOutput(String text) {
        
	this();
        appendChild(text);
    }
}
