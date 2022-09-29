package baseball.common;
import java.util.*;

public class Util {
    public static List<Integer> convertToList(String numbers) {
        List<Integer> answer = new ArrayList<>();
        for (String number : numbers.split("")) {
            answer.add(Integer.parseInt(number));
        }
        return answer;
    }
}
