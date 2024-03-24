package baseball.ui;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public String getUserInput() {
        Output.printRequestNumberMessage();
        return getInput();
    }

    public String getInput() {
        return scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }
}
