package baseball.controller;

import baseball.domain.BaseballPlayer;
import baseball.domain.BaseballResult;
import baseball.service.Referee;
import baseball.view.GameView;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame implements GameController {

    private final GameView baseballView;
    private final Referee baseballReferee;

    public BaseballGame(GameView baseballView, Referee baseballReferee) {
        this.baseballView = baseballView;
        this.baseballReferee = baseballReferee;
    }

    @Override
    public void start() {
        do {
            gameInit();
        } while (continueGame());
    }

    private void gameInit() {
        BaseballPlayer computer = BaseballPlayer.computer();
        BaseballResult result;

        do {
            result = play(computer);
            baseballView.println(result.getResultScore());
        } while (!result.isGameOver());

        baseballView.continueGame();
    }

    private BaseballResult play(BaseballPlayer computer) {
        baseballView.enter();
        String command = Console.readLine();
        checkCommand(command);
        BaseballPlayer user = BaseballPlayer.user(command);

        return compareNumber(computer, user);
    }

    private void checkCommand(String command) {
        baseballReferee.checkCommand(command);
    }

    private BaseballResult compareNumber(BaseballPlayer player1 , BaseballPlayer player2) {
        return (BaseballResult) baseballReferee.compareNumber(player1, player2);
    }

    private boolean continueGame() {
        return Console.readLine().equals("1");
    }
}
