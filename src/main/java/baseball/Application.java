package baseball;

import baseball.domain.BaseBallGameMachine;
import baseball.domain.RandomPickBallsStrategy;
import baseball.ui.StandardInput;
import baseball.ui.StandardOutput;

public class Application {
    public static void main(String[] args) {
        BaseBallGameMachine baseBallGameMachine = new BaseBallGameMachine(new StandardInput(), new StandardOutput(),
                new RandomPickBallsStrategy());

        baseBallGameMachine.startGame();
    }
}
