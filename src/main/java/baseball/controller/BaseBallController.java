package baseball.controller;

import baseball.BaseBallGameManager;
import nextstep.utils.Console;

public class BaseBallController {

    public static void startGame() {
        BaseBallGameManager baseBallGameManager = new BaseBallGameManager();
        while (!baseBallGameManager.isFinished()) {
            System.out.print("숫자를 입력해주세요 : ");
            String userAnswer = Console.readLine();
            baseBallGameManager.checkUserAnswer(userAnswer);
        }
    }
}
