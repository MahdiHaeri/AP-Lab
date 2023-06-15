package org.example.server;

import org.example.server.models.*;
import org.example.server.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private static ArrayList<ClientHandler> clients = new ArrayList<>();
    private final static int port = 6000;

    public static void main(String[] args) {
        try {
            User admin = new User("Admin");
            ExecutorService excutorService = Executors.newFixedThreadPool(10);
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                ClientHandler clientHandler = new ClientHandler(socket, admin);
                clients.add(clientHandler);
                excutorService.execute(clientHandler);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized void broadcastMessage(Message message) {
        for (ClientHandler client : clients) {
            if (!client.getUser().getUsername().equals(message.getUser().getUsername())) {
                client.sendMessage(message);
            }
        }
    }
}