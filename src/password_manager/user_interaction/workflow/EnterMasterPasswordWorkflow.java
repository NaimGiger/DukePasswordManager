package password_manager.user_interaction.workflow;

import password_manager.security.MasterPasswordChecker;
import password_manager.security.MasterPasswordCreator;
import password_manager.user_interaction.UserInterface;
import password_manager.user_interaction.step.PromptStep;
import password_manager.user_interaction.step.TextStep;

public class EnterMasterPasswordWorkflow implements Workflow {
    private final UserInterface userInterface;

    public EnterMasterPasswordWorkflow(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    @Override
    public void start() throws Exception {
        MasterPasswordChecker masterPasswordChecker = new MasterPasswordChecker();
        if (!masterPasswordChecker.exists()) {
            PromptStep passwordPrompt = new PromptStep(userInterface, "Set new master password");
            passwordPrompt.execute();
            String password = passwordPrompt.getUserInput().strip();
            MasterPasswordCreator masterPasswordCreator = new MasterPasswordCreator(password);
            masterPasswordCreator.storePassword();
            new TextStep(userInterface, "master password is set and stored").execute();
        } else {
            boolean passwordIsCorrect = false;
            while (!passwordIsCorrect) {
                PromptStep passwordPrompt = new PromptStep(userInterface, "Enter your master password");
                passwordPrompt.execute();
                String password = passwordPrompt.getUserInput().strip();
                passwordIsCorrect = masterPasswordChecker.compareToStored(password);
                if (passwordIsCorrect) {
                    new TextStep(userInterface, "master password is correct").execute();
                } else {
                    new TextStep(userInterface, "master password is incorrect").execute();
                }
            }
        }
    }
}
