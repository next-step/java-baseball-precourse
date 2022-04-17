package baseball.controller;

import baseball.model.Computer;
import baseball.model.GameProcessor;
import baseball.view.MessagePrinter;
import baseball.model.Player;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseballGameController {

    final String RETRY = "1";
    final String TERMINATE = "2";

    public void start() {
        boolean isStart = true;
        while (isStart) {
            isStart = init();
        }
        terminate();
    }

    public boolean init() {
        boolean isThreeStrike = false;
        GameProcessor gameProcessor = new GameProcessor(new Player(), new Computer());
        while (!isThreeStrike) {
            isThreeStrike = gameProcessor.playGame();
        }
        MessagePrinter.printAskRetry();
        String continueFlag = readLine();
        return retry(continueFlag);
    }

    private boolean retry(String continueFlag) {
        if (continueFlag.equals(RETRY)) {
            MessagePrinter.printRetry();
            return true;
        }
        if (continueFlag.equals(TERMINATE)) {
            return false;
        }
        throw new IllegalArgumentException();
    }

    public static void terminate() {
        MessagePrinter.printTerminate();
    }
}
