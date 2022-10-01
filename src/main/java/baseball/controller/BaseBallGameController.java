package baseball.controller;

import baseball.model.Computer;
import baseball.model.Judge;
import baseball.model.User;
import baseball.view.BaseBallGameView;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseBallGameController {

    private boolean executable = true;
    private static final String END_GAME = "2";

    public void start() throws IllegalArgumentException {
        Judge judge = new Judge();
        User user = new User();
        Computer computer = new Computer();
        do {
            checkContinue(computer);
            execute(user, judge);

            BaseBallGameView.printJudgeResult(judge);
        } while (isExecutable(readLine()));
    }

    private static void execute(User user, Judge judge) throws IllegalArgumentException {
        while (!judge.isStrikeOut()) {
            BaseBallGameView.printRequestInput();
            String input = readLine();
            user.throwBalls(input);
            judge.countBalls(new ArrayList<>(Computer.getBallCount()), User.getBallCount());
            BaseBallGameView.notStrikeOut(judge);
        }
    }

    private void checkContinue(Computer computer) {
        if (!executable) {
            return;
        }
        if (executable) {
            computer.throwBalls();
        }
    }

    private boolean isExecutable(String input) {
        if (END_GAME.equals(input)) {
            executable = false;
        }
        return executable;
    }
}
