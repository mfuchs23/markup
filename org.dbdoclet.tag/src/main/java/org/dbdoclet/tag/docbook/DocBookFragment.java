/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;

import org.dbdoclet.xiphias.dom.DocumentFragmentImpl;

public class DocBookFragment extends DocumentFragmentImpl {

	public DocBookFragment() {

		super();
		setNodeType(DOCUMENT_FRAGMENT_NODE);
		setParentNode(null);
	}
	
	public Section addSection() {
		
		Section section = new Section();
		section.setAttribute("xmlns", DocBookElement.DOCBOOK_NAMESPACE);
		appendChild(section);
		return section;
	}
}
