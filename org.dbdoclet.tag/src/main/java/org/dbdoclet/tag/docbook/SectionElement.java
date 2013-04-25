/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;

import org.dbdoclet.xiphias.dom.CommentImpl;
import org.dbdoclet.xiphias.dom.ElementImpl;
import org.dbdoclet.xiphias.dom.NodeImpl;
import org.dbdoclet.xiphias.dom.TextImpl;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SectionElement extends DocBookElement {

	SectionElement(String name) {
		super(name);
	}

	public SectionElement getFirstSectionChild() {

		NodeList children = getChildNodes();
		int length = children.getLength();

		for (int i = 0; i < length; i++) {

			Node node = children.item(i);

			if (node != null && node instanceof SectionElement) {
				return (SectionElement) node;
			}
		}

		return null;
	}

	SectionElement getLastSectionChild() {

		NodeList children = getChildNodes();
		int length = children.getLength();

		SectionElement sectionChild = null;

		for (int i = 0; i < length; i++) {

			Node node = children.item(i);

			if (node != null && node instanceof SectionElement) {
				sectionChild = (SectionElement) node;
			}
		}

		return sectionChild;
	}

	public String getTitle() {

		NodeImpl titleElement = (NodeImpl) findChildElement("title");

		if (titleElement != null) {
			return titleElement.getTextContent();
		}
		
		return "";
	}

	public void setTitle(String title) {

		NodeImpl titleElement = (NodeImpl) findChildElement("title");

		if (titleElement != null) {
			titleElement.setTextContent(title);
		}
	}

	public boolean hasContentChildren() {

		NodeList children = getChildNodes();

		int counter = 0;
		int length = children.getLength();

		for (int i = 0; i < length; i++) {

			Node node = children.item(i);

			if (node != null && node instanceof ElementImpl) {

				if (node instanceof Title || node instanceof IndexTerm
						|| node instanceof CommentImpl) {
					continue;
				}

				if (node instanceof TextImpl) {

					TextImpl text = (TextImpl) node;
					String buffer = text.getData();

					if ((buffer == null) || (buffer.trim().length() == 0)) {
						continue;
					}
				}

				if (node instanceof Para) {

					if (node.hasChildNodes() == false) {
						continue;
					}
				}

				counter++;
			}
		}

		if (counter > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hasSectionChildren() {

		NodeList children = getChildNodes();

		int length = children.getLength();

		for (int i = 0; i < length; i++) {

			Node node = children.item(i);

			if (node != null && node instanceof DocBookElement) {

				DocBookElement elem = (DocBookElement) node;

				if (elem.isSection()) {
					return true;
				}
			}
		}

		return false;
	}
	
}
