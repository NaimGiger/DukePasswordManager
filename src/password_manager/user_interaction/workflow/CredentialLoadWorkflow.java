package password_manager.user_interaction.workflow;

import password_manager.credential.CredentialGathering;
import password_manager.persistence.CredentialLoader;
import password_manager.persistence.Integrator;
import password_manager.security.Decryptor;
import password_manager.user_interaction.UserInterface;
import password_manager.user_interaction.step.TextStep;

public class CredentialLoadWorkflow implements Workflow {
    private final CredentialGathering credentialGathering;
    private final UserInterface userInterface;

    public CredentialLoadWorkflow(UserInterface userInterface, CredentialGathering credentialGathering) {
        this.credentialGathering = credentialGathering;
        this.userInterface = userInterface;
    }

    @Override
    public void start() throws Exception {
        CredentialLoader credentialLoader = new CredentialLoader();
        if(!credentialLoader.credentialsExist() || credentialLoader.getCredentialsCsv().isBlank()) {
            new TextStep(userInterface, "no credentials found").execute();
        } else {
            Decryptor decryptor = new Decryptor();
            String decryptedCsv = decryptor.decrypt(credentialLoader.getCredentialsCsv());
            Integrator integrator = new Integrator();
            credentialGathering.setCredentials(integrator.createCredentials(decryptedCsv));
            new TextStep(userInterface, "credentials loaded").execute();
        }
    }
}
