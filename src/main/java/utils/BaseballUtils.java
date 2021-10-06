package utils;

import java.util.Arrays;
import java.util.List;

public class BaseballUtils {

    private BaseballUtils() {
    }

    public static int[] userInputToIntArray(String userInput) {
        return Arrays.stream(userInput.split("")).mapToInt(Integer::parseInt).toArray();
    }

    public static int[] toIntArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) arr[i] = list.get(i);

        return arr;
    }
}
