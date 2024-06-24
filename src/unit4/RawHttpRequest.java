    package unit4;

    import java.io.*;
    import java.net.*;

    public class RawHttpRequest {
        public static void main(String[] args) {
            // Replace with the target server and resource
            String server = "localhost";
            String resource = "/";
            try {
                Socket socket = new Socket(server, 8888);// Establish a connection to the server on port 8888 (HTTP)
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);   // Get output stream to send request
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));// Get input stream to read response

                // Construct and send the HTTP GET request
                out.println("GET " + resource + " HTTP/1.1");
                out.println("Host: " + server);
                out.println("Connection: close");
                out.println(""); // Blank line to indicate the end of the request headers

                // Read and print the response from the server
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }

                // Close the streams and the socket
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
