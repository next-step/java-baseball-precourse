package baseball.domain;

import baseball.ui.UI;

public class CheckResult {

    private int strikeCount;
    private int ballCount;
    private boolean result = false;

    public CheckResult() {
    }

    public CheckResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;

        if(strikeCount ==3){
            this.result = true;
        }
    }


    public int getStrikeCount() {
        return strikeCount;
    }

    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public boolean isCorrect(){
        return this.result;
    }

    public String checkResultString(){
        StringBuffer response = new StringBuffer();

        if(strikeCount > 0){
            response.append(strikeCount).append(UI.STRIKE).append(" ");
        }

        if(ballCount > 0){
            response.append(ballCount).append(UI.BALL);
        }

        if(strikeCount == 0 && ballCount == 0){
            response.append(UI.NOTHING);
        }

        return response.toString();
    }

}
