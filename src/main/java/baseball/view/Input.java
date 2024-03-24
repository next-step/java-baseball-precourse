package baseball.view;

import baseball.domain.GameCommand;
import baseball.domain.UserInputNumbers;

import java.util.Scanner;

public class Input {

    private static final Scanner scanner = new Scanner(System.in);
    public static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    public static GameCommand command() {
        System.out.print("게임을 시작하려면 1, 게임을 종료하려면 2를 입력해주세요 : ");
        try {
            String input = scanner.nextLine();
            return GameCommand.from(input);
        } catch (Exception e) {
            System.out.println(ERROR_MESSAGE_PREFIX + e.getMessage());
        }
        return command();
    }

    public static UserInputNumbers numbers() {
        System.out.print("숫자를 입력해주세요 : ");
        try {
            String input = scanner.nextLine();
            return UserInputNumbers.from(input);
        } catch (Exception e) {
            System.out.println(ERROR_MESSAGE_PREFIX + e.getMessage());
        }
        return numbers();
    }
}
