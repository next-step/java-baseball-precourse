package baseball.view;

import baseball.contant.BaseballConstant;
import baseball.contant.ExceptionMessage;
import java.util.Arrays;
import java.util.HashSet;

public class UserInputValidator {

    public static void validateUserNumbers(String userNumbers) {
        validateUserNumbersComposition(userNumbers);
        validateUserNumbersSize(userNumbers);
    }

    private static void validateUserNumbersComposition(String userNumbers) {
        if (!userNumbers.matches(BaseballConstant.INPUT_USER_NUMBERS_REG_EXP)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT);
        }
    }

    private static void validateUserNumbersSize(String userNumbers) {
        HashSet<String> splitUserNumbers = new HashSet<>(Arrays.asList(userNumbers.split("")));
        if (splitUserNumbers.size() != BaseballConstant.BASEBALL_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT);
        }
    }

    public static void validateContinue(String continueStr) {
        if (!continueStr.matches(BaseballConstant.INPUT_CONTINUE_REG_EXP)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT);
        }
    }
}
