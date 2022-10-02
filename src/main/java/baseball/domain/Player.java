package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final char CHAR_ZERO = '0';
    private final Balls balls;

    public Player(String enteredNumber) {
        this.balls = createBalls(enteredNumber);
    }

    private static Balls createBalls(String enteredNumber) {
        List<Integer> numbers = new ArrayList<>();
        for (char c : enteredNumber.toCharArray()) {
            numbers.add(c - CHAR_ZERO);
        }
        return new Balls(numbers);
    }

    public Balls getHasBalls() {
        return this.balls;
    }
}
