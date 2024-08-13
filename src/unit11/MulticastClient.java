package unit11;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastClient {
    public static void main(String[] args) {
        try {
            // Create a MulticastSocket bound to port 4000
            MulticastSocket socket = new MulticastSocket(4000);

            // Multicast group address
            InetAddress groupAddress = InetAddress.getByName("224.2.2.2");

            // Join the multicast group
            socket.joinGroup(groupAddress);

            // Buffer for receiving data
            byte[] buffer = new byte[8192];

            // Continuously receive data
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength(), "UTF-8");
                System.out.println("Received message: " + message);
            }

            // If you want to leave the group and close the socket (not reached in this example)
            // socket.leaveGroup(groupAddress);
            // socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
