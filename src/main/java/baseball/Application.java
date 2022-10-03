package baseball;

import baseball.console.ConsoleInterface;
import baseball.console.GameConsole;
import baseball.game.BaseballGameLauncher;
import baseball.game.GameLauncher;
import baseball.score.RandomScoreGenerator;
import baseball.score.ScoreGenerator;

public class Application {
    public static void main(String[] args) {
        ConsoleInterface consoleInterface = new GameConsole();
        ScoreGenerator scoreGenerator = new RandomScoreGenerator();
        GameLauncher gameLauncher = new BaseballGameLauncher(consoleInterface, scoreGenerator);
        gameLauncher.play();
    }
}
