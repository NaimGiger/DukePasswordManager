package password_manager;

import java.util.ArrayList;
import java.util.List;

public class CredentialGathering {
    private List<Credential> credentials = new ArrayList<>();

    public List<Credential> getCredentials() {
        return credentials;
    }

    Credential createCredential(String title) {
        Credential credential = new Credential(title);
        credentials.add(credential);
        return credential;
    }
}
