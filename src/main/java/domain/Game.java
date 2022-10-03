package domain;

public class Game {
    private int strikeCount;
    private int ballCount;
    private int[] gameNumber;

    public Game(int[] gameNumber) {
        this.gameNumber = gameNumber;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public int[] getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(int[] gameNumber) {
        this.gameNumber = gameNumber;
    }

    public void initGame(){
        this.ballCount=0;
        this.strikeCount=0;
    }
}
