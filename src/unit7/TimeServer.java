package unit7;

import java.io.*;
import java.net.*;
import java.sql.Time;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.*;

public class TimeServer {
    public final static int PORT = 9001;

    private final static Logger LOGGER =
            Logger.getLogger("TimeServer");

    public static void main(String[] args) {
        long differenceBetweenEpochs = 2208988800L;
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server Started");
            while (true) {
                try (Socket connection = server.accept()) {
                    LOGGER.info("Connection established");
                    OutputStream out = connection.getOutputStream();
                    Date now = new Date();
                    long msSince1970 = now.getTime();
                    long secondsSince1970 = msSince1970 / 1000;
                    long secondsSince1900 = secondsSince1970
                            + differenceBetweenEpochs;
                    byte[] time = new byte[4];
                    time[0] = (byte) ((secondsSince1900 & 0x00000000FF000000L) >> 24);
                    time[1] = (byte) ((secondsSince1900 & 0x0000000000FF0000L) >> 16);
                    time[2] = (byte) ((secondsSince1900 & 0x000000000000FF00L) >> 8);
                    time[3] = (byte) (secondsSince1900 & 0x00000000000000FFL);
                    out.write(time);
                    out.flush();
                } catch (IOException ex) {
                    LOGGER.severe("Error Occured");
                    System.err.println(ex.getMessage());
                }
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}