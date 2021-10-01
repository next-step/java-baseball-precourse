package baseball.domain;

import java.util.Objects;

public class Ball {

    private int seq;
    private int number;

    public Ball(int seq, int number) {
        this.seq = seq;
        this.number = number;
    }

    public int getSeq() {
        return seq;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return seq == ball.seq && number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(seq, number);
    }
}
