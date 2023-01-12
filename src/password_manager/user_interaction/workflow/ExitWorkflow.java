package password_manager.user_interaction.workflow;

import password_manager.credential.CredentialGathering;
import password_manager.user_interaction.UserInterface;

public class ExitWorkflow implements Workflow {
    private final UserInterface userInterface;
    private final CredentialGathering credentialGathering;

    public ExitWorkflow(UserInterface userInterface, CredentialGathering credentialGathering) {
        this.userInterface = userInterface;
        this.credentialGathering = credentialGathering;
    }

    @Override
    public void start() throws Exception {
        SaveCredentialsWorkflow saveCredentialsWorkflow = new SaveCredentialsWorkflow(userInterface, credentialGathering);
        saveCredentialsWorkflow.start();
        System.exit(0);
    }
}
