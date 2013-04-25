package org.dbdoclet.xsd;

import org.w3c.dom.Element;

public class SimpleType extends AbstractType {

    private final Element element;

    public SimpleType(Element element) {
        this.element = element;
    }

    public Element getElement() {
        return element;
    }
}
