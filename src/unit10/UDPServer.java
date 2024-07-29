package unit10;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) {
        int port = 8085;
        try {
            DatagramSocket socket = new DatagramSocket(port);
            DatagramPacket request = new DatagramPacket(new byte[1], 1);
            socket.receive(request);
            String quote = "Truth can only be found in one place: the code.";
            byte[] buffer = quote.getBytes();
            InetAddress clientAddress = request.getAddress();
            int clientPort = request.getPort();
            DatagramPacket response = new DatagramPacket(buffer, buffer.length, clientAddress, clientPort);
            socket.send(response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}