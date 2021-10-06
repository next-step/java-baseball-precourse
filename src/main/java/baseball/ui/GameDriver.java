package baseball.ui;

import baseball.domain.Count;
import baseball.domain.Game;
import baseball.domain.Number;

public class GameDriver {

    public void run() {
        PlayerOption option;
        do {
            play();
            option = InputHandler.getPlayerOptionWithRetry();
        } while (option.isContinue());

        OutputHandler.printGameExit();
    }

    public void play() {
        final Number randomNumber = new Number("123");
        final Game game = new Game(randomNumber);
        Number guess;
        Count count;
        do {
            guess = InputHandler.getPlayerNumberWithRetry();
            count = game.guess(guess);
            OutputHandler.printCount(count.toString());
        } while (!count.isStrikeOut());

        OutputHandler.printStrikeOut();
    }
}
