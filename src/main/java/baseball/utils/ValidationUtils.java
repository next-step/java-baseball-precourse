package baseball.utils;

import java.util.HashSet;
import java.util.Set;

/**
 * @author KingCjy
 */
public class ValidationUtils {

    private static final int BALL_MAX_LENGTH = 3;

    public static ValidationResult isValidBallInput(String input) {
        if(input.length() != BALL_MAX_LENGTH) {
            return ValidationResult.BALL_INVALID_LENGTH;
        }
        if(hasDuplicatedNumbers(input)) {
            return ValidationResult.BALL_DUPLICATED_NUMBER;
        }
        if(!(isNumber(input) || containsZero(input))) {
            return ValidationResult.BALL_IS_NOT_NUMBER;
        }
        return ValidationResult.SUCCESS;
    }

    public static ValidationResult isValidRestartInput(String input) {
        if(!isNumber(input)) {
            return ValidationResult.RESTART_INVALID;
        }

        int inputNumber = Integer.parseInt(input);
        if(!(inputNumber == 1 || inputNumber == 2)) {
            return ValidationResult.RESTART_INVALID;
        }

        return ValidationResult.SUCCESS;
    }

    private static boolean hasDuplicatedNumbers(String input) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            set.add(input.charAt(i));
        }

        return set.size() != input.length();
    }

    private static boolean containsZero(String input) {
        return input.contains("0");
    }

    private static boolean isNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
