package org.dbdoclet.trafo.html.parser;

public class ParserException extends Exception {

	private static final long serialVersionUID = 1L;

	public ParserException(String msg) {
		super(msg);
	}

	public ParserException(Throwable oops) {
		super(oops);
	}

	@Override
	public String getMessage() {

		String str;
		String msg;

		Throwable cause = getCause();

		if (cause != null) {

			msg = "[" + cause.getClass().getName() + "] ";
			str = cause.getMessage();

			if ((str != null) && (str.length() > 0)) {
				msg += str;
			}

		} else {

			msg = super.getMessage();
		}

		return msg;
	}
}
