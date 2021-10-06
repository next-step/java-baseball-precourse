package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Referee;
import baseball.domain.User;
import nextstep.utils.Console;

public class GameController {

    public void run(int gameNumberDigits, int minNumber, int maxNumber){
        Computer computer = new Computer(gameNumberDigits);
        computer.makeQuiz(minNumber, maxNumber);
        Referee referee = new Referee(gameNumberDigits, computer.getQuizList());
        User user = new User();
        while (!referee.isEndGame()){
            System.out.print("숫자를 입력해주세요 : ");
            String readLine = Console.readLine();
            referee.ruleCheck(readLine);
            user.challenge(referee.getInputList());
        }
    }
}
