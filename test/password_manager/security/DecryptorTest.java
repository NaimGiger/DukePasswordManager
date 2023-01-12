package password_manager.security;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DecryptorTest {
    @Test
    void encrypt_decrypt_isOriginalString() {
        String originalString = "123 abc ;:_";
        Encryptor encryptor = new Encryptor();
        String encryptedString = encryptor.encrypt(originalString);
        Decryptor decryptor = new Decryptor();

        String decryptedString = decryptor.decrypt(encryptedString);

        assertThat(decryptedString).isEqualTo(decryptedString);
    }
}
