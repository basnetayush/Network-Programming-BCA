package unit3;

import java.net.*;

public class URLSplitter {
    public static void main(String args[]) {
        String urlString = "https://www.example.com/path/to/resource?query=example#section";
        try {
            URL u = new URL(urlString);
            System.out.println("The URL is " + u);
            System.out.println("The scheme is " + u.getProtocol());
            System.out.println("The host is " + u.getHost());
            System.out.println("The authority is " + u.getAuthority());
            System.out.println("The port is " + u.getPort());
            System.out.println("The path is " + u.getPath());
            System.out.println("The query string is " + u.getQuery());
            System.out.println("The fragment is " + u.getRef());
        } catch (MalformedURLException ex) {
            System.err.println(urlString+ " is not a URL I understand.");
        }
        System.out.println();
    }
}