package password_manager;

public class TextStep implements Step {
    private final UserInterface userInterface;
    private final String text;

    public TextStep(UserInterface userInterface, String text) {
        this.text = text;
        this.userInterface = userInterface;
    }

    @Override
    public void execute() {
        userInterface.printMessage(text);
    }
}
