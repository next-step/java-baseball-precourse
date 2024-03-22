import model.GameModel;
import model.GameResult;
import model.RandomGenerator;
import view.InputView;
import view.OutputView;

public class Game {

    private static final RandomGenerator randomGenerator = new RandomGenerator();

    public static void main(String[] args) {
        final GameModel gameModel = new GameModel(randomGenerator);

        while (true) {
            OutputView.printInfo();
            final String number = InputView.getNumber();

            if (gameModel.isGameEnd(number)){
               OutputView.printEnding();
               break;
            }

            final GameResult gameResult = gameModel.calculateGameResult(number);
            OutputView.printHint(gameResult.getNumOfStrike(), gameResult.getNumOfBall());
        }
    }
}
