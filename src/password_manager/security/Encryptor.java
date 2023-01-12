package password_manager.security;

public class Encryptor {
    public static final int KEY = 20;

    public String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            encrypted.append(c += KEY);
        }
        return encrypted.toString();
    }
}
