package baseball;

import baseball.app.BaseBallGame;
import baseball.io.DefaultInput;
import baseball.io.DefaultOutput;
import baseball.io.Input;
import baseball.io.Output;

public class Application {
    public static void main(String[] args) {
        Input input = new DefaultInput();
        Output output = new DefaultOutput();
        new BaseBallGame(input, output).play();
    }
}
