package baseball;

import java.util.List;
import java.util.Objects;

public class GameProcessor {

    public static int countStrike = 0;
    public static int countBall = 0;
    public int STRIKE = 3;

    public static void initializeCounts() {
        countStrike = 0;
        countBall = 0;
    }

    public boolean playGame(List<Integer> computerNumberList, List<String> playerNumberList) {

        initializeCounts();

        int count = 3;
        for (int index = 0; index < count; index++) {
            Integer computerNumber = computerNumberList.get(index);
            Integer playerNumber = Integer.parseInt(playerNumberList.get(index));

            calculateStrikes(computerNumber, playerNumber);
            calculateBall(index, computerNumberList, playerNumber);
        }
        MessagePrinter.printResult(countStrike, countBall);
        return countStrike == STRIKE;
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
