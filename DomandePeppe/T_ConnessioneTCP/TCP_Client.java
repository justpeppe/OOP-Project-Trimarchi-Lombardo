package DomandePeppe.T_ConnessioneTCP;

import java.net.*;
import java.io.*;

public class TCP_Client {

    public static void main(String[] args) {
        final int PORTA = 8080;
        final String HOST = "localhost";

        try {

            Socket socket = new Socket(HOST, PORTA);

            // Inviamo dati
            PrintWriter dati_out = new PrintWriter(socket.getOutputStream(), true);
            dati_out.println("Sono il client!");

            // Leggiamo i dati
            BufferedReader dati_in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String risposta = dati_in.readLine();
            System.out.println("Risposta dal server: " + risposta);

        } catch (Exception e) {
            System.err.println("ERRORE: " + e.getMessage());
        }
    }

}
