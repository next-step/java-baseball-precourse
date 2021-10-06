package baseball.domain;

import java.util.Arrays;
import java.util.List;

public class Umpire {

    private Computer computer;
    private Gamer gamer;
    private int strikeCount;
    private int ballCount;
    private List tempList;

    public Umpire(Computer computer, Gamer gamer) {
        this.computer = computer;
        this.gamer = gamer;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isThreeStrike() {
        if (this.strikeCount == 3)
            return true;
        return false;
    }

    public Umpire called() {
        this.tempList = Arrays.asList(gamer.getBalls());
        for (int i = 0; i < computer.getFullCount().length; i++) {
            countStrike(gamer.getBalls()[i], computer.getFullCount()[i]);
            countBall(i, computer.getFullCount()[i]);
        }
        return this;
    }

    private void countStrike(int ball, int count) {
        if (ball == count) strikeCount++;
    }

    private void countBall(int index, int count) {
        int tempIndex = tempList.indexOf(count);
        if (tempIndex > -1 && index != tempList.indexOf(count)) ballCount++;
    }
}
