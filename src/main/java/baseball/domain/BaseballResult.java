package baseball.domain;

import baseball.enums.BaseballStatus;

import java.util.ArrayList;
import java.util.List;

public class BaseballResult {

    private int strikeCount = 0;
    private int ballCount = 0;

    public void addResult(BaseballStatus Status) {
        if (Status.STRIKE == Status) strikeCount++;
        if (Status.BALL == Status) ballCount++;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public String convert(BaseballResult gameResult) {
        List<String> resultMessagesList = new ArrayList<>();

        if (gameResult.getBallCount() > 0) {
            resultMessagesList.add(String.format("%d%s", gameResult.getBallCount(), BaseballStatus.BALL.getName()));
        }

        if (gameResult.getStrikeCount() > 0) {
            resultMessagesList.add(String.format("%d%s", gameResult.getStrikeCount(), BaseballStatus.STRIKE.getName()));
        }

        if (gameResult.getStrikeCount() == 0 && gameResult.getBallCount() == 0) {
            resultMessagesList.add(BaseballStatus.NOTHING.getName());
        }
        return String.join(" ", resultMessagesList).trim();
    }
}
