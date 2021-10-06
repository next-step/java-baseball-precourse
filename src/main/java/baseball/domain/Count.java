package baseball.domain;

import java.util.Objects;

public class Count {

    private static final int UPPER_BOUND = 3;
    private static final int LOWER_BOUND = 0;

    private final int numberOfStrikes;
    private final int numberOfBalls;

    public Count(final int numberOfStrikes, final int numberOfBalls) {
        validate(numberOfStrikes, numberOfBalls);
        this.numberOfStrikes = numberOfStrikes;
        this.numberOfBalls = numberOfBalls;
    }

    public void validate(final int numberOfStrikes, final int numberOfBalls) {
        if (numberOfStrikes < LOWER_BOUND || numberOfStrikes > UPPER_BOUND) {
            throw new IllegalArgumentException("[ERROR] 스트라이크 갯수는 0개~3개를 벗어난 범위의 값을 입력할 수 없습니다.");
        }

        if (numberOfBalls < LOWER_BOUND || numberOfBalls > UPPER_BOUND) {
            throw new IllegalArgumentException("[ERROR] 볼 갯수는 0개~3개를 벗어난 범위의 값을 입력할 수 없습니다.");
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Count count = (Count) o;
        return numberOfStrikes == count.numberOfStrikes && numberOfBalls == count.numberOfBalls;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfStrikes, numberOfBalls);
    }
}
