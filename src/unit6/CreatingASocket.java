package unit6;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class CreatingASocket {
    public static void main(String[] args) {
        Socket socket=null;
        try {
            // Create a Socket Object
            socket=new Socket("time.nist.gov",13);
            // Obtain Input Streams
            InputStream in = socket.getInputStream();
            StringBuilder time = new StringBuilder();
            InputStreamReader reader = new InputStreamReader(in, "ASCII");
            // Receive Data from the Server
            for (int c = reader.read(); c != -1; c = reader.read()) {
                time.append((char) c);
            }
            System.out.println(time);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (socket != null) {
                try {
                    // Close the Streams and Socket
                    socket.close();
                } catch (IOException ex) {
                }
            }
        }
    }
}
