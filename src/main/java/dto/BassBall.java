package dto;

public class BassBall {

    String initYN = "";
    String baseBallNum = "";


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

}
