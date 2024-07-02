package unit5;

import java.io.*;
import java.net.*;

public class DownloadWebPageURlConnection {
    public static void main(String[] args) {
        String urlString="https://www.w3schools.com/java/";
        try {
            // Open the URLConnection for reading
            URL u = new URL(urlString);
            URLConnection uc = u.openConnection();
            try (InputStream raw = uc.getInputStream()) { // autoclose
                InputStream buffer = new BufferedInputStream(raw);
                // chain the InputStream to a Reader
                Reader reader = new InputStreamReader(buffer);
                int c;
                while ((c = reader.read()) != -1) {
                    System.out.print((char) c);
                }
            }
        } catch (MalformedURLException ex) {
            System.err.println( urlString+ " is not a parseable URL");
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
