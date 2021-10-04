package baseball.game;

public class GameResult {

    private int strikeCount = 0;
    private int ballCount = 0;
    private boolean isFinish = false;

    private final int totalStrikeCount;

    public GameResult(int totalStrikeCount) {
        this.totalStrikeCount = totalStrikeCount;
    }

    public void compare(String systemNumbers, String inputNumbers) {
        calculateStrikeCount(systemNumbers, inputNumbers);
        calculateBallCount(systemNumbers, inputNumbers);
        this.isFinish = isFinish(strikeCount);
    }

    private boolean isFinish(int strikeCount) {
        return strikeCount == totalStrikeCount;
    }

    private void calculateStrikeCount(String systemNumbers, String numbers) {
        resetStrikeCount();
        for (int i = 0; i < systemNumbers.length(); i++) {
            plusCountIfIsStrike(systemNumbers.charAt(i), numbers.charAt(i));
        }
    }

    private void resetStrikeCount() {
        this.strikeCount = 0;
    }

    private void plusCountIfIsStrike(char systemNumberChar, char inputNumberChar) {
        if(systemNumberChar == inputNumberChar) {
            this.strikeCount ++;
        }
    }


    private void calculateBallCount(String systemNumbers, String number) {
        resetBallCount();
        for (int i = 0; i < systemNumbers.length(); i++) {
            plusCountIfIsBall(systemNumbers, i, number.charAt(i));
        }
    }

    private void resetBallCount() {
        this.ballCount = 0;
    }

    private void plusCountIfIsBall(String systemNumbers, int inputNumberIndex, char inputNumberChar) {
        if(isBall(systemNumbers, inputNumberIndex, inputNumberChar)) {
            this.ballCount ++;
        }
    }

    private boolean isBall(String systemNumbers, int inputNumberIndex, char inputNumberChar) {
        return systemNumbers.charAt(inputNumberIndex) != inputNumberChar
                && systemNumbers.contains(String.valueOf(inputNumberChar));
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isFinish() {
        return isFinish;
    }
}
