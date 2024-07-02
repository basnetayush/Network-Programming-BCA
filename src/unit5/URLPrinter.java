package unit5;

import java.io.*;
import java.net.*;

public class URLPrinter {
    public static void main(String[] args) {
        try {
            URL u = new URL("https://tu.edu.np/");
            URLConnection uc = u.openConnection();
            System.out.println(uc.getURL());
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}