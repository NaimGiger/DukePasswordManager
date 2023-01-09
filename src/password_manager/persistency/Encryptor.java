package password_manager.persistency;

import password_manager.credential.Credential;

import javax.crypto.*;
import java.nio.charset.StandardCharsets;

public class Encryptor {

    public static final String ALGORITHM = "AES";

    byte[] encryptText(String text) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        SecretKey key = keyGenerator.generateKey();
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);

        return cipher.doFinal(text.getBytes(StandardCharsets.UTF_8));
    }

    String createCredentialCsvLine(Credential credential)  {
        StringBuilder csvLine = new StringBuilder();
        csvLine.append(credential.getTitle()).append(";");
        if (credential.getUsername() == null) {
            csvLine.append("null").append(";");
        } else {
            csvLine.append(credential.getUsername()).append(";");
        }
        if (credential.getPassword() == null) {
            csvLine.append("null").append("\n");
        } else {
            csvLine.append(credential.getPassword()).append("\n");
        }
        return csvLine.toString();
    }
}
