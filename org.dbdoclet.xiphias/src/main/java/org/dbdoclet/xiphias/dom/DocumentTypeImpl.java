/* 
 * $Id$
 *
 * ### Copyright (C) 2005 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 *
 * RCS Information
 * Author..........: $Author$
 * Date............: $Date$
 * Revision........: $Revision$
 * State...........: $State$
 */
package org.dbdoclet.xiphias.dom;

import org.dbdoclet.service.StringServices;
import org.dbdoclet.xiphias.XmlServices;
import org.w3c.dom.DocumentType;
import org.w3c.dom.NamedNodeMap;

/**
 * The class <code>DocumentType</code>.
 * 
 * @author <a href="mailto:mfuchs@unico-consulting.com">Michael Fuchs</a>
 * @version 1.0
 */
public class DocumentTypeImpl extends NodeImpl implements DocumentType {

    public static DocumentTypeImpl DOCBOOK_XML_ARTICLE_4_3 = new DocumentTypeImpl("article",
	    "-//OASIS//DTD DocBook XML V4.3//EN",
	    "http://www.oasis-open.org/docbook/xml/4.3/docbookx.dtd");

    public static DocumentTypeImpl DOCBOOK_XML_ARTICLE_4_4 = new DocumentTypeImpl("article",
	    "-//OASIS//DTD DocBook XML V4.4//EN",
	    "http://www.oasis-open.org/docbook/xml/4.4/docbookx.dtd");

    public static DocumentTypeImpl DOCBOOK_XML_ARTICLE_4_5 = new DocumentTypeImpl("article",
	    "-//OASIS//DTD DocBook XML V4.5//EN",
	    "http://www.oasis-open.org/docbook/xml/4.5/docbookx.dtd");

    private String name = "";
    private String publicId = "";
    private String systemId = "";
    private NamedNodeMapImpl entityMap;
    
    public DocumentTypeImpl() {
	super();

	setNodeName("@doctype@");
	setNodeType(DOCUMENT_TYPE_NODE);
	entityMap = new NamedNodeMapImpl();
    }

    private DocumentTypeImpl(String name, String publicId, String systemId) {
	this();

	if (name == null) {

	    throw new IllegalArgumentException("The argument name must not be null!");
	}

	if (publicId == null) {

	    throw new IllegalArgumentException("The argument publicId must not be null!");
	}

	if (systemId == null) {

	    throw new IllegalArgumentException("The argument systemId must not be null!");
	}

	this.name = name;
	this.publicId = publicId;
	this.systemId = systemId;
    }

    public String getName() {

	return name;
    }

    @Override
    public String getNodeValue() {

	return "<!DOCTYPE " + XmlServices.textToXml(name) + " PUBLIC \""
		+ XmlServices.textToXml(publicId) + "\" \"" + XmlServices.textToXml(systemId)
		+ "\">";
    }

    public String getPublicId() {
	return publicId;
    }

    public String getSystemId() {
	return systemId;
    }

    public void setName(String name) {

	if ((name == null) || (name.length() == 0)) {
	    throw new IllegalArgumentException("The argument name must not be empty!");
	}

	this.name = name;
    }

    public void setPublicId(String publicId) {
	this.publicId = publicId;
    }

    public void setSystemId(String systemId) {

	if (systemId != null) {
	    systemId = StringServices.replace(systemId, "\\", "\\\\");
	}

	this.systemId = systemId;
    }

    @Override
    public String toString() {

	return "<!DOCTYPE>";
    }

    public NamedNodeMap getEntities() {
        return entityMap;
    }

    public String getInternalSubset() {
        // TODO Auto-generated method stub
        return null;
    }

    public NamedNodeMap getNotations() {
        // TODO Auto-generated method stub
        return null;
    }

    public void addEntity(EntityImpl entity) {
        entityMap.setNamedItem(entity);
    }
}
