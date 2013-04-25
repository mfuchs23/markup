package org.dbdoclet.trafo.html.tokenizer;

import java.util.HashMap;

import org.dbdoclet.service.StringServices;

/**
 * Die Klasse <code>MLToken</code> repräsentiert einen einzelnen Token.
 *
 * Ein Token entsteht bei der Zerlegung der Eingabedaten in Teilstücke.
 *
 * @author <a href="mailto:michael.fuchs@unico-group.com">Michael Fuchs</a>
 * @version 1.0
 */
public class Token {

    /** Der Inhalt des Token. */
    private String value;

    /** Der Name des Tags, falls der Token einen Tag repräsentiert.*/
    private String tagName;

    /** Die Attributes des Tags, falls der Token einen Tag repräsentiert.*/
    private HashMap<String, String> tagAttributes;

    /** Der Typ des Tokens. */
    private String type;

    /** Die Zeilenummer, in der der Token gefunden wurde. */
    private int line;

    /** Die Spaltennummer, in der der Token gefunden wurde. */
    private int column;

    public Token() {
        this("");
    }

    /**
     * Erzeugt eine neue Instanz der Klasse <code>MLToken</code>.
     *
     * @param token <code>String</code>
     */
    public Token(String token) {

        if (token == null) {

            throw new IllegalArgumentException(
                "The argument token may not be null!");
        }

        type = "__UNKNOWN__";
        tagAttributes = new HashMap<String, String>();

        this.value = parse(token);
    }

    /**
     * Die Methode <code>getAttribute</code> liefert ein bestimmtes Attribut des Tags.
     *
     * Ist der Token kein Tag, wird null zurückgegeben.
     *
     * @return <code>HashMap</code>
     */
    public String getAttribute(String attrName) {

        if (attrName == null) {
            throw new IllegalArgumentException("The argument attrName must not be null!");
        }

        if (tagAttributes != null) {

            return (String) tagAttributes.get(attrName);
        }

        return null;
    }

    /**
     * Die Methode <code>getAttributes</code> liefert die Attribute des Tags.
     *
     * Ist der Token kein Tag, wird null zurückgegeben.
     *
     * @return <code>HashMap</code>
     */
    public HashMap<String, String> getAttributes() {

        return tagAttributes;
    }

    /**
     * Die Methode <code>getColumn</code> liefert die Spaltennummer.
     *
     * @return <code>int</code>
     */
    public int getColumn() {

        return column;
    }

    /**
     * Die Methode <code>getLine</code> liefert die Zeilennummer.
     *
     * @return <code>int</code>
     */
    public int getLine() {

        return line;
    }

    /**
     * Die Methode <code>getTagName</code> liefert den Namen des Tags.
     *
     * Ist der Token kein Tag, wird null zurückgegeben.
     *
     * @return <code>String</code>
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * Die Methode <code>getToken</code> liefert den Token als Ganzes.
     *
     * @return <code>String</code>
     */
    public String getValue() {

    	if (isComment() && value != null) {

    		String buffer = value.trim();
    		buffer = StringServices.cutPrefix(buffer, "<!--");
    		buffer = StringServices.cutSuffix(buffer, "-->");
    		buffer = buffer.trim();
    		return buffer;
    	}
        return value;
    }

    /**
     * Wahr, falls der Token ein schließender Tag ist.
     *
     * @return <code>boolean</code>
     */
    public boolean isClosingTag() {

        if (type.endsWith(".Closing") || type.endsWith(".Empty")) {

            return true;
        }

        return false;
    }

    /**
     * Wahr, falls der Token ein Kommentar ist.
     *
     * @return <code>boolean</code>
     */
    public boolean isComment() {

        if (type.equals("Text.Comment")) {
            return true;
        }

        return false;
    }

    /**
     * Wahr, falls der Token eine Doctype-Anweisung ist.
     *
     * @return <code>boolean</code>
     */
    public boolean isDoctype() {

        if (type.equals("Doctype")) {

            return true;
        }

        return false;
    }

    /**
     * Wahr, falls der Token ein leerer Tag ist.
     *
     * @return <code>boolean</code>
     */
    public boolean isEmptyTag() {

        if (type.equals("Tag.Empty")) {

            return true;
        }

        return false;
    }

    /**
     * Wahr, falls der Token ein JavaDoc-Tag ist.
     *
     * @return <code>boolean</code>
     */
    public boolean isJavadoc() {

        if (type.startsWith("Tag.Javadoc.")) {

            return true;
        }

        return false;
    }

    /**
     * Wahr, falls der Token ein öffnender Tag ist.
     *
     * @return <code>boolean</code>
     */
    public boolean isOpeningTag() {

        if (type.endsWith(".Opening") || type.endsWith(".Empty")) {

            return true;
        }

        return false;
    }

    /**
     * Wahr, falls der Token ein Tag ist.
     *
     * @return <code>boolean</code>
     */
    public boolean isTag() {

        if (type.startsWith("Tag.")) {

            return true;
        }

        return false;
    }

    /**
     * Wahr, falls der Token nur Text enthält ist.
     *
     * @return <code>boolean</code>
     */
    public boolean isText() {

        if (type.startsWith("Text.")) {
            return true;
        }

        return false;
    }

    /**
     * Wahr, falls der Token nur Trennzeichen enthält.
     *
     * @return <code>boolean</code>
     */
    public boolean isWhitespace() {

        if (type.equals("Text.Whitespace")) {
            return true;
        }

        return false;
    }

    /**
     * Die Methode <code>setAttributes</code> setzt die Attribute des Tags.
     *
     * @param attributes <code>HashMap</code>
     */
    public void setAttributes(HashMap<String, String> attributes) {

        this.tagAttributes = attributes;
    }

    /**
     * Die Methode <code>setColumn</code> setzt die Spaltennummer.
     *
     * @param column <code>int</code>
     */
    public void setColumn(int column) {

        this.column = column;
    }

    /**
     * Die Methode <code>setLine</code> setzt die Zeilennummer.
     *
     * @param line <code>int</code>
     */
    public void setLine(int line) {

        this.line = line;
    }

    /**
     * Die Methode <code>setTagName</code> setzt den Namen des Tags.
     *
     * @param tagName <code>String</code>
     */
    public void setTagName(String tagName) {

        if (tagName == null) {

            throw new IllegalArgumentException("Parameter tagName is null!");
        }

        this.tagName = tagName;
    }

    public void setValue(String value) {
        this.value = value;
        parse(value);
    }

    public void appendValue(String value) {
        this.value += value;
    }

    /**
     * Die Methode <code>toString</code> liefert eine textuelle Darstellung des
     * Tokens.
     *
     * @return <code>String</code>
     */
    @Override
    public String toString() {

    	StringBuilder buffer = new StringBuilder();

    	if (tagName != null) {
    		buffer.append(tagName);
    		buffer.append(", ");
    	}

    	if (type != null) {
    		buffer.append(type);
    		buffer.append(", ");
    	}

    	if (value != null) {
    		buffer.append(value);
    	}

    	if (buffer.length() > 42) {
    		buffer.delete(39, buffer.length());
    		buffer.append("...");
    	}

        return buffer.toString();
    }

    /**
     * Die Methode <code>parse</code> wertet den Inhalt des Tokens aus und setzt
     * danach den Wert des Attributes type.
     *
     * @param token <code>String</code>
     * @return <code>String</code>
     */
    private String parse(String token) {

        if (token == null) {
            return null;
        }

        String value = token.trim();

        if (value.startsWith("<!--") && value.endsWith("-->")) {

            type = "Text.Comment";

        } else if (value.startsWith("<!") && value.endsWith(">")) {

            type = "Doctype";

        } else if (value.startsWith("<?") && value.endsWith("?>")) {

            type = "Declaration";

        } else if (value.startsWith("<") && value.endsWith("/>")) {

            type = "Tag.Empty";

        } else if (value.startsWith("<javadoc:") && value.endsWith(">")) {

            type = "Tag.Javadoc.Opening";

        } else if (value.startsWith("</javadoc:") && value.endsWith(">")) {

            type = "Tag.Javadoc.Closing";

        } else if (value.startsWith("</") && value.endsWith(">")) {

            type = "Tag.Closing";

        } else if (value.startsWith("<") && value.endsWith(">")) {

            type = "Tag.Opening";

        } else if (value.trim().equals("")) {

            type = "Text.Whitespace";

        } else {

            type = "Text.";
        }

        return token;
    }
}
