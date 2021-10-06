package baseball.controller;

import baseball.Game;
import baseball.Player;
import baseball.domain.Computer;
import baseball.domain.Baseball;
import baseball.domain.BaseballResult;

public class BaseballController {

    public void start() {

        Baseball baseball = new Baseball(Computer.createComputerBall());
        BaseballResult baseballResult = baseball.compare(new Baseball(Player.createPlayerBall()));
        baseballResult.gameResultPrint();

        if(baseballResult.allStrike()){
            System.out.println(Game.restart());
        }

    }
}
