package unit10;

import java.net.*;
import java.io.*;

/*
shows a UDP discard server that receives incoming datagrams.
Just for fun, it logs the data in each datagram to System.out so that
we can see who’s sending what to your discard server
* */
public class UDPDiscardServer {
    public final static int PORT = 8081;
    public final static int MAX_PACKET_SIZE = 65507;

    public static void main(String[] args) {
        byte[] buffer = new byte[MAX_PACKET_SIZE];
        try (DatagramSocket server = new DatagramSocket(PORT)) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            while (true) {
                try {
                    server.receive(packet);
                    String s = new String(packet.getData(), 0, packet.getLength(), "8859_1");
                    System.out.println(packet.getAddress() + " at port "
                            + packet.getPort() + " says " + s);
                    // reset the length for the next packet
                    packet.setLength(buffer.length);
                } catch (IOException ex) {
                    System.err.println(ex);
                }
            } // end while
        } catch (SocketException ex) {
            System.err.println(ex);
        }
    }
}