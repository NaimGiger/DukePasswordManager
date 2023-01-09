package password_manager;

public class WorkflowExecutor {
    private final UserInterface userInterface;

    public WorkflowExecutor(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public void executeWorkflows() {
        TitleScreenWorkflow titleScreenWorkflow = new TitleScreenWorkflow(userInterface);
        titleScreenWorkflow.start();
        // TODO: Implement next Workflows
        // titleScreenWorkflow.getNextWorkflow().start();
    }
}
