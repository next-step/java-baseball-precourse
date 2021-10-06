package baseball.controller;

import baseball.domain.*;
import baseball.veiw.PlayerResponse;

public class BaseballController {

    public void start() {
        Baseball baseball;
        do {
            baseball = new Baseball(Computer.createComputerBall());
        } while (baseballGamePlay(baseball));

    }

    private boolean baseballGamePlay(Baseball baseball) {
        boolean playCheck = true;
        while (playCheck) {
            PlayerResponse response = Player.createPlayerBall();
            playCheck = isPlayCheck(baseball, playCheck, response);
        }
        return Game.restart();
    }

    private boolean isPlayCheck(Baseball baseball, boolean playCheck, PlayerResponse response) {
        if (response.isSuccess()) {
            BaseballResult baseballResult = baseball.compare(new Baseball(response));
            baseballResult.playResultPrint();
            return isPlayCheck(playCheck, baseballResult);
        }
        response.errorPrint();
        return playCheck;
    }

    private boolean isPlayCheck(boolean playCheck, BaseballResult baseballResult) {
        if (baseballResult.allStrike()) {
            playCheck = false;
        }
        return playCheck;
    }
}
