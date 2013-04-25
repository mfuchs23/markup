// $ANTLR 3.4 /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g 2012-03-30 15:02:10

package org.dbdoclet.css.parser.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class CSSParser extends Parser {
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
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public CSSParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public CSSParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return CSSParser.tokenNames; }
    public String getGrammarFileName() { return "/home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g"; }


    public static class parse_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "parse"
    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:21:1: parse : ( rule )+ EOF ;
    public final CSSParser.parse_return parse() throws RecognitionException {
        CSSParser.parse_return retval = new CSSParser.parse_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token EOF2=null;
        CSSParser.rule_return rule1 =null;


        Object EOF2_tree=null;

        try {
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:22:2: ( ( rule )+ EOF )
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:22:4: ( rule )+ EOF
            {
            root_0 = (Object)adaptor.nil();


            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:22:4: ( rule )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= UNIVERSAL_SELECTOR && LA1_0 <= WORD)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:22:4: rule
            	    {
            	    pushFollow(FOLLOW_rule_in_parse57);
            	    rule1=rule();

            	    state._fsp--;

            	    adaptor.addChild(root_0, rule1.getTree());

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


            EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_parse60); 
            EOF2_tree = 
            (Object)adaptor.create(EOF2)
            ;
            adaptor.addChild(root_0, EOF2_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "parse"


    public static class rule_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rule"
    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:24:1: rule : selector '{' ( property )* '}' -> ^( RULE selector ( property )* ) ;
    public final CSSParser.rule_return rule() throws RecognitionException {
        CSSParser.rule_return retval = new CSSParser.rule_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal4=null;
        Token char_literal6=null;
        CSSParser.selector_return selector3 =null;

        CSSParser.property_return property5 =null;


        Object char_literal4_tree=null;
        Object char_literal6_tree=null;
        RewriteRuleTokenStream stream_21=new RewriteRuleTokenStream(adaptor,"token 21");
        RewriteRuleTokenStream stream_22=new RewriteRuleTokenStream(adaptor,"token 22");
        RewriteRuleSubtreeStream stream_selector=new RewriteRuleSubtreeStream(adaptor,"rule selector");
        RewriteRuleSubtreeStream stream_property=new RewriteRuleSubtreeStream(adaptor,"rule property");
        try {
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:24:5: ( selector '{' ( property )* '}' -> ^( RULE selector ( property )* ) )
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:25:2: selector '{' ( property )* '}'
            {
            pushFollow(FOLLOW_selector_in_rule70);
            selector3=selector();

            state._fsp--;

            stream_selector.add(selector3.getTree());

            char_literal4=(Token)match(input,21,FOLLOW_21_in_rule72);  
            stream_21.add(char_literal4);


            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:25:15: ( property )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==WORD) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:25:15: property
            	    {
            	    pushFollow(FOLLOW_property_in_rule74);
            	    property5=property();

            	    state._fsp--;

            	    stream_property.add(property5.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            char_literal6=(Token)match(input,22,FOLLOW_22_in_rule77);  
            stream_22.add(char_literal6);


            // AST REWRITE
            // elements: property, selector
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 25:29: -> ^( RULE selector ( property )* )
            {
                // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:25:32: ^( RULE selector ( property )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(RULE, "RULE")
                , root_1);

                adaptor.addChild(root_1, stream_selector.nextTree());

                // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:25:48: ( property )*
                while ( stream_property.hasNext() ) {
                    adaptor.addChild(root_1, stream_property.nextTree());

                }
                stream_property.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rule"


    public static class selector_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "selector"
    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:27:1: selector : ( ( WORD )+ -> ^( SELECTOR ( WORD )+ ) | UNIVERSAL_SELECTOR -> ^( SELECTOR UNIVERSAL_SELECTOR ) );
    public final CSSParser.selector_return selector() throws RecognitionException {
        CSSParser.selector_return retval = new CSSParser.selector_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token WORD7=null;
        Token UNIVERSAL_SELECTOR8=null;

        Object WORD7_tree=null;
        Object UNIVERSAL_SELECTOR8_tree=null;
        RewriteRuleTokenStream stream_WORD=new RewriteRuleTokenStream(adaptor,"token WORD");
        RewriteRuleTokenStream stream_UNIVERSAL_SELECTOR=new RewriteRuleTokenStream(adaptor,"token UNIVERSAL_SELECTOR");

        try {
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:28:2: ( ( WORD )+ -> ^( SELECTOR ( WORD )+ ) | UNIVERSAL_SELECTOR -> ^( SELECTOR UNIVERSAL_SELECTOR ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==WORD) ) {
                alt4=1;
            }
            else if ( (LA4_0==UNIVERSAL_SELECTOR) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:28:4: ( WORD )+
                    {
                    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:28:4: ( WORD )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==WORD) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:28:4: WORD
                    	    {
                    	    WORD7=(Token)match(input,WORD,FOLLOW_WORD_in_selector98);  
                    	    stream_WORD.add(WORD7);


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


                    // AST REWRITE
                    // elements: WORD
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 28:10: -> ^( SELECTOR ( WORD )+ )
                    {
                        // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:28:13: ^( SELECTOR ( WORD )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(SELECTOR, "SELECTOR")
                        , root_1);

                        if ( !(stream_WORD.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_WORD.hasNext() ) {
                            adaptor.addChild(root_1, 
                            stream_WORD.nextNode()
                            );

                        }
                        stream_WORD.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:29:5: UNIVERSAL_SELECTOR
                    {
                    UNIVERSAL_SELECTOR8=(Token)match(input,UNIVERSAL_SELECTOR,FOLLOW_UNIVERSAL_SELECTOR_in_selector114);  
                    stream_UNIVERSAL_SELECTOR.add(UNIVERSAL_SELECTOR8);


                    // AST REWRITE
                    // elements: UNIVERSAL_SELECTOR
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 29:24: -> ^( SELECTOR UNIVERSAL_SELECTOR )
                    {
                        // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:29:27: ^( SELECTOR UNIVERSAL_SELECTOR )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(SELECTOR, "SELECTOR")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_UNIVERSAL_SELECTOR.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "selector"


    public static class property_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "property"
    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:31:1: property : propertyName ':' propertyValue ';' -> ^( PROPERTY propertyName propertyValue ) ;
    public final CSSParser.property_return property() throws RecognitionException {
        CSSParser.property_return retval = new CSSParser.property_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal10=null;
        Token char_literal12=null;
        CSSParser.propertyName_return propertyName9 =null;

        CSSParser.propertyValue_return propertyValue11 =null;


        Object char_literal10_tree=null;
        Object char_literal12_tree=null;
        RewriteRuleTokenStream stream_20=new RewriteRuleTokenStream(adaptor,"token 20");
        RewriteRuleTokenStream stream_19=new RewriteRuleTokenStream(adaptor,"token 19");
        RewriteRuleSubtreeStream stream_propertyName=new RewriteRuleSubtreeStream(adaptor,"rule propertyName");
        RewriteRuleSubtreeStream stream_propertyValue=new RewriteRuleSubtreeStream(adaptor,"rule propertyValue");
        try {
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:31:9: ( propertyName ':' propertyValue ';' -> ^( PROPERTY propertyName propertyValue ) )
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:31:11: propertyName ':' propertyValue ';'
            {
            pushFollow(FOLLOW_propertyName_in_property130);
            propertyName9=propertyName();

            state._fsp--;

            stream_propertyName.add(propertyName9.getTree());

            char_literal10=(Token)match(input,19,FOLLOW_19_in_property132);  
            stream_19.add(char_literal10);


            pushFollow(FOLLOW_propertyValue_in_property134);
            propertyValue11=propertyValue();

            state._fsp--;

            stream_propertyValue.add(propertyValue11.getTree());

            char_literal12=(Token)match(input,20,FOLLOW_20_in_property136);  
            stream_20.add(char_literal12);


            // AST REWRITE
            // elements: propertyName, propertyValue
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 31:46: -> ^( PROPERTY propertyName propertyValue )
            {
                // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:31:49: ^( PROPERTY propertyName propertyValue )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(PROPERTY, "PROPERTY")
                , root_1);

                adaptor.addChild(root_1, stream_propertyName.nextTree());

                adaptor.addChild(root_1, stream_propertyValue.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "property"


    public static class propertyName_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "propertyName"
    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:33:1: propertyName : WORD ;
    public final CSSParser.propertyName_return propertyName() throws RecognitionException {
        CSSParser.propertyName_return retval = new CSSParser.propertyName_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token WORD13=null;

        Object WORD13_tree=null;

        try {
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:34:2: ( WORD )
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:34:4: WORD
            {
            root_0 = (Object)adaptor.nil();


            WORD13=(Token)match(input,WORD,FOLLOW_WORD_in_propertyName155); 
            WORD13_tree = 
            (Object)adaptor.create(WORD13)
            ;
            adaptor.addChild(root_0, WORD13_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "propertyName"


    public static class propertyValue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "propertyValue"
    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:37:1: propertyValue : ( WORD )+ ;
    public final CSSParser.propertyValue_return propertyValue() throws RecognitionException {
        CSSParser.propertyValue_return retval = new CSSParser.propertyValue_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token WORD14=null;

        Object WORD14_tree=null;

        try {
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:38:2: ( ( WORD )+ )
            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:38:4: ( WORD )+
            {
            root_0 = (Object)adaptor.nil();


            // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:38:4: ( WORD )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==WORD) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /home/michael/Werkbank/xmleditor/org.dbdoclet.css/src/main/java/org/dbdoclet/css/parser/antlr/CSS.g:38:4: WORD
            	    {
            	    WORD14=(Token)match(input,WORD,FOLLOW_WORD_in_propertyValue167); 
            	    WORD14_tree = 
            	    (Object)adaptor.create(WORD14)
            	    ;
            	    adaptor.addChild(root_0, WORD14_tree);


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


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "propertyValue"

    // Delegated rules


 

    public static final BitSet FOLLOW_rule_in_parse57 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_EOF_in_parse60 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selector_in_rule70 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_rule72 = new BitSet(new long[]{0x0000000000420000L});
    public static final BitSet FOLLOW_property_in_rule74 = new BitSet(new long[]{0x0000000000420000L});
    public static final BitSet FOLLOW_22_in_rule77 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WORD_in_selector98 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_UNIVERSAL_SELECTOR_in_selector114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyName_in_property130 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_property132 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_propertyValue_in_property134 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_property136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WORD_in_propertyName155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WORD_in_propertyValue167 = new BitSet(new long[]{0x0000000000020002L});

}