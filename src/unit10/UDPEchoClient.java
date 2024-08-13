package unit10;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPEchoClient {
    public static void main(String[] args) {
        String message = "Hello, UDP server!";
        String serverAddress = "localhost";
        int port = 12345;

        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress address = InetAddress.getByName(serverAddress);
            byte[] buffer = message.getBytes();

            DatagramPacket request = new DatagramPacket(buffer, buffer.length, address, port);
            socket.send(request);

            byte[] responseBuffer = new byte[1024];
            DatagramPacket response = new DatagramPacket(responseBuffer, responseBuffer.length);
            socket.receive(response);

            String received = new String(response.getData(), 0, response.getLength());
            System.out.println("Received from server: " + received);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
