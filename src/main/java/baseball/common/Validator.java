package baseball.common;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Validator {
    public static boolean isValidBaseballNumber(String input) {
        return isNumberRange(input) && isNotDuplicate(input);
    }

    private static boolean isNumberRange(String input) {
        Pattern numberPattern = Pattern.compile("^[1-9]{3}$");
        return numberPattern.matcher(input).matches();
    }
    private static boolean isNotDuplicate(String input) {
        String[] inputArray = input.split("");
        Set<String> inputSet = new HashSet<>(Arrays.asList(inputArray));
        return inputSet.size() == 3;
    }

    public static boolean isValidRestartFlag(String input) {
        Pattern numberPattern = Pattern.compile("^[1-2]{1}$");
        return numberPattern.matcher(input).matches();
    }
}
