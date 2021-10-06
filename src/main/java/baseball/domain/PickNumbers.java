package baseball.domain;

import java.util.LinkedHashSet;

import static nextstep.utils.Randoms.pickNumberInRange;

public class PickNumbers {

    private static LinkedHashSet<Integer> pickNumbersSet;

    private PickNumbers() {
    }

    /**
     * 게임에서 사용되는 임의의 수를 생성하는 메소드.
     * <p>
     * 게임이 종료되기 전까지(clear) 새로운 임의의 수를 생성할 수 없다.
     * </p>
     * @return 새로운 임의의 수가 생성되었을 경우 true, 생성할 수 없는 경우 false
     */
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

    public static void pickNumbersClear() {
        pickNumbersSet.clear();
    }
}
