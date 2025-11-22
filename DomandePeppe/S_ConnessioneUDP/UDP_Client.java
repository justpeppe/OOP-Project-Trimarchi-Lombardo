package DomandePeppe.S_ConnessioneUDP;

import java.net.*;

public class UDP_Client {

    public static void main(String[] args) {

        try {
            InetAddress HOST = InetAddress.getByName("localhost");
            final int PORTA = 8080;

            DatagramSocket socket = new DatagramSocket();

            String message = "Messaggio dal client UDP";
            byte[] sendData = message.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, HOST, PORTA);
            socket.send(sendPacket);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);

            String responseMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Risposta dal server: " + responseMessage);

            socket.close();

        } catch (Exception e) {
            System.err.println("ERRORE: " + e.getMessage());
        }

    }

}
