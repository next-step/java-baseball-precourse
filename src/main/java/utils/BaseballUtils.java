package utils;

import java.util.List;

public class BaseballUtils {

    private BaseballUtils() {
    }

    public static int[] userInputToIntArray(String userInput) {
        int[] numbers = new int[userInput.length()];
        String[] split = userInput.split("");

        for (int i = 0; i < split.length; i++) numbers[i] = Integer.parseInt(split[i]);

        return numbers;
    }

    public static int[] toIntArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) arr[i] = list.get(i);

        return arr;
    }
}
