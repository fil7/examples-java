package fil7.ru.examples.java.IO.passwordEncrypter;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Генерирование паролей
 */
public class PasswordEncrypter {

    // зашифрованный пароль
    public static byte[] encrypt(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("sha-1");
            messageDigest.update(password.getBytes());
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException ignore) {}

        // возвращает null если шифрование не удалось
        return null;
    }

    public static String encryptAndEncode(String password) {
        BASE64Encoder enc = new BASE64Encoder();
        String encoded = enc.encode(encrypt(password));
        enc = null;

        return encoded;
    }
}
