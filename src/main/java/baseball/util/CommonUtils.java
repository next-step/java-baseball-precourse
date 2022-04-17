package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class CommonUtils {

    private CommonUtils() {}

    public static List<Integer> convertStringArrayToIntegerList(final String[] arr) {
        final List<Integer> list = new ArrayList<>();

        for (String element : arr) {
            list.add(Integer.parseInt(element));
        }

        return list;
    }
}
