package baseball.model;

import baseball.GlobalVariables;
import baseball.enums.MATCH_RESULT;

public class PlayResult {
    private static final String STRIKE_STR = "스트라이크";
    private static final String BALL_STR = "볼";
    private static final String NOTHING_STR = "낫싱";
    private static final String EMPTY_STR = " ";

    private int strikeCnt;
    private int ballCnt;
    private int nothingCnt;

    public int getStrikeCnt() {
        return this.strikeCnt;
    }

    public int getBallCnt() {
        return this.ballCnt;
    }

    public int getNothingCnt() {
        return this.nothingCnt;
    }

    public PlayResult() {
        this.strikeCnt = 0;
        this.ballCnt = 0;
        this.nothingCnt = 0;
    }

    public PlayResult(int strikeCnt, int ballCnt, int nothingCnt) {
        this.strikeCnt = strikeCnt;
        this.ballCnt = ballCnt;
        this.nothingCnt = nothingCnt;
    }

    public void add(MATCH_RESULT matchResult) {
        if (matchResult == MATCH_RESULT.NOTHING) {
            this.nothingCnt++;
            return;
        }

        if (matchResult == MATCH_RESULT.BALL) {
            this.ballCnt++;
            return;
        }

        this.strikeCnt++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayResult)) return false;

        PlayResult that = (PlayResult) o;
        return this.strikeCnt == that.getStrikeCnt() &&
                this.ballCnt == that.getBallCnt() &&
                this.nothingCnt == that.getNothingCnt();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (this.strikeCnt != 0) {
            this.appendBallState(builder, this.strikeCnt + STRIKE_STR);
        }

        if (this.ballCnt != 0) {
            this.appendBallState(builder, this.ballCnt + BALL_STR);
        }

        if (this.nothingCnt == GlobalVariables.MAX_BALL_CNT) {
            this.appendBallState(builder, NOTHING_STR);
        }

        return builder.toString();
    }

    private void appendBallState(StringBuilder builder, String appendText) {
        if (builder.length() != 0) {
            builder.append(EMPTY_STR);
        }

        builder.append(appendText);
    }

    public boolean isGameEnd() {
        return this.strikeCnt == GlobalVariables.MAX_BALL_CNT;
    }
}
