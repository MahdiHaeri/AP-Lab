package server;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(new ClientHandler(socket)).start();
        }
    }
}