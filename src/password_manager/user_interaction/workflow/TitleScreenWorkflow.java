package password_manager.user_interaction.workflow;

import password_manager.credential.CredentialGathering;
import password_manager.user_interaction.step.PromptStep;
import password_manager.user_interaction.step.TextStep;
import password_manager.user_interaction.UserInterface;

public class TitleScreenWorkflow implements Workflow {
    private final UserInterface userInterface;
    private final CredentialGathering credentialGathering;
    private Workflow nextWorkflow;

    public TitleScreenWorkflow(UserInterface userInterface, CredentialGathering credentialGathering) {
        this.userInterface = userInterface;
        this.credentialGathering = credentialGathering;
    }

    public Workflow getNextWorkflow() {
        return nextWorkflow;
    }

    @Override
    public void start() {
        new TextStep(userInterface, "Welcome to DukePasswordManager!").execute();
        nextWorkflow = workflowSelection();
    }

    private Workflow workflowSelection() {
        String workflowSelectionOptions = "1: add credential\n00: exit application";
        new TextStep(userInterface, workflowSelectionOptions).execute();
        PromptStep workflowSelectionStep = new PromptStep(userInterface, "Select a workflow");
        workflowSelectionStep.execute();
        String workflowSelection = workflowSelectionStep.getUserInput().strip();
        if (workflowSelection.equals("00")) {
            return new ExitWorkflow();
        } else if (workflowSelection.equals("1")) {
            return new CreateCredentialWorkflow(userInterface, credentialGathering);
        }
        return null;
    }
}
