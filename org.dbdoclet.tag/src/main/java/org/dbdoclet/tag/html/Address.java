package org.dbdoclet.tag.html;

public class Address extends Inline2Element {

    private static final String tag = "address";

    public Address() {
        setNodeName(tag);
        setFormatType(FORMAT_INLINE);
    }

    public static String getTag() {
        return tag;
    }
}
