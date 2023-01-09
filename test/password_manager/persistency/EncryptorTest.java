package password_manager.persistency;

import org.junit.jupiter.api.Test;
import password_manager.credential.Credential;

import static org.assertj.core.api.Assertions.assertThat;

public class EncryptorTest {
    @Test
    void newCredential_createCsvLine_correctCsvLine() throws Exception {
        Encryptor encryptor = new Encryptor();
        Credential credential = new Credential("cred1");
        credential.setUsername("hans123");

        String csvLine = encryptor.createCredentialCsvLine(credential);

        assertThat(csvLine).isEqualTo("cred1;hans123;null\n");
    }
}
