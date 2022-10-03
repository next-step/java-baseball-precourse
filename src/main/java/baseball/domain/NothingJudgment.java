package baseball.domain;

public class NothingJudgment implements Judgment{
    
    private final String judgmentName = "낫싱";

    private final BaseballNumbers computerNumbers;
    private final BaseballNumbers playerNumbers;

    NothingJudgment(BaseballNumbers computerNumbers, BaseballNumbers playerNumbers) {
        this.computerNumbers = computerNumbers;
        this.playerNumbers = playerNumbers;
    }

    @Override
    public int getCount() {
        return judge();
    }

    @Override
    public String getResult() {
        if (getCount() == BaseballNumbers.NUMBER_SIZE) {
            return judgmentName;
        }
        
        return "";
    }

    private int judge() { 
        int result = 0;

        for (int i = 0; i < BaseballNumbers.NUMBER_SIZE; i++) {
            result += contains(computerNumbers.getNumber(i), playerNumbers);
        }

        return result;
    }
    
    private int contains(BaseballNumber computerNumber, BaseballNumbers playerNumbers) {
        return (!playerNumbers.contains(computerNumber)) ? 1 : 0;
    }
}
