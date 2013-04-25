package org.dbdoclet.format;

import java.awt.Color;

import org.dbdoclet.unit.Length;

public interface FormattedObject {

    public void setAlignment(Alignment alignment);
    public void setFontWeight(FontWeight fontWeight);
    public void setFontSize(Length value);
    public void setDisplay(Display value);
    public void setMarginTop(Length value);
    public void setMarginBottom(Length value);
    public void setMarginLeft(Length value);
    public void setMarginRight(Length value);
	public void setForeground(Color value);
	public void setFontFamily(String value);
}
