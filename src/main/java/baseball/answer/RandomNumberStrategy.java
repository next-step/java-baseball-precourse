package baseball.answer;

import java.util.HashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberStrategy implements NumberStrategy{

    @Override
    public int[] generate() {
        Set<Integer> numbers = new HashSet<Integer>();
        while (numbers.size() < AnswerConfig.ANSWER_LENGTH){
            numbers.add(Randoms.pickNumberInRange(AnswerConfig.ANSWER_NUMBER_MIN, AnswerConfig.ANSWER_NUMBER_MAX));
        }

        int[] numbersArray = new int[AnswerConfig.ANSWER_LENGTH];
        int idx = 0;
        for (Integer number : numbers.toArray(new Integer[0])){
            numbersArray[idx] = number.intValue();
            idx++;
        }
        
        return numbersArray;
    }
    
}
