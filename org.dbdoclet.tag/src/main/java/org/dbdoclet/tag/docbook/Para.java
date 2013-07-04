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

public class Para extends DocBookElement {

	private static HashMap<String, HashMap<String, Object>> validParentMap;
	private static String tag = "para";

	static {

		validParentMap = new HashMap<String, HashMap<String, Object>>();

		validParentMap.put(Article.getTag(), Article.getAttributeMap());

		// abstract
		// answer
		// appendix
		validParentMap.put(Article.getTag(), Article.getAttributeMap());

		// authorblurb
		// bibliodiv
		// bibliography
		validParentMap.put(BlockQuote.getTag(), BlockQuote.getAttributeMap());

		// callout
		validParentMap.put(Caption.getTag(), Caption.getAttributeMap());
		validParentMap.put(Caution.getTag(), Caution.getAttributeMap());
		validParentMap.put(Chapter.getTag(), Chapter.getAttributeMap());

		// colophon,
		// constraintdef
		// dedication
		validParentMap.put(Entry.getTag(), Entry.getAttributeMap());

		// epigraph
		validParentMap.put(Example.getTag(), Example.getAttributeMap());

		// footnote
		validParentMap.put(FormalPara.getTag(), FormalPara.getAttributeMap());

		// glossary
		// glossdef
		// glossdiv
		// highlights
		validParentMap.put(Important.getTag(), Important.getAttributeMap());

		// index
		// indexdiv
		validParentMap.put(InformalExample.getTag(),
				InformalExample.getAttributeMap());
		validParentMap.put(ItemizedList.getTag(),
				ItemizedList.getAttributeMap());

		// legalnotice
		validParentMap.put(ListItem.getTag(), ListItem.getAttributeMap());

		// msgexplan
		// msgtext
		validParentMap.put(Note.getTag(), Note.getAttributeMap());
		validParentMap.put(OrderedList.getTag(), OrderedList.getAttributeMap());

		validParentMap.put(PartIntro.getTag(), PartIntro.getAttributeMap());
		// personblurb
		// preface
		// printhistory
		// procedure
		// qandadiv
		// qandaset
		// question
		validParentMap.put(RefSect1.getTag(), RefSect1.getAttributeMap());
		validParentMap.put(RefSect2.getTag(), RefSect2.getAttributeMap());
		validParentMap.put(RefSect3.getTag(), RefSect3.getAttributeMap());

		// refsection,
		validParentMap.put(RefSynopsisDiv.getTag(),
				RefSynopsisDiv.getAttributeMap());

		// revdescription
		validParentMap.put(Sect1.getTag(), Sect1.getAttributeMap());
		validParentMap.put(Sect2.getTag(), Sect2.getAttributeMap());
		validParentMap.put(Sect3.getTag(), Sect3.getAttributeMap());
		validParentMap.put(Sect4.getTag(), Sect4.getAttributeMap());
		validParentMap.put(Sect5.getTag(), Sect5.getAttributeMap());
		validParentMap.put(Section.getTag(), Section.getAttributeMap());

		// setindex
		// sidebar
		validParentMap.put(SimpleSect.getTag(), SimpleSect.getAttributeMap());

		// step
		validParentMap.put(TextObject.getTag(), TextObject.getAttributeMap());
		validParentMap.put(Tip.getTag(), Tip.getAttributeMap());
		validParentMap.put(VariableList.getTag(),
				VariableList.getAttributeMap());
		validParentMap.put(Warning.getTag(), Warning.getAttributeMap());
	}

	public static String getTag() {
		return tag;
	}

	@Override
	public boolean isValidParent(DocBookElement parent) {

		if (parent == null) {
			return true;
		}

		boolean rc = validate2(validParentMap, new Para(), parent);
		return rc;
	}

	Para() {

		super(tag);
		setFormatType(FORMAT_CONTENT);
	}

	Para(String text) {
		this();
		appendChild(text);
	}

	@Override
	public boolean validate() {

		if (getParentNode() == null) {
			return true;
		}

		boolean rc = validate2(validParentMap);
		return rc;
	}
}
