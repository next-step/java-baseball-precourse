package baseball;

import baseball.domain.BaseballGame;
import baseball.io.BaseballInput;
import baseball.io.BaseballOutput;
import baseball.io.ConsoleBaseballInput;
import baseball.io.ConsoleBaseballOutput;

public class Application {
    public static void main(String[] args) {
        BaseballInput input = new ConsoleBaseballInput();
        BaseballOutput output = new ConsoleBaseballOutput(System.out);

        BaseballGame baseballGame = new BaseballGame(input, output);
        baseballGame.start();
    }
}
