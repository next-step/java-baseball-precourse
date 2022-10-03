package baseball;
/**
 * packageName    : baseball
 * fileName       : Hint
 * author         : BOM
 * date           : 2022-10-02
 * description    : 힌트의 count 수를 가지는 class
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-10-02        BOM       최초 생성
 * 2022-10-02        BOM       resetCounts 메서드 추가
 */
public class Hint {
    private int strike,ball;

    public Hint(){
        this.strike =0;
        this.ball = 0;
    }
    public void resetCounts(){
        this.strike =0;
        this.ball = 0;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }
    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }
}
