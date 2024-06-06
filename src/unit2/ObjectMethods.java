package unit2;

import java.net.*;

public class ObjectMethods {
    public static void main(String args[]) {
        try {
            InetAddress facebook = InetAddress.getByName("facebook.com");
            InetAddress fb = InetAddress.getByName("fb.com");
            if (facebook.equals(fb)) {
                System.out.println("Facebook and FB are same");
            } else {
                System.out.println("Facebook and FB are not same");
            }
        } catch (UnknownHostException ex) {
            System.out.println("Host lookup failed.");
        }
    }
}