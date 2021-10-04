package baseball;

import nextstep.utils.*;

import java.util.Arrays;
import java.util.List;

public class GameController {
    List<Integer> randomNumber;

    protected GameController() {
        randomNumber = GameService.makeRandomNumber(3);
    }

    public void playGame() {
        // TODO

    }

    public boolean askContinue() {
        GameConsole.askContinue();
        String continueNumber = Console.readLine();
        while (!(continueNumber.equals("1") || continueNumber.equals("2"))) {
            GameConsole.errorAskContinue();
            GameConsole.askContinue();
            continueNumber = Console.readLine();
        }

        return continueNumber.equals("1");
    }
}
