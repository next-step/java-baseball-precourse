package baseball;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameUtils {

    public static List<Integer> generateAnswer(){
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < 3){
            int number = Randoms.pickNumberInRange(1,9);
            numbers.add(number);
        }
        return new ArrayList<>(numbers);
    }

    public static Record match(List<Integer> answer, String input) {
        return new Record();
    }
}
