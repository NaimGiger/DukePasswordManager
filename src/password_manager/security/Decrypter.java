package password_manager.security;

import javax.crypto.Cipher;

public class Decrypter {
    public String decrypt(String input, String masterPassword) throws Exception {
        Encryptor encryptor = new Encryptor();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, encryptor.createKey(masterPassword));
        return new String(cipher.doFinal(input.getBytes()));
    }
}
