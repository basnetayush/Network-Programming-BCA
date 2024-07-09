package unit6;

import java.net.*;
import java.io.*;

public class SocketInfo {
    public static void main(String[] args) {
        String host = "java.sun.com";
        try {
         Socket theSocket = new Socket(host, 80);
         System.out.println("Remote Address: "+ theSocket.getRemoteSocketAddress());
         System.out.println("Remote Port: "+ theSocket.getPort());
         System.out.println("Local Address: "+ theSocket.getLocalAddress());
         System.out.println("Local Port: "+ theSocket.getLocalPort());
        } catch (UnknownHostException ex) {
            System.err.println("I can't find " + host);
        } catch (SocketException ex) {
            System.err.println("Could not connect to " + host);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}