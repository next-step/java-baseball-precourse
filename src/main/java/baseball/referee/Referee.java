package baseball.referee;

import baseball.balls.Ball;
import baseball.balls.Balls;


public class Referee {

    private Balls computerBalls;

    public Referee(Balls computerBalls) {
        this.computerBalls = computerBalls;
    }

    public String judge(Ball userBall) {
        for (int i = 0; i < computerBalls.getBallList().size(); i++) {
                Ball computerBall = computerBalls.getBallList().get(i);

            if (computerBall.getNumber() == userBall.getNumber() && computerBall.getPosition() == userBall.getPosition()) {
                return "STRIKE";
            }

            if(computerBall.getNumber() == userBall.getNumber() && computerBall.getPosition() != userBall.getPosition()){
                return "BALL";
            }

        }

        return "NOTHING";
    }





}
