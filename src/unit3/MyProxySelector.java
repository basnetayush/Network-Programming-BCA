package unit3;

import java.net.*;
import java.io.*;
import java.util.*;

public class MyProxySelector extends ProxySelector {
    
    private List<Proxy> proxies;

    public MyProxySelector() {
        // Initialize with a list of proxies
        proxies = new ArrayList<>();
        proxies.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("localhost", 8888)));
        proxies.add(Proxy.NO_PROXY); // Direct connection
    }

    @Override
    public List<Proxy> select(URI uri) {
        // Return the list of proxies
        return proxies;
    }

    @Override
    public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
        System.err.println("Connection to proxy failed: " + sa);
    }

    public static void main(String[] args) throws Exception {
        ProxySelector.setDefault(new MyProxySelector());

        URL url = new URL("http://httpbin.org/ip");
        URLConnection conn = url.openConnection();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
