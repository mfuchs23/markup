package org.dbdoclet.css;

import org.dbdoclet.format.FormattedObject;
import org.dbdoclet.unit.Length;

public class CssMarginTop extends CssProperty<Length> {

    public CssMarginTop() {
        super();
        setName("margin-top");
    }

    @Override
    public void apply(FormattedObject fo) {
        fo.setMarginTop(getValue());
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
