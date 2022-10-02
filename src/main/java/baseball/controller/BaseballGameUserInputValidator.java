package baseball.controller;

public class BaseballGameUserInputValidator {
    public static void validateUserNumberInput(String input, int length) {
        if (input == null) {
            throw new IllegalArgumentException();
        }

        try {
            Integer.parseInt(input);
        } catch (NumberFormatException ignored) {
            throw new IllegalArgumentException();
        }

        if (input.length() != length) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateRestartCommand(int command) {
        if (command != 1 && command != 2) {
            throw new IllegalArgumentException();
        }
    }
}
