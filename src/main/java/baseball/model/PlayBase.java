package baseball.model;

import baseball.common.Constants;
import baseball.common.PlayBaseStatus;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;
import org.assertj.core.util.Strings;

public class PlayBase {
    private final int[] numberArr = new int[3];
    private final Set<Integer> numberJar = new HashSet<>();
    private int ballCount;
    private int strikeCount;

    public PlayBase() {
        initializeInning();
    }

    /**
     * Returns a string for output.
     *
     * @return counts string.
     */
    public String getCounts() {
        if (ballCount > 0 && strikeCount > 0) {
            return Strings.concat(ballCount + Constants.BALL, " ", strikeCount, Constants.STRIKE);
        }
        if (ballCount > 0 && strikeCount == 0) {
            return Strings.concat(ballCount, Constants.BALL);
        }
        if (ballCount == 0 && strikeCount > 0) {
            return Strings.concat(strikeCount, Constants.STRIKE);
        }
        return Constants.NOTHING;
    }

    /**
     * Returns the current play state.
     *
     * @return play status.
     */
    public PlayBaseStatus getMatchResult() {
        if (strikeCount == 3) {
            return PlayBaseStatus.OVER;
        }
        return PlayBaseStatus.ONGOING;
    }

    /**
     * Returns an array of picked numbers.
     *
     * @return picked numbers.
     */
    public int[] getNumberArr() {
        return numberArr;
    }

    public Set<Integer> getNumberJar() {
        return numberJar;
    }

    public void initializeInning() {
        pickNumber();
        clearCounts();
    }

    /**
     * Initializes the current ballCount and strikeCount to 0.
     */
    public void clearCounts() {
        ballCount = 0;
        strikeCount = 0;
    }

    /**
     * Increase ballCount
     */
    public void addBallCounts() {
        ballCount++;
    }

    /**
     * Increase strikeCount
     */
    public void addStrikeCounts() {
        strikeCount++;
    }

    /**
     * Clear the number jar for duplicate verification and pick a random number. Random numbers are picked one by one
     * and put into the numberArr array after undergoing duplicate verification with the numberJar method "add()".
     */
    private void pickNumber() {
        numberJar.clear();
        int i = 0;
        while (numberJar.size() < 3) {
            int temp = Randoms.pickNumberInRange(1, 9);
            if (numberJar.add(temp)) {
                numberArr[i] = temp;
                i++;
            }
        }
    }

}


