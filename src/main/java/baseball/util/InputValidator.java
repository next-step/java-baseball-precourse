package baseball.util;

import baseball.exception.BaseBallErrorMessage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static baseball.constant.BaseballProperties.*;

public class InputValidator {
    private final static String NUMERIC = "^[1-9]+$";

    public static void validateGuessNumber(String inputNumber) {
        validateNumeric(inputNumber);
        validateLength(inputNumber);
        validateDuplication(inputNumber);
    }

    private static void validateNumeric(String inputNumber) {
        if(!inputNumber.matches(NUMERIC)) {
            throw new IllegalArgumentException(BaseBallErrorMessage.ONLY_NUMERIC_REQUIRED.getErrorMessage());
        }
    }
    private static void validateLength(String inputNumber) {
        if(inputNumber.length() != GAME_SIZE) {
            throw new IllegalArgumentException(BaseBallErrorMessage.INPUT_SIZE_AND_GAME_SIZE_NOT_EQUAL.getErrorMessage());
        }
    }

    private static void validateDuplication(String inputNumber) {
        Set<String> checkSet = new HashSet<>(Arrays.asList(inputNumber.split("")));
        if(checkSet.size() != GAME_SIZE) {
            throw new IllegalArgumentException(BaseBallErrorMessage.INPUT_NUMBER_DUPLICATION.getErrorMessage());
        }
    }

    public static void validateRestartInput(String restart) {
        validateNumeric(restart);
        validateRange(restart);
    }

    private static void validateRange(String restart) {
        if(!restart.equals(RESTART) && !restart.equals(GAME_SET)) {
            throw new IllegalArgumentException(BaseBallErrorMessage.INVALID_GAME_MENU_NUMBER.getErrorMessage());
        }
    }
}
