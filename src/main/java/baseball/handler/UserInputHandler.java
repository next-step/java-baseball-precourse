package baseball.handler;

import baseball.common.Constants;
import baseball.util.ValidationUtils;
import camp.nextstep.edu.missionutils.Console;

public class UserInputHandler {

    public int inputProgressStep() {
        return Integer.parseInt(validateProgressStep(Console.readLine()));
    }

    public String inputAnswer() {
        return validateInputAnswer(Console.readLine());
    }

    private String validateProgressStep(String input) {
        if (input == null || input.length() != 1 || !ValidationUtils.isOnlyNumber(input)) {
            throw new IllegalArgumentException();
        }

        return input;
    }

    private String validateInputAnswer(String input) {
        if (input == null || input.length() != Constants.LIMIT_DIGITS || !ValidationUtils.isOnlyNumber(input)) {
            throw new IllegalArgumentException();
        }

        return input;
    }

}
