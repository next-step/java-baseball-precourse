package baseball.controller;

import baseball.aggregate.RefereeService;
import baseball.domain.Computer;
import baseball.domain.User;
import baseball.view.ConsoleView;

public class GameController {

    public void run(int gameNumberDigits, int minNumber, int maxNumber){
        RefereeService referee = new RefereeService(gameNumberDigits, minNumber, maxNumber);
        Computer computer = new Computer(gameNumberDigits);
        User user = new User();
        referee.ready(computer);
        do {
            System.out.println(computer.getQuizList());
            user.setReadLine(ConsoleView.readInput(user));
            referee.gameDoingCheck(user, computer);
        }
        while (!user.getIsEndPlay());
    }
}
