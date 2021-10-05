package baseball;

import nextstep.utils.Randoms;

import java.util.*;

public class GameUtils {

    public static List<Integer> generateAnswer(){
        Set<Integer> numbers = new LinkedHashSet<>();
        while (numbers.size() < 3){
            int number = Randoms.pickNumberInRange(1,9);
            numbers.add(number);
        }
        return new ArrayList<>(numbers);
    }

    public static void match(Record record) {
        for(int i=0; i < record.input.size();i++){
            calculate(record,i);
        }
    }

    private static void calculate(Record record, int i) {
        if(Objects.equals(record.input.get(i), record.answer.get(i))){
            record.plusOneStrike();
            return;
        }
        if(record.answer.contains(record.input.get(i))){
            record.plusOneBall();
        }
    }
}
