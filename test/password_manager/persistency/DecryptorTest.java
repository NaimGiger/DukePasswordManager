package password_manager.persistency;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DecryptorTest {
    @Test
    void encryptText_decrypt_isOriginalText() throws Exception {
        Encryptor encryptor = new Encryptor();
        Decryptor decryptor = new Decryptor();
        String originalText = "some random text";
        byte[] encryptedText = encryptor.encryptText(originalText);

        String decryptedText = decryptor.decrypt(encryptedText);

        assertThat(decryptedText).isEqualTo(originalText);
    }
}
