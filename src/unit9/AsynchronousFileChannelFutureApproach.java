package unit9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AsynchronousFileChannelFutureApproach {
    public static void main(String[] args) throws Exception {
        readFile();
    }

    private static void readFile() throws IOException, InterruptedException, ExecutionException {

        String filePath = "dummy.txt";

        printFileContents(filePath);

        Path path = Paths.get(filePath);
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocate(400);
        Future<Integer> result = channel.read(buffer, 0);

        while (!result.isDone()) {
            System.out.println("The process of reading file is in progress asynchronously.");
        }
        System.out.println("Is the reading done? " + result.isDone());
        System.out.println("The number of bytes read from file is " + result.get());
        buffer.flip();
        System.out.print("Buffer contents: ");

        while (buffer.hasRemaining()) {
            System.out.print((char) buffer.get());
        }
        System.out.println(" ");

        buffer.clear();
        channel.close();
    }

    private static void printFileContents(String path) throws IOException {
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        String textRead = br.readLine();

        System.out.println("Content in the File: ");

        while (textRead != null) {
            System.out.println("	 " + textRead);
            textRead = br.readLine();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        fr.close();
        br.close();
    }
}
