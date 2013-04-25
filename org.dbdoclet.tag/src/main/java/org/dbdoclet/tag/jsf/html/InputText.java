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

public class InputText extends JsfHtmlElement {

    private String value = "[:MISSING VALUE:]";
    private int size = 32;
    
    public InputText() {
    }
    
    public InputText setValue(String value) {

        if (value == null) {
            throw new IllegalArgumentException("The argument value must not be null!");
        }

        this.value = value;

        return this;
    }

    public String getValue() {
        return value;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public int getSize() {
        return size;
    }
    
    @Override
    public String toString() {

        StringBuffer buffer = new StringBuffer();

        buffer.append('<');
        buffer.append(getNamespace());
        buffer.append("inputText");
        buffer.append(" id=\"");
        buffer.append(getId());
        buffer.append('"');
        buffer.append(" value=\"");
        buffer.append(value);
        buffer.append('"');
        buffer.append(" size=\"");
        buffer.append(size);
        buffer.append('"');
        
        if (getOnClick() != null && getOnClick().length() > 0) {
            buffer.append(" onclick=\"");
            buffer.append(getOnClick());
            buffer.append('"');
        }

        if (getStyle() != null && getStyle().length() > 0) {
            buffer.append(" style=\"");
            buffer.append(getStyle());
            buffer.append('"');
        }

        buffer.append("/>");

        return buffer.toString();
    }
}
