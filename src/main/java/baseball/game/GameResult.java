package baseball.game;

public class GameResult {
    private int STRIKE_CNT;
    private int BALL_CNT;

    public GameResult(int _strikeCnt, int _ballCnt) {
        this.STRIKE_CNT = _strikeCnt;
        this.BALL_CNT = _ballCnt;
    }


    public boolean resultOfCompareAnswer(){
        if(STRIKE_CNT == 3){
            return true;
        }

        if (STRIKE_CNT > 0 || BALL_CNT > 0) {
            return false;
        }
        return false;
    }

    @Override
    public String toString() {

        if (this.STRIKE_CNT == 0 && this.BALL_CNT == 0) {
            return "낫싱";
        }

        StringBuilder sbGameResult = new StringBuilder();
        if (this.BALL_CNT > 0) {
            sbGameResult.append(this.BALL_CNT + "볼 ");
        }

        if (this.STRIKE_CNT > 0) {
            sbGameResult.append(this.STRIKE_CNT + "스트라이크 ");
        }

        return sbGameResult.toString().trim();
    }
}
