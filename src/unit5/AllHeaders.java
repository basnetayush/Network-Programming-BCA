package unit5;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.*;

public class AllHeaders {
    public static void main(String[] args) {
     String urlString = "https://www.w3schools.com/java/";
        try {
            URL u = new URL(urlString);
            URLConnection uc = u.openConnection();
            for (int j = 1; ; j++) {
                String header = uc.getHeaderField(j);
                if (header == null) break;
                System.out.println(uc.getHeaderFieldKey(j) + ": " + header);
            }
        } catch (MalformedURLException ex) {
            System.err.println(urlString + " is not a URL I understand.");
        } catch (IOException ex) {
            System.err.println(ex);
        }
        System.out.println();
    }

}