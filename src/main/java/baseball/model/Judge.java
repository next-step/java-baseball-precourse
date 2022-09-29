package baseball.model;

import java.util.HashSet;
import java.util.List;

public class Judge {

    private static int ballCount;
    private static int strikeCount;

    private static final int STRIKE_OUT = 3;

    private final StringBuilder ballCountResult = new StringBuilder();

    public static int getBallCount() {
        return ballCount;
    }

    public static int getStrikeCount() {
        return strikeCount;
    }

    public Judge() {
        ballCount = 0;
        strikeCount = 0;
    }

    public static Judge resetBallCount() {
        return new Judge();
    }

    public static boolean isStrikeOut() {
        return strikeCount == STRIKE_OUT;
    }

    @Override
    public String toString() {
        noteBallCount();
        return ballCountResult.toString();
    }

    public static void countBalls(List<String> computerNumbers, List<String> userInputNumbers) {
        Judge judge = new Judge();

        for (int i=0; i<computerNumbers.size(); i++) {
            String element = computerNumbers.get(i);
            countBall(userInputNumbers, element, i);
        }
    }

    private static void countBall(List<String> userInputNumbers, String element, int i) {
        if (userInputNumbers.contains(element) && userInputNumbers.indexOf(element) == i) {
            increaseStrikeCount();
        }
        if (userInputNumbers.contains(element) && userInputNumbers.indexOf(element) != i) {
            increaseBallCount();
        }
    }

    private void noteBallCount() {
        noteBallToBallCount();
        appendSpace();
        noteStrikeToBallCount();
        appendSpace();
        noteNothingToBallCount();
    }

    private void noteStrikeToBallCount() {
        if (strikeCount > 0) {
            ballCountResult.append(String.format("%d스트라이크", strikeCount));
        }
    }

    private void noteBallToBallCount() {
        if (ballCount > 0) {
            ballCountResult.append(String.format("%d볼", ballCount));
        }
    }

    private void noteNothingToBallCount() {
        if (strikeCount == 0 && ballCount == 0) {
            ballCountResult.append("낫싱");
        }
    }

    private void appendSpace() {
        if (ballCountResult.length() > 0) {
            ballCountResult.append(" ");
        }
    }

    private static void increaseStrikeCount() {
        strikeCount += 1;
    }

    private static void increaseBallCount() {
        ballCount += 1;
    }
}
