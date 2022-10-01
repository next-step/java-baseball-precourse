package baseball.controller;

import baseball.model.Computer;
import baseball.model.Judge;
import baseball.model.User;
import baseball.view.BaseBallGameView;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseBallGameController {

    private static boolean executable = true;

    public static void start() throws IllegalArgumentException {
        Judge judge = new Judge();
        User user = new User();
        Computer computer = new Computer();
        do {
            if (!executable) {
                break;
            }
            if (executable) {
                computer.throwBalls();
            }

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

    private static boolean isExecutable(String input) {
        if (input.equals("2")) {
            executable = false;
        }

        return executable;
    }
}
