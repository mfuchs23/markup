package org.dbdoclet.css;

import org.dbdoclet.format.FormattedObject;

public class CssUnsupported extends CssProperty<Object> {

    public CssUnsupported() {
        super();
        setName("unsupported");
    }

    @Override
    public void apply(FormattedObject fo) {
    	// 
    }

	@Override
	public void appendValue(String value) {
		super.addValue(value);
	}


}
