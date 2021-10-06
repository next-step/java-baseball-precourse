package baseball.model;
import nextstep.utils.Console;

public class BaseballGame {
    private String GAMESTATUS = "start";
    private final BaseballComputer numberOfComputer;

    private BaseballGame(BaseballComputer computerNumber) {
        this.numberOfComputer = computerNumber;
    }

    public static BaseballGame createGame(){
        BaseballComputer randomNumber = new BaseballComputer();
        return new BaseballGame(randomNumber);
    }

    public BaseballComputer getComputer(){
        return this.numberOfComputer;
    }

    public void startGame(){
        while(this.GAMESTATUS == "start"){
            System.out.println("숫자를 입력하세요: ");
            String userInput = Console.readLine();
            BaseballPlayer baseballPlayerNumber = new BaseballPlayer(userInput);
            baseballPlayerNumber.verifyNumber(baseballPlayerNumber.getNumber());

        }
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
