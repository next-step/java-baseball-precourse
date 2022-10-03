package baseball.domain;

public class Computer {

    private final Balls balls;

    public Computer(PickBallsStrategy pickBallsStrategy) {
        this.balls = new Balls(pickBallsStrategy.pickBalls());
    }

    public GameResult judgeResult(Balls playerBalls) {
        return this.balls.makeGameResult(playerBalls);
    }

}
