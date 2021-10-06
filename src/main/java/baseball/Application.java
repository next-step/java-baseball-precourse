package baseball;

import baseball.controller.BaseballGame;
import baseball.service.RandomBallsGenerator;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame(new RandomBallsGenerator());
        baseballGame.start();
    }
}
