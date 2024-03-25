package NumberBaseball.controller;

import NumberBaseball.model.BaseballConfig;

public class InputValidator {
    private static final String VALID_PATTERN = "\\d{" + BaseballConfig.BASEBALL_NUMBER_LENGTH + "}";
    private static final String RESTART_VALID_PATTERN = "[1-2]";

    public static void isValid(String input) {
        if (input == null || !input.matches(VALID_PATTERN) || input.length() != BaseballConfig.BASEBALL_NUMBER_LENGTH)
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT);
    }

    public static void isRestartValid(String input) {
        if (input == null || !input.matches(RESTART_VALID_PATTERN))
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT);
    }
}
