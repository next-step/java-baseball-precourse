package baseball.view;

import baseball.constant.GameMessage;
import baseball.validation.GameValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputConsole {
    public static String readGameNumbers() {
        String input = printNumberInputView();
        boolean isValid = GameValidator.isValidGameNumbers(input);
        occursErrorBy(isValid);

        return input;
    }

    public static String readRestartNumber() {
        String input = printRestartInputView();
        boolean isValid = GameValidator.isValidRestartNumber(input);
        occursErrorBy(isValid);

        return input;
    }

    private static void occursErrorBy(boolean isValid) {
        if (!isValid) {
            OutputConsole.printErrorView();
            throw new IllegalArgumentException(GameMessage.GAME_ERROR_OUTPUT);
        }
    }

    private static String printNumberInputView() {
        System.out.print(GameMessage.PLAYER_NUMBER_INPUT);
        return Console.readLine();
    }

    private static String printRestartInputView() {
        System.out.println(GameMessage.PLAYER_RESTART_INPUT);
        return Console.readLine();
    }
}