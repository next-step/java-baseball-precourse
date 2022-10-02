package baseball.controller;

import baseball.common.ConstMessage;
import baseball.enums.GameStatus;
import baseball.model.Computer;
import baseball.model.User;
import camp.nextstep.edu.missionutils.Console;

public class GameController {

    public GameController() {

    }

    public void playing() {
        start();
        retry();
    }

    private void start() {

        Computer computer = new Computer();
        boolean isClear = false;

        while (!isClear) {
            System.out.print(ConstMessage.INPUT_NUMBER);
            User user = new User(Console.readLine());
            String result = user.score(computer.ballList);
            System.out.println(result);
            isClear = user.userResult.isClear();
        }
    }

    private void retry() {
        System.out.println(ConstMessage.COMPLETE);
        System.out.println(ConstMessage.CONTINUE);
        if (GameStatus.RESTART.equals(getContinueStatus())) {
            playing();
        }
    }

    private GameStatus getContinueStatus() {
        return GameStatus.getCode(Console.readLine());
    }
}
