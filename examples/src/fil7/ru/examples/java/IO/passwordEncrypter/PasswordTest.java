package fil7.ru.examples.java.IO.passwordEncrypter;

public class PasswordTest {
    public static void main(String[] args) {
        String password  = "password";
        String encrypted = new String(PasswordEncrypter.encrypt(password));
        String encoded   = PasswordEncrypter.encryptAndEncode(password);

        System.out.println("Зашифрованный пароль: " + encrypted);
        System.out.println("Кодированный шифр: " + encoded);
    }
}
