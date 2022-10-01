package baseball.factory;

import baseball.game.GameRestartPolicy;
import baseball.io.ConsolePrinter;
import baseball.io.ConsoleScanner;

public class GameRestartPolicyFactory {

    public static GameRestartPolicy create() {
        return new GameRestartPolicy(
            new ConsolePrinter(),
            new ConsoleScanner()
        );
    }
}
