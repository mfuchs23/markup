/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;



public class ManVolNum extends DocBookElement {

    ManVolNum(String manvolnum) {
	super("manvolnum");
	appendChild(manvolnum);
    }
}
