package password_manager.security;

import password_manager.persistence.CredentialLoader;

public class Decryptor {
    /**
     * @param input encrypted credential csv, get it from {@link CredentialLoader#getCredentialsCsv()}
     * @return decrypted credential csv
     */
    public String decrypt(String input) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            decrypted.append(c -= Encryptor.KEY);
        }
        return decrypted.toString();
    }
}
