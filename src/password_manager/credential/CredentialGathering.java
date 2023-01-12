package password_manager.credential;

import java.util.ArrayList;
import java.util.List;

public class CredentialGathering {
    private List<Credential> credentials = new ArrayList<>();

    public List<Credential> getCredentials() {
        return credentials;
    }

    public void setCredentials(List<Credential> credentials) {
        this.credentials = credentials;
    }

    public Credential createCredential(String title) throws Exception {
        Credential credential = new Credential(title);
        credentials.add(credential);
        return credential;
    }

}
