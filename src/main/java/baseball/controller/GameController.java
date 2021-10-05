package baseball.controller;

import baseball.domain.Referee;
import baseball.domain.User;
import nextstep.utils.Console;

public class GameController {

    public void run(int gameNumberDigits){
        Referee referee = new Referee(gameNumberDigits);
        User user = new User();
        while (!referee.isEndGame()){
            System.out.print("숫자를 입력해주세요 : ");
            String readLine = Console.readLine();
            // System.out.println("readLine :  "+ readLine);
            referee.ruleCheck(readLine);
            user.challenge(referee.getInputList());
        }
    }
}
