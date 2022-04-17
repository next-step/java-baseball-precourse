package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {

    private static final int ANSWER_DIGITS = 3;

    private List<Integer> answer;

    public BaseBallGame() {
        this.initializeAnswer();
    }

    private void initializeAnswer() {
        List<Integer> answers = new ArrayList<>();
        for (int i = 0; i < ANSWER_DIGITS; i++) {
            answers.add(Randoms.pickNumberInRange(1, 9));
        }

        this.answer = answers;
    }

}