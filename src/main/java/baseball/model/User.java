package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<String> ballCount = new ArrayList<>();

    private void storeInputArrayToBallCount(String[] input) {
        for(String element: input) {
            ballCount.add(element);
        }
    }

    private void clearBallCount() {
        ballCount.clear();
    }

    public List<String> getBallCount() {
        return ballCount;
    }

    public void throwBalls(String input) {
        clearBallCount();

        String[] inputArray = input.split("");
        storeInputArrayToBallCount(inputArray);
    }
}
