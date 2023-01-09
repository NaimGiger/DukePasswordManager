package password_manager;

public class ExitWorkflow implements Workflow {
    @Override
    public void start() {
        System.exit(0);
    }
}
