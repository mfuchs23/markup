/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3</a>, using an XML
 * Schema.
 * $Id$
 */

package org.dbdoclet.antol.ant;

/**
 * Class Doclet.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Doclet implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _name.
     */
    private java.lang.String _name;

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _paramList.
     */
    private java.util.List<org.dbdoclet.antol.ant.Param> _paramList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Doclet() {
        super();
        this._paramList = new java.util.ArrayList<org.dbdoclet.antol.ant.Param>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vParam
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addParam(
            final org.dbdoclet.antol.ant.Param vParam)
    throws java.lang.IndexOutOfBoundsException {
        this._paramList.add(vParam);
    }

    /**
     * 
     * 
     * @param index
     * @param vParam
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addParam(
            final int index,
            final org.dbdoclet.antol.ant.Param vParam)
    throws java.lang.IndexOutOfBoundsException {
        this._paramList.add(index, vParam);
    }

    /**
     * Method enumerateParam.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends org.dbdoclet.antol.ant.Param> enumerateParam(
    ) {
        return java.util.Collections.enumeration(this._paramList);
    }

    /**
     * Returns the value of field 'choiceValue'. The field
     * 'choiceValue' has the following description: Internal choice
     * value storage
     * 
     * @return the value of field 'ChoiceValue'.
     */
    public java.lang.Object getChoiceValue(
    ) {
        return this._choiceValue;
    }

    /**
     * Returns the value of field 'name'.
     * 
     * @return the value of field 'Name'.
     */
    public java.lang.String getName(
    ) {
        return this._name;
    }

    /**
     * Method getParam.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the org.dbdoclet.antol.ant.Param at the
     * given index
     */
    public org.dbdoclet.antol.ant.Param getParam(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._paramList.size()) {
            throw new IndexOutOfBoundsException("getParam: Index value '" + index + "' not in range [0.." + (this._paramList.size() - 1) + "]");
        }

        return (org.dbdoclet.antol.ant.Param) _paramList.get(index);
    }

    /**
     * Method getParam.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.dbdoclet.antol.ant.Param[] getParam(
    ) {
        org.dbdoclet.antol.ant.Param[] array = new org.dbdoclet.antol.ant.Param[0];
        return (org.dbdoclet.antol.ant.Param[]) this._paramList.toArray(array);
    }

    /**
     * Method getParamCount.
     * 
     * @return the size of this collection
     */
    public int getParamCount(
    ) {
        return this._paramList.size();
    }

    /**
     * Method isValid.
     * 
     * @return true if this object is valid according to the schema
     */
    public boolean isValid(
    ) {
        try {
            validate();
        } catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    }

    /**
     * Method iterateParam.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends org.dbdoclet.antol.ant.Param> iterateParam(
    ) {
        return this._paramList.iterator();
    }

    /**
     * 
     * 
     * @param out
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void marshal(
            final java.io.Writer out)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Marshaller.marshal(this, out);
    }

    /**
     * 
     * 
     * @param handler
     * @throws java.io.IOException if an IOException occurs during
     * marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     */
    public void marshal(
            final org.xml.sax.ContentHandler handler)
    throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Marshaller.marshal(this, handler);
    }

    /**
     */
    public void removeAllParam(
    ) {
        this._paramList.clear();
    }

    /**
     * Method removeParam.
     * 
     * @param vParam
     * @return true if the object was removed from the collection.
     */
    public boolean removeParam(
            final org.dbdoclet.antol.ant.Param vParam) {
        boolean removed = _paramList.remove(vParam);
        return removed;
    }

    /**
     * Method removeParamAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.dbdoclet.antol.ant.Param removeParamAt(
            final int index) {
        java.lang.Object obj = this._paramList.remove(index);
        return (org.dbdoclet.antol.ant.Param) obj;
    }

    /**
     * Sets the value of field 'name'.
     * 
     * @param name the value of field 'name'.
     */
    public void setName(
            final java.lang.String name) {
        this._name = name;
    }

    /**
     * 
     * 
     * @param index
     * @param vParam
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setParam(
            final int index,
            final org.dbdoclet.antol.ant.Param vParam)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._paramList.size()) {
            throw new IndexOutOfBoundsException("setParam: Index value '" + index + "' not in range [0.." + (this._paramList.size() - 1) + "]");
        }

        this._paramList.set(index, vParam);
    }

    /**
     * 
     * 
     * @param vParamArray
     */
    public void setParam(
            final org.dbdoclet.antol.ant.Param[] vParamArray) {
        //-- copy array
        _paramList.clear();

        for (int i = 0; i < vParamArray.length; i++) {
                this._paramList.add(vParamArray[i]);
        }
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled org.dbdoclet.antol.ant.Doclet
     */
    public static org.dbdoclet.antol.ant.Doclet unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.dbdoclet.antol.ant.Doclet) org.exolab.castor.xml.Unmarshaller.unmarshal(org.dbdoclet.antol.ant.Doclet.class, reader);
    }

    /**
     * 
     * 
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void validate(
    )
    throws org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    }

}
