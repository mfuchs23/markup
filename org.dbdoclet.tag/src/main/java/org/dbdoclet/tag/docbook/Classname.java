/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class Classname extends DocBookElement {

    Classname() {
        super("classname");
    }
    
    Classname(String classname) {
 
        this();
        appendChild(classname);
    }
}
