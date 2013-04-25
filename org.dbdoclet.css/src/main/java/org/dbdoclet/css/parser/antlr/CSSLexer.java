// $ANTLR 3.4 /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g 2012-03-30 15:02:10

package org.dbdoclet.css.parser.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class CSSLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int CHAR=4;
    public static final int COMMENT=5;
    public static final int ESC_SEQ=6;
    public static final int EXPONENT=7;
    public static final int FLOAT=8;
    public static final int HEX_DIGIT=9;
    public static final int OCTAL_ESC=10;
    public static final int PROPERTY=11;
    public static final int RULE=12;
    public static final int SELECTOR=13;
    public static final int STRING=14;
    public static final int UNICODE_ESC=15;
    public static final int UNIVERSAL_SELECTOR=16;
    public static final int WORD=17;
    public static final int WS=18;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public CSSLexer() {} 
    public CSSLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public CSSLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g"; }

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:6:7: ( ':' )
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:6:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:7:7: ( ';' )
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:7:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:8:7: ( '{' )
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:8:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:9:7: ( '}' )
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:9:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "UNIVERSAL_SELECTOR"
    public final void mUNIVERSAL_SELECTOR() throws RecognitionException {
        try {
            int _type = UNIVERSAL_SELECTOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:40:20: ( '\\u002A' )
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:40:22: '\\u002A'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UNIVERSAL_SELECTOR"

    // $ANTLR start "WORD"
    public final void mWORD() throws RecognitionException {
        try {
            int _type = WORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:41:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '-' )+ )
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:41:7: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '-' )+
            {
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:41:7: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '-' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='-'||(LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:
            	    {
            	    if ( input.LA(1)=='-'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WORD"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:45:5: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? | '.' ( '0' .. '9' )+ ( EXPONENT )? | ( '0' .. '9' )+ EXPONENT )
            int alt8=3;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:45:9: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )?
                    {
                    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:45:9: ( '0' .. '9' )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt2 >= 1 ) break loop2;
                                EarlyExitException eee =
                                    new EarlyExitException(2, input);
                                throw eee;
                        }
                        cnt2++;
                    } while (true);


                    match('.'); 

                    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:45:25: ( '0' .. '9' )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:45:37: ( EXPONENT )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0=='E'||LA4_0=='e') ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:45:37: EXPONENT
                            {
                            mEXPONENT(); 


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:46:9: '.' ( '0' .. '9' )+ ( EXPONENT )?
                    {
                    match('.'); 

                    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:46:13: ( '0' .. '9' )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt5 >= 1 ) break loop5;
                                EarlyExitException eee =
                                    new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);


                    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:46:25: ( EXPONENT )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='E'||LA6_0=='e') ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:46:25: EXPONENT
                            {
                            mEXPONENT(); 


                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:47:9: ( '0' .. '9' )+ EXPONENT
                    {
                    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:47:9: ( '0' .. '9' )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);


                    mEXPONENT(); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:51:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='/') ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1=='/') ) {
                    alt12=1;
                }
                else if ( (LA12_1=='*') ) {
                    alt12=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }
            switch (alt12) {
                case 1 :
                    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:51:9: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
                    {
                    match("//"); 



                    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:51:14: (~ ( '\\n' | '\\r' ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0 >= '\u0000' && LA9_0 <= '\t')||(LA9_0 >= '\u000B' && LA9_0 <= '\f')||(LA9_0 >= '\u000E' && LA9_0 <= '\uFFFF')) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:
                    	    {
                    	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:51:28: ( '\\r' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='\r') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:51:28: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    _channel=HIDDEN;

                    }
                    break;
                case 2 :
                    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:52:9: '/*' ( options {greedy=false; } : . )* '*/'
                    {
                    match("/*"); 



                    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:52:14: ( options {greedy=false; } : . )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0=='*') ) {
                            int LA11_1 = input.LA(2);

                            if ( (LA11_1=='/') ) {
                                alt11=2;
                            }
                            else if ( ((LA11_1 >= '\u0000' && LA11_1 <= '.')||(LA11_1 >= '0' && LA11_1 <= '\uFFFF')) ) {
                                alt11=1;
                            }


                        }
                        else if ( ((LA11_0 >= '\u0000' && LA11_0 <= ')')||(LA11_0 >= '+' && LA11_0 <= '\uFFFF')) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:52:42: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    match("*/"); 



                    _channel=HIDDEN;

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:55:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:55:9: ( ' ' | '\\t' | '\\r' | '\\n' )
            {
            if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:63:5: ( '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"' )
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:63:8: '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 

            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:63:12: ( ESC_SEQ |~ ( '\\\\' | '\"' ) )*
            loop13:
            do {
                int alt13=3;
                int LA13_0 = input.LA(1);

                if ( (LA13_0=='\\') ) {
                    alt13=1;
                }
                else if ( ((LA13_0 >= '\u0000' && LA13_0 <= '!')||(LA13_0 >= '#' && LA13_0 <= '[')||(LA13_0 >= ']' && LA13_0 <= '\uFFFF')) ) {
                    alt13=2;
                }


                switch (alt13) {
            	case 1 :
            	    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:63:14: ESC_SEQ
            	    {
            	    mESC_SEQ(); 


            	    }
            	    break;
            	case 2 :
            	    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:63:24: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "CHAR"
    public final void mCHAR() throws RecognitionException {
        try {
            int _type = CHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:66:5: ( '\\'' ( ESC_SEQ |~ ( '\\'' | '\\\\' ) ) '\\'' )
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:66:8: '\\'' ( ESC_SEQ |~ ( '\\'' | '\\\\' ) ) '\\''
            {
            match('\''); 

            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:66:13: ( ESC_SEQ |~ ( '\\'' | '\\\\' ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='\\') ) {
                alt14=1;
            }
            else if ( ((LA14_0 >= '\u0000' && LA14_0 <= '&')||(LA14_0 >= '(' && LA14_0 <= '[')||(LA14_0 >= ']' && LA14_0 <= '\uFFFF')) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }
            switch (alt14) {
                case 1 :
                    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:66:15: ESC_SEQ
                    {
                    mESC_SEQ(); 


                    }
                    break;
                case 2 :
                    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:66:25: ~ ( '\\'' | '\\\\' )
                    {
                    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CHAR"

    // $ANTLR start "EXPONENT"
    public final void mEXPONENT() throws RecognitionException {
        try {
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:71:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:71:12: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:71:22: ( '+' | '-' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='+'||LA15_0=='-') ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:71:33: ( '0' .. '9' )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0 >= '0' && LA16_0 <= '9')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EXPONENT"

    // $ANTLR start "HEX_DIGIT"
    public final void mHEX_DIGIT() throws RecognitionException {
        try {
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:74:11: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HEX_DIGIT"

    // $ANTLR start "ESC_SEQ"
    public final void mESC_SEQ() throws RecognitionException {
        try {
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:78:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | OCTAL_ESC )
            int alt17=3;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='\\') ) {
                switch ( input.LA(2) ) {
                case '\"':
                case '\'':
                case '\\':
                case 'b':
                case 'f':
                case 'n':
                case 'r':
                case 't':
                    {
                    alt17=1;
                    }
                    break;
                case 'u':
                    {
                    alt17=2;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    {
                    alt17=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;

                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }
            switch (alt17) {
                case 1 :
                    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:78:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    {
                    match('\\'); 

                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:79:9: UNICODE_ESC
                    {
                    mUNICODE_ESC(); 


                    }
                    break;
                case 3 :
                    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:80:9: OCTAL_ESC
                    {
                    mOCTAL_ESC(); 


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ESC_SEQ"

    // $ANTLR start "OCTAL_ESC"
    public final void mOCTAL_ESC() throws RecognitionException {
        try {
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:85:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt18=3;
            int LA18_0 = input.LA(1);

            if ( (LA18_0=='\\') ) {
                int LA18_1 = input.LA(2);

                if ( ((LA18_1 >= '0' && LA18_1 <= '3')) ) {
                    int LA18_2 = input.LA(3);

                    if ( ((LA18_2 >= '0' && LA18_2 <= '7')) ) {
                        int LA18_4 = input.LA(4);

                        if ( ((LA18_4 >= '0' && LA18_4 <= '7')) ) {
                            alt18=1;
                        }
                        else {
                            alt18=2;
                        }
                    }
                    else {
                        alt18=3;
                    }
                }
                else if ( ((LA18_1 >= '4' && LA18_1 <= '7')) ) {
                    int LA18_3 = input.LA(3);

                    if ( ((LA18_3 >= '0' && LA18_3 <= '7')) ) {
                        alt18=2;
                    }
                    else {
                        alt18=3;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;

            }
            switch (alt18) {
                case 1 :
                    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:85:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '3') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:86:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 3 :
                    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:87:9: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OCTAL_ESC"

    // $ANTLR start "UNICODE_ESC"
    public final void mUNICODE_ESC() throws RecognitionException {
        try {
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:92:5: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:92:9: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
            {
            match('\\'); 

            match('u'); 

            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UNICODE_ESC"

    public void mTokens() throws RecognitionException {
        // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:1:8: ( T__19 | T__20 | T__21 | T__22 | UNIVERSAL_SELECTOR | WORD | FLOAT | COMMENT | WS | STRING | CHAR )
        int alt19=11;
        alt19 = dfa19.predict(input);
        switch (alt19) {
            case 1 :
                // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:1:10: T__19
                {
                mT__19(); 


                }
                break;
            case 2 :
                // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:1:16: T__20
                {
                mT__20(); 


                }
                break;
            case 3 :
                // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:1:22: T__21
                {
                mT__21(); 


                }
                break;
            case 4 :
                // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:1:28: T__22
                {
                mT__22(); 


                }
                break;
            case 5 :
                // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:1:34: UNIVERSAL_SELECTOR
                {
                mUNIVERSAL_SELECTOR(); 


                }
                break;
            case 6 :
                // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:1:53: WORD
                {
                mWORD(); 


                }
                break;
            case 7 :
                // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:1:58: FLOAT
                {
                mFLOAT(); 


                }
                break;
            case 8 :
                // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:1:64: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 9 :
                // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:1:72: WS
                {
                mWS(); 


                }
                break;
            case 10 :
                // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:1:75: STRING
                {
                mSTRING(); 


                }
                break;
            case 11 :
                // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:1:82: CHAR
                {
                mCHAR(); 


                }
                break;

        }

    }


    protected DFA8 dfa8 = new DFA8(this);
    protected DFA19 dfa19 = new DFA19(this);
    static final String DFA8_eotS =
        "\5\uffff";
    static final String DFA8_eofS =
        "\5\uffff";
    static final String DFA8_minS =
        "\2\56\3\uffff";
    static final String DFA8_maxS =
        "\1\71\1\145\3\uffff";
    static final String DFA8_acceptS =
        "\2\uffff\1\2\1\1\1\3";
    static final String DFA8_specialS =
        "\5\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\3\1\uffff\12\1\13\uffff\1\4\37\uffff\1\4",
            "",
            "",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "44:1: FLOAT : ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? | '.' ( '0' .. '9' )+ ( EXPONENT )? | ( '0' .. '9' )+ EXPONENT );";
        }
    }
    static final String DFA19_eotS =
        "\6\uffff\1\7\6\uffff\3\7";
    static final String DFA19_eofS =
        "\20\uffff";
    static final String DFA19_minS =
        "\1\11\5\uffff\1\56\6\uffff\1\53\2\60";
    static final String DFA19_maxS =
        "\1\175\5\uffff\1\145\6\uffff\3\71";
    static final String DFA19_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\6\1\7\1\10\1\11\1\12\1\13"+
        "\3\uffff";
    static final String DFA19_specialS =
        "\20\uffff}>";
    static final String[] DFA19_transitionS = {
            "\2\12\2\uffff\1\12\22\uffff\1\12\1\uffff\1\13\4\uffff\1\14\2"+
            "\uffff\1\5\2\uffff\1\7\1\10\1\11\12\6\1\1\1\2\5\uffff\32\7\6"+
            "\uffff\32\7\1\3\1\uffff\1\4",
            "",
            "",
            "",
            "",
            "",
            "\1\10\1\uffff\12\6\13\uffff\1\15\37\uffff\1\15",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\10\1\uffff\1\16\2\uffff\12\17",
            "\12\17",
            "\12\17"
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__19 | T__20 | T__21 | T__22 | UNIVERSAL_SELECTOR | WORD | FLOAT | COMMENT | WS | STRING | CHAR );";
        }
    }
 

}