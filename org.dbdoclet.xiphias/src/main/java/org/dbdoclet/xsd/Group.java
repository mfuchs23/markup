package org.dbdoclet.xsd;

import org.w3c.dom.Element;

public class Group {

    private final Element element;

    public Group(Element element) {
        this.element = element;
    }

    public Element getElement() {
        return element;
    }

}
