import model.GameInput;
import model.GameModel;
import model.GameResult;
import model.RandomGenerator;
import view.InputView;
import view.OutputView;

public class BaseballGame {

    private static final int END_STATUS = 2;
    private static final RandomGenerator randomGenerator = new RandomGenerator();

    public static void main(String[] args) {
        final GameModel gameModel = new GameModel(randomGenerator);

        while (true) {
            OutputView.printInfo();
            final String number = InputView.getInput();

            try {
                final GameInput gameInput = new GameInput(number);
                endGameIfPossible(gameInput, gameModel);
                playGame(gameInput, gameModel);
            } catch(IllegalArgumentException exception) {
                OutputView.printError();
            }
        }
    }

    private static void endGameIfPossible(final GameInput gameInpt, final GameModel gameModel) {
        if (!gameModel.isGameEnd(gameInpt)) return;

        OutputView.printEnding();
        final int input = Integer.parseInt(InputView.getInput());

        if (input == END_STATUS) System.exit(0);
    }

    private static void playGame(final GameInput gameInput, final GameModel gameModel) {
        final GameResult gameResult = gameModel.calculateGameResult(gameInput);
        OutputView.printHint(gameResult.getNumOfStrike(), gameResult.getNumOfBall());
    }
}
