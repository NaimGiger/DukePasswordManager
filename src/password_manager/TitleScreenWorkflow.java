package password_manager;

public class TitleScreenWorkflow implements Workflow {
    private final UserInterface userInterface;

    public TitleScreenWorkflow(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    @Override
    public void start() {
        new TextStep(userInterface, "Welcome to DukePasswordManager!").execute();
        String workflowSelectionOptions = "1: add credential\n00: exit application";
        new TextStep(userInterface, workflowSelectionOptions).execute();
        PromptStep workflowSelectionStep = new PromptStep(userInterface, "Select a workflow");
        String workflowSelection = workflowSelectionStep.getUserInput();
    }
}
