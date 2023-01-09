import password_manager.UserInterface;
import password_manager.WorkflowExecutor;

public class DukePasswordManager {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        WorkflowExecutor workflowExecutor = new WorkflowExecutor(userInterface);
        workflowExecutor.executeWorkflows();
    }
}
