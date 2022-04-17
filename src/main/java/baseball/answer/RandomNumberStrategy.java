package baseball.answer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import baseball.common.Utils;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberStrategy implements NumberStrategy{

    @Override
    public int[] generate() {
        Set<Integer> numbers = new HashSet<Integer>();
        while (numbers.size() < AnswerConfig.ANSWER_LENGTH){
            numbers.add(Randoms.pickNumberInRange(AnswerConfig.ANSWER_NUMBER_MIN, AnswerConfig.ANSWER_NUMBER_MAX));
        }
        List<Integer> numberList = new ArrayList<>(numbers);
        // Collections.shuffle(numberList);

        return Utils.convertArrayFrom(numberList);
    }
    
}
