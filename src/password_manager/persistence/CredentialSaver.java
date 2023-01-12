package password_manager.persistence;

import password_manager.credential.Credential;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CredentialSaver {
    public static final Path FILE_PATH = Paths.get("credentials.csv");
    void storeCredentials(List<Credential> credentials) throws IOException {
        Extractor extractor = new Extractor();
        String credentialCsv = extractor.createCsv(credentials);
        Files.writeString(FILE_PATH, credentialCsv);
    }
}
