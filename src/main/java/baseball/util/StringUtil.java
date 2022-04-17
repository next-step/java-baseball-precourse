package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {

    public static List<Integer> numbersStringToList(String numbers) {
        List<Integer> numberList = new ArrayList<>();
        for(int i = 0; i < numbers.length(); i++) {
            numberList.add(Integer.parseInt(numbers.charAt(i)+""));
        }
        return numberList;
    }

    public static void addBetweenWords(StringBuilder sb, String separator) {
        if(sb.length() > 0) sb.append(separator);
    }
}
