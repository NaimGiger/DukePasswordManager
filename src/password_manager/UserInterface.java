package password_manager;

import java.util.Scanner;

public class UserInterface {

    public static final String PROMPT_SYMBOL = "> ";

    public String prompt(String message) {
        System.out.println(message);
        System.out.print(PROMPT_SYMBOL);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
