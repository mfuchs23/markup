package org.dbdoclet.tag.html;

public class Applet extends InlineElement {

    private static final String tag = "applet";

    public Applet() {

        setNodeName(tag);
        setFormatType(FORMAT_INLINE);
        setAttribute("width", "400");
        setAttribute("height", "300");
    }

    public static String getTag() {
        return tag;
    }
}
