package baseball;

import baseball.application.BaseBallGame;
import baseball.application.io.Input;
import baseball.application.io.Output;
import baseball.domain.player.RandomBallGeneratePolicy;

public class Application {

    public static void main(String[] args) {
        BaseBallGame game = new BaseBallGame(new Input(), new Output(), new RandomBallGeneratePolicy());
        game.run();
    }
}