package baseball.model;

import baseball.rule.BaseballGameRule;
import baseball.util.GameStatus;
import baseball.view.OutputView;

import java.util.List;
import java.util.Objects;

public class Referee {
    private int sCount;
    private int bCount;
    private List<Integer> computerNum;
    private List<Integer> playerNum;

    public Referee() {
    }

    public void init(List<Integer> computerNum, List<Integer> playerNum) {
        sCount = 0;
        bCount = 0;
        this.computerNum = computerNum;
        this.playerNum = playerNum;
    }

    public GameStatus judge() {
        for(int i=0; i< BaseballGameRule.LENGTH_OF_NUMBERS; i++) {
            countStrike(computerNum.get(i), playerNum.get(i));
        }
        for(int number : playerNum) {
            countBall(number);
        }

        return getGameStatus();
    }

    private void countStrike(Integer computerNum, Integer playerNum) {
        if(Objects.equals(computerNum, playerNum)){
            sCount++;
        }
    }

    private void countBall(int number) {
        if(computerNum.contains(number)) {
            bCount++;
        }
    }

    private GameStatus getGameStatus() {
        if(sCount == BaseballGameRule.LENGTH_OF_NUMBERS) {
            return GameStatus.END;
        }

        return GameStatus.IN_PROGRESS;
    }

    public void printResult() {
        if(getBCount() != 0){
            OutputView.printBall(getBCount());
        }
        if(getSCount() != 0){
            OutputView.printStrike(getSCount());
        }
        if(getBCount() == 0 && getSCount() == 0){
            OutputView.printNothing();
        }
        OutputView.printNewLine();
    }

    public int getBCount() {
        return bCount - sCount;
    }

    public int getSCount() {
        return sCount;
    }
}
