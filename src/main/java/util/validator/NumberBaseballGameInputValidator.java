package util.validator;

import exception.NumberBaseballGameException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberBaseballGameInputValidator {

    public static void validateNumbersInput(String inputString) {
        if (!lengthWithinLimit(inputString, 3)) {
            throw new NumberBaseballGameException("[ERROR] 3자리 이하의 숫자를 입력해주세요.");
        }

        if (!isDigitExceptZero(inputString)) {
            throw new NumberBaseballGameException("[ERROR] 1~9사이의 숫자를 입력해주세요.");
        }

        if (!isNotDuplicated(inputString)) {
            throw new NumberBaseballGameException("[ERROR] 중복되지 않는 숫자를 입력해주세요.");
        }
    }

    public static void validateContinueGameInput(String inputString) {
        if (!lengthWithinLimit(inputString, 1)) {
            throw new NumberBaseballGameException("[ERROR] 1 또는 2만 입력해주세요.");
        }

        if (!isOneOrTwo(inputString)) {
            throw new NumberBaseballGameException("[ERROR] 1 또는 2만 입력해주세요.");
        }
    }


    /**
     * Private methods
     */
    private static boolean lengthWithinLimit(String inputString, int n) {
        return inputString.length() <= n;
    }

    private static boolean isDigitExceptZero(String inputString) {
        String[] split = inputString.split("");

        for (String s : split) {
            if (!"123456789".contains(s)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isNotDuplicated(String inputString) {
        String[] split = inputString.split("");
        Set<String> set = new HashSet<>(Arrays.asList(split));

        return inputString.length() == set.size();
    }

    private static boolean isOneOrTwo(String inputString) {
        return "12".contains(inputString);
    }

}
