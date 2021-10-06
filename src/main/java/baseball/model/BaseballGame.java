package baseball.model;
import baseball.model.BaseballNumber;

public class BaseballGame {
    private String GAMESTATUS = "start";
    private final BaseballNumber numberOfComputer;

    private BaseballGame(BaseballNumber computerNumber) {
        this.numberOfComputer = computerNumber;
    }

    public static BaseballGame createGame(){
        BaseballNumber randomNumber = new BaseballNumber();
        return new BaseballGame(randomNumber);
    }

    public BaseballNumber getComputer(){
        return this.numberOfComputer;
    }

    public void setStatusEnd(){
        GAMESTATUS = "end";
    }

    public void checkGameEnd(){
        if (GAMESTATUS == "end"){
            endGame();
        }
    }

    public void endGame(){

    }
}
