package baseball.referee.domain;

import baseball.ball.domain.Ball;
import baseball.game.domain.Game;
import baseball.pitching.domain.Pitching;
import baseball.zone.domain.Zone;

public class Referee {

    private final Zone zone;
    private final Pitching pitching;

    public Referee(Zone zone, Pitching pitching) {
        this.zone = zone;
        this.pitching = pitching;
    }

    public void judgeGame(Game game) {
        if (judgeStrikeCount() == 3) {
            game.end();
        }
    }

    public int judgeStrikeCount() {
        int strikeCount = 0;
        for (Ball ball : this.pitching.pitchingBalls()) {
            strikeCount = increaseStrikeCount(strikeCount, ball);
        }
        return strikeCount;
    }

    public int judgeBallCount() {
        int ballCount = 0;
        for (Ball pitchingBall : this.pitching.pitchingBalls()) {
            ballCount = increaseBallCount(ballCount, pitchingBall);
        }
        return ballCount - judgeStrikeCount();
    }

    private int increaseStrikeCount(int strikeCount, Ball ball) {
        if (this.zone.isContainBall(ball)) {
            strikeCount++;
        }
        return strikeCount;
    }

    private int increaseBallCount(int ballCount, Ball pitchingBall) {
        if (this.zone.isContainBallNumber(pitchingBall.ballNumber())) {
            ballCount++;
        }
        return ballCount;
    }

}
