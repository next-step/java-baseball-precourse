package baseball.model;

public class InningRepository {
    private int strikeCnt;
    private int ballCnt;
    private String answer;
    private String userInput;

    public void InningRepository(){
        this.strikeCnt = 0;
        this.ballCnt = 0;
    }

    public String getAnswer(){
        return this.answer;
    }
    public void setAnswer(String answer){
        this.answer = answer;
    }

    public String getUserInput(){
        return this.userInput;
    }
    public void setUserInput(String userInput){
        this.userInput = userInput;
    }

    public int getStrikeCnt(){
        return this.strikeCnt;
    }
    public void setStirikeCnt(int num){
        this.strikeCnt = num;
    }

    public int getBallCnt(){
        return this.ballCnt;
    }
    public void setBallCnt(int num){
        this.ballCnt = num;
    }
}
