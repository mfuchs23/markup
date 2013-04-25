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
package org.dbdoclet.tag.jsf.html;

import org.dbdoclet.tag.jsf.JsfElement;

public class JsfHtmlElement extends JsfElement {

    private String onClick = "";
    private String style = "";
    private String id = "";

    public JsfHtmlElement() {

        setNamespace("h:");
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
    
    @Override
    public String getId() {
        return id;
    }

    public void setOnClick(String onClick) {
        this.onClick = onClick;
    }
    
    public String getOnClick() {
        return onClick;
    }
    
    public void setStyle(String style) {
        this.style = style;
    }
    
    public String getStyle() {
        return style;
    }
}
