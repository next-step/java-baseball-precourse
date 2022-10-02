package baseball;

import baseball.game.BaseballGameLauncher;
import baseball.game.GameLauncher;

public class Application {
    public static void main(String[] args) {
        GameLauncher gameLauncher = new BaseballGameLauncher();
        gameLauncher.play();
    }
}
