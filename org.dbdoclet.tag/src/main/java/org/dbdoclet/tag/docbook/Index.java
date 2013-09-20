/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;

import org.w3c.dom.Node;


public class Index extends DocBookElement {

	private static String[] validParentList = new String[] {
		Appendix.getTag(),
		Article.getTag(),
		Book.getTag(),
		Chapter.getTag(),
		Part.getTag(),
		Preface.getTag(),
		Sect1.getTag(),
		Sect2.getTag(),
		Sect3.getTag(),
		Sect4.getTag(),
		Section.getTag()
	};

	Index() {
		super("index");
		isEmpty(true);
	}

	@Override
	public boolean isValidParent(Node parent) {
		
		if (parent.getNodeName() == null) {
			return false;
		}
		
		for (String tag : validParentList) {
			if (tag.equals(parent.getNodeName())) {
				return true;
			}
		}
		return false;
	}
}
