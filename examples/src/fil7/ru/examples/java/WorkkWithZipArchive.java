package fil7.ru.examples.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

    /**
     * Кроме общего функционала для работы с файлами Java предоставляет функциональность для работы с таким видом файлов как zip-архивы.
     * Для этого в пакете java.util.zip определены два класса - ZipInputStream и ZipOutputStream
     */
public class WorkkWithZipArchive {
    public static void main(String[] args) {

        String pathZipArchive = "C:\\Users\\Мария\\Documents\\Books\\Android\\Android.zip";
        String pathFile = "C:\\Github\\examples\\java\\ReadMe.txt";

        getInfoZip(pathZipArchive);
        createZipArchive(pathFile, pathZipArchive);
    }

    /**
     * ZipInputStream в конструкторе получает ссылку на поток ввода.
     * И затем в цикле выводятся все файлы и их размер в байтах, которые находятся в данном архиве.
     */
    private static void getInfoZip (String pathFileZip) {
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(pathFileZip), Charset.forName("CP866"))
        ) {
            ZipEntry entry;
            String name;
            long size;

            while ( (entry = zin.getNextEntry()) != null ) {
                name = entry.getName();
                size = entry.getSize();
                System.out.printf("Название: %s \t размер: %d \n", name, size);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Для создания архива используется класс ZipOutputStream.
     * Перезаписывает весь архив (удаляя сущетвующие данные)
     */
    private static void createZipArchive(String pathFile, String pathFileZip) {
        try (ZipOutputStream zout = new ZipOutputStream(
                                        new FileOutputStream(pathFileZip));
            FileInputStream fis = new FileInputStream(pathFile);
        ) {
            ZipEntry entry = new ZipEntry(pathFile);
            zout.putNextEntry(entry);
            // считываем содержимое файла в массив byte
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            // закрываем текущую запись для новой записи
            zout.closeEntry();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
