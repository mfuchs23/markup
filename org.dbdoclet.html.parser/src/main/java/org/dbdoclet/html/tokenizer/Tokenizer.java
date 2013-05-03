package org.dbdoclet.html.tokenizer;

import java.text.ParseException;
import java.util.ArrayList;

import org.dbdoclet.html.tokenizer.parser.HtmlTokenizer;
import org.dbdoclet.html.tokenizer.parser.TokenMgrError;
import org.dbdoclet.progress.ProgressListener;

/**
 * Die Klasse <code>Tokenizer</code> implementiert einen Tokenizer für HTML.
 * 
 * @author Michael Fuchs
 * @version 1.0
 */
public class Tokenizer {

	private ArrayList<Token> tokens;
	private Token currentToken;
	private StringBuffer buffer = null;
	private int tokenPosition = 0;

	private ArrayList<ProgressListener> listeners;

	/**
	 * Creates a new <code>MLTokenizer</code> instance.
	 * 
	 * @param data
	 *            {@link String (String)}
	 */
	public Tokenizer(String data) {
		buffer = new StringBuffer(data);
	}

	public void tokenize() throws TokenizerException {
		tokenPosition = 0;
		tokens = parse();
	}

	/* ======================================================================== */
	/* PUBLIC METHODS */
	/* ======================================================================== */

	/**
	 * The method <code>hasNext</code> returns true if there are still tokens to
	 * be fetched.
	 * 
	 * @return True if another token exists.
	 */
	public boolean hasNext() {

		if (tokenPosition < tokens.size()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * The method <code>next</code> returns the next token.
	 * 
	 * If there are no more tokens left, a null value is returned.
	 * 
	 * @return The next token or null {@link Token (MLToken)}.
	 */
	public Token next() {

		if (tokenPosition >= tokens.size()) {

			return null;
		}

		currentToken = tokens.get(tokenPosition);
		tokenPosition++;

		return currentToken;
	}

	public int size() {

		if (tokens == null) {

			throw new IllegalStateException("Variable tokens is null!");
		}

		return tokens.size();
	}

	public int position() {

		return tokenPosition;
	}

	/* ======================================================================== */
	/* PRIVATE METHODS */
	/* ======================================================================== */

	/**
	 * The method <code>parse</code> parses the buffer and adds all tokens into
	 * an object of the type <code>ArrayList</code>, which is returned in the
	 * end.
	 * 
	 * @return {@link java.util.ArrayList (ArrayList)}
	 * @exception TokenizerException
	 *                if an error occurs
	 */
	private ArrayList<Token> parse() throws TokenizerException {

		HtmlTokenizer parser;

		try {

			parser = new HtmlTokenizer(buffer.toString(), "UTF-8");
			parser.setProgressListeners(listeners);

			return parser.parse();

		} catch (Throwable oops) {

			String msg = "Tokenizer Error";

			if (oops instanceof TokenMgrError || oops instanceof ParseException) {
				msg = "Parse error " + oops.getMessage() + " while parsing \""
						+ buffer.toString() + "\".";
			}

			throw new TokenizerException(msg, oops);
		}
	}

	public void setProgressListeners(ArrayList<ProgressListener> listeners) {
		this.listeners = listeners;
	}
}
