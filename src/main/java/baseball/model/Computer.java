package baseball.model;

import baseball.controller.Game;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> balls;

    public List<Integer> balls() {
        return balls;
    }

    public void generateBalls() {
        this.balls = new ArrayList<>();

        while (isLessThanInputSize()) {
            addNewBall(this.balls);
        }
    }

    private boolean isLessThanInputSize() {
        return this.balls.size() < Game.BALL_INPUT_SIZE;
    }

    private static void addNewBall(List<Integer> balls) {
        int newBall = generateNewBall();

        if (isDuplicateBalls(balls, newBall)) {
            balls.add(newBall);
        }
    }

    private static int generateNewBall() {
        return Randoms.pickNumberInRange(Game.BALL_MIN_NUMBER, Game.BALL_MAX_NUMBER);
    }

    private static boolean isDuplicateBalls(List<Integer> balls, int ball) {
        return !balls.contains(ball);
    }
}
