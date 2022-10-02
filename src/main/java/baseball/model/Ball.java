package baseball.model;

import java.util.Objects;

public class Ball {
    private final int value;


    public Ball(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball = (Ball) o;
        return value == ball.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Ball{" +
                "value=" + value +
                '}';
    }
}
