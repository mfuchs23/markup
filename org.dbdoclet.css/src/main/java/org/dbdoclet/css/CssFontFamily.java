package org.dbdoclet.css;

import org.dbdoclet.format.FormattedObject;

public class CssFontFamily extends CssProperty<String> {

    public CssFontFamily() {
    	setName("font-family");
    }

    @Override
    public void apply(FormattedObject fo) {
        fo.setFontFamily(getValue());
    }

    @Override
    public void appendValue(String value) {

        if (value == null) {
            setValue("serif");
            return;
        }
        
        setValue(value);
    }
}
