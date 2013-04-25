package org.dbdoclet.xsd;

import java.util.ArrayList;
import java.util.Random;

public class XsdMetaData {

    private ArrayList<String> enumList;
    private String importNamespace;
    private Integer maxLength;
    private String maxOccurs;

	private String minOccurs;
    private String type;
	private ContentModel contentModel;
	
    public void addEnumeration(String enumValue) {

        if (enumValue == null) {
            return;
        }

        if (enumList == null) {
            enumList = new ArrayList<String>();
        }

        enumList.add(enumValue);
    }

	public ContentModel getContentModel() {
		return contentModel;
	}

    public String getEnum(int index) {
        
        if (enumList != null && enumList.size() > index) {
            return enumList.get(index);
        }
        return null;
    }

    public ArrayList<String> getEnumList() {
		return enumList;
	}

    public String getImportNamespace() {
        return importNamespace;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public String getMaxOccurs() {
        return maxOccurs;
    }

    public String getMinOccurs() {
        return minOccurs;
    }

    public String getRandomEnum() {

        if (enumList == null || enumList.size() == 0) {
            return null;
        }
        
        Random rand = new Random();
        return enumList.get(rand.nextInt(enumList.size()));
    }

    public String getType() {
        return type;
    }

    public boolean isEnum() {

        if (enumList != null && enumList.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isOptional() {

        if (minOccurs != null) {
            
            try {
                
                int min = Integer.parseInt(minOccurs);
                
                if (min == 0) {
                    return true;
                }
                
            } catch (NumberFormatException oops) {
                // Keine Zahl
            }
        }
        
        return false;
    }

    public void setContentModel(ContentModel contentModel) {
		this.contentModel = contentModel;
	}

    public void setImportNamespace(String importNamespace) {
        this.importNamespace = importNamespace;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    public void setMaxOccurs(String maxOccurs) {
        this.maxOccurs = maxOccurs;
    }

    public void setMinOccurs(String minOccurs) {
        this.minOccurs = minOccurs;
    }

	public void setType(String type) {
        this.type = type;
    }
}
