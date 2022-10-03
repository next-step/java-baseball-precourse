package baseball.model;

public class Number {
    private String playerNum;
    private String randomNum;

    public static Number initNumber(String randomNum) {
        return new Number(null, randomNum);
    }

    public Number(String playerNum, String randomNum) {
        this.playerNum = playerNum;
        this.randomNum = randomNum;
    }

    public String getPlayerNum() {
        return playerNum;
    }

    public String getRandomNum() {
        return randomNum;
    }

    public void setPlayerNum(String playerNum) {
        this.playerNum = playerNum;
    }
}
