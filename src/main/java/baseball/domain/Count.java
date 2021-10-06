package baseball.domain;

public class Count {
    private int ball;
    private int strike;

    public Count() {
        this.ball = 0;
        this.strike = 0;
    }

    public void ballPlus(){
        this.ball++;
    }

    public void strikePlus(){
        this.strike++;
    }

    public void setBallCount(){
        this.ball = this.ball - this.strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
