package password_manager.user_interaction.workflow;

import password_manager.credential.CredentialGathering;
import password_manager.user_interaction.UserInterface;
import password_manager.user_interaction.step.PromptStep;
import password_manager.user_interaction.step.TextStep;

public class WorkflowSelectionWorkflow implements Workflow {
    private final UserInterface userInterface;
    private final CredentialGathering credentialGathering;
    private Workflow nextWorkflow;

    public WorkflowSelectionWorkflow(UserInterface userInterface, CredentialGathering credentialGathering) {
        this.userInterface = userInterface;
        this.credentialGathering = credentialGathering;
    }

    public Workflow getNextWorkflow() {
        return nextWorkflow;
    }

    @Override
    public void start() {
        new TextStep(userInterface, createSelectableWorkflowsMessage()).execute();
        while (nextWorkflow == null) {
            PromptStep workflowPrompt = new PromptStep(userInterface, "Select a workflow");
            workflowPrompt.execute();
            String workflowSelection = workflowPrompt.getUserInput().strip();
            if (workflowSelection.equals("1")) {
                nextWorkflow = new CreateCredentialWorkflow(userInterface, credentialGathering);
            } else if(workflowSelection.equals("99")) {
                nextWorkflow = new ExitWorkflow();
            } else {
                new TextStep(userInterface, "Invalid workflow number: " + workflowSelection).execute();
            }
        }
    }

    private String createSelectableWorkflowsMessage() {
        StringBuilder stb = new StringBuilder();
        for (SelectableWorkflow workflowName : SelectableWorkflow.values()) {
            stb.append(workflowName.getId()).append(": ").append(workflowName.name()).append("\n");
        }
        return stb.toString();
    }
}
