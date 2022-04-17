package baseball.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class ValidationUtils {

    public static final int FIXED_LENGTH = 3;
    private static final Pattern ONLY_NUMBER = Pattern.compile("^[0-9]+$");

    public static boolean validateLength(final int number, final int length) {
        return Integer.toString(number).length() == length;
    }

    public static boolean validateNumberRange(final int number, final int min, final int max) {
        return min <= number && number <= max;
    }

    public static boolean validateDuplication(final int number) {
        Set<Character> s = new HashSet<>();
        for (final char c : Integer.toString(number).toCharArray()) {
            s.add(c);
        }
        return s.size() == FIXED_LENGTH;
    }

    public static boolean isNumeric(String userInput) {
        return ONLY_NUMBER.matcher(userInput).matches();
    }
}
