package baseball.domain;

import baseball.common.Const;
import baseball.view.InputView;

import java.util.List;

public class BaseballController {

    public static boolean isNewGame() {
        int userIntent = Integer.parseInt(InputView.getNewGameOrQuitNumber());

        if(userIntent != Const.NEW_GAME && userIntent != Const.QUIT) {
            System.out.println(Const.NEW_GAME_OPTION_EXCEPTION);
            isNewGame();
        }
        return userIntent == Const.NEW_GAME;
    }

    public static void startBaseballGame(List<Integer> computerBaseballNumbers) {
        List<Integer> userBaseballNumbers = InputView.inputNumbers();
        BaseballGameInfo baseballGame = new BaseballGameInfo(userBaseballNumbers, computerBaseballNumbers);

        if(!baseballGame.getIsWinning()) {
            printResult(baseballGame);
            startBaseballGame(computerBaseballNumbers);
            return;
        }
        ResultMessage.printWinningMessage();
    }

    public static void printResult(BaseballGameInfo baseballGame) {
        ResultMessage.printResult(baseballGame.getStrikeCount(), baseballGame.getBallCount());
    }
}
