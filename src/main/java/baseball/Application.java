package baseball;

import baseball.view.BaseballGame;

public class Application {
    public static void main(String[] args) {

        BaseballGame baseballGame = BaseballGame.getInstance();

        do {
            baseballGame.playBall();
        } while (baseballGame.contiuePlay());

    }
}
