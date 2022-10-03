package baseball.controller;

import baseball.model.Computer;
import baseball.model.Referee;
import baseball.model.User;
import baseball.view.PrintManager;


public class GameController {

    private final Computer computer;

    private final User user;

    private final Referee referee;

    public GameController() {
        computer = new Computer();
        user = new User();
        referee = new Referee();
    }

    public void start() {
        while (referee.continuesGame()) {
            PrintManager.printInputNumber();
            user.inputNumber();
            referee.judgeInning(computer, user);
            PrintManager.printCount(referee.getStrikeCount(), referee.getBallCount());
        }
        PrintManager.printFinishGame();
    }
}