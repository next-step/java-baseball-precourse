package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    public static List<Integer> intToList(int number) {
        String[] textArray = Integer.toString(number).split("");
        List<Integer> result = new ArrayList<>();
        for (String s : textArray) {
            result.add(Integer.parseInt(s));
        }
        return result;
    }
}
