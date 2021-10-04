package dto;

public class BassBall {

    String initYN = "";
    String baseBallNum = "";
    String strike ="";
    String ball = "";
    String msg = "";


    public BassBall() {
        this.initYN = "Y";
        this.baseBallNum = baseBallNum;
    }
    public BassBall(String baseBallNum,String initYM) {
        this.baseBallNum = baseBallNum;
        this.initYN = initYM;
    }

    public String getInitYN() {
        return initYN;
    }
    public void setInitYN(String initYN) {
        this.initYN = initYN;
    }
    public String getBaseBallNum() {
        return baseBallNum;
    }
    public void setBaseBallNum(String baseBallNum) {
        this.baseBallNum = baseBallNum;
    }

    public String getStrike() {
        return strike;
    }
    public void setStrike(String strike) {
        this.strike = strike;
    }

    public String getBall() {
        return ball;
    }
    public void setBall(String ball) {
        this.ball = ball;
    }

    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
