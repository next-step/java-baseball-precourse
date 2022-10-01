package baseball.factory;

import baseball.game.Player;
import baseball.io.ConsolePrinter;
import baseball.io.ConsoleScanner;

public class PlayerFactory {

    public static Player create() {
        return new Player(
            new ConsolePrinter(),
            new ConsoleScanner()
        );
    }
}
