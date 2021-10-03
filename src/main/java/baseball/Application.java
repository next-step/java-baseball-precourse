package baseball;

import baseball.domain.BaseballGame;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현


        BaseballGame game = new BaseballGame();
        while (game.start()) { }


    }
}
