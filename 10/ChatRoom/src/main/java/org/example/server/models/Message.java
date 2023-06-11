package org.example.server.models;

import java.util.Date;
public class Message {
    private String id;
    private String text;
    private Date date;

    public Message(String text) {
        this.text = text;
        this.date = new Date();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
    }
}