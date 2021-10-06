package baseball.utils;

import java.util.HashSet;
import java.util.Set;

/**
 * @author KingCjy
 */
public class ValidationUtils {

    private static final int BALL_MAX_LENGTH = 3;

    public static boolean isValidInput(String input) {
        if (input.length() != BALL_MAX_LENGTH
        || hasDuplicatedNumbers(input)
        || !isNumber(input)
        || containsZero(input)) {
            return false;
        }

        return true;
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
