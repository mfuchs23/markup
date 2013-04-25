/* 
 * $Id$
 *
 * ### Copyright (C) 2006 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.xiphias.dom;

import org.w3c.dom.Comment;

public class CommentImpl extends CharacterDataImpl implements Comment {

    public CommentImpl(String text) {
        this(text, null);
    }

    public CommentImpl(String text, NodeImpl parent) {
	
        setNodeType(COMMENT_NODE);
        setNodeName("#comment");
        setData(text);
        setParentNode(parent);
    }
}
