package org.dbdoclet.xiphias.dom;

import org.w3c.dom.CharacterData;
import org.w3c.dom.DOMException;

public class CharacterDataImpl extends NodeImpl implements CharacterData {

    private String data;
    
    public void appendData(String arg) throws DOMException {
        // TODO Auto-generated method stub

    }

    public void deleteData(int offset, int count) throws DOMException {
        // TODO Auto-generated method stub

    }

    public String getData() throws DOMException {
        return data;
    }

    public int getLength() {
        // TODO Auto-generated method stub
        return 0;
    }

    public void insertData(int offset, String arg) throws DOMException {
        // TODO Auto-generated method stub

    }

    public void replaceData(int offset, int count, String arg) throws DOMException {
        // TODO Auto-generated method stub

    }

    public void setData(String data) throws DOMException {
        
    	this.data = data;
        setNodeValue(data);
    }

    public String substringData(int offset, int count) throws DOMException {
        // TODO Auto-generated method stub
        return null;
    }

}
