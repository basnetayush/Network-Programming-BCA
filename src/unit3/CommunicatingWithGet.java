package unit3;

import java.io.*;
import java.net.*;

public class CommunicatingWithGet {
    public static void main(String[] args) {
        try {
            URL u = new URL("https://www.google.com/search?q=hello+world");
            try (InputStream in = new BufferedInputStream(u.openStream())) {
                InputStreamReader theHTML = new InputStreamReader(in);
                int c;
                while ((c = theHTML.read()) != -1) {
                    System.out.print((char) c);
                }
            }
        } catch (MalformedURLException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}