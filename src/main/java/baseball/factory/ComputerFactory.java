package baseball.factory;

import baseball.game.Computer;
import baseball.io.ConsolePrinter;

public class ComputerFactory {

    public static Computer create() {
        return new Computer(
            new ConsolePrinter()
        );
    }
}
