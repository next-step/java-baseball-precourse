package baseball.model;

import static baseball.constant.BaseballProperties.GAME_SIZE;

public class Result {
    private int strikeCount;
    private int ballCount;

    public void addStrike() {
        strikeCount++;
    }

    public void addBall() {
        ballCount++;
    }

    public boolean isAllStrike() {
        return strikeCount == GAME_SIZE;
    }

    public String getResultString() {
        String result = "";

        if(ballCount > 0) {
            result += ballCount + "볼 ";
        }

        if(strikeCount > 0) {
            result += strikeCount + "스트라이크 ";
        }

        if(ballCount == 0 && strikeCount == 0) {
            result = "낫싱";
        }

        return result.trim();
    }
}
