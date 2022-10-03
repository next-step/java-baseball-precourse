package baseball.domain.number;

import static baseball.util.StringUtils.parseInt;

public class Number {

    private final int number;

    public Number(final int number) {
        this.number = number;
    }

    public Number(final String number) {
        this.number = parseInt(number);
    }

    public Number(final char number) {
        this.number = Character.getNumericValue(number);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Number{" +
            "number=" + number +
            '}';
    }
}
