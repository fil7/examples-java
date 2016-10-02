package fil7.ru.examples.java.IO.logreader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Пример чтения из файла протокола выводимой приложением информации
 */
public class LogReader {

    public static void main(String[] args) {

        // Первый параметр - это имя протокола
        String logFile = null;
        if (args.length == 0) {
            logFile = "C:\\Users\\Мария\\IdeaProjects\\fil7\\java_tutorial\\src\\fil7.ru.java.IO\\logreader\\text.log";
        } else {
            logFile = args[0];
        }
        // последовательное чтение файла
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(logFile)));
            while (true) {
                String line = br.readLine();
                if (line != null) {
                    System.out.println(line);
                } else {
                    // спящий режим программы
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
