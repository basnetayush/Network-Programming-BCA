package unit3;

import java.io.*;
import java.net.*;

public class ContentGetter {
 // https://logos-world.net/wp-content/uploads/2022/07/Java-Logo.png
    public static void main(String[] args) {
            // Open the URL for reading
            try {
                URL u = new URL("https://logos-world.net/wp-content/uploads/2022/07/Java-Logo.png");
                Object o = u.getContent();
                System.out.println("I got a " + o.getClass().getName());
            } catch (MalformedURLException ex) {
                System.err.println( "Provided URL is not a parseable URL");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
}