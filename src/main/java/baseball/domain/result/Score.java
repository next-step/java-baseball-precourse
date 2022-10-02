package baseball.domain.result;

public enum Score {
    STRIKE, BALL, MISS;

    public static Score of(int idx1, int idx2) {
        if (idx1 == -1 || idx2 == -1) {
            return Score.MISS;
        }
        if (idx1 == idx2) {
            return Score.STRIKE;
        }
        return Score.BALL;
    }

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBall() {
        return this == BALL;
    }
}