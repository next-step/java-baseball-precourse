import java.util.Optional;
import model.GameInput;
import model.GameAnswer;
import model.GameResult;
import model.RandomGenerator;
import view.InputView;
import view.OutputView;

public class BaseballGame {

    private static final int END_STATUS = 2;
    private static final RandomGenerator randomGenerator = new RandomGenerator();

    public static void main(String[] args) {
        while (true) {
            playGame();

            final int input = Integer.parseInt(InputView.getInput());
            if (input == END_STATUS) break;
        }
    }

    private static void playGame() {
        final GameAnswer gameAnswer = new GameAnswer(randomGenerator);

        while (true) {
            OutputView.printInfo();

            final String number = InputView.getInput();
            final boolean isGameEnd = evaluateInput(gameAnswer, number)
                .map(GameResult::isGameEnd)
                .orElse(false);

            if (isGameEnd) {
                OutputView.printEnding();
                break;
            }
        }
    }

    private static Optional<GameResult> evaluateInput(final GameAnswer gameAnswer, final String number) {
        try {
            final GameInput gameInput = new GameInput(number);
            final GameResult gameResult = gameAnswer.calculateGameResult(gameInput);
            OutputView.printHint(gameResult.getNumOfStrike(), gameResult.getNumOfBall());
            return Optional.of(gameResult);
        } catch (IllegalArgumentException exception) {
            OutputView.printError();
            return Optional.empty();
        }
    }
}
