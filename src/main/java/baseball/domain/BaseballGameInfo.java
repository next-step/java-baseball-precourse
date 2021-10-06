package baseball.domain;

import baseball.common.Const;

import java.util.List;

public class BaseballGameInfo {
    private int strikeCount;
    private int ballCount;
    private boolean isWinning;

    private List<Integer> userBaseballNumbers;
    private List<Integer> computerBaseballNumbers;

    public BaseballGameInfo(List<Integer> userBaseballNumbers, List<Integer> computerBaseballNumbers) {
        this.userBaseballNumbers = userBaseballNumbers;
        this.computerBaseballNumbers = computerBaseballNumbers;
        setGameState();
    }

    private void setGameState() {
        initializeGame();
        match();
        isWinning();
    }

    private void initializeGame() {
        this.strikeCount = 0;
        this.ballCount = 0;
        this.isWinning = false;
    }

    private void match() {
        for(int i = 0; i < Const.BALL_COUNT; i++) {
            ballCount += checkBall(userBaseballNumbers, i);
            strikeCount += checkStrike(userBaseballNumbers, i);
        }
    }

    private int checkBall (List<Integer> userBaseballNumbers, int idx) {
        if(computerBaseballNumbers.contains(userBaseballNumbers.get(idx)) &&
                !computerBaseballNumbers.get(idx).equals(userBaseballNumbers.get(idx))) {
            return 1;
        }
        return 0;
    }

    private int checkStrike (List<Integer> userBaseballNumbers, int idx) {
        if(computerBaseballNumbers.get(idx).equals(userBaseballNumbers.get(idx))){
            return 1;
        }
        return 0;
    }

    private void isWinning() {
        if(strikeCount == Const.BALL_COUNT) {
            this.isWinning = true;
        }
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean getIsWinning() {
        return isWinning;
    }
}


