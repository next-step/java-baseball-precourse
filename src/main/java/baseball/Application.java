package baseball;

import baseball.controller.BaseballGameController;
import baseball.vo.CompareResultVO;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final String NEW_GAME = "1";

    public static void main(String[] args) {
        new Application().startBaseballGame();
    }

    public void startBaseballGame() {
        BaseballGameController baseballGameController = new BaseballGameController();
        boolean isStartNewGame;
        do {
            baseballGameController.newGame();
            proceedGame(baseballGameController);
            isStartNewGame = isStartNewGame(baseballGameController);
        } while (isStartNewGame);
    }

    private boolean isStartNewGame(BaseballGameController baseballGameController) {
        String newOrExitGameView = baseballGameController.newOrExitGameView();
        System.out.println(newOrExitGameView);
        String inputNewOrExit = Console.readLine();
        return NEW_GAME.equals(inputNewOrExit);
    }

    private void proceedGame(BaseballGameController baseballGameController) {
        boolean isAllCorrectAnswer;
        do {
            String inputNumberView = baseballGameController.inputNumberView();
            System.out.print(inputNumberView);
            String inputNumber = Console.readLine();
            CompareResultVO compareResultVO = baseballGameController.proceedGame(inputNumber);
            System.out.println(compareResultVO.getGameResultMessage());
            isAllCorrectAnswer = compareResultVO.isAllCorrectAnswer();
        } while (!isAllCorrectAnswer);
    }
}
