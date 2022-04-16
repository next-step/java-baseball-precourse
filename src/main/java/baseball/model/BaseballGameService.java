package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGameService {

    private final List<Integer> answerNumberList = new ArrayList<>();
    private static final int NUMBER_OF_DIGIT = 3;

    public void createAnswer() {
        answerNumberList.clear();

        for (int count = 0; count < NUMBER_OF_DIGIT; count++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            answerNumberList.add(randomNumber);
        }
    }

    public List<Integer> getAnswerNumberList() {
        return answerNumberList;
    }

}
