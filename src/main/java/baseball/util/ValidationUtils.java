package baseball.util;

public class ValidationUtils {
    private ValidationUtils() {}

    public static boolean isOnlyNumber(final String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }

        final String regex = "[0-9]+";

        return input.matches(regex);
    }
}
