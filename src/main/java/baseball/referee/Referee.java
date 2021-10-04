package baseball.referee;

import baseball.balls.Ball;
import baseball.balls.Balls;

public class Referee {

    private Balls computerBalls;
    private Ball userBall;

    public Referee(Balls computerBalls, Ball userBall) {
        this.computerBalls = computerBalls;
        this.userBall = userBall;
    }

    public String judge() {
        for (int i = 0; i < computerBalls.getBallList().size(); i++) {
            Ball computerBall = computerBalls.getBallList().get(i);

            if (computerBall.getNumber() == userBall.getNumber() && computerBall.getPosition() == userBall.getPosition()) {
                return "STRIKE";
            }

            if (computerBall.getNumber() == userBall.getNumber() && computerBall.getPosition() != userBall.getPosition()) {
                return "BALL";
            }

        }

        return "NOTHING";
    }


}
