package org.dbdoclet.xiphias.dom;

import org.w3c.dom.Entity;
import org.w3c.dom.Node;

public class EntityImpl extends NodeImpl implements Entity {

    private String inputEncoding;
    private String notationName;
    private String publicId;
    private String systemId;
    private String xmlEncoding;
    private String xmlVersion;

    public EntityImpl(String name, String systemId) {

        this.systemId = systemId;
        setNodeType(Node.ENTITY_NODE);
        setNodeName(name);
    }
    
    public String getInputEncoding() {
        return inputEncoding;
    }

    public String getNotationName() {
        return notationName;
    }

    public String getPublicId() {
        return publicId;
    }

    public String getSystemId() {
        return systemId;
    }

    public String getXmlEncoding() {
        return xmlEncoding;
    }

    public String getXmlVersion() {
        return xmlVersion;
    }

    public void setInputEncoding(String inputEncoding) {
        this.inputEncoding = inputEncoding;
    }

    public void setNotationName(String notationName) {
        this.notationName = notationName;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public void setXmlEncoding(String xmlEncoding) {
        this.xmlEncoding = xmlEncoding;
    }

    public void setXmlVersion(String xmlVersion) {
        this.xmlVersion = xmlVersion;
    }

}
