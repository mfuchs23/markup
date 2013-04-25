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

public class CommandButton extends JsfHtmlElement {

    private String type = "submit";
    private String value = "[:MISSING VALUE:]";
    private String onClick = "";
    private String style = "";

    public CommandButton() {
    }

    public CommandButton setType(String type) {

        if (type == null) {
            throw new IllegalArgumentException("The argument type must not be null!");
        }

        type = type.toLowerCase();
        type = type.trim();

        if (type.equals("button") || type.equals("submit") || type.equals("reset")) {
            this.type = type;
        }

        return this;
    }
    
    public String getType() {
        return type;
    }
    
    public CommandButton setValue(String value) {

        if (value == null) {
            throw new IllegalArgumentException("The argument value must not be null!");
        }

        this.value = value;

        return this;
    }

    @Override
    public void setOnClick(String onClick) {
        this.onClick = onClick;
    }
    
    @Override
    public String getOnClick() {
        return onClick;
    }
    
    @Override
    public void setStyle(String style) {
        this.style = style;
    }
    
    @Override
    public String getStyle() {
        return style;
    }
    
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {

        StringBuffer buffer = new StringBuffer();

        buffer.append('<');
        buffer.append(getNamespace());
        buffer.append("commandButton");
        buffer.append(" type=\"");
        buffer.append(type);
        buffer.append('"');
        buffer.append(" value=\"");
        buffer.append(value);
        buffer.append('"');
        
        if (onClick != null && onClick.length() > 0) {
            buffer.append(" onclick=\"");
            buffer.append(onClick);
            buffer.append('"');
        }

        if (style != null && style.length() > 0) {
            buffer.append(" style=\"");
            buffer.append(style);
            buffer.append('"');
        }

        buffer.append("/>");

        return buffer.toString();
    }
}
