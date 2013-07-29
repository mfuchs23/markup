package org.dbdoclet.tag.dita;

import org.dbdoclet.xiphias.dom.ElementImpl;

public class DitaElement extends ElementImpl {

	public static final String DITA_NAMESPACE = "http://dita.oasis-open.org/architecture/2005/";
	private boolean contentModel = false;

	public DitaElement(String name) {
		super(name);
	}

	public boolean isContentModel() {
		return contentModel;
	}

	protected void isContentModel(boolean contentModel) {
		this.contentModel = contentModel;
	}

	public boolean isValidParent(DitaElement parent) {
		return true;
	}

	public void setRemap(String remap) {
		
		String value = getAttribute("otherprops");
		
		if (value == null) {
			value = "remap(" + remap + ")";
		} else {
			value += " remap(" + remap + ")";
		}
		
		setAttribute("otherprops", value);
	}
}
