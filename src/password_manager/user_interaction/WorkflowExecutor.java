package password_manager.user_interaction;

import password_manager.credential.CredentialGathering;
import password_manager.user_interaction.workflow.TitleScreenWorkflow;
import password_manager.user_interaction.workflow.Workflow;
import password_manager.user_interaction.workflow.WorkflowSelectionWorkflow;

public class WorkflowExecutor {
    private final UserInterface userInterface;
    private final CredentialGathering credentialGathering;

    public WorkflowExecutor(UserInterface userInterface, CredentialGathering credentialGathering) {
        this.userInterface = userInterface;
        this.credentialGathering = credentialGathering;
    }

    public void executeWorkflows() throws Exception {
        TitleScreenWorkflow titleScreenWorkflow = new TitleScreenWorkflow(userInterface);
        titleScreenWorkflow.start();
        while (true) {
            WorkflowSelectionWorkflow workflowSelector = new WorkflowSelectionWorkflow(userInterface, credentialGathering);
            workflowSelector.start();
            Workflow nextWorkflow = workflowSelector.getNextWorkflow();
            nextWorkflow.start();
        }
    }
}
