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
        validateIsThreeDigits(input);
        validateIsNumberWithOutZero(input);
        validateDuplicateNumber(input);

        return input;
    }




    private static void validateIsThreeDigits(String input) {
        if (input.toCharArray().length != 3) {
            throw new ValidationException(ErrorCode.VALIDATE_EXCEPTION_IS_NOT_THREE_DIGITS);
        }
    }

    private static void validateIsNumberWithOutZero(String input) {
        if (!isNumber.matcher(input).matches()) {
            throw new ValidationException(ErrorCode.VALIDATE_EXCEPTION_IS_NOT_NUMBER_OR_CONTAIN_ZERO);
        }
    }

    private static void validateDuplicateNumber(String input) {
        if (new HashSet<>(Arrays.asList(input.toCharArray())).size() != 3) {
            throw new ValidationException(ErrorCode.VALIDATE_EXCEPTION_IS_DUPLICATE);
        }
    }



}