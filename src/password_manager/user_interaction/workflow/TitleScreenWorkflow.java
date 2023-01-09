package password_manager.user_interaction.workflow;

import password_manager.user_interaction.step.TextStep;
import password_manager.user_interaction.UserInterface;

public class TitleScreenWorkflow implements Workflow {
    private final UserInterface userInterface;

    public TitleScreenWorkflow(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    @Override
    public void start() {
        new TextStep(userInterface, "Welcome to DukePasswordManager!").execute();
    }
}
