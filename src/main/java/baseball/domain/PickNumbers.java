package baseball.domain;

import java.util.LinkedHashSet;

import static nextstep.utils.Randoms.pickNumberInRange;

public class PickNumbers {

    private static LinkedHashSet<Integer> pickNumbersSet;

    private PickNumbers() {
    }

    public static boolean makePickNumbers() {
        if (pickNumbersSet == null || pickNumbersSet.isEmpty()) {
            pickNumbersSet = new LinkedHashSet<>();
            addPickNumber();
            return true;
        }
        return false;
    }

    private static void addPickNumber() {
        while (pickNumbersSet.size() < GameConfig.PICK_NUMBER_SIZE.getValue()) {
            int pickNumber = pickNumberInRange(GameConfig.MIN_NUMBER.getValue(), GameConfig.MAX_NUMBER.getValue());
            pickNumbersSet.add(pickNumber);
        }
    }

    public static LinkedHashSet<Integer> getPickNumbersSet() {
        return pickNumbersSet;
    }
}
