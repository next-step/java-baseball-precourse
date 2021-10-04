package baseball.domain;

import java.util.List;

public class Balls {

    private List<Ball> balls;

    public Balls() {
    }

    public Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public static boolean composeOfDifferentNumbers() {
        return true;
    }


    public int size() {
        return balls.size();
    }
}
