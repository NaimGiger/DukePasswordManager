package password_manager.user_interaction.workflow;

import password_manager.credential.Credential;
import password_manager.credential.CredentialGathering;
import password_manager.user_interaction.UserInterface;
import password_manager.user_interaction.step.PromptStep;
import password_manager.user_interaction.step.TextStep;

public class CreateCredentialWorkflow implements Workflow {
    private final UserInterface userInterface;
    private final CredentialGathering credentialGathering;

    public CreateCredentialWorkflow(UserInterface userInterface, CredentialGathering credentialGathering) {
        this.userInterface = userInterface;
        this.credentialGathering = credentialGathering;
    }

    @Override
    public void start() {
        String credentialTitle = "";
        while (credentialTitle.isBlank()) {
            PromptStep titlePrompt = new PromptStep(userInterface, "Title of credential");
            titlePrompt.execute();
            credentialTitle = titlePrompt.getUserInput().strip();
        }
        Credential credential = credentialGathering.createCredential(credentialTitle);
        promptAndSetUsername(credential);
        promptAndSetPassword(credential);
        TextStep successText = new TextStep(userInterface, "Successfully created credential:\n" + credential.toString());
        successText.execute();
    }

    private void promptAndSetUsername(Credential credential) {
        PromptStep usernamePrompt = new PromptStep(userInterface, "Username (empty for no username)");
        usernamePrompt.execute();
        String username = usernamePrompt.getUserInput().strip();
        if (!username.isBlank()) {
            credential.setUsername(username);
        }
    }

    private void promptAndSetPassword(Credential credential) {
        PromptStep passwordPrompt = new PromptStep(userInterface, "Password (empty for no password)");
        passwordPrompt.execute();
        String password = passwordPrompt.getUserInput().strip();
        if (!password.isBlank()) {
            credential.setPassword(password);
        }
    }
}
