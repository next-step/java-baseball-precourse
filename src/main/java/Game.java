import view.InputView;
import view.OutputView;

public class Game {

    private static final RandomGenerator randomGenerator = new RandomGenerator();

    public static void main(String[] args) {
        final GameModel gameModel = new GameModel(randomGenerator);

        while (true) {
            OutputView.printInfo();
            String number = InputView.getNumber();

            if (gameModel.isGameEnd(number)){
               OutputView.printEnding();
                break;
            }

            int[] gameResult = gameModel.calculateGameResult(number);
            OutputView.printHint(gameResult[0], gameResult[1]);
        }
    }
}
