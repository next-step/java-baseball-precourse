package baseball.domain;

import baseball.util.RandomNumberGenerator;
import java.util.List;

public class Computer {
    private final Balls balls;

    public Computer() {
        this.balls = createBalls();
    }

    private static Balls createBalls() {
        List<Integer> randomNumbers = RandomNumberGenerator.getThreeRandomNumbers();
        return new Balls(randomNumbers);
    }

    public Balls getHasBalls() {
        return this.balls;
    }
}
