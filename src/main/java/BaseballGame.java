import view.InputView;
import view.OutputView;

public class BaseballGame {

    public static void main(String[] args) {
        final GameController gameController = new GameController();
        gameController.setupGame();

        while (true) {
            OutputView.printInfo();
            String number = InputView.getNumber();

            if (gameController.isGameEnd(number)){
               OutputView.printEnding();
                break;
            }

            int[] gameResult = gameController.calculateGameResult(number);
            OutputView.printHint(gameResult[0], gameResult[1]);
        }
    }
}
