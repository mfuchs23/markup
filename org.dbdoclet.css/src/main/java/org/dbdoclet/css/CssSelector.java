package org.dbdoclet.css;

import java.util.ArrayList;
import java.util.List;

public class CssSelector {

    private ArrayList<String> values;

    public CssSelector(String value) {
        
        if (value == null) {
            throw new IllegalArgumentException("The argument value must not be null!");
        }
        
    	this.values = new ArrayList<String>();
    	values.add(value);
    }

    public CssSelector(List<Object> values) {
    	
    	this.values = new ArrayList<String>();
    	
    	for (Object obj : values) {
    		this.values.add(obj.toString());
    	}
    }

	@Override
    public boolean equals(Object obj) {
		
        return getValue().equals(((CssSelector) obj).getValue());
    }

    public String getValue() {
        
    	StringBuilder buffer = new StringBuilder();
    	
    	for (String value : values) {
    		buffer.append(value);
    		buffer.append(' ');
    	}
    	
    	return buffer.toString().trim();
    }

    @Override
    public int hashCode() {
        return getValue().hashCode();
    }

    @Override
    public String toString() {
        return "CssSelector [value=" + getValue() + "]";
    }
    
}
