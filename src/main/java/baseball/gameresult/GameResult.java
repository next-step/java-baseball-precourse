package baseball.gameresult;

import baseball.balls.Ball;
import baseball.balls.Balls;
import baseball.referee.Referee;

public class GameResult {

    private Balls computerBalls, userBalls;

    private int strikeCount = 0;
    private int ballCount = 0;

    public GameResult(Balls computerBalls, Balls userBalls) {
        this.computerBalls = computerBalls;
        this.userBalls = userBalls;
    }

    public String playGame() {
        Referee referee = new Referee(computerBalls);

        for (int i = 0; i < userBalls.getBallList().size(); i++) {
            increaseCount(referee.judge(userBalls.getBallList().get(i)));
        }

        return resultWithCount();
    }

    private void increaseCount(String judgementResult) {
        if(judgementResult == "STRIKE"){
            ++strikeCount;
        }

        if(judgementResult == "BALL"){
            ++ballCount;
        }
    }

    private String resultWithCount(){
        if(strikeCount == 0 && ballCount == 0){
            return "NOTHING";
        }

        if(strikeCount == 0){
            return ballCount + "BALL";
        }

        if(ballCount == 0){
            return strikeCount + "STRIKE";
        }

        if(strikeCount !=0 && ballCount !=0){
            return strikeCount + "STRIKE " + ballCount + "BALL";
        }

        return "NOTHING";
    }
}
