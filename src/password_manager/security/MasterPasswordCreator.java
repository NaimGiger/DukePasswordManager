package password_manager.security;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MasterPasswordCreator {
    public static final Path FILE_PATH = Paths.get("master_password.txt");
    private final String masterPassword;
    private String errorMessage;


    public MasterPasswordCreator(String masterPassword) {
        this.masterPassword = masterPassword;
    }

    public boolean storePassword() {
        try {
            String hash = hashPassword(masterPassword);
            Files.createFile(FILE_PATH);
            Files.writeString(FILE_PATH, hash);
        } catch (NoSuchAlgorithmException e) {
            errorMessage = "Hash-Algorithm 'SHA-256' doesn't exist";
            return false;
        } catch (IOException e) {
            errorMessage = "IO Error";
            return false;
        }
        return true;
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hash = messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(hash);
    }

    private String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
