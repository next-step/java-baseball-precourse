package baseball.controller;

import baseball.domain.Game;
import baseball.domain.Player;
import baseball.domain.Computer;
import baseball.domain.Baseball;
import baseball.domain.BaseballResult;
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
        while(playCheck) {
            PlayerResponse response = Player.createPlayerBall();
            if(response.isSuccess()){
                BaseballResult baseballResult = baseball.compare(new Baseball(response));
                baseballResult.playResultPrint();
                playCheck = isPlayCheck(playCheck, baseballResult);
            } else {
                response.errorPrint();
            }
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
