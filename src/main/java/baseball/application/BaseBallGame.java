package baseball.application;

import baseball.application.io.Flag;
import baseball.application.io.Input;
import baseball.application.io.Output;
import baseball.domain.player.BallGeneratePolicy;
import baseball.domain.player.Computer;
import baseball.domain.player.Player;
import baseball.domain.result.Result;

public class BaseBallGame {

    private final Input input;
    private final Output output;
    private final BallGeneratePolicy generatePolicy;
    private boolean isCycle = true;

    public BaseBallGame(Input input, Output output, BallGeneratePolicy generatePolicy) {
        this.input = input;
        this.output = output;
        this.generatePolicy = generatePolicy;
    }

    public void run() {
        do {
            play();
        } while (isCycle);
    }

    private void play() {
        Computer computer = Computer.from(generatePolicy);
        Result result;
        do {
            output.numberInputMessage();
            Player player = Player.from(input.numbers());
            result = computer.check(player);
            output.resultMessage(result);
        } while (!isFinish(result.isVictory()));
    }

    private boolean isFinish(boolean isVictory) {
        if (!isVictory) {
            return false;
        }
        output.restartMessage();
        Flag flag = input.restartFlag();

        if (flag.isStop()) {
            isCycle = false;
        }
        return true;
    }
}