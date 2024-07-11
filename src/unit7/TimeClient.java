package unit7;

import java.io.*;
import java.net.*;
import java.util.Date;

public class TimeClient {
    public final static String SERVER = "localhost";
    public final static int PORT = 9001;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER, PORT)) {
            InputStream in = socket.getInputStream();
            byte[] time = new byte[4];
            int bytesRead = in.read(time);

            if (bytesRead == time.length) {
                long secondsSince1900 = ((time[0] & 0xFFL) << 24)
                        | ((time[1] & 0xFFL) << 16)
                        | ((time[2] & 0xFFL) << 8)
                        | (time[3] & 0xFFL);

                long differenceBetweenEpochs = 2208988800L;
                long secondsSince1970 = secondsSince1900 - differenceBetweenEpochs;
                long msSince1970 = secondsSince1970 * 1000;
                Date now = new Date(msSince1970);

                System.out.println("Server time: " + now);
            } else {
                System.err.println("Error: Incomplete time received.");
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
