package org.dbdoclet.css;

import org.dbdoclet.format.FontWeight;
import org.dbdoclet.format.FormattedObject;

public class CssFontWeight extends CssProperty<FontWeight> {

    public CssFontWeight() {
        super();
        setName("font-weight");
    }

    @Override
    public void apply(FormattedObject fo) {
        fo.setFontWeight(getValue());
    }

    @Override
    public void appendValue(String value) {

        if (value == null) {
            setValue(FontWeight.NORMAL);
            return;
        }
        
        value = value.toLowerCase();
        
        if (value.equals("bold")) {
            setValue(FontWeight.BOLD);
        } else {      
            setValue(FontWeight.NORMAL);
        }
    }
}
