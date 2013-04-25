package org.dbdoclet.svg;

public class Connection {

    private Activity from;
    private Activity to;
    private String id;
    private String text;

    public Connection(String id, Activity from, Activity to, String text) {
	
	this.id = id;
	this.from = from;
	this.to = to;
	this.text = text;
    }

    public Activity getFrom() {
        return from;
    }
    
    public String getId() {
        return id;
    }
    
    public String getText() {
        return text;
    }
    
    public Activity getTo() {
        return to;
    }
    
    public void setFrom(Activity from) {
        this.from = from;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public void setTo(Activity to) {
        this.to = to;
    }

    public String toString() {

	String delim = ",";

	StringBuilder buffer = new StringBuilder();

	buffer.append("Connection:=[");
	buffer.append("id=");
	buffer.append(getId());
	buffer.append(delim);
	buffer.append("from=");
	buffer.append(getFrom());
	buffer.append(delim);
	buffer.append("to=");
	buffer.append(getTo());
	buffer.append(delim);
	buffer.append("text=");
	buffer.append(getText());
	buffer.append("]");

	return buffer.toString();
    }
}
