package org.dbdoclet.css;

import org.dbdoclet.format.FormattedObject;
import org.dbdoclet.unit.Length;

public class CssFontSize extends CssProperty<Length> {

    public CssFontSize() {
        super();
        setName("font-size");
    }

    @Override
    public void apply(FormattedObject fo) {
        fo.setFontSize(getValue());
    }

    @Override
    public void appendValue(String value) {

        if (value == null) {
            setValue(Length.valueOf("0"));
            return;
        }
        
        setValue(Length.valueOf(value));
    }
}
