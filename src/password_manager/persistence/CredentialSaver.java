package password_manager.persistence;

import password_manager.credential.Credential;
import password_manager.security.Encryptor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CredentialSaver {
    public static final Path FILE_PATH = Paths.get("credentials.csv");
    public void saveCredentials(List<Credential> credentials) throws IOException {
        Extractor extractor = new Extractor();
        String credentialCsv = extractor.createCsv(credentials);
        Encryptor encryptor = new Encryptor();
        String encryptedCsv = encryptor.encrypt(credentialCsv);
        Files.writeString(FILE_PATH, encryptedCsv);
    }
}
