package org.dbdoclet.xsd;

import org.w3c.dom.Element;

public class AttributeGroup {

    private final Element element;

    public AttributeGroup(Element element) {
        this.element = element;
    }

    public Element getElement() {
        return element;
    }

}
