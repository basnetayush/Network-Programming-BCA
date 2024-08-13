
package unit9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class AsynchronousFileChannelCompletionHandler {

    public static void main(String[] args) throws Exception {
        writeFile();
    }

    private static void writeFile() throws IOException {
		String input = "Content to be written to the file.";

        System.out.println("Input string: " + input);

        byte[] byteArray = input.getBytes();

        ByteBuffer buffer = ByteBuffer.wrap(byteArray);

        Path path = Paths.get("dummy.txt");

        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
        CompletionHandler handler = new CompletionHandler() {
            @Override
            public void completed(Object result,
                                  Object attachment) {
                System.out.println(attachment + " completed and " + result + " bytes are written.");
            }
			@Override
            public void failed(Throwable exc,
                               Object attachment) {
                System.out.println(attachment + " failed with exception:");
                exc.printStackTrace();
            }
        };

        channel.write(buffer, 0, "Async Task", handler);
        channel.close();
        printFileContents(path.toString());
    }

    private static void printFileContents(String path) throws IOException {

        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);

        String textRead = br.readLine();

        System.out.println("File contents: ");
		while (textRead != null) {
            System.out.println("	 " + textRead);
            textRead = br.readLine();
        }

        fr.close();
        br.close();
    }
}
