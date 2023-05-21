package models;

import java.io.Serializable;
import java.util.Date;

public class Note implements Serializable {
    private String name;
    private String text;
    private Date date; 

    public Note(String name, String text, Date date) {
        this.name = name;
        this.text = text;
        this.date = date;
    }

    public String getName() { return name; }
    public String getText() { return text; }
    public Date getDate() { return date; }

    public void setName(String name) { this.name = name; }
    public void setText(String text) { this.text = text; }
    public void setDate(Date date) { this.date = date; }

    @Override
    public String toString() {
        return "Name: " + name + "\nText: " + text + "\nDate: " + date;
    }
}