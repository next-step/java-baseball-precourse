package baseball.model;

import baseball.view.MessagePrinter;

import java.util.List;
import java.util.Objects;

public class GameProcessor {

    public int countStrike = 0;
    public int countBall = 0;
    public int STRIKE = 3;

    public void initializeCounts() {
        countStrike = 0;
        countBall = 0;
    }

    private final Player player;
    private final Computer computer;

    public GameProcessor(Player player, Computer computer) {
        this.player = player;
        this.computer = computer;
    }

    public boolean playGame() {
        List<Integer> computerNumberList = this.computer.generateThreeNumbers();
        List<String> playerNumberList = this.player.getNumbers();
        calculateResult(computerNumberList, playerNumberList);
        MessagePrinter.printResult(countStrike, countBall);
        return STRIKE == countStrike;
    }

    public void calculateResult(List<Integer> computerNumberList, List<String> playerNumberList) {
        initializeCounts();
        for (int index = 0; index < 3; index++) {
            Integer computerNumber = computerNumberList.get(index);
            Integer playerNumber = Integer.parseInt(playerNumberList.get(index));
            calculateStrikes(computerNumber, playerNumber);
            calculateBall(index, computerNumberList, playerNumber);
        }
    }

    public void calculateStrikes(Integer computerNumber, Integer playerNumber) {
        if (Objects.equals(computerNumber, playerNumber)) {
            countStrike += 1;
        }
    }

    public void calculateBall(int i, List<Integer> computerNumber, Integer playerNumber) {
        if (computerNumber.contains(playerNumber) && !Objects.equals(computerNumber.get(i), playerNumber)) {
            countBall += 1;
        }
    }

}
