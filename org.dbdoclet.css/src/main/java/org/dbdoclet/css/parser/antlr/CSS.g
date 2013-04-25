grammar CSS;

options {
	output = AST;
}

tokens {
	PROPERTY;
	RULE;
	SELECTOR;
}

@header {
package org.dbdoclet.css.parser.antlr;
}

@lexer::header {
package org.dbdoclet.css.parser.antlr;
}

parse 
	: rule+ EOF;
	
rule:	
	selector '{' property* '}' -> ^(RULE selector property*);
	
selector
	:	WORD+ -> ^(SELECTOR WORD+)
		| UNIVERSAL_SELECTOR -> ^(SELECTOR UNIVERSAL_SELECTOR);	

property:	propertyName ':' propertyValue ';' -> ^(PROPERTY propertyName propertyValue);

propertyName
	:	WORD
	;
	
propertyValue
	:	WORD+;
	
UNIVERSAL_SELECTOR : '\u002A';
WORD: ('a'..'z'|'A'..'Z'|'0'..'9'|'-')+;


FLOAT
    :   ('0'..'9')+ '.' ('0'..'9')* EXPONENT?
    |   '.' ('0'..'9')+ EXPONENT?
    |   ('0'..'9')+ EXPONENT
    ;

COMMENT
    :   '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    |   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {$channel=HIDDEN;}
    ;

STRING
    :  '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
    ;

CHAR:  '\'' ( ESC_SEQ | ~('\''|'\\') ) '\''
    ;

fragment
EXPONENT : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;


