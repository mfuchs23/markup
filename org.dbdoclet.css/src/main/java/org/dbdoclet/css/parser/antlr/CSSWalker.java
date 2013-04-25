// $ANTLR 3.4 /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSSWalker.g 2012-03-30 15:49:26

package org.dbdoclet.css.parser.antlr;

import java.util.*;
import org.antlr.runtime.BitSet;
import org.dbdoclet.css.*;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class CSSWalker extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CHAR", "COMMENT", "ESC_SEQ", "EXPONENT", "FLOAT", "HEX_DIGIT", "OCTAL_ESC", "PROPERTY", "RULE", "SELECTOR", "STRING", "UNICODE_ESC", "UNIVERSAL_SELECTOR", "WORD", "WS", "':'", "';'", "'{'", "'}'"
    };

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
    public TreeParser[] getDelegates() {
        return new TreeParser[] {};
    }

    // delegators


    public CSSWalker(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public CSSWalker(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return CSSWalker.tokenNames; }
    public String getGrammarFileName() { return "/home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSSWalker.g"; }


    	HashMap<CssSelector, ArrayList<CssProperty<?>>> ruleMap = new HashMap<CssSelector, ArrayList<CssProperty<?>>>();



    // $ANTLR start "parse"
    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSSWalker.g:20:1: parse returns [HashMap<CssSelector, ArrayList<CssProperty<?>>> map] : ( rule )+ EOF ;
    public final HashMap<CssSelector, ArrayList<CssProperty<?>>> parse() throws RecognitionException {
        HashMap<CssSelector, ArrayList<CssProperty<?>>> map = null;


        try {
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSSWalker.g:21:3: ( ( rule )+ EOF )
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSSWalker.g:21:3: ( rule )+ EOF
            {
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSSWalker.g:21:3: ( rule )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSSWalker.g:21:3: rule
            	    {
            	    pushFollow(FOLLOW_rule_in_parse50);
            	    rule();

            	    state._fsp--;


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


            match(input,EOF,FOLLOW_EOF_in_parse53); 


            	map = ruleMap;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return map;
    }
    // $ANTLR end "parse"



    // $ANTLR start "rule"
    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSSWalker.g:26:1: rule : ^( RULE s= selector (p= property )* ) ;
    public final void rule() throws RecognitionException {
        CssSelector s =null;

        CssProperty p =null;



        	ArrayList<CssProperty<?>> propertyList = new ArrayList<CssProperty<?>>();

        try {
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSSWalker.g:30:3: ( ^( RULE s= selector (p= property )* ) )
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSSWalker.g:30:3: ^( RULE s= selector (p= property )* )
            {
            match(input,RULE,FOLLOW_RULE_in_rule69); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_selector_in_rule73);
            s=selector();

            state._fsp--;


            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSSWalker.g:30:21: (p= property )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==PROPERTY) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSSWalker.g:30:22: p= property
            	    {
            	    pushFollow(FOLLOW_property_in_rule78);
            	    p=property();

            	    state._fsp--;


            	     propertyList.add(p); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            match(input, Token.UP, null); 



            	ruleMap.put(s, propertyList);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "rule"



    // $ANTLR start "selector"
    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSSWalker.g:35:1: selector returns [CssSelector selector] : ^( SELECTOR (s+= ( WORD | UNIVERSAL_SELECTOR ) )+ ) ;
    public final CssSelector selector() throws RecognitionException {
        CssSelector selector = null;


        CommonTree s=null;
        List list_s=null;

        try {
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSSWalker.g:36:2: ( ^( SELECTOR (s+= ( WORD | UNIVERSAL_SELECTOR ) )+ ) )
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSSWalker.g:36:4: ^( SELECTOR (s+= ( WORD | UNIVERSAL_SELECTOR ) )+ )
            {
            match(input,SELECTOR,FOLLOW_SELECTOR_in_selector100); 

            match(input, Token.DOWN, null); 
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSSWalker.g:36:15: (s+= ( WORD | UNIVERSAL_SELECTOR ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= UNIVERSAL_SELECTOR && LA3_0 <= WORD)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSSWalker.g:36:16: s+= ( WORD | UNIVERSAL_SELECTOR )
            	    {
            	    s=(CommonTree)input.LT(1);

            	    if ( (input.LA(1) >= UNIVERSAL_SELECTOR && input.LA(1) <= WORD) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    if (list_s==null) list_s=new ArrayList();
            	    list_s.add(s);


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            match(input, Token.UP, null); 


             selector = new CssSelector(list_s); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return selector;
    }
    // $ANTLR end "selector"



    // $ANTLR start "property"
    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSSWalker.g:39:1: property returns [CssProperty property] : ^( PROPERTY (p+= WORD )+ ) ;
    public final CssProperty property() throws RecognitionException {
        CssProperty property = null;


        CommonTree p=null;
        List list_p=null;

        try {
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSSWalker.g:40:2: ( ^( PROPERTY (p+= WORD )+ ) )
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSSWalker.g:40:5: ^( PROPERTY (p+= WORD )+ )
            {
            match(input,PROPERTY,FOLLOW_PROPERTY_in_property131); 

            match(input, Token.DOWN, null); 
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSSWalker.g:40:16: (p+= WORD )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==WORD) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSSWalker.g:40:17: p+= WORD
            	    {
            	    p=(CommonTree)match(input,WORD,FOLLOW_WORD_in_property136); 
            	    if (list_p==null) list_p=new ArrayList();
            	    list_p.add(p);


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            match(input, Token.UP, null); 


             property = CssProperty.newInstance(list_p); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return property;
    }
    // $ANTLR end "property"

    // Delegated rules


 

    public static final BitSet FOLLOW_rule_in_parse50 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_EOF_in_parse53 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_in_rule69 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_selector_in_rule73 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_property_in_rule78 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_SELECTOR_in_selector100 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_set_in_selector105 = new BitSet(new long[]{0x0000000000030008L});
    public static final BitSet FOLLOW_PROPERTY_in_property131 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_WORD_in_property136 = new BitSet(new long[]{0x0000000000020008L});

}