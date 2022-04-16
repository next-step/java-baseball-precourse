package baseball.model;

import baseball.vo.CompareResultVO;
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

    public CompareResultVO compareInputToAnswer(String inputNumber, List<Integer> answerNumberList) {
        return new CompareResultVO(0, 0);
    }

    public List<Integer> getAnswerNumberList() {
        return answerNumberList;
    }

}
