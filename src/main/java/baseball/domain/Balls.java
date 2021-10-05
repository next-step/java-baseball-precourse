package baseball.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Balls {

    private List<Ball> balls;
    private Result result;


    public Balls() {
        balls = new ArrayList<>();
        result = new Result();
    }

    public Balls(List<Ball> balls) {
        this.balls = balls;
    }


    public Ball getBall(int i) {
        return balls.get(i);
    }

    public void setBalls(List<Integer> ballsNumber) {
        balls = new ArrayList<>();
        for (int i = 0; i < ballsNumber.size(); i++) {
            balls.add(new Ball(i + 1, ballsNumber.get(i)));
        }
    }


    public String calculate(Balls targetBalls) {
        result = new Result();
        result = calculateStrike(result, targetBalls);

        return result.toString();
    }

    public Result getResult() {
        return result;
    }

    private Result calculateBall(Result result, Ball targetBall) {
        for (int i = 0; i < balls.size(); i++) {
            result.compareStatus(balls.get(i).compareBall(targetBall));
        }
        return result;
    }

    public Result calculateStrike(Result result, Balls targetBalls) {
        for (int i = 0; i < balls.size(); i++) {
            result.compareStatus(balls.get(i).compareStrike(targetBalls.getBall(i)));
            result = calculateBall(result, targetBalls.getBall(i));
        }
        return result;
    }







    public int size() {
        return balls.size();
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < balls.size(); i++) {
            buf.append(balls.get(i).getNumber());
        }
        return buf.toString();
    }

    public int toInteger() {
        return Integer.parseInt(toString());
    }

}
