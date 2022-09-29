package baseball.controller;
import baseball.model.Computer;
import java.util.List;

import static baseball.view.ConsoleIO.*;

public class GameHost {
    private final Computer computer;

    public GameHost() {
        this.computer = new Computer();
    }

    public void startGame() {
        computer.initBaseballNumber();
        tryPlay();
    }

    private void tryPlay(){
        List<Integer> input = inputAnswer();
        computer.calculateScore(input);
        printResult(computer.getStrike(), computer.getBall());

        if (computer.isWrong())
        {
            tryPlay();
            return;
        }
        printComplete();
        restartGame();
    }

    private void restartGame(){
        String input = inputRestart();
        if(input.equals("1")) startGame();
    }
}
