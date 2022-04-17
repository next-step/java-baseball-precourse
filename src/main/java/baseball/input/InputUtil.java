package baseball.input;

import java.util.ArrayList;
import java.util.List;

public class InputUtil {
    public static List<Integer> convertToIntegerList(String input) {
        List<Integer> result = new ArrayList<>();
        String[] inputArray = input.split("");
        for (int i = 0 ; i < input.length(); i++) {
            result.add(Integer.parseInt(inputArray[i]));
        }
        return result;
    }
}
