package org.dbdoclet.css;

import java.awt.Color;

import org.dbdoclet.format.FormattedObject;

public class CssColor extends CssProperty<Color> {

    public CssColor() {
        super();
        setName("color");
    }

    @Override
    public void apply(FormattedObject fo) {
        fo.setForeground(getValue());
    }

    @Override
    public void appendValue(String value) {

        if (value == null) {
            setValue(Color.decode(value));
        }
    }

}
