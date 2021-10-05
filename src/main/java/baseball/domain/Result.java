package baseball.domain;

import static baseball.view.OutputView.*;

public class Result {

    private int strikeNo;
    private int ballNo;

    public Result() {
        strikeNo = 0;
        ballNo = 0;
    }

    public int getStrikeNo() {
        return strikeNo;
    }

    public int getBallNo() {
        return ballNo;
    }

    public void compareStatus(BallStatus ballStatus) {
        if (ballStatus.isStrike()) {
            strikeNo += 1;
        }
        if (ballStatus.isBall()) {
            ballNo += 1;
        }
    }


    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        if (strikeNo == 0 && ballNo == 0) {
            return getNoting();
        }
        if (strikeNo > 0) {
            buf.append(getStrike(this.strikeNo) + " ");
        }
        if (ballNo > 0) {
            buf.append(getBall(this.ballNo) + " ");
        }
        return buf.toString();
    }
}
