package baseball.service;

import baseball.util.Constant;
public class Score {
    private static final Score SCORE = new Score();
    private int strike;
    private int ball;

    private Score() {
        clearScore();
    }

    public static Score getInstance() {
        return SCORE;
    }

    public void checkScore(String number, String input) {
        for (int i = 0; i < Constant.NUMBER_SIZE; i++) {
            checkStrikeBall(number, input.charAt(i), i);
        }
    }

    private void checkStrikeBall(String number, char c, int index) {
        // number의 해당 인덱스가 c와 같으면 스트라이크
        if (number.charAt(index) == c) {
            strike++;
            return;
        }

        // number에 c가 포함되어 있으면 ball
        if (number.indexOf(c) >= 0) {
            ball++;
        }
    }

    // Getter
    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    // 초기화
    public void clearScore() {
        this.strike = 0;
        this.ball = 0;
    }


}
