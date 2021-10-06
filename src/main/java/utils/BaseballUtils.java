package utils;

import java.util.Arrays;

public class BaseballUtils {

    private BaseballUtils() {
    }

    public static int[] userInputToIntArray(String userInput) {
        return Arrays.stream(userInput.split("")).mapToInt(Integer::parseInt).toArray();
    }
}
