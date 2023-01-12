package password_manager.user_interaction.workflow;

import password_manager.credential.Credential;
import password_manager.credential.CredentialGathering;
import password_manager.user_interaction.UserInterface;
import password_manager.user_interaction.step.TextStep;

public class ShowCredentialWorkflow implements Workflow {
    private final UserInterface userInterface;
    private final CredentialGathering credentialGathering;

    public ShowCredentialWorkflow(UserInterface userInterface, CredentialGathering credentialGathering) {
        this.userInterface = userInterface;
        this.credentialGathering = credentialGathering;
    }

    @Override
    public void start() {
        for (Credential credential : credentialGathering.getCredentials()) {
            new TextStep(userInterface, credential.toString().substring(10)).execute();
        }
    }
}
