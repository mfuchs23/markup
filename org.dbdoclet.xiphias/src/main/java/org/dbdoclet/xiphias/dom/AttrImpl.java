package org.dbdoclet.xiphias.dom;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.TypeInfo;

public class AttrImpl extends NodeImpl implements Attr {

    private Element ownerElement;

	public String getName() {
        return getNodeName();
    }
    
    public Element getOwnerElement() {
    	return ownerElement;
    }

    public TypeInfo getSchemaTypeInfo() {
        return null;
    }

    public boolean getSpecified() {
        return false;
    }

    public String getValue() {
        return getNodeValue();
    }

    public boolean isId() {
        return false;
    }

    public void setOwnerElement(Element ownerElement) {
		this.ownerElement = ownerElement;
	}

    public void setValue(String value) throws DOMException {
        setNodeValue(value);
    }

}
