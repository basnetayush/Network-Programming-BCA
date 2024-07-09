package unit2;

import java.net.*;
import java.util.*;

public class NetworkInterfaceGetterMethods {
    public static void main(String[] args) {
        try {
            NetworkInterface ni = NetworkInterface.getByName("wlp3s0");
            if (ni == null) {
                System.err.println("No such interface: wlp3s0");
            }
            System.out.println("Display Name: "+ni.getDisplayName());
            System.out.println("Name: "+ni.getName());

            Enumeration<InetAddress> inetAddresses = ni.getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                InetAddress address = inetAddresses.nextElement();
                System.out.println("Inet Address: " +address);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
