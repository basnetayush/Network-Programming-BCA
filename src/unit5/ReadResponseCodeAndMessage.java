package unit5;

import java.io.*;
import java.net.*;

public class ReadResponseCodeAndMessage {
    public static void main(String[] args) {
        String urlString = "https://www.google.com/";
        try {
            // Open the URLConnection for reading
            URL u = new URL(urlString);
            HttpURLConnection uc = (HttpURLConnection) u.openConnection();
            int code = uc.getResponseCode();
            String response = uc.getResponseMessage();
            System.out.println("HTTP/1.x " + code + " " + response);
            for (int j = 1; ; j++) {
                String header = uc.getHeaderField(j);
                String key = uc.getHeaderFieldKey(j);
                if (header == null || key == null) break;
                System.out.println(uc.getHeaderFieldKey(j) + ": " + header);
            }
        } catch (MalformedURLException ex) {
            System.err.println(urlString + " is not a parseable URL");
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
