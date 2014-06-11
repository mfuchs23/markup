package org.dbdoclet.tag.html;

public class Area extends ReplaceElement {

	public Area() {

		setNodeName("area");
		setFormatType(FORMAT_CONTENT);
		isEmpty(true);

		setAttribute("alt", "area");
	}
}
