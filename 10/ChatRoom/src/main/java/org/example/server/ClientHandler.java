package org.example.server;

import java.io.*;
import java.net.Socket;

import org.example.server.models.Message;
import org.example.server.models.User;

public class ClientHandler implements Runnable {
    private static Socket socket;
    private User user;
    private InputStream inputStream;
    private OutputStream outputStream;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;

    private User admin;

    public ClientHandler(Socket socket, User admin) {
        this.socket = socket;
        try {
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectInputStream = new ObjectInputStream(inputStream);
            this.admin = admin;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void run() {
        while (true) {
            Message message = readMessage();
            System.out.println("Message received from " + message.getUser().getUsername() + ": " + message.getText());
            Server.broadcastMessage(message);
        }
    }

    public void sendMessage(Message message) {
        try {
            objectOutputStream.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Message readMessage() {
        try {
            return (Message) objectInputStream.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public User getUser() {
        return user;
    }
}
