package unit1;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 9001);
            System.out.println("Connected to server");
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF("Hello unit1.Server");
            dout.flush();
            dout.close();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}