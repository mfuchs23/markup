package org.dbdoclet.css;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.dbdoclet.format.FormattedObject;

public abstract class CssProperty<T> {

	private static HashMap<String, Class<?>> PROPERTY_CLASS_MAP = new HashMap<String, Class<?>>() {
		private static final long serialVersionUID = 1L;
		{
			put("color", CssColor.class);
			put("display", CssDisplay.class);
			put("font-family", CssFontFamily.class);
			put("font-size", CssFontSize.class);
			put("font-weight", CssFontWeight.class);
			put("margin-bottom", CssMarginBottom.class);
			put("margin-top", CssMarginTop.class);
			put("text-align", CssTextAlign.class);
		}
	};

	private String name;
	private ArrayList<T> values;

	public CssProperty() {
		values = new ArrayList<T>();
	}
	
	public String getName() {
		return name;
	}

	public T getValue() {
		
		if (values.size() == 0) {
			return null;
		}
		
		return values.get(0);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(T value) {
		values.clear();
		values.add(value);
	}

	public void addValue(T value) {
		values.add(value);
	}

	@Override
	public String toString() {
		return "CssRule [name=" + name + ", value=" + values + "]";
	}

	public abstract void apply(FormattedObject fo);
	public abstract void appendValue(String value);

	public static CssProperty<?> newInstance(List<Object> values) {

		if (values == null || values.size() == 0) {
			return null;
		}

		String key = values.get(0).toString();
		Class<?> propertyClass = PROPERTY_CLASS_MAP.get(key);
		CssProperty<?> property = null;

		if (propertyClass != null) {
			try {
				property = (CssProperty<?>) propertyClass.newInstance();
			} catch (InstantiationException oops) {
				oops.printStackTrace();
			} catch (IllegalAccessException oops) {
				oops.printStackTrace();
			}
		} else {
			property = new CssUnsupported();
		}

		if (values.size() > 1) {

			for (int i = 1; i < values.size(); i++) {
				property.appendValue(values.get(i).toString());
			}
		}

		return property;
	}

}
