package org.dbdoclet.xiphias;

import java.io.File;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

/**
 * Die Klasse <code>SAXErrorHandler</code> wird benachrichtigt falls beim Parsen
 * einer XML-Datei ein Fehler auftritt.
 *
 * Die Fehlermeldungen werden formatiert und auf <code>System.err</code> über
 * die Konsole ausgegeben.
 *
 * @author <a href="mailto:michael.fuchs@unico-group.com">Michael Fuchs</a>
 * @version 1.0
 */
public class SaxErrorHandler implements ErrorHandler {

    private static String fatalPrefix = "[XML Parser FATAL] ";
    private static String errorPrefix = "[XML Parser ERROR] ";
    private static String warnPrefix  = "[XML Parser WARN ] ";

    /** Kennzeichnet das erste Auftreten eines Fehlers. */
    private boolean first = true;
    
    private int errors = 0;

    /** Die XML-Datei */
    private File source;

    /**
     * Erzeugt eine neue Instanz der Klasse <code>SaxErrorHandler</code>.
     *
     * @param source <code>File</code>
     */
    public SaxErrorHandler(File source) {

        if (source == null) {
            throw new IllegalArgumentException("The argument source may not be null!");
        }
 
        this.source = source;
    }

    public int getNumOfErrors() {

        return errors;
    }

    /**
     * Die Methode <code>error</code> wird bei Auftreten eines Fehlers vom
     * Sax-Parser aufgerufen.
     *
     * @param oops <code>SAXParseException</code>
     */
    public void error(SAXParseException oops) {

        if (first == true) {
            printHeader();
            first = false;
        }
        
        errors++;
        print(errorPrefix, oops);
    }

    /**
     * Die Methode <code>fatalError</code> wird bei Auftreten eines fatalen
     * Fehlers vom Sax-Parser aufgerufen.
     *
     * @param oops <code>SAXParseException</code>
     */
    public void fatalError(SAXParseException oops) {

        if (first == true) {
            printHeader();
            first = false;
        }

        print(fatalPrefix, oops);
    }

    /**
     * Die Methode <code>warning</code> wird bei Auftreten einer Warnung vom
     * SAX-Parser aufgerufen.
     *
     * @param oops <code>SAXParseException</code>
     */
    public void warning(SAXParseException oops) {

        if (first == true) {
            printHeader();
            first = false;
        }
        
        print(warnPrefix, oops);
    }

    /**
     * Die Methode <code>printHeader</code> schreibt den Kopf einer
     * Fehlermeldung nach <code>System.err</code>.
     *
     */
    private void printHeader() {
        
        System.err.println("\nValidation Error(s):");
        System.err.println("Source: " + source.getAbsolutePath());

    }

    /**
     * Die Methode <code>print</code> schreibt eine Fehlermeldung nach
     * <code>System.err</code>.
     *
     * @param prefix <code>String</code>
     * @param oops <code>SAXParseException</code>
     */
    private void print(String prefix, SAXParseException oops) {

        String line = prefix + " " 
            + source.getAbsolutePath() + ":"
            + oops.getLineNumber() + ","
            + oops.getColumnNumber() + " "
            + oops.getMessage();

        System.err.println(line);
    }
}
