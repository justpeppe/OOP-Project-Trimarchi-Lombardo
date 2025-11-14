package DomandePeppe.ClientServer;

// Importazione pacchetti e librerie
import java.net.*;
import java.io.*;

// Creazione classe Server
public class Server {

    // Creazione metodo avvia server
    public static void AvviaServer() {

        int porta = 8080;

        try {

            // Creazione del serversocket sulla porta dichiarata
            ServerSocket serverSocket = new ServerSocket(porta);

            // Accettazione richieste tramite serversocket.accept
            Socket socket = serverSocket.accept();

            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            // Lancio delle eccezioni
            System.err.println("Errore " + e.getMessage());
        }

    }

}