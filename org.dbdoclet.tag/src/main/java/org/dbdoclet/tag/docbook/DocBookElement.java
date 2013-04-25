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

import org.dbdoclet.xiphias.dom.ElementImpl;

public class DocBookElement extends ElementImpl {

	public static final String DOCBOOK_NAMESPACE = "http://docbook.org/ns/docbook";
	public static final String XLINK_NAMESPACE = "http://www.w3.org/1999/xlink";

	private DocBookVersion docBookVersion = DocBookVersion.V5_0;
	private boolean isContentModel = false;

	private boolean isNew = true;

	DocBookElement(String name) {
		super(name);
	}

	public static HashMap<String, Object> getAttributeMap() {
		return new HashMap<String, Object>();
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

	public static boolean validate2(
			HashMap<String, HashMap<String, Object>> validParentMap,
			DocBookElement element, DocBookElement parent) {

		if (validParentMap == null) {
			throw new IllegalArgumentException(
					"Variable validParentMap is null!");
		}

		if (element == null) {
			throw new IllegalArgumentException(
					"The argument element must not be null!");
		}

		if (parent == null) {
			throw new IllegalArgumentException("Variable parent is null!");
		}

		if (element.isSection() == false && parent.isSection() == true) {

			SectionElement sect = (SectionElement) parent;

			if (sect.hasSectionChildren()) {
				return false;
			}
		}

		if (validParentMap.get(parent.getNodeName()) != null) {
			return true;
		}

		return false;
	}

	public void closed() {
		//
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

	public boolean isContentModel() {

		if (getNodeName().equalsIgnoreCase(".")) {
			return true;
		}

		return isContentModel;
	}

	public void isContentModel(boolean isContentModel) {

		this.isContentModel = isContentModel;
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

	public boolean isMixedContentModel() {
		return !isContentModel();
	}

	public void isMixedContentModel(boolean isMixedContentModel) {

		this.isContentModel = !isMixedContentModel;
	}

	public boolean isNew() {
		return isNew;
	}

	public void isNew(boolean isNew) {
		this.isNew = isNew;
	}

	public boolean isSection() {

		String name = getNodeName();

		if (name.equalsIgnoreCase("book")) {
			return true;
		}

		if (name.equalsIgnoreCase("article")) {
			return true;
		}

		if (name.equalsIgnoreCase("chapter")) {
			return true;
		}

		if (name.equalsIgnoreCase("sect1")) {

			return true;
		}

		if (name.equalsIgnoreCase("sect2")) {
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

	public boolean isValidParent(DocBookElement elem) {
		return true;
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
			setAttribute("xml:id", hardenId(id));
		} else {
			setAttribute("id", hardenId(id));
		}
	}

	public void setLang(String lang) {

		if (lang == null || lang.length() == 0) {
			return;
		}

		if (docBookVersion == DocBookVersion.V5_0) {
			setAttribute("xml:lang", lang);
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

	public boolean validate() {

		DocBookElement parent = (DocBookElement) getParentNode();

		if (parent != null) {

			if (isSection() == false && parent.isSection() == true) {

				SectionElement sect = (SectionElement) parent;

				if (sect.hasSectionChildren()) {
					return false;
				}
			}
		}

		return true;
	}

	public boolean validate(
			HashMap<String, HashMap<String, Object>> invalidParentMap) {

		if (invalidParentMap.get(getParentNode().getNodeName()) != null) {
			return false;
		}

		return true;
	}

	public boolean validate2(
			HashMap<String, HashMap<String, Object>> validParentMap) {
		return validate2(validParentMap, this, (DocBookElement) getParentNode());
	}

	protected boolean isDocBook5() {

		if (docBookVersion == DocBookVersion.V5_0) {
			return true;
		} else {
			return false;
		}
	}
}
