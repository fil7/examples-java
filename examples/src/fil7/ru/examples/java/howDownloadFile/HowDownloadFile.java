package fil7.ru.examples.java.howDownloadFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * Created by Мария on 02.08.2016.
 */
public class HowDownloadFile {

    public static void main(String[] args) throws IOException {
        // Give a try to Java NIO:

        downloadFileNIO("http://tainyimir.ru/wp-content/uploads/2012/09/image_1222639949.jpg", "image_1222639949.jpg");
        //download("http://tainyimir.ru/wp-content/uploads/2012/09/image_1222639949.jpg", "C:\\Users\\Мария\\IdeaProjects\\fil7\\java_tutorial\\src\\fil7.ru.java.howDownloadFile\\");
    }

    public static void downloadFileNIO (String url, String fileName) {
        try {
            // открываем поток на чтение
            URL website = new URL(url);
            ReadableByteChannel readableByteChannel = Channels.newChannel(website.openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Path download(String sourceUrl,
                                String targetDirectory) throws MalformedURLException, IOException
    {
        URL url = new URL(sourceUrl);

        String fileName = url.getFile();

        Path targetPath = new File(targetDirectory + fileName).toPath();

        Files.copy(url.openStream(), targetPath,
                StandardCopyOption.REPLACE_EXISTING);

        return targetPath;
    }
}
