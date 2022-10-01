package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class InputUtil {

    public static final String NEXT_LINE = "\n";
    private static final String INVALID_NUMBER_FORMAT_ERROR_MESSAGE = "숫자를 입력해주세요.";
    private static final String INVALID_NUMBER_LENGTH_ERROR_MESSAGE = "3자리 숫자를 입력해주세요.";
    private static final String INVALID_NUMBER_DUPLICATION_ERROR_MESSAGE = "중복되지 않은 숫자를 입력해주세요.";
    private static final int NUMBER_LENGTH = 3;

    private InputUtil() {
    }

    public static List<Integer> getUserNumbers(String input) {

        validateNumberLength(input);

        List<Integer> integers = new ArrayList<>();
        int tempNumber;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            tempNumber = getInteger(getInput(input, i));
            validateDuplicateNumber(integers, tempNumber);
            integers.add(tempNumber);
        }
        return integers;
    }

    private static void validateDuplicateNumber(List<Integer> integers, int tempNumber) {
        if (integers.contains(tempNumber)) {
            throw new IllegalArgumentException(INVALID_NUMBER_DUPLICATION_ERROR_MESSAGE);
        }
    }

    private static String getInput(String input, int i) {
        return String.valueOf(input.charAt(i));
    }

    private static Integer getInteger(String input) {
        int integer;
        try {
            integer = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT_ERROR_MESSAGE);
        }
        return integer;
    }


    private static void validateNumberLength(String input) {
        if (input.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(INVALID_NUMBER_LENGTH_ERROR_MESSAGE);
        }
    }

}
