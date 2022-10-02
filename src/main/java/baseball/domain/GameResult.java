package baseball.domain;

public class GameResult {

    private int strike;
    private int ball;

    public GameResult(BaseballNumber opponent, BaseballNumber player) {
        String opponentNumber = opponent.getNumberText();
        String playerNumber = player.getNumberText();
        
        setStrike(opponentNumber, playerNumber);
        setBall(opponentNumber, playerNumber);
    }

    private void setStrike(String opponent, String player) {
        int strike = 0;
        for (int index = 0; index < opponent.length(); index++) {
            strike = increaseStrike(opponent, player, strike, index);
        }
        this.strike = strike;
    }

    private int increaseStrike(String opponent, String player, int strike, int index) {
        if (isStrike(opponent, player, index)) {
            strike++;
        }

        return strike;
    }

    private void setBall(String opponent, String player) {
        int ball = 0;
        for (int index = 0; index < opponent.length(); index++) {
            ball = increaseBall(opponent, player, ball, index);
        }
        this.ball = ball;
    }

    private int increaseBall(String opponent, String player, int ball, int index) {
        if (isStrike(opponent, player, index)) {
            return ball;
        }

        if (isBall(opponent, player, index)) {
            ball++;
        }

        return ball;
    }

    private boolean isStrike(String opponent, String player, int index) {
        return opponent.charAt(index) == player.charAt(index);
    }

    private boolean isBall(String opponent, String player, int index) {
        return opponent.contains(String.valueOf(player.charAt(index)));
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
