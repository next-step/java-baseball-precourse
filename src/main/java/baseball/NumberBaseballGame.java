package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class NumberBaseballGame {

    private final int gamePlayerNumber;
    private final int computerNumber;

    private NumberBaseballGame(int gamePlayerNumber, int computerNumber) {
        this.gamePlayerNumber = gamePlayerNumber;
        this.computerNumber = computerNumber;
    }

    public static NumberBaseballGame of(int gamePlayerValue, int computerNumber) {
        if (computerNumber != -1) return new NumberBaseballGame(gamePlayerValue, computerNumber);
        return new NumberBaseballGame(gamePlayerValue, generateComputerNumber());
    }

    public int getComputerNumber() {
        return computerNumber;
    }

    public ResultView decideScore() {
        return new ResultView(Umpire.compareNumber(gamePlayerNumber, computerNumber));
    }

    public static int generateComputerNumber() {
        StringBuilder stringBuilder = new StringBuilder();
        Set<Integer> anotherNumberSet = new HashSet<>();
        while (anotherNumberSet.size() < 3) {
            anotherNumberSet.add(Randoms.pickNumberInRange(1, 9));
        }
        for (int number : anotherNumberSet) {
            stringBuilder.append(number);
        }
        System.out.println(stringBuilder);
        return Integer.parseInt(stringBuilder.toString());
    }
}
