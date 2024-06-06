package unit2;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressCreateObject {
    public static void main(String[] args) {
        try {
            InetAddress a1 = InetAddress.getByName("www.texasintl.edu.np");
            System.out.println(a1); //www.texasintl.edu.np/172.67.139.249

            InetAddress a2 = InetAddress.getByName("172.67.139.249");
            System.out.println(a2.getHostName()); //www.texasintl.edu.np

            InetAddress[] a3 = InetAddress.getAllByName("www.texasintl.edu.np");
            for (InetAddress a : a3) {
               System.out.println(a);
             }

            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost); // ayush/127.0.1.1

            byte[] address = {107,2,10, (byte) 177};
            InetAddress byAddress = InetAddress.getByAddress(address);
            System.out.println(byAddress);
            InetAddress byNameAndAddress = InetAddress.getByAddress("www.test.com",address);
            System.out.println(byNameAndAddress);

            InetAddress loopbackAddress = InetAddress.getLoopbackAddress();
            System.out.println(loopbackAddress);

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}