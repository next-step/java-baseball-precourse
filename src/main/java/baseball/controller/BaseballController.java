package baseball.controller;

import baseball.Game;
import baseball.Player;
import baseball.domain.Computer;
import baseball.domain.Baseball;
import baseball.domain.BaseballResult;

public class BaseballController {

    public void start() {
        Baseball baseball;
        do {
            baseball = new Baseball(Computer.createComputerBall());
        } while (baseballGamePlay(baseball));

    }

    private boolean baseballGamePlay(Baseball baseball) {
        boolean playCheck = true;
        while(playCheck) {
            BaseballResult baseballResult = baseball.compare(new Baseball(Player.createPlayerBall()));
            baseballResult.playResultPrint();
            playCheck = isPlayCheck(playCheck, baseballResult);
        }
        return Game.restart();
    }

    private boolean isPlayCheck(boolean playCheck, BaseballResult baseballResult) {
        if (baseballResult.allStrike()) {
            playCheck = false;
        }
        return playCheck;
    }
}
