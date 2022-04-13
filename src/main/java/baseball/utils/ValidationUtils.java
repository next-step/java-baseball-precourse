package baseball.utils;

import java.util.HashSet;
import java.util.Set;

public class ValidationUtils {

    public static final int FIXED_LENGTH = 3;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    public static boolean validateLength(int number) {
        return Integer.toString(number).length() == FIXED_LENGTH;
    }

    public static boolean validateNumber(int number) {
        return MIN_NUMBER <= number && number <= MAX_NUMBER;
    }

    public static boolean validateDuplication(int number) {
        Set<Character> s = new HashSet<>();
        for (final char c : Integer.toString(number).toCharArray()) {
            s.add(c);
        }
        return s.size() == FIXED_LENGTH;
    }
}
