package baseball.controller;

import baseball.model.Answer;
import baseball.model.BullsAndCowsGame;
import baseball.model.Result;
import baseball.model.Trial;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class BullsAndGameController {

    public void start() {
        do {
            Answer answer = generateAnswer();
            BullsAndCowsGame game = new BullsAndCowsGame(answer);
            play(game);
            View.answer();
        } while (restart());
    }

    /**
     * Answer 객체는 3 숫자가 모두 다름을 보장한다.
     * 따라서 같은 수가 포함된 3 수가 생성되면 재귀 호출을 통해 3 수가 다름을 보장한다.
     * @return 3 수가 모두 다른 정답 객체
     */
    private Answer generateAnswer() {
        Answer result;
        try {
            result = new Answer(String.valueOf(Randoms.pickNumberInRange(1, 9)) +
                    Randoms.pickNumberInRange(1, 9) + Randoms.pickNumberInRange(1, 9));
        } catch (IllegalArgumentException e) {
            result = generateAnswer();
        }
        return result;
    }

    private void play(BullsAndCowsGame game) {
        while (!game.isEnd()) {
            String line = Console.readLine();
            Trial trial = new Trial(line);
            Result result = game.challenge(trial);
            View.result(result);
        }
    }

    private boolean restart() {
        View.restart();
        String line = Console.readLine().trim();
        return line.equals("1");
    }
}
