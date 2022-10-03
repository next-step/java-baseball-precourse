package baseball;

import java.util.ArrayList;
import java.util.List;

public class ConvertUtils {

    public static List<Integer> StringToList(String str) {
        List<Integer> convert = new ArrayList<>();
        convert.add(Integer.parseInt(str.substring(0, 1)));
        convert.add(Integer.parseInt(str.substring(1, 2)));
        convert.add(Integer.parseInt(str.substring(2, 3)));

        return convert;
    }
}
