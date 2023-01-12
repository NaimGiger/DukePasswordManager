package password_manager.security;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EncryptorTest {
    @Test
    void givenString_encrypt_differentString() {
        String input = "lets go äöü";
        Encryptor encryptor = new Encryptor();

        String output = encryptor.encrypt(input);

        assertThat(input).isNotEqualTo(output);
    }
}
