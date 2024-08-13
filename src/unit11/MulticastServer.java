package unit11;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastServer {
    public static void main(String[] args) {
        try {
            // Create a MulticastSocket bound to port 4000
            MulticastSocket socket = new MulticastSocket();

            // Multicast group address
            InetAddress groupAddress = InetAddress.getByName("224.2.2.2");

            // Data to send
            String message = "Hello, Multicast Group!";
            byte[] data = message.getBytes();

            // Create a DatagramPacket for the message
            DatagramPacket packet = new DatagramPacket(data, data.length, groupAddress, 4000);

            // Set TTL to 64 (packet can travel through 64 routers)
            socket.setTimeToLive(64);

            // Send the packet repeatedly
            for (int i = 0; i < 10; i++) {
                socket.send(packet);
                System.out.println("Sent message: " + message);
                Thread.sleep(1000); // Sleep for 1 second between messages
            }

            // Close the socket
            socket.close();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
