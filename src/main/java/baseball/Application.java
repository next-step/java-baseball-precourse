package baseball;

import baseball.dto.BaseballDto;
import baseball.service.GameService;
import baseball.service.ConsoleService;

import static baseball.constants.BaseballConstants.START_CODE;

public class Application {
    public static void main(String[] args) {
        boolean isStartGame = true;

        while(isStartGame) {
            newGame();
            isStartGame = isContinueGame();
        }
    }

    private static void newGame() {
        String gameNumber = GameService.newNumber(3);

        while(true) {
            String inputNumber = ConsoleService.doInputNumber();
            BaseballDto baseball = GameService.checkStrikeAndBall(gameNumber, inputNumber);
            ConsoleService.printGameScore(baseball);

            if (baseball.getStrike() == 3) break;
        }
    }

    private static boolean isContinueGame() throws IllegalArgumentException{
        String number = ConsoleService.doInputGameCode();

        if(START_CODE.equals(number)) {
            return true;
        }

        return false;
    }
}
