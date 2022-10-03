package baseball.utils;

import java.util.LinkedHashSet;

public class ValidationUtils {

    public static final String MESSAGE_ERROR_INPUT_3DIGIT = "3자리의 숫자만 입력가능합니다.";
    public static final String MESSAGE_ERROR_INPUT_INVALID = "숫자(1~9)가 아닌 문자가 입력되었습니다.";
    public static final String MESSAGE_ERROR_INPUT_DUPLICATE = "중복된 숫자가 입력되었습니다.";
    public static final int INPUT_LENGTH = 3;
    public static final int MIN = 1;
    public static final int MAX = 9;


    public static void validate(String input) {
        checkLength(input.length(), MESSAGE_ERROR_INPUT_3DIGIT);

        LinkedHashSet<Integer> temp = new LinkedHashSet<>();
        for (int i = 0; i < input.length(); i++) {
            int tempValue = input.charAt(i) - '0';
            checkInvalid(tempValue < MIN || tempValue > MAX, MESSAGE_ERROR_INPUT_INVALID);
            temp.add(tempValue);
        }

        checkDuplicate(temp.size() != INPUT_LENGTH, MESSAGE_ERROR_INPUT_DUPLICATE);
    }

    private static void checkLength(int length, String messageErrorInput3digit) {
        checkInvalid(length != INPUT_LENGTH, messageErrorInput3digit);
    }

    private static void checkInvalid(boolean b, String messageErrorInputInvalid) {
        checkDuplicate(b, messageErrorInputInvalid);
    }

    private static void checkDuplicate(boolean b, String messageErrorInputDuplicate) {
        if (b) {
            throw new IllegalArgumentException(messageErrorInputDuplicate);
        }
    }
}
