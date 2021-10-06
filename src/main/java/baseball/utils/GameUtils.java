package baseball.utils;

import baseball.domain.Record;
import nextstep.utils.Randoms;

import java.util.*;

public class GameUtils {

    private GameUtils(){}

    public static List<Integer> generateAnswer(){
        Set<Integer> numbers = new LinkedHashSet<>();
        while (numbers.size() < 3){
            int number = Randoms.pickNumberInRange(1,9);
            numbers.add(number);
        }
        return new ArrayList<>(numbers);
    }

    public static Record match(List<Integer> answer, List<Integer> input) {
        Record record = new Record(answer,input);
        for(int i=0; i < input.size();i++){
            calculate(record,i);
        }
        return record;
    }

    private static void calculate(Record record, int i) {
        if(Objects.equals(record.getInput().get(i), record.getAnswer().get(i))){
            record.plusOneStrike();
            return;
        }
        if(record.getAnswer().contains(record.getInput().get(i))){
            record.plusOneBall();
        }
    }


}
