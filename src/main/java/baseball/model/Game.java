package baseball.model;

import baseball.constant.GameEnvironment;
import baseball.constant.GameStatus;
import baseball.util.DataConverter;
import java.util.List;

public class Game {
    private final RandomNumber randomNumber;
    private GameStatus status;

    public Game() {
        randomNumber = new RandomNumber();
        status = GameStatus.START;
    }

    public boolean isRunning() {
        return status == GameStatus.START;
    }

    public boolean isOver() {
        return status == GameStatus.END;
    }

    public void over() {
        status = GameStatus.END;
    }

    public GameCounter play(String input) {
        List<Integer> userNumbers = DataConverter.stringToIntegerList(input);
        List<Integer> gameNumbers = randomNumber.getRandomList();

        GameCounter counter = new GameCounter();
        counter.calculate(userNumbers, gameNumbers);

        checkGameOver(counter);
        return counter;
    }

    private void checkGameOver(GameCounter gameCounter) {
        if (gameCounter.getStrike() == GameEnvironment.NUMBER_SIZE) {
            over();
        }
    }
}