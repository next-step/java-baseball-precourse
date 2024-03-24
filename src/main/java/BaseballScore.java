import java.util.HashSet;
import java.util.Set;

public class BaseballScore {
    private int strikeCount;
    private int ballCount;

    BaseballScore() {
        strikeCount = 0;
        ballCount = 0;
    }

    public static BaseballScore calculateScore(int[] userNumbers, int[] answerNumbers) {
        int length = userNumbers.length;
        BaseballScore score = new BaseballScore();
        Set<Integer> answerSet = new HashSet<>();

        for (int answerNumber : answerNumbers) {
            answerSet.add(answerNumber);
        }

        for (int i = 0; i < length; i++) {
            if (userNumbers[i] == answerNumbers[i]) {
                score.addStrikeCount();
                continue;
            }
            if (answerSet.contains(userNumbers[i])) {
                score.addBallCount();
            }
        }

        return score;
    }

    public void addStrikeCount() {
        strikeCount++;
    }

    public void addBallCount() {
        ballCount++;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isOut(int length) {
        return strikeCount == length;
    }

    public boolean hasStrike() {
        return strikeCount > 0;
    }

    public boolean hasBall() {
        return ballCount > 0;
    }

    public boolean isNothing() {
        return !(hasBall() || hasStrike());
    }
}
