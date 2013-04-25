package org.dbdoclet.xiphias.dom;

import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;

public class DOMImplementationImpl implements DOMImplementation {

    public Document createDocument(String namespaceURI, String qualifiedName, DocumentType doctype) throws DOMException {
        // TODO Auto-generated method stub
        return null;
    }

    public DocumentType createDocumentType(String qualifiedName, String publicId, String systemId) throws DOMException {
        // TODO Auto-generated method stub
        return null;
    }

    public Object getFeature(String feature, String version) {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean hasFeature(String feature, String version) {
        // TODO Auto-generated method stub
        return false;
    }

}
