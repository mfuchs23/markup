package org.dbdoclet.xsd.sage;

public class SampleDataNode {

	private Token token;

	public void setToken(Token token) {
		this.token = token;
	}
	
	public String getValue() {
		return token.image.trim();
	}
}
