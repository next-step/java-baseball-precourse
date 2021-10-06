package baseball.domain;

import java.util.Objects;

public class Game {

    private final Number answer;

    public Game(final Number answer) {
        validate(answer);
        this.answer = answer;
    }

    private void validate(final Number answer) {
        if (Objects.isNull(answer)) {
            throw new IllegalArgumentException("[ERROR] 게임의 정답은 null이 될 수 없습니다.");
        }
    }

    public Count guess(final Number guess) {
        int numberOfStrikes = 0;
        int numberOfBalls = 0;

        for (int i = 0; i < Number.NUMBER_OF_DIGITS; i++) {
            numberOfStrikes += isStrike(guess, i);
            numberOfBalls += isBall(guess, i);
        }

        return new Count(numberOfStrikes, numberOfBalls);
    }

    private int isStrike(final Number guess, final int index) {
        if (answer.equalsAt(guess, index)) {
            return 1;
        }
        return 0;
    }

    private int isBall(final Number guess, final int i) {
        if (answer.containsExceptAt(guess, i)) {
            return 1;
        }
        return 0;
    }
}
