package org.dbdoclet.css;

import org.dbdoclet.format.FormattedObject;
import org.dbdoclet.unit.Length;

public class CssMarginBottom extends CssProperty<Length> {

    public CssMarginBottom() {
        super();
        setName("margin-bottom");
    }

    @Override
    public void apply(FormattedObject fo) {
        fo.setMarginBottom(getValue());
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
