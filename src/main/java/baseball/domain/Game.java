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

    public boolean guess(final Number guess) {
        return this.answer.equals(guess);
    }
}
