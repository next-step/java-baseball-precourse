package baseball.model;

import java.util.List;

public class Judge {

    public Judge() {
        resetBallCount();
    }

    private int ballCount;
    private int strikeCount;

    private final int STRIKE_OUT = 3;

    private StringBuilder ballCountResult = new StringBuilder();

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void resetBallCount() {
        ballCount = 0;
        strikeCount = 0;
    }

    public boolean isStrikeOut() {
        return strikeCount == STRIKE_OUT;
    }

    public String makeScore() {
        noteBallCount();
        return ballCountResult.toString();
    }

    public void countBalls(List<String> computerNumbers, List<String> userInputNumbers) {
        for (int i=0; i<computerNumbers.size(); i++) {
            String element = computerNumbers.get(i);
            countBall(userInputNumbers, element, i);
        }
    }

    private void countBall(List<String> userInputNumbers, String element, int i) {
        if (userInputNumbers.contains(element) && userInputNumbers.indexOf(element) == i) {
            increaseStrikeCount();
        }
        if (userInputNumbers.contains(element) && userInputNumbers.indexOf(element) != i) {
            increaseBallCount();
        }
    }

    public void clearBallCount() {
        ballCount = 0;
        strikeCount = 0;
        ballCountResult.setLength(0);
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

    private void increaseStrikeCount() {
        strikeCount += 1;
    }

    private void increaseBallCount() {
        ballCount += 1;
    }
}
