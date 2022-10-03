package baseball.domain;

public class StrikeJudgment implements Judgment{
    
    private final String judgmentName = "스트라이크";

    private final BaseballNumbers computerNumbers;
    private final BaseballNumbers playerNumbers;
    
    StrikeJudgment(BaseballNumbers computerNumbers, BaseballNumbers playerNumbers) {
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
            result += compare(computerNumbers.getNumber(i), playerNumbers.getNumber(i));
        }

        return result;
    }
    
    private static int compare(BaseballNumber computerNumber, BaseballNumber playerNumber) {
        return (computerNumber.equals(playerNumber)) ? 1 : 0;
    }
}
