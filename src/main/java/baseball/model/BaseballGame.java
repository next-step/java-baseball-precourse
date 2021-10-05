package baseball.model;

public class BaseballGame {
    String GAMESTATUS = "start";

    public BaseballGame(){
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
