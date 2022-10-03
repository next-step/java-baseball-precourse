package baseball.domain.input;

import static baseball.type.ErrorMessageType.INPUT_NOT_ALLOW_BLANK;

public interface Input<T> {

    void validate();

    T create();

    default void validateBlank(String input) {
        if (isNullOrEmpty(input) || isWhitespace(input)) {
            throw new IllegalArgumentException(INPUT_NOT_ALLOW_BLANK.getMessage());
        }
    }

    static boolean isWhitespace(String input) {
        for (int i = 0; i < input.length(); i++) {
            char charAt = input.charAt(i);
            if (Character.isWhitespace(charAt)) {
                return true;
            }
        }
        return false;
    }

    static boolean isNullOrEmpty(String input) {
        return input == null || input.length() == 0;
    }
}
