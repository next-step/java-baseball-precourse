package baseball.domain;

import java.util.Arrays;
import java.util.List;

/**
 * @author theco2de
 * @version 1.0
 * @since 1.0
 */
public class Role {

    private Computer computer;
    private Gamer gamer;
    private int strikeCount;
    private int ballCount;
    private List tempList;

    public Role(Computer computer, Gamer gamer) {
        this.computer = computer;
        this.gamer = gamer;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    /**
     * 3 스트라이크 판정
     * @return boolean
     */
    public boolean isThreeStrike() {
        if (this.strikeCount == 3)
            return true;
        return false;
    }

    /**
     * 스트라이크와 볼 수 판정
     * @return Role
     */
    public Role called() {
        this.tempList = Arrays.asList(gamer.getBalls());
        for (int i = 0; i < computer.getFullCount().length; i++) {
            countStrike(gamer.getBalls()[i], computer.getFullCount()[i]);
            countBall(i, computer.getFullCount()[i]);
        }
        return this;
    }

    /**
     * 스트라이크 수 판정
     * @param ball
     * @param count
     */
    private void countStrike(int ball, int count) {
        if (ball == count) strikeCount++;
    }

    /**
     * 볼 수 판정
     * @param index
     * @param count
     */
    private void countBall(int index, int count) {
        int tempIndex = tempList.indexOf(count);
        if (tempIndex > -1 && index != tempList.indexOf(count)) ballCount++;
    }
}
