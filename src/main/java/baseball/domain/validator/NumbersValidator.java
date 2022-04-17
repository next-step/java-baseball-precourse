package baseball.domain.validator;

import java.util.Arrays;
import java.util.HashSet;

public class NumbersValidator {
    static final int MIN_NUM = 1;
    static final int MAX_NUM = 9;
    private static final String regx = "[" + MIN_NUM + "-" + MAX_NUM + "]+";

    public static boolean isNumbersValidate(String numberString, int size) {

        if (isNotNumber(numberString)) {
            throw new IllegalArgumentException();
        }

        if (isOutOfSize(numberString, size)) {
            throw new IllegalArgumentException();
        }

        if (isDuplicateInNumbers(numberString, size)) {
            throw new IllegalArgumentException();
        }

        return true;
    }

    private static boolean isNotNumber(String numberString) {
        return !numberString.matches(regx);
    }

    private static boolean isOutOfSize(String numberString, int size) {
        return numberString.length() != size;
    }

    private static boolean isDuplicateInNumbers(String numberString, int size) {
        HashSet<String> checkNumberSet = new HashSet<>(Arrays.asList(numberString.split("")));
        return checkNumberSet.size() != size;
    }

}
