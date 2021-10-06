package baseball;

import baseball.ui.GameDriver;
import baseball.ui.OutputHandler;

public class Application {

    public static void main(String[] args) {
        try {
            final GameDriver driver = new GameDriver();
            driver.run();
        } catch (IllegalArgumentException ex) {
            OutputHandler.printException(ex.getMessage());
        }
    }
}
