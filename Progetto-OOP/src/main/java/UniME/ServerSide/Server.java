package ServerSide;

import Shared.Utils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        int porta = Integer.parseInt(Utils.getElementValue("server.xml", "porta"));
        ServerSocket serverSocket;

        try {
            serverSocket = new ServerSocket(porta);
            while (true) {
                Socket socket = serverSocket.accept();
                new GestoreClient(socket).start();
            }
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }
}
