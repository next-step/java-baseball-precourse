package baseball.game;

public class GameRoundResult {
    int strike = 0;
    int ball = 0;

    public void addStrike(){
        this.strike += 1;
    }
    public void addBall(){
        this.ball += 1;
    }

    public int getStrike() {
        return strike;
    }
    public void setStrike(int strike) {
        this.strike = strike;
    }
    public int getBall() {
        return ball;
    }
    public void setBall(int ball) {
        this.ball = ball;
    }    
}
