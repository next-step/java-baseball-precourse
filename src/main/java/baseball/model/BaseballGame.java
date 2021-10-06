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
            BaseballCount baseballCount = new BaseballCount(0,0).calculateCount(this.numberOfComputer.getNumber(),baseballPlayerNumber.getNumber());
            BaseballHint baseballHint = new BaseballHint(baseballCount.getStrikes(), baseballCount.getBalls());
            baseballHint.showHint();
            checkGameEnd(baseballCount.getStrikes(), baseballCount.getBalls());
        }
    }
    public void askRestart(){
        System.out.println("게임이 끝났습니다. 재시작하시려면 1, 종료하시려면 다른키 를 입력해주세요.");
        String restartInput = Console.readLine();
        System.out.println(restartInput+"1");
        if (restartInput.equals("1")){
            this.GAMESTATUS="start";
            startGame();
        }
        endGame();
    }

    public void checkGameEnd(int strikes, int balls){
        if (strikes == 3){
            askRestart();
        }
        endGame();
    }

    public void endGame(){
        this.GAMESTATUS = "end";
    }
}
