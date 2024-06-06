package unit2;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddressGetterMethods {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress = InetAddress.getByName("www.texasintl.edu.np");
            String hostName = inetAddress.getHostName();
            String canonicalHostName = inetAddress.getCanonicalHostName();
            byte[] address = inetAddress.getAddress();
            String hostAddress = inetAddress.getHostAddress();
            System.out.println("HostName: " + hostName); //  www.texasintl.edu.np
            System.out.println("Canonical HostName: " + canonicalHostName); //  www.texasintl.edu.np
            System.out.println("Host Address: " + hostAddress); // 172.67.139.249
            System.out.println("Address: " + Arrays.toString(address)); // [104, 21, 49, 3]

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}