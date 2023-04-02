package org.dbdoclet.xsd;

import javax.xml.xpath.XPathExpressionException;

import org.dbdoclet.xiphias.XPathServices;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class ComplexType extends AbstractType {

    private final Element element;

    public ComplexType(Element element) {
        this.element = element;
    }

    public Element getElement() {
        return element;
    }

    public boolean isSimpleContent() throws XPathExpressionException {

        Node node = XPathServices.getNode(element, "xs", XmlSchema.XML_SCHEMA_URI, "./xs:simpleContent");

        if (node != null) {
            return true;
        }
        
        return false;
    }

    public String getSimpleContentBase() throws XPathExpressionException {

        Element node = (Element) XPathServices.getNode(element, "xs", XmlSchema.XML_SCHEMA_URI, "./xs:simpleContent/xs:extension");
        
        if (node != null) {
            return node.getAttribute("base");
        }

        return null;
    }

	public boolean isMixed() {
		return isMixed(element);
	}

	public static boolean isMixed(Element element) {

		String mixed = element.getAttribute("mixed");
		
		if (mixed == null) {
			return false;
		}
		
		return Boolean.valueOf(mixed);
	}

}
