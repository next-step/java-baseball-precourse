package baseball.util;

import static baseball.type.ErrorMessageType.INPUT_ONLY_ALLOW_NUMBER;

public class StringUtils {

    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ONLY_ALLOW_NUMBER.getMessage());
        }
    }

}
