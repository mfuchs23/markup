/* Generated By:JJTree&JavaCC: Do not edit this line. HtmlTokenizerConstants.java */
package org.dbdoclet.html.tokenizer.parser;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface HtmlTokenizerConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int TAG_START = 8;
  /** RegularExpression Id. */
  int QUOTE = 9;
  /** RegularExpression Id. */
  int TEXT = 10;
  /** RegularExpression Id. */
  int TAG_END = 16;
  /** RegularExpression Id. */
  int EQUALS = 17;
  /** RegularExpression Id. */
  int SLASH = 18;
  /** RegularExpression Id. */
  int NCNAME = 19;
  /** RegularExpression Id. */
  int VALUE = 20;
  /** RegularExpression Id. */
  int COMMENT = 22;
  /** RegularExpression Id. */
  int DIGIT = 23;
  /** RegularExpression Id. */
  int LETTER = 24;
  /** RegularExpression Id. */
  int WHITESPACE = 25;
  /** RegularExpression Id. */
  int NAME_START_CHAR = 26;
  /** RegularExpression Id. */
  int TEXT_AFTER_GT = 27;
  /** RegularExpression Id. */
  int NAME_CHAR = 28;
  /** RegularExpression Id. */
  int NAME = 29;

  /** Lexical state. */
  int DEFAULT = 0;
  /** Lexical state. */
  int WithinIgnorable = 1;
  /** Lexical state. */
  int TAG_CONTEXT = 2;
  /** Lexical state. */
  int COMMENT_CONTEXT = 3;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\r\"",
    "\"\\t\"",
    "\"\\n\"",
    "<token of kind 5>",
    "<token of kind 6>",
    "<token of kind 7>",
    "\"<\"",
    "<QUOTE>",
    "<TEXT>",
    "\"<!--\"",
    "\" \"",
    "\"\\r\"",
    "\"\\t\"",
    "\"\\n\"",
    "\">\"",
    "\"=\"",
    "\"/\"",
    "<NCNAME>",
    "<VALUE>",
    "<token of kind 21>",
    "\"-->\"",
    "<DIGIT>",
    "<LETTER>",
    "<WHITESPACE>",
    "<NAME_START_CHAR>",
    "<TEXT_AFTER_GT>",
    "<NAME_CHAR>",
    "<NAME>",
  };

}
