package baseball;

import baseball.controller.GameController;
import baseball.view.PrintManager;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    private boolean isContinue = true;

    public static void main(String[] args) {
        Application application = new Application();
        while (application.isContinue) {
            GameController gameController = new GameController();
            gameController.start();
            application.checkContinue();
        }
    }

    private void checkContinue() {
        PrintManager.printCheckContinueGame();
        String input = Console.readLine();
        if ("1".equals(input)) {
            return;
        }
        if ("2".equals(input)) {
            isContinue = false;
            return;
        }
        throw new IllegalArgumentException("잘못된 숫자를 입력했습니다.");
    }
}