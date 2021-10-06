package baseball.utils;

import baseball.exception.BaseballException;
import baseball.exception.BaseballException.InvalidBallFormatException;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {

    public static List<Integer> convertToIntList(String str) {
        List<Integer> ints = new ArrayList<>();
        for (Character e : str.toCharArray()) {
            ints.add(convertInt(String.valueOf(e)));
        }
        return ints;
    }

    public static int convertInt(String str) {
        int result;
        try {
            result = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new InvalidBallFormatException();
        }
        return result;
    }
}
