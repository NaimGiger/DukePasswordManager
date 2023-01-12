package password_manager.user_interaction.workflow;

import password_manager.credential.CredentialGathering;
import password_manager.persistence.CredentialSaver;
import password_manager.user_interaction.UserInterface;
import password_manager.user_interaction.step.TextStep;

public class SaveCredentialsWorkflow implements Workflow {
    private final UserInterface userInterface;
    private final CredentialGathering credentialGathering;

    public SaveCredentialsWorkflow(UserInterface userInterface, CredentialGathering credentialGathering) {
        this.userInterface = userInterface;
        this.credentialGathering = credentialGathering;
    }

    @Override
    public void start() throws Exception {
        CredentialSaver credentialSaver = new CredentialSaver();
        credentialSaver.saveCredentials(credentialGathering.getCredentials());
        new TextStep(userInterface, "credentials saved").execute();
    }
}
