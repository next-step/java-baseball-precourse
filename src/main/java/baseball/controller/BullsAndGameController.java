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
            Answer answer = getAnswer();
            BullsAndCowsGame game = new BullsAndCowsGame(answer);
            play(game);
            View.answer();
        } while (restart());
    }

    private void play(BullsAndCowsGame game) {
        while (!game.isEnd()) {
            String line = Console.readLine();
            Trial trial = new Trial(line);
            Result result = game.challenge(trial);
            View.result(result);
        }
    }

    private Answer getAnswer() {
        Answer result;
        try {
            result = new Answer(String.valueOf(Randoms.pickNumberInRange(1, 9)) +
                    Randoms.pickNumberInRange(1, 9) + Randoms.pickNumberInRange(1, 9));
        } catch (IllegalArgumentException e) {
            result = getAnswer();
        }
        return result;
    }

    private boolean restart() {
        View.restart();
        String line = Console.readLine().trim();
        return line.equals("1");
    }
}
