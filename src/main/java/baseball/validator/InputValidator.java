package baseball.validator;

import baseball.error.ErrorCode;
import baseball.exception.ValidationException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;

public class InputValidator {

    private static final Pattern isNumber = Pattern.compile("^[1-9]*?");

    private InputValidator() {
    }

    public static String validateInput(String input) {
        if (validateIsThreeDigits(input).startsWith("[ERROR]")) {
            return validateIsThreeDigits(input);
        }
        if (validateIsNumberWithOutZero(input).startsWith("[ERROR]")) {
            return validateIsNumberWithOutZero(input);
        }
        if (validateDuplicateNumber(input).startsWith("[ERROR]")) {
            return validateDuplicateNumber(input);
        }

        return input;
    }




    private static String validateIsThreeDigits(String input) {
        if (input.toCharArray().length != 3) {
            return ErrorCode.VALIDATE_EXCEPTION_IS_NOT_THREE_DIGITS;
        }
        return input;
    }

    private static String validateIsNumberWithOutZero(String input) {
        if (!isNumber.matcher(input).matches()) {
            return ErrorCode.VALIDATE_EXCEPTION_IS_NOT_NUMBER_OR_CONTAIN_ZERO;
        }
        return input;
    }

    private static String validateDuplicateNumber(String input) {
        if (new HashSet<>(Arrays.asList(input.toCharArray())).size() != 3) {
            return ErrorCode.VALIDATE_EXCEPTION_IS_DUPLICATE;
        }
        return input;
    }



}