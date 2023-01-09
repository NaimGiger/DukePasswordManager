package password_manager.user_interaction;

import password_manager.credential.CredentialGathering;
import password_manager.user_interaction.workflow.TitleScreenWorkflow;
import password_manager.user_interaction.workflow.Workflow;

public class WorkflowExecutor {
    private final UserInterface userInterface;
    private final CredentialGathering credentialGathering;

    public WorkflowExecutor(UserInterface userInterface, CredentialGathering credentialGathering) {
        this.userInterface = userInterface;
        this.credentialGathering = credentialGathering;
    }

    public void executeWorkflows() {
        TitleScreenWorkflow titleScreenWorkflow = new TitleScreenWorkflow(userInterface, credentialGathering);
        titleScreenWorkflow.start();
        Workflow nextWorkflow = titleScreenWorkflow.getNextWorkflow();
        nextWorkflow.start();
    }
}
