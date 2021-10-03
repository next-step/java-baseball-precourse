package baseball.model;

import nextstep.utils.Randoms;

public class Baseball {
    private final String NOTHING = "낫싱";
    private final String STRIKE = "스트라이크 ";
    private final String BALL = "볼";

    private String computerNum;
    private String playerNum;
    private int strike;
    private int ball;

    public String getComputerNum() {
        return computerNum;
    }

    public void setComputerNum() {
        int num1 = Randoms.pickNumberInRange(1, 9);
        int num2 = 0;
        int num3 = 0;
        while((num2 = Randoms.pickNumberInRange(1, 9)) == num1) ;
        while((num3 = Randoms.pickNumberInRange(1, 9)) == num1 || num3 == num2) ;

        this.computerNum = String.valueOf(num1 * 100 + num2 * 10 + num3);
    }

    public String getPlayerNum() {
        return playerNum;
    }

    public void setPlayerNum(String playerNum) {
        this.playerNum = playerNum;
    }

    public int getStrike() {
        return strike;
    }

     public int getBall() {
        return ball;
    }

    public void setStrikeAndBall() {
        int strikeCnt = 0;
        int ballCnt = 0;

        for(int i = 0; i < 3; i++) {
            //computerNum에 player 숫자가 있는지 확인
            int idx = computerNum.indexOf(playerNum.charAt(i));
            if(idx != -1 && idx == i) strikeCnt++;
            if(idx != -1 && idx != i) ballCnt++;
        }

        this.strike = strikeCnt;
        this.ball = ballCnt;
    }

    public String returnResult() {
        String result = "";
        if(this.strike == 0 && this.ball == 0) result = NOTHING;
        if(strike > 0 || ball > 0) {
            result = (strike == 0 ? "" : strike + STRIKE) + (ball == 0 ? "" : ball + BALL);
        }

        return result;
    }
}
