package baseball;

import java.util.*;

public class BallValidator {

    private static final Integer defaultLength = 3;
    private static final String numbersRegExp = "[1-9]{3}";

    public static boolean isInputHasRightLength(String input) {
        return defaultLength.equals(input.length());
    }
    public static boolean isInputContainsOnlyOneToNine(String input) {
        return input.matches(numbersRegExp);
    }

    public static boolean isInputContainsUniqueNumbers(String input) {
        Set<Character> setForDuplicateCheck = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            setForDuplicateCheck.add(input.charAt(i));
        }

        return setForDuplicateCheck.size() == input.length();
    }
}
