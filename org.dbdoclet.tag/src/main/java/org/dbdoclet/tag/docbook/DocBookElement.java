/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dbdoclet.xiphias.XmlConstants;
import org.dbdoclet.xiphias.dom.ElementImpl;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class DocBookElement extends ElementImpl {

	private static Log logger = LogFactory.getLog(DocBookElement.class);

	private DocBookVersion docBookVersion = DocBookVersion.V5_0;

	public static HashMap<String, Object> getAttributeMap() {
		return new HashMap<String, Object>();
	}

	public final boolean isValidParent(String contextInfo, Node node) {

		if (node == null) {
			throw new IllegalArgumentException("Variable parent is null!");
		}

		if (node instanceof DocumentFragment) {
			return true;
		}

		try {

			node.appendChild(this);
			return DocBookSchemaValidator.getInstance().validate(contextInfo,
					node);

		} catch (SAXException e) {
			logger.error("", e);
			return false;

		} finally {
			node.removeChild(this);
		}
	}

	public static void setFlavour(String flavour) {

		if (flavour == null) {
			throw new IllegalArgumentException(
					" The argument flavour must not be null!");
		}

		if (flavour.equalsIgnoreCase("xml") || flavour.equalsIgnoreCase("sgml")) {
			flavour.toLowerCase();
		}
	}

	DocBookElement(String name) {
		super(name);
	}

	public String getCondition() {
		return getAttribute("condition");
	}

	public DocBookVersion getDocBookVersion() {
		return docBookVersion;
	}

	@Override
	public String getId() {

		if (docBookVersion == DocBookVersion.V4_5) {
			return getAttribute("id");
		} else {
			return getAttribute("xml:id");
		}
	}

	public String getRemap() {
		return getAttribute("remap");
	}

	protected boolean isDocBook5() {

		if (docBookVersion == DocBookVersion.V5_0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isList() {

		String name = getNodeName();

		if (name == null) {

			return false;
		}

		if (name.equalsIgnoreCase("orderedlist")) {

			return true;
		}

		if (name.equalsIgnoreCase("itemizedlist")) {

			return true;
		}

		if (name.equalsIgnoreCase("variablelist")) {

			return true;
		}

		return false;
	}

	public boolean isSection() {

		String name = getNodeName();

		if (name.equalsIgnoreCase("book") || name.equalsIgnoreCase("article")
				|| name.equalsIgnoreCase("chapter")
				|| name.equalsIgnoreCase("sect1")
				|| name.equalsIgnoreCase("sect2")
				|| name.equalsIgnoreCase("sect3")
				|| name.equalsIgnoreCase("sect4")
				|| name.equalsIgnoreCase("sect5")
				|| name.equalsIgnoreCase("section")
				|| name.equalsIgnoreCase("refsect1")
				|| name.equalsIgnoreCase("refsect2")
				|| name.equalsIgnoreCase("refsect3")
				|| name.equalsIgnoreCase("refsect4")
				|| name.equalsIgnoreCase("refsect5")
				|| name.equalsIgnoreCase("refsection")) {
			return true;
		}

		if (name.equalsIgnoreCase("sect3")) {
			return true;
		}

		if (name.equalsIgnoreCase("sect4")) {
			return true;
		}

		if (name.equalsIgnoreCase("sect5")) {
			return true;
		}

		if (name.equalsIgnoreCase("section")) {
			return true;
		}

		if (name.equalsIgnoreCase("simplesect")) {
			return true;
		}

		return false;
	}

	public DocBookElement setCondition(String condition) {

		if (condition == null) {
			return this;
		}

		setAttribute("condition", condition);
		return this;
	}

	public void setDocBookVersion(DocBookVersion docBookVersion) {
		this.docBookVersion = docBookVersion;
	}

	@Override
	public void setId(int number) {

		if (docBookVersion == DocBookVersion.V4_5) {
			setAttribute("id", String.valueOf(number));
		} else {
			setAttribute("xml:id", String.valueOf(number));
		}
	}

	@Override
	public void setId(String id) {

		if (id == null || id.length() == 0) {
			return;
		}

		if (docBookVersion == DocBookVersion.V5_0) {
			setAttributeNS(XmlConstants.NAMESPACE_XML, "xml:id", hardenId(id));
		} else {
			setAttribute("id", hardenId(id));
		}
	}

	public void setLang(String lang) {

		if (lang == null || lang.length() == 0) {
			return;
		}

		if (docBookVersion == DocBookVersion.V5_0) {
			setAttributeNS(XmlConstants.NAMESPACE_XML, "xml:lang", lang);
		} else {
			setAttribute("lang", lang);
		}
	}

	public DocBookElement setRemap(String remap) {

		if (remap == null) {
			return this;
		}

		setAttribute("remap", remap);
		return this;
	}

	public DocBookElement setRole(String role) {

		if (role == null) {
			return this;
		}

		setAttribute("role", role);

		return this;
	}

	public DocBookElement setXrefLabel(String label) {

		if (label == null) {
			return this;
		}

		setAttribute("xreflabel", label);
		return this;
	}

	public boolean isInline() {
		return getFormatType() == FORMAT_INLINE;
	}
}
