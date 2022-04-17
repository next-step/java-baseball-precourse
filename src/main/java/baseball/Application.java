package baseball;


//import static baseball.game.BaseBallGame;

import baseball.game.BaseBallGame;

public class Application {

//    private final Console console;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseBallGame baseBallGame = new BaseBallGame();
        BaseBallGame.init(baseBallGame);
    }
}
