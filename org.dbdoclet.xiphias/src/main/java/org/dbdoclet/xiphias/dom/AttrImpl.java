package org.dbdoclet.xiphias.dom;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.TypeInfo;

public class AttrImpl extends NodeImpl implements Attr {

    public AttrImpl(String namespaceUri, String name, String value) {
        
        setNodeName(name);
        setNodeValue(value);
        setNamespaceURI(namespaceUri);
    }
    
    public String getName() {
        return getNodeName();
    }

    public Element getOwnerElement() {
        // TODO Auto-generated method stub
        return null;
    }

    public TypeInfo getSchemaTypeInfo() {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean getSpecified() {
        // TODO Auto-generated method stub
        return false;
    }

    public String getValue() {
        return getNodeValue();
    }

    public boolean isId() {
        // TODO Auto-generated method stub
        return false;
    }

    public void setValue(String value) throws DOMException {
        setNodeValue(value);
    }

}
