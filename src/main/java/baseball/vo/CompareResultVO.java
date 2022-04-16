package baseball.vo;


public class CompareResultVO {
    private int ballCount;
    private int strikeCount;
    private boolean isAllCorrectAnswer;
    private String gameResultMessage;

    public CompareResultVO(){
        this.ballCount = 0;
        this.strikeCount = 0;
        this.isAllCorrectAnswer = false;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public String getGameResultMessage() {
        return gameResultMessage;
    }

    public boolean isAllCorrectAnswer() {
        return isAllCorrectAnswer;
    }

    public void increaseBallCount(){
        this.ballCount++;
    }

    public void increaseStrikeCount(){
        this.strikeCount++;
    }

    public void allCorrectAnswer() {
        this.isAllCorrectAnswer = true;
    }

    public void setGameResultMessage(String gameResultMessage) {
        this.gameResultMessage = gameResultMessage;
    }

}
