package password_manager.persistence;

import password_manager.credential.Credential;

import java.util.ArrayList;
import java.util.List;

public class Integrator {
    /**
     * @param credentialCsv credentials as csv, get csv form {@link CredentialLoader#getCredentialsCsv()}
     * @return credentials as List
     */
    public List<Credential> createCredentials(String credentialCsv) throws Exception {
        String[] lines = credentialCsv.split("\n");
        List<Credential> credentials = new ArrayList<>();
        for (String line : lines) {
            String[] columns = line.split(";");
            Credential credential = new Credential(columns[0]);
            if (columns.length > 1) {
                if (!columns[1].equals("null")) {
                    credential.setUsername(columns[1]);
                }
                if (columns.length > 2) {
                    if (!columns[2].equals("null")) {
                        credential.setPassword(columns[2]);
                    }
                }
            }
            credentials.add(credential);
        }
        return credentials;
    }
}
