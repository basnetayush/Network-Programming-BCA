package unit10;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPEchoServer {
    public static void main(String[] args) {
        int port = 12345;

        try (DatagramSocket socket = new DatagramSocket(port)) {
            byte[] buffer = new byte[1024];

            System.out.println("UDP server listening on port " + port);

            while (true) {
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                socket.receive(request);

                String received = new String(request.getData(), 0, request.getLength());
                System.out.println("Received: " + received + " from " + request.getAddress());

                DatagramPacket response = new DatagramPacket(
                    request.getData(), request.getLength(), request.getAddress(), request.getPort());
                socket.send(response);

                System.out.println("Sent: " + received + " to " + request.getAddress());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
