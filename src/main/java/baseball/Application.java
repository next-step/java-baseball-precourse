package baseball;

import baseball.view.BaseBallGame;

public class Application {
    public static void main(String[] args) {
        BaseBallGame baseballGame = BaseBallGame.getInstance();

        do {
            baseballGame.playBall();
        } while (baseballGame.contiuePlay());


    }
}
