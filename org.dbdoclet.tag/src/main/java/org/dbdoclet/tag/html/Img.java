/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.html;

import java.util.HashMap;

public class Img extends InlineElement {

    private static final String tagName = "img";

    private static HashMap<String, HashMap<String, String>> validParentMap;
    private static HashMap<String, String> attributeMap;

    static {

        validParentMap = new HashMap<String, HashMap<String, String>>();
        validParentMap.putAll(blockElementMap);
        validParentMap.putAll(inlineElementMap);
        validParentMap.remove("var");

        attributeMap = new HashMap<String, String>();
        attributeMap.put("align", "top, middle, bottom, left, center, right");
        attributeMap.put("alt", "");
        attributeMap.put("border", "");
        attributeMap.put("height", "");
        attributeMap.put("hspace", "");
        attributeMap.put("ismap", "");
        attributeMap.put("longdesc", "");
        attributeMap.put("name", "");
        attributeMap.put("src", "");
        attributeMap.put("usemap", "");
        attributeMap.put("vspace", "");
        attributeMap.put("width", "");
    }

    public Img() {

        setNodeName("img");
        setFormatType(FORMAT_INLINE);
        isEmpty(true);
        setAttribute("alt", "image");
        setAttribute("src", "image.png");
    }

    public static String getTag() {
        return tagName;
    }

    @Override
	public void init() {
    }

    public String getSrc() {
        return getAttribute("src");
    }

    public String getAlt() {
        return getAttribute("alt");
    }

    public String getWidth() {
        return getAttribute("width");
    }

    public String getHeight() {
        return getAttribute("height");
    }

    public String getAlign() {
        return getAttribute("align");
    }
}
