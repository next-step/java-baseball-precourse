package baseball.utils;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    private Utils(){}

    public static List<Integer> convertIntegerArray(String input) {
        List<Integer> newInput = new ArrayList<>();
        String[] inputs = input.split("");
        for (String s : inputs) {
            newInput.add(Integer.parseInt(s));
        }
        return newInput;
    }
}
