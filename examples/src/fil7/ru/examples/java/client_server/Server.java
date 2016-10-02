package fil7.ru.examples.java.client_server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 6666; // случайный порт (от 1025 до 65535)
        try {
            // создаем сокет сервера и связываем его с портом
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Waiting for a client...");

            // Заставялем сервер ждать подключения
            Socket socket = ss.accept();
            // Выводим сообщение, когда кто-то связался с нами
            System.out.println("Got a client");
            System.out.println();

            // Потоки данных
            InputStream socketIn = socket.getInputStream();
            OutputStream socketOut = socket.getOutputStream();

            // Конвертируем потоки в другой тип (для удобства)
            DataInputStream in = new DataInputStream(socketIn);
            DataOutputStream out = new DataOutputStream(socketOut);

            String line = null;

            while (true) {
                line = in.readUTF();
                System.out.println("The dumb client just sent me this line : " + line);
                System.out.println("I'm sending it back...");
                out.writeUTF(line); // отсылаем клиенту обратно ту самую строку текста.
                out.flush(); // заставляем поток закончить передачу данных.
                System.out.println("Waiting for the next line...");
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
