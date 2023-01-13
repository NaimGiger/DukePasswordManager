package password_manager.security;

import java.util.List;

public class Encryptor {
    public static final int KEY = 20;

    /**
     * @param input credential csv, get it from {@link password_manager.persistence.Extractor#createCsv(List)}
     * @return encrypted credential csv
     */
    public String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            encrypted.append(c += KEY);
        }
        return encrypted.toString();
    }
}
