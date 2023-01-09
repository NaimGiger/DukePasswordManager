import password_manager.user_interaction.UserInterface;
import password_manager.user_interaction.WorkflowExecutor;

public class DukePasswordManager {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        WorkflowExecutor workflowExecutor = new WorkflowExecutor(userInterface);
        workflowExecutor.executeWorkflows();
    }
}
