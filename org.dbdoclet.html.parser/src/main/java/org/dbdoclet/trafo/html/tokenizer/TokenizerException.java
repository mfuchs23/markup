package org.dbdoclet.trafo.html.tokenizer;

public class TokenizerException extends Exception {

	private static final long serialVersionUID = 1L;

	public TokenizerException(String msg) {
		super(msg);
	}

	public TokenizerException(String message, Throwable cause) {
		super(message, cause);
	}

	public TokenizerException(Throwable oops) {
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

/*
 * $Log: TokenizerException.java,v $ Revision 1.1.1.1 2004/12/21 13:57:02 mfuchs
 * Reimport
 * 
 * Revision 1.2 2004/10/05 13:11:21 mfuchs Koorektur in der Behandlung von
 * Entitäten
 * 
 * Revision 1.1.1.1 2004/07/29 14:49:43 mfuchs Tagspender
 * 
 * Revision 1.1.1.1 2004/02/17 22:51:06 mfuchs dbdoclet
 * 
 * Revision 1.1.1.1 2004/01/05 14:58:45 cvs dbdoclet
 * 
 * Revision 1.1.1.1 2003/08/01 13:17:52 cvs DocBook Doclet
 * 
 * Revision 1.1.1.1 2003/07/31 17:05:39 mfuchs DocBook Doclet since 0.46
 * 
 * Revision 1.1.1.1 2003/05/30 11:09:40 mfuchs dbdoclet
 * 
 * Revision 1.1.1.1 2003/03/18 07:41:37 mfuchs DocBook Doclet 0.40
 * 
 * Revision 1.1.1.1 2003/03/17 20:50:12 cvs dbdoclet
 */
