package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static List<Integer> stringToList(String string) {
        List<Integer> result = new ArrayList<>();
        char[] chars = string.toCharArray();

        for (char ch : chars) {
            result.add(ch - 48);
        }

        return result;
    }
}
