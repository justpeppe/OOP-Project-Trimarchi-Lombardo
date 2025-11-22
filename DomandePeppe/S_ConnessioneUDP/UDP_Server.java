package DomandePeppe.S_ConnessioneUDP;

import java.net.*;

public class UDP_Server {

    public static void main(String[] args) {

        try {
            final int PORTA = 8080;
            DatagramSocket socket = new DatagramSocket(PORTA);
            byte[] receiveData = new byte[1024];

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Messaggio ricevuto: " + message);

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                String responseMessage = "Messaggio ricevuto correttamente";

                byte[] sendData = responseMessage.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                socket.send(sendPacket);

            }

        } catch (Exception e) {
            System.err.println("ERRORE: " + e.getMessage());
        }

    }

}
