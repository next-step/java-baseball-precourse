package util.converter;

import java.util.ArrayList;
import java.util.List;

public class IntegerListConverter {

    public static List<Integer> mapToInts(String input, String delimiter) {
        String[] stringArray = input.split(delimiter);
        List<Integer> nums = new ArrayList<>();
        for (String s : stringArray) {
            nums.add(Integer.valueOf(s));
        }
        return nums;
    }
}
