package password_manager.credential;

import java.util.ArrayList;
import java.util.List;

public class CredentialGathering {
    private final List<Credential> credentials = new ArrayList<>();

    public List<Credential> getCredentials() {
        return credentials;
    }

    public Credential createCredential(String title) throws Exception {
        Credential credential = new Credential(title);
        credentials.add(credential);
        return credential;
    }
}
