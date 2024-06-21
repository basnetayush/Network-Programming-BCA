package unit3;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URLDecoderExample {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String input="https://www.google.com/search?q=hello+world";
        String output = URLDecoder.decode(input, "UTF-8");
        System.out.println(output);
    }
}
