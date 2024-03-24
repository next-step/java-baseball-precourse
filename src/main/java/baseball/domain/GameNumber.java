package baseball.domain;

import java.util.Objects;

public class GameNumber {

    private final Integer number;

    private GameNumber(Integer number) {
        validate(number);
        this.number = number;
    }

    public static GameNumber create(Integer number) {
        return new GameNumber(number);
    }

    private void validate(Integer number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException("게임 숫자는 1 ~ 9 사이의 숫자이어야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameNumber that = (GameNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
