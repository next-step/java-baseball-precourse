package baseball;

import java.util.ArrayList;

import nextstep.utils.Randoms;

public class RandomInputGenerator {
    public ArrayList<Integer> genRandomInts() {
        ArrayList<Integer> randomInts = new ArrayList<>();

        while (randomInts.size() < GlobalVariables.MAX_BALL_CNT) {
            int randomInt = Randoms.pickNumberInRange(GlobalVariables.MIN_BALL_NUMBER, GlobalVariables.MAX_BALL_NUMBER);

            insertOnlyDistinct(randomInts, randomInt);
        }

        return randomInts;
    }

    private static void insertOnlyDistinct(ArrayList<Integer> into, int insertValue) {
        if (into.contains(insertValue)) return;

        into.add(insertValue);
    }
}
