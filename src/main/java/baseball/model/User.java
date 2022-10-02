package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private static List<String> ballCount = new ArrayList<>();

    private static void storeInputArrayToBallCount(String[] input) {
        for(String element: input) {
            ballCount.add(element);
        }
    }

    private static void clearBallCount() {
        ballCount.clear();
    }

    public static List<String> getBallCount() {
        return ballCount;
    }

    public static void throwBalls(String input) {
        clearBallCount();

        String[] inputArray = input.split("");
        storeInputArrayToBallCount(inputArray);
    }
}
