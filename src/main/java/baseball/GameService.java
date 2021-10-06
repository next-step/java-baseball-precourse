package baseball;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Randoms;
import baseball.common.GameConfig;

public class GameService {
    public static List<Integer> makeRandomNumber() {
        List<Integer> listOfNumber = new ArrayList<>();

        while (listOfNumber.size() < GameConfig.RULE_NUMBER_COUNT.getNumber()) {
            int pickNumber = Randoms.pickNumberInRange(GameConfig.RULE_NUMBER_MIN.getNumber(), GameConfig.RULE_NUMBER_MAX.getNumber());
            addRandomNumber(listOfNumber, pickNumber);
        }

        return listOfNumber;
    }

    public static boolean isSameNumber(List<Integer> randomNumber) {
        // TODO

        return false;
    }

    public static boolean isDiffNumber(List<Integer> randomNumber) {
        // TODO

        return false;
    }

    public static int getStrikeCount(List<Integer> randomNumber) {
        // TODO

        return 0;
    }

    public static int getBallCount(List<Integer> randomNumber) {
        // TODO

        return 0;
    }

    private static void addRandomNumber(List<Integer> listOfNumber, int pickNumber) {
        if (!listOfNumber.contains(pickNumber)) {
            listOfNumber.add(pickNumber);
        }
    }
}
