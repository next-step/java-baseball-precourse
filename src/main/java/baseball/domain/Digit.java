package baseball.domain;

import java.util.Objects;

public class Digit {
    private int value;

    public Digit(int value) {
        this.value = value;
    }

    public static Digit parse(char digitChar) {
        try {
            int digit = Integer.parseInt(Character.toString(digitChar));
            return new Digit(digit);
        } catch (Exception e) {
            throw new IllegalArgumentException("input should be digit but: " + digitChar);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Digit digit = (Digit) o;
        return value == digit.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Digit{" +
                "value=" + value +
                '}';
    }
}
