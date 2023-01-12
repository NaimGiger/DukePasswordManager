package password_manager.security;

import java.io.IOException;
import java.nio.file.Files;
import java.security.NoSuchAlgorithmException;

public class MasterPasswordChecker {
    public boolean exists() {
        return Files.exists(MasterPasswordCreator.FILE_PATH);
    }

    public boolean compareToStored(String masterPassword) throws NoSuchAlgorithmException, IOException {
        if (!exists()) {
            return false;
        }
        String newHash = new MasterPasswordCreator(masterPassword).hashPassword();
        String storedHash = Files.readString(MasterPasswordCreator.FILE_PATH);
        return newHash.equals(storedHash);
    }
}
