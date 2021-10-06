package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Count {

    private static final int UPPER_BOUND = 3;
    private static final int LOWER_BOUND = 0;

    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private static final String DELIMITER = " ";

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

    public boolean isStrikeOut() {
        return this.numberOfStrikes == UPPER_BOUND;
    }

    @Override
    public String toString() {
        final List<String> logs = new ArrayList<>();
        onNothing(logs);
        onStrikes(logs);
        onBalls(logs);
        return String.join(DELIMITER, logs);
    }

    private void onNothing(final List<String> logs) {
        if (numberOfStrikes == 0 && numberOfBalls == 0) {
            logs.add(NOTHING);
        }
    }

    private void onStrikes(final List<String> logs) {
        if (numberOfStrikes > 0) {
            logs.add(numberOfStrikes + STRIKE);
        }
    }

    private void onBalls(final List<String> logs) {
        if (numberOfBalls > 0) {
            logs.add(numberOfBalls + BALL);
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
