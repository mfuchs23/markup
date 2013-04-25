package org.dbdoclet.css;

import org.dbdoclet.format.Display;
import org.dbdoclet.format.FormattedObject;

public class CssDisplay extends CssProperty<Display> {

    public CssDisplay() {
        super();
        setName("display");
    }

    @Override
    public void apply(FormattedObject fo) {
        fo.setDisplay(getValue());
    }

    @Override
    public void appendValue(String value) {

        if (value == null) {
            setValue(Display.INLINE);
        }
        
        value = value.toLowerCase();
        
        if (value.equals("block")) {
            setValue(Display.BLOCK);
        }
    }

}
