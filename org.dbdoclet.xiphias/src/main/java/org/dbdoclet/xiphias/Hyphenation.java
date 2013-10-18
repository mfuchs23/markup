package org.dbdoclet.xiphias;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hyphenation {

	public enum HyphenationChar {
		
		SOFT_HYPHEN("&#x00ad;"), 
		ZERO_WIDTH_SPACE("&#x200b;");
		
		public String entity;
		
		HyphenationChar(String entity) {
			this.entity = entity;
		}
		
		public String getEntity() {
			return entity;
		}
	}

	public HyphenationChar hyphenationChar = HyphenationChar.SOFT_HYPHEN;
	
	public HyphenationChar getHyphenationChar() {
		return hyphenationChar;
	}
	
	public String hyphenateAfter(String text, HyphenationChar hyphenChar, String... tokens) {

		if (text == null || text.length() == 0) {
			return text;
		}

		if (tokens == null || tokens.length == 0) {
			return text;
		}

		String wrapable = text;
		String token;

		for (int i = 0; i < tokens.length; i++) {

			token = tokens[i];

			if (token == null || token.length() == 0) {
				continue;
			}

			Pattern pattern = Pattern.compile("(\\S" + token + ")(\\S)");
			Matcher matcher = pattern.matcher(wrapable);
			
			StringBuffer buffer = new StringBuffer();
			while (matcher.find()) {
				matcher.appendReplacement(buffer, matcher.group(1) + hyphenationChar.getEntity() + matcher.group(2));
			}
			matcher.appendTail(buffer);

			wrapable = buffer.toString();
		}

		return wrapable;
	}
	/**
	 * Fügt ein Trennzeichen hinter jedem gefundenen Token ein.
	 * 
	 * @param buffer
	 * @param tokens
	 * @return
	 */
	public String hyphenateAfter(String buffer, String... tokens) {
		return hyphenateAfter(buffer, hyphenationChar, tokens);
	}
	
	public String hyphenateCamelCase(String text) {
		
		StringBuilder buffer = new StringBuilder();
		
		for (Character c : text.toCharArray()) {
			
			if (buffer.length() > 0 && Character.isUpperCase(c) == true) {
				buffer.append(hyphenationChar.getEntity());
			}
			
			buffer.append(c);
		}
		
		return buffer.toString();
	}

	public void setHyphenationChar(HyphenationChar hyphenationChar) {
		this.hyphenationChar = hyphenationChar;
	}

}
