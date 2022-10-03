package baseball.domain;

import static baseball.domain.GameMachineStatus.FINISH;
import static baseball.domain.GameMachineStatus.RUNNING;

import java.util.List;

public class BaseBallGame {

    private final Computer computer;
    private GameMachineStatus gameMachineStatus;

    public BaseBallGame(PickBallsStrategy pickBallsStrategy) {
        this.computer = new Computer(pickBallsStrategy);
        gameMachineStatus = RUNNING;
    }

    public GameResult playOnce(List<Integer> numbers) {
        GameResult gameResult = computer.judgeResult(new Balls(numbers));
        postProcess(gameResult);
        return gameResult;
    }

    private void postProcess(GameResult gameResult) {
        if (gameResult.isOut()) {
            gameMachineStatus = FINISH;
        }
    }

    public boolean isGameEnd() {
        return gameMachineStatus.isFinish();
    }

}
