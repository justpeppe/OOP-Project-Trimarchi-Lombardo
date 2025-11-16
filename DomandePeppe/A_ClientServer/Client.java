package DomandePeppe.A_ClientServer;

import java.io.*;
import java.net.*;

public class Client {

    public static void GestioneClient() {

        int porta = 8080;
        String host = "localhost";

        try {

            Socket socket = new Socket(host, porta);

            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            printWriter.println("Pubblica questo messaggio");
            String risposta = bufferedReader.readLine();

            System.out.println("Il server ha risposto cosi: " + risposta);

            socket.close();

        } catch (IOException e) {
            System.err.println("Errore: " + e.getMessage());
        }

    }

}