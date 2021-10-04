package baseball;

public class PlayResult {
    public static final int MAX_BALL_CNT = 3;
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
            this.appendBallState(builder, this.strikeCnt + "스트라이크");
        }

        if (this.ballCnt != 0) {
            this.appendBallState(builder, this.ballCnt + "볼");
        }

        if (this.nothingCnt == MAX_BALL_CNT) {
            this.appendBallState(builder, "낫싱");
        }

        return builder.toString();
    }

    private void appendBallState(StringBuilder builder, String appendText) {
        if (builder.length() != 0) {
            builder.append(" ");
        }

        builder.append(appendText);
    }

    public boolean isGameEnd() {
        return this.strikeCnt == MAX_BALL_CNT;
    }
}
