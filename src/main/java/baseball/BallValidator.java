package baseball;

import java.util.HashSet;
import java.util.Set;

public class BallValidator {

    public static boolean isValidBalls(String input) {
        return isInputHasRightLength(input) && isInputContainsOnlyOneToNine(input) && isInputContainsUniqueNumbers(input);
    }

    public static boolean isInputHasRightLength(String input) {
        return GameConstants.numberOfBalls.equals(input.length());
    }
    public static boolean isInputContainsOnlyOneToNine(String input) {
        return input.matches(GameConstants.regExpressionIsContainOneToNine);
    }

    public static boolean isInputContainsUniqueNumbers(String input) {
        Set<Character> setForDuplicateCheck = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            setForDuplicateCheck.add(input.charAt(i));
        }

        return setForDuplicateCheck.size() == input.length();
    }
}
