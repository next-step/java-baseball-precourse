package baseball.domain;

public class Round {

    private int strikeCnt = 0;
    private int ballCnt = 0;

    public void setStrikeCnt(int strikeCnt) {
        this.strikeCnt = strikeCnt;
    }

    public int getStrikeCnt(){
        return this.strikeCnt;
    }

    public void setBallCnt(int ballCnt) {
        this.ballCnt = ballCnt;
    }

    public int getBallCnt(){
        return this.ballCnt;
    }

}
