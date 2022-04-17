package baseball.domain;

import baseball.constants.BaseballGameCount;
import baseball.util.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BaseballGameResult {
    private int strike = 0;
    private int ball = 0;

    public void incrementStrike() {
        this.strike++;
    }

    public void incrementBall() {
        this.ball++;
    }

    @Override
    public String toString() {
        if(ball == 0 && strike == 0) return BaseballGameCount.NOTHING.getString();

        StringBuilder resultString = new StringBuilder();
        if(ball > 0) resultString.append(ballToString());
        if(strike > 0) {
            StringUtil.addBetweenWords(resultString, " ");
            resultString.append(strikeToString());
        }

        return resultString.toString();
    }

    private String strikeToString() {
        return strike + BaseballGameCount.STRIKE.getString();
    }

    private String ballToString() {
        return ball + BaseballGameCount.BALL.getString();
    }

}
