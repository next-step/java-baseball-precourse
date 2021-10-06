package utils;

import java.util.ArrayList;
import java.util.List;

public class TestUtils {
    public static List<Integer> arrayToList(int[] arr) {
        List<Integer> numbers = new ArrayList<>(arr.length);
        for (int i : arr) numbers.add(i);
        return numbers;
    }
}
