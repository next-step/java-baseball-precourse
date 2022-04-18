package baseball;

import baseball.common.Constants;
import baseball.contoller.BaseballGame;
import baseball.model.GameManager;
import baseball.view.InquireReader;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        do {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.start();
        }
        while (inquireReGame());
    }

    public static boolean inquireReGame() {
        GameManager gameManager = new GameManager(InquireReader.inquireReGame());
        gameManager.validCheckGameStatusNumber(gameManager.getGameStatusNumber());

        if (gameManager.getGameStatusNumber().equals(Constants.GAME_STATUS_RESTART_NUMBER)) {
            return true;
        }
        return false;
    }
}
