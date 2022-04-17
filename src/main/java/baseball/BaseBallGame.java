package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {

    private static final int ANSWER_DIGITS = 3;

    private List<Integer> answer;

    public BaseBallGame() {
        this.initializeAnswer();
    }

    public void start() {
        System.out.print("숫자를 입력 해 주세요 : ");
        String input = this.validateInput(Console.readLine());
        BaseBallGameHint hint = BaseBallGameAnswerComparator.compare(this.answer, input);

        System.out.println(hint.toMessage());
    }

    private void initializeAnswer() {
        List<Integer> answers = new ArrayList<>();
        for (int i = 0; i < ANSWER_DIGITS; i++) {
            answers.add(Randoms.pickNumberInRange(1, 9));
        }

        this.answer = answers;
    }

    private String validateInput(final String input) {
        boolean isEmpty = input == null || input.length() == 0;
        if (isEmpty || input.length() > ANSWER_DIGITS) {
            throw new IllegalArgumentException();
        }

        return input;
    }

}