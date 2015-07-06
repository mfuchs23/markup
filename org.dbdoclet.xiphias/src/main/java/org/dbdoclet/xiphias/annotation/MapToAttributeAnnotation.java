package org.dbdoclet.xiphias.annotation;


public class MapToAttributeAnnotation extends Annotation {

	private String attribute;
	private String mapTo;

	public String getAttribute() {
		return attribute;
	}

	public String getMapTo() {
		return mapTo;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public void setMapTo(String mapTo) {
		this.mapTo = mapTo;
	}
}
