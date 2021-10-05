package baseball.validator;

import baseball.exception.ValidationException;
import baseball.message.Number;
import baseball.message.error.ErrorCode;

import java.util.HashSet;
import java.util.regex.Pattern;

public class InputValidator {

    /**
     * 1~9 인지 체크하는 정규표현식
     */
    private static final Pattern isNumber = Pattern.compile("^[1-9]*?");

    private InputValidator() {
    }


    /**
     * 3자리수가 아니면
     * 문자열이나 0이 들어가있으면
     * 중복되는 숫자가 있으면
     * 에러 메시지를 반환
     * @param input
     * @return
     */
    public static boolean validateInput(String input) {
        validateIsThreeDigits(input);
        validateIsNumberWithOutZero(input);
        validateDuplicateNumber(input);

        return true;
    }


    /**
     * 3자리수 인지 체크
     * @param input
     * @return
     */
    private static void validateIsThreeDigits(String input) {
        if (input.toCharArray().length != Number.INPUT_MAX_VALUE) {
            throw new ValidationException(ErrorCode.VALIDATE_EXCEPTION_IS_NOT_THREE_DIGITS);
        }
    }

    /**
     * 문자열이나 0이 들어가있는지 체크
     * @param input
     * @return
     */
    private static void validateIsNumberWithOutZero(String input) {
        if (!isNumber.matcher(input).matches()) {
            throw new ValidationException(ErrorCode.VALIDATE_EXCEPTION_IS_NOT_NUMBER_OR_CONTAIN_ZERO);
        }
    }

    /**
     * 중복되는 숫자가 있는지 체크
     * @param input
     * @return
     */
    private static void validateDuplicateNumber(String input) {
        final HashSet<Character> set = new HashSet<>();
        for (char aChar : input.toCharArray()) {
            set.add(aChar);
        }
        if (set.size() != Number.INPUT_MAX_VALUE) {
            throw new ValidationException(ErrorCode.VALIDATE_EXCEPTION_IS_DUPLICATE);
        }
    }



}