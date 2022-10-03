package baseball.utils;

import java.util.ArrayList;
import java.util.List;

public class ConvertUtil {
    public static List<Integer> convertIntegerToIntegerList(String input) {
        List<Integer> convertedList = new ArrayList<>();
        for(String number : input.split("")) {
            convertedList.add(Integer.parseInt(number));
        }
        return convertedList;
    }
}
