package baseball;

public class PlayResult {
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

    public PlayResult(){
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
}
