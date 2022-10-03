package baseball.result.bean;

import baseball.result.Counter;

public class Result {
    public Result(Counter counter) {
        this.counter = counter;
    }
    public Result() {
    }
    private Counter counter;
    private int ballCount;
    private int strikeCount;
    private boolean nothing;
    private boolean gameOver;

    public Counter getCounter() {
        return counter;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    public boolean isNothing() {
        return nothing;
    }

    public void setNothing(boolean nothing) {
        this.nothing = nothing;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}
