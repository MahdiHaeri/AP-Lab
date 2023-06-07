package org.example.server.data_access;

import org.example.server.models.*;

import javax.swing.*;
import java.util.ArrayList;

public class MessageDAO {
    ArrayList<Message> messages;

    public MessageDAO() {
        messages = new ArrayList<Message>();
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public void removeMessage(Message message) {
        messages.remove(message);
    }

    public Message getMessage(String id) {
        for (Message message : messages) {
            if (message.getId().equals(id)) {
                return message;
            }
        }

        return null;
    }
}
