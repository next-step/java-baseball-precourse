package model;

public class Score {
    private final int strikes;
    private final int balls;

    public Score(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }

    public boolean isGameEnd() {
        return this.strikes == 3;
    }
}
