package unit2;

import java.net.*;
import java.util.Enumeration;

public class NetworkInterfaceFactoryMethod {
    public static void main(String[] args) {
        try {
            NetworkInterface ni = NetworkInterface.getByName("wlp3s0");
            if (ni == null) {
                System.err.println("No such interface: wlp3s0");
            }
            Enumeration<InetAddress> inetAddresses = ni.getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                System.out.println(inetAddresses.nextElement());
            }


            InetAddress local = InetAddress.getByName("127.0.0.1");
            NetworkInterface ni2 = NetworkInterface.getByInetAddress(local);
            if (ni2 == null) {
                System.err.println("That's weird. No local loopback address.");
            }


            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface nix = interfaces.nextElement();
                System.out.println(nix);
            }
        } catch (SocketException ex) {
            System.err.println("Could not list sockets.");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
