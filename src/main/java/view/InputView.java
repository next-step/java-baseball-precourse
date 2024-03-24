package view;

import domain.baseball.constants.CommandType;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int input() {
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        scanner.next();
        return 0;
    }
}
