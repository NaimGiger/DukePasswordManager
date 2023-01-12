package password_manager.persistence;

import java.io.IOException;
import java.nio.file.Files;

public class CredentialLoader {
    public boolean credentialsExist() {
        return Files.exists(CredentialSaver.FILE_PATH);
    }

    public String getCredentialsCsv() throws IOException {
        return Files.readString(CredentialSaver.FILE_PATH);
    }
}
