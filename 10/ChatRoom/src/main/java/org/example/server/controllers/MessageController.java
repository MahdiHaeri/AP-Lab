package org.example.server.controllers;

import org.example.server.models.*;
import org.example.server.data_access.MessageDAO;

import java.util.Date;

public class MessageController {
    private final MessageDAO messageDAO;

    public MessageController() {
        messageDAO = new MessageDAO();
    }

    public void addMessage(String text) {
        Message message = new Message(text, new Date());
        messageDAO.addMessage(message);
    }

    public void removeMessage(String id) {
        messageDAO.removeMessage(getMessage(id));
    }

    public Message getMessage(String id) {
        return messageDAO.getMessage(id);
    }
}
