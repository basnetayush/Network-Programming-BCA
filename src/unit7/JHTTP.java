package unit7;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;
import java.util.logging.*;

public class JHTTP {
    private static final Logger logger = Logger.getLogger(
            JHTTP.class.getCanonicalName());
    private static final int NUM_THREADS = 50;
    private static final String INDEX_FILE = "index.html";
    private final File rootDirectory;
    private final int port;

    public JHTTP(File rootDirectory, int port) throws IOException {
        if (!rootDirectory.isDirectory()) {
            throw new IOException(rootDirectory
                    + " does not exist as a directory");
        }
        this.rootDirectory = rootDirectory;
        this.port = port;
    }

    public void start() throws IOException {
        ExecutorService pool = Executors.newFixedThreadPool(NUM_THREADS);
        try (ServerSocket server = new ServerSocket(port)) {
            logger.info("Accepting connections on port " + server.getLocalPort());
            logger.info("Document Root: " + rootDirectory);
            while (true) {
                try {
                    Socket request = server.accept();
                    Runnable r = new RequestProcessor(
                            rootDirectory, INDEX_FILE, request);
                    pool.submit(r);
                } catch (IOException ex) {
                    logger.log(Level.WARNING, "Error accepting connection", ex);
                }
            }
        }
    }

    public static void main(String[] args) {
        // get the Document root
        File docroot;
        try {
            docroot = new File("/home/shady/Desktop/NGINX/html");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Usage: java JHTTP docrtoot port");
            return;
        }
        // set the port to listen on
        int port=8081;
        try {
            JHTTP webserver = new JHTTP(docroot, port);
            webserver.start();
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Server could not start", ex);
        }
    }
}