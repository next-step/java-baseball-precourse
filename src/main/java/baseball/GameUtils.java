package baseball;

import nextstep.utils.Randoms;

import java.util.*;

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
        Record record = new Record(answer,input);
        for(int i=0; i < input.length();i++){
            calculate(record,i);
        }
        System.out.println(record.strike+"스트라이크"+record.ball+"볼");
        return record;
    }

    private static int calculate(Record record, int i) {
        if(Objects.equals(record.input.get(i), record.answer.get(i))){
            record.plusOneStrike();
            return 0;
        }
        if(record.answer.contains(record.input.get(i))){
            record.plusOneBall();
            return 0;
        }
        return 1;

    }
}
