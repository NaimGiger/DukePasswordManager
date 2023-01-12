package password_manager.persistence;

import org.junit.jupiter.api.Test;
import password_manager.credential.Credential;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegratorTest {
    @Test
    void extractCredentials_createCredentials_sameCredentials() throws Exception {
        List<Credential> originalCredentials = new ArrayList<>();
        Credential cred1 = new Credential("tile1");
        cred1.setUsername("user1");
        cred1.setPassword("pass1");
        originalCredentials.add(cred1);
        Credential cred2 = new Credential("User _");
        cred2.setUsername("user ?");
        cred2.setPassword("pass !");
        originalCredentials.add(cred2);
        Extractor extractor = new Extractor();
        String extractedCredentials = extractor.createCsv(originalCredentials);
        Integrator integrator = new Integrator();

        List<Credential> newCredentials = integrator.createCredentials(extractedCredentials);

        assertThat(newCredentials).containsExactly(cred1, cred2);
    }
}
