package password_manager;

public class PromptStep implements Step {
    private final UserInterface userInterface;
    private final String promptMessage;
    private String userInput;

    public PromptStep(UserInterface userInterface, String prompt) {
        this.userInterface = userInterface;
        this.promptMessage = prompt;
    }

    @Override
    public void execute() {
        userInput = userInterface.prompt(promptMessage);
    }

    public String getUserInput() {
        return userInput;
    }
}
