package baseball.score;

import baseball.model.Ball;

import java.util.ArrayList;

public class ScoreController extends ScoreServiceImpl {
    @Override
    public void start() {
        super.start();
    }

    @Override
    public ArrayList<String> createBallCount(ArrayList<String> ballCount) {
        return super.createBallCount(ballCount);
    }

    @Override
    public ArrayList<String> input() {
        return super.input();
    }

    @Override
    public ArrayList<String> validationSelectBalls(String inputBalls) {
        return super.validationSelectBalls(inputBalls);
    }

    @Override
    public Ball compareValue(Ball ball, ArrayList<String> arr, ArrayList<String> anotherArr) {
        return super.compareValue(ball, arr, anotherArr);
    }

    @Override
    public void restart() {
        super.restart();
    }

    @Override
    public void finish() {
        super.finish();
    }
}
