package unit3;

import java.net.URI;
import java.net.URISyntaxException;

public class ResolvingRelativeURI {
    public static void main(String[] args) {
        try {
            // Using resolve method
            URI absolute = new URI("http://www.example.com/");
            URI relative = new URI("images/logo.png");
            URI resolved = absolute.resolve(relative);
            System.out.println(resolved); // http://www.example.com/images/logo.png

            URI top = new URI("javafaq/books/");
            URI resolved2 = top.resolve("jnp3/examples/07/index.html");
            System.out.println(resolved2); // javafaq/books/jnp3/examples/07/index.html

            URI absolute2 = new URI("http://www.example.com/images/logo.png");
            URI top2 = new URI("http://www.example.com/");
            URI relative2 = top2.relativize(absolute2);
            System.out.println(relative2); // images/logo.png

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
