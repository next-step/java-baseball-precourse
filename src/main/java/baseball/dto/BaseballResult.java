package baseball.dto;

public class BaseballResult {
    private int strike;
    private int ball;
    private String resultCode;
    /*
    resultCode - 결과코드
    S : 숫자 모두 맞춤
    F : 숫자 모두 or 일부 못맞
    E : 에러
     */

    public BaseballResult(int strike, int ball, String resultCode) {
        this.strike = strike;
        this.ball = ball;
        this.resultCode = resultCode;
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

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

}
