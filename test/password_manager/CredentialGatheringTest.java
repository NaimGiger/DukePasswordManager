package password_manager;

import org.junit.jupiter.api.Test;
import password_manager.credential.Credential;
import password_manager.credential.CredentialGathering;

import static org.assertj.core.api.Assertions.assertThat;

public class CredentialGatheringTest {
    @Test
    void initialize_createCredential_isCorrectlyCreated() {
        CredentialGathering credentialGathering = new CredentialGathering();

        Credential credential = credentialGathering.createCredential("test");

        assertThat(credential.getTitle()).isEqualTo("test");
        assertThat(credentialGathering.getCredentials()).containsExactly(credential);
    }
}
