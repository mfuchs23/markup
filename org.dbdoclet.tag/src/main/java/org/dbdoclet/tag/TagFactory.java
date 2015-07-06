package org.dbdoclet.tag;

import org.dbdoclet.tag.docbook.DocBookElement;
import org.w3c.dom.Element;


public abstract class TagFactory {
	
	public abstract Element createElement(String mapTo);
	protected abstract void initialize(DocBookElement elem);
}
