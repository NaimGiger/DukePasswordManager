import password_manager.credential.CredentialGathering;
import password_manager.user_interaction.UserInterface;
import password_manager.user_interaction.WorkflowExecutor;

public class DukePasswordManager {
    public static void main(String[] args) throws Exception {
        UserInterface userInterface = new UserInterface();
        CredentialGathering credentialGathering = new CredentialGathering();
        WorkflowExecutor workflowExecutor = new WorkflowExecutor(userInterface, credentialGathering);
        workflowExecutor.executeWorkflows();
    }
}
