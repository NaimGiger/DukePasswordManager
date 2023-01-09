package password_manager.user_interaction.workflow;

public class ExitWorkflow implements Workflow {
    @Override
    public void start() {
        System.exit(0);
    }
}
