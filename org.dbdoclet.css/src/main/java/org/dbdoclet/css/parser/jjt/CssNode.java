package org.dbdoclet.css.parser.jjt;

public class CssNode {

    private Token token;

    public String getValue() {
        return token.image;
    }

    public void setToken(Token token) {
        
        if (token == null) {
            return;
        }
        
        this.token = token;
    }
}
