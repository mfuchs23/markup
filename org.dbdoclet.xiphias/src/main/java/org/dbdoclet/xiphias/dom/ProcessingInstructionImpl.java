/* 
 * ### Copyright (C) 2005-2007 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.xiphias.dom;

import org.w3c.dom.DOMException;
import org.w3c.dom.ProcessingInstruction;


public class ProcessingInstructionImpl extends NodeImpl implements ProcessingInstruction {

    private String target;
    private String data;
    
    public ProcessingInstructionImpl(String target, String data) {

        if (target == null) {
            throw new IllegalArgumentException("The argument target must not be null!");
        }

        if (data == null) {
            throw new IllegalArgumentException("The argument data must not be null!");
        }

        setNodeName("@processing-instruction@");
        setNodeType(PROCESSING_INSTRUCTION_NODE);

        this.target = target.trim();
        this.data = data.trim();
    }

    public String getData() {
        return data;
    }

    public String getTarget() {
        return target;
    }

    public void setData(String data) throws DOMException {
       this.data = data;        
    }
}
