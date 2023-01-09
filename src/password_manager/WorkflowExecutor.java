package password_manager;

public class WorkflowExecutor {
    private final UserInterface userInterface;

    public WorkflowExecutor(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public void executeWorkflows() {
        TitleScreenWorkflow titleScreenWorkflow = new TitleScreenWorkflow(userInterface);
        titleScreenWorkflow.start();
        Workflow nextWorkflow = titleScreenWorkflow.getNextWorkflow();
        nextWorkflow.start();
    }
}
