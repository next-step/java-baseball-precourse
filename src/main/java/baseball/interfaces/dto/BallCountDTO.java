package baseball.interfaces.dto;

import baseball.domain.BallCount;

import java.util.ArrayList;

public class BallCountDTO {

    public int strikeCount;
    public int ballCount;
    public boolean isStrikeOut;

    public static BallCountDTO fromModel(BallCount ballCount) {
        return new BallCountDTO(ballCount.getStrikeCount(), ballCount.getBallCount(), ballCount.getIsStrikeOut());
    }

    public BallCountDTO(int strikeCount, int ballCount, boolean isStrikeOut) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
        this.isStrikeOut = isStrikeOut;
    }

    public String toString() {
        ArrayList<String> result = new ArrayList<>();

        if (this.ballCount > 0) {
            result.add(ballCount + "볼");
        }

        if (this.strikeCount > 0) {
            result.add(strikeCount + "스트라이크");
        }

        if (this.strikeCount == 0 && this.ballCount == 0) {
            return "낫싱";
        }

        return String.join(" ", result);

    }


}
