package fil7.ru.examples.java.nio;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * ReadableByteChannel
 * WritableByteChannel
 * Example of Non-blocking io (nio)
 * Чтение доступных данных (без ожидания)
 */

public class NioDemo {
    public static void main(String[] args) throws IOException{
        Path path = Paths.get("examples", "src", "fil7", "ru", "examples", "java", "nio", "NioDemo.java");

        try (ReadableByteChannel in = FileChannel.open(path);
             WritableByteChannel out = Channels.newChannel(System.out);
        ) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (in.read(buffer) >= 0 || buffer.position() != 0) {
                buffer.flip();
                out.write(buffer);
                buffer.compact();
            }
        }

        /**
         * blocking io
         */
//        try (InputStream ins = Files.newInputStream(path);
//                            OutputStream out = System.out;
//        ) {
//            byte[] buffer = new byte[1024];
//            int bytesRead;
//            while ((bytesRead = ins.read(buffer)) > 0) {
//                out.write(buffer, 0, bytesRead);
//            }
//        }
    }


}
