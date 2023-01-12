package password_manager.persistence;

import password_manager.credential.Credential;

import java.util.List;

public class Extractor {


    public String createCsv(List<Credential> credentials) {
        StringBuilder credentialCsv = new StringBuilder();
        for (Credential credential : credentials) {
            credentialCsv.append(createCredentialCsvLine(credential));
        }
        return credentialCsv.toString();
    }

    String createCredentialCsvLine(Credential credential)  {
        StringBuilder csvLine = new StringBuilder();
        csvLine.append(credential.getTitle()).append(";");
        if (credential.getUsername() == null) {
            csvLine.append("null").append(";");
        } else {
            csvLine.append(credential.getUsername()).append(";");
        }
        if (credential.getPassword() == null) {
            csvLine.append("null").append("\n");
        } else {
            csvLine.append(credential.getPassword()).append("\n");
        }
        return csvLine.toString();
    }
}
