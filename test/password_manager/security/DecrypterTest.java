package password_manager.security;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class DecrypterTest {
    @Test
    void encrypt_decrypt_originalString() throws Exception {
        Encryptor encryptor = new Encryptor();
        Decrypter decrypter = new Decrypter();
        String originalText = "myText123 _./";
        String password = "myPassword123";
        String encryptedText = encryptor.encrypt(originalText, password);

        String decryptedText = decrypter.decrypt(encryptedText, password);

        assertThat(decryptedText).isEqualTo(originalText);
    }
}
