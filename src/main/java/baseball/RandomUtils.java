package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomUtils {

    public static List<Integer> makeAnswerNumbers(){
        List<Integer> answer = new ArrayList<>();
        while(answer.size() != 3){
            int nowNo = Randoms.pickNumberInRange(1,9);
            if(!answer.contains(nowNo)){
                answer.add(nowNo);
            }
        }
        return answer;
    }
}
