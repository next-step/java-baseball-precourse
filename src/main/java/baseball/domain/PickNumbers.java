package baseball.domain;

import java.util.LinkedHashSet;

public class PickNumbers {

    private static LinkedHashSet<Integer> pickNumbersSet;

    private PickNumbers() {
    }

    public static LinkedHashSet<Integer> makePickNumbers() {
        if (pickNumbersSet == null || pickNumbersSet.isEmpty()) {
            pickNumbersSet = new LinkedHashSet<>();
//            addPickNumber();
        }
        return pickNumbersSet;
    }

//    private static void addPickNumber() {
//        while (pickNumbersSet.size() < Constants.PICK_NUMBER_SIZE) {
//            int pickNumber = pickNumberInRange(Constants.MIN_NUMBER, Constants.MAX_NUMBER);
//            pickNumbersSet.add(pickNumber);
//        }
//    }

    public static void pickNumbersClear() {
        pickNumbersSet.clear();
    }

    public static LinkedHashSet<Integer> getPickNumbersSet() {
        return pickNumbersSet;
    }
}
