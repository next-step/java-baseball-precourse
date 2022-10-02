package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballView {
    private final BaseballController baseballController;

    public BaseballView(BaseballController baseballController) {
        this.baseballController = baseballController;
    }

    public void startGame() {
        String answer = baseballController.makeAnswer();
        boolean isFinished = false;
        while (!isFinished) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            isFinished = baseballController.playGame(answer, input);
        }
        endGame();
    }

    private void endGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (baseballController.checkRestart(input)) {
            startGame();
        }
    }
}
