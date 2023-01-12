package password_manager.security;

public class Decryptor {
    public String decrypt(String input) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            decrypted.append(c -= Encryptor.KEY);
        }
        return decrypted.toString();
    }
}
