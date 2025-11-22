package DomandePeppe.T_ConnessioneTCP;

import java.net.*;
import java.io.*;

public class TCP_Server {

    public static void main(String[] args) {

        final int PORTA = 8080;

        try {

            ServerSocket serverSocket = new ServerSocket(PORTA);
            Socket clientSocket = serverSocket.accept();

            // Leggiamo i dati
            BufferedReader dati_in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String messaggio = dati_in.readLine();
            System.out.println("Messaggio da client a server: " + messaggio);

            // Inviamo dati
            PrintWriter dati_out = new PrintWriter(clientSocket.getOutputStream(), true);
            dati_out.println("Messaggio da server a client");

            clientSocket.close();
            serverSocket.close();

        } catch (Exception e) {
            System.err.println("ERRORE: " + e.getMessage());
        }

    }

}
