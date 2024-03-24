package domain.baseball;


public class Hint {

    /**
     * aggregate
     */
    private int strike;
    private int ball;

    public void init(){
        this.strike = this.ball = 0;
    }

    public void addStrikeCount() {
        strike++;
    }

    public void addBallCount() {
        ball++;
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
