package baseball.service.executor;

import baseball.domain.BaseballGame;
import baseball.domain.BaseballGameScoreBoard;
import baseball.domain.GameMessage;
import baseball.service.AnswerMaker;
import nextstep.utils.Console;

import static baseball.domain.GameMessagePrinter.print;
import static baseball.service.AnswerMaker.isValid;

public class BaseballGameExecutor {

    public void execute() {

        do {
            BaseballGame baseballGame = new BaseballGame(AnswerMaker.make());
            executeSingleGame(baseballGame);

            print(GameMessage.ASK_RESTART_OR_DONE);
        } while (isRestartGame());
    }

    public void executeSingleGame(BaseballGame baseballGame) {
        do {
            print(GameMessage.ASK_INPUT);
            print(deal(baseballGame));
        } while (isSingleGameContinue(baseballGame));
    }

    private boolean isRestartGame() {

        final String input = Console.readLine();

        if (input.equals("1")) {
            return true;
        }

        if (input.equals("2")) {

            print(GameMessage.END_PROGRAM);
            return false;
        }

        print(GameMessage.ERR_PUT_ONLY_1_OR_2);
        return isRestartGame();
    }

    private BaseballGameScoreBoard deal(BaseballGame baseballGame) {

        String input = Console.readLine();

        if (isValid(input)) {
            return baseballGame.deal(input);
        }

        print(GameMessage.ERR_PUT_ONLY_THREE_NUMBERS);
        print(GameMessage.ASK_INPUT);
        return deal(baseballGame);
    }

    private boolean isSingleGameContinue(BaseballGame baseballGame) {
        if (baseballGame.isContinue()) {
            return true;
        }
        print(GameMessage.END_SINGLE_GAME_WITH_THREE_STRIKES);
        return false;
    }
}
