package fil7.ru.examples.java.client_server;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 1. Связывается с сервером
 * 2. Получает ввод от пользователя
 * 3. Отправляет введенные данные на сервер
 * 4. Ждет ответ, получает его и выводит ответ для пользователя
 */

public class Client {
    public static void main(String[] args) {
        int serverPort = 6666; // здесь обязательно нужно указать порт к которому привязывается сервер.
        String address = "127.0.0.1"; // это IP-адрес компьютера, где исполняется наша серверная программа.
        try {
            // создаем объект который отображает вышеописанный IP-адрес.
            InetAddress ipAddress = InetAddress.getByName(address);
            System.out.println("Any of you heard of a socket with IP address " + address + " and port " + serverPort + "?");
            // создаем сокет используя IP-адрес и порт сервера.
            Socket socket = new Socket(ipAddress, serverPort);
            System.out.println("Yes! I just got hold of the program.");

            // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиентом.
            InputStream socketIn = socket.getInputStream();
            OutputStream socketOut = socket.getOutputStream();

            // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
            DataInputStream in = new DataInputStream(socketIn);
            DataOutputStream out = new DataOutputStream(socketOut);

            // Создаем поток для чтения с клавиатуры.
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            System.out.println("Type in something and press enter. Will send it to the server and tell ya what it thinks.");
            System.out.println();

            while (true) {
                line = keyboard.readLine();
                System.out.println("Sending this line to the server...");
                out.writeUTF(line); // отсылаем введенную строку текста серверу.
                out.flush(); // заставляем поток закончить передачу данных.
                line = in.readUTF(); // ждем пока сервер отошлет строку текста.
                System.out.println("The server was very polite. It sent me this : " + line);
                System.out.println("Looks like the server is pleased with us. Go ahead and enter more lines.");
                System.out.println();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
