package unit1;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(9001);
            System.out.println("unit1.Server started");
            Socket clientSocket = ss.accept();
            System.out.println("Connection Established with unit1.Client");
            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            String str = (String) dis.readUTF();
            System.out.println("message= " + str);
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}