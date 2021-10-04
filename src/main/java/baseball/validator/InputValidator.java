package baseball.validator;

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


    /**
     * 3자리수 인지 체크
     * @param input
     * @return
     */
    private static String validateIsThreeDigits(String input) {
        if (input.toCharArray().length != 3) {
            return ErrorCode.VALIDATE_EXCEPTION_IS_NOT_THREE_DIGITS;
        }
        return input;
    }

    /**
     * 문자열이나 0이 들어가있는지 체크
     * @param input
     * @return
     */
    private static String validateIsNumberWithOutZero(String input) {
        if (!isNumber.matcher(input).matches()) {
            return ErrorCode.VALIDATE_EXCEPTION_IS_NOT_NUMBER_OR_CONTAIN_ZERO;
        }
        return input;
    }

    /**
     * 중복되는 숫자가 있는지 체크
     * @param input
     * @return
     */
    private static String validateDuplicateNumber(String input) {
        final HashSet<Character> set = new HashSet<>();
        for (char aChar : input.toCharArray()) {
            set.add(aChar);
        }
        if (set.size() != 3) {
            return ErrorCode.VALIDATE_EXCEPTION_IS_DUPLICATE;
        }
        return input;
    }



}