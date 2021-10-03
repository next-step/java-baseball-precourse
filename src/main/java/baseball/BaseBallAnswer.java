package baseball;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseBallAnswer {

    private static final int ANSWER_SIZE = 3;

    private List<Integer> answer = new ArrayList<>();

    public BaseBallAnswer() {
        while (answer.size() != ANSWER_SIZE) {
            int number = Randoms.pickNumberInRange(1, 9);
            addNumber(number);
        }
    }

    private void addNumber(int number) {
        if (answer.contains(number)) {
            return;
        }
        answer.add(number);
    }

    public List<Integer> getAnswer() {
        return answer;
    }

}
