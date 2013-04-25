package org.dbdoclet.css;

import org.dbdoclet.format.Alignment;
import org.dbdoclet.format.FormattedObject;

public class CssTextAlign extends CssProperty<Alignment> {

    public CssTextAlign() {
        super();
        setName("text-align");
    }

    @Override
    public void apply(FormattedObject fo) {
        fo.setAlignment(getValue());
    }

    @Override
    public void appendValue(String value) {

        if (value == null) {
            setValue(Alignment.LEFT);
        }
        
        value = value.toLowerCase();
        
        if (value.equals("center")) {
            setValue(Alignment.CENTER);
        }
        
        if (value.equals("left")) {
            setValue(Alignment.LEFT);
        }
        
        if (value.equals("right")) {
            setValue(Alignment.RIGHT);
        }
    }

}
