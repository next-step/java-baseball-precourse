package baseball.domain;

import java.util.List;

public class BallJudgment implements Judgment {
    
    private final String judgmentName = "볼";

    private final BaseballNumbers computerNumbers;
    private final BaseballNumbers playerNumbers;
    
    BallJudgment(BaseballNumbers computerNumbers, BaseballNumbers playerNumbers) {
        this.computerNumbers = computerNumbers;
        this.playerNumbers = playerNumbers;
    }

    @Override
    public int getCount() {
        return judge();
    }

    @Override
    public String getResult() {    
        if (getCount() == 0) {
            return "";
        }

        return String.format("%d%s", getCount(), judgmentName);
    }

    private int judge() { 
        int result = 0;

        for (int i = 0; i < BaseballNumbers.NUMBER_SIZE; i++) {
            result += findBall(computerNumbers.getNumber(i), playerNumbers.exceptFor(i));
        }

        return result;
    }
    
    private int findBall(BaseballNumber computerNumber, List<BaseballNumber> playerNumbers) {
        return (playerNumbers.contains(computerNumber)) ? 1 : 0;
    }
}
