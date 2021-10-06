package baseball.domain;

import java.util.Objects;

public class Number {

    public static final int NUMBER_OF_DIGITS = 3;

    private static final int UPPER_BOUND = 9;
    private static final int LOWER_BOUND = 1;
    private final String value;

    public Number(final String value) {
        validate(value);
        this.value = value;
    }

    private void validate(final String value) {
        shouldBeInteger(value);
        shouldBeThreeDigit(value);
        eachDigitBetweenOneAndNine(value);
        eachDigitUnique(value);
    }

    private void shouldBeInteger(final String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("[ERROR] 숫자 외 문자는 입력할 수 없습니다.");
        }
    }

    private void shouldBeThreeDigit(final String value) {
        if (value.length() != NUMBER_OF_DIGITS) {
            throw new IllegalArgumentException("[ERROR] 3자리 외 숫자는 입력할 수 없습니다.");
        }
    }

    private void eachDigitBetweenOneAndNine(final String value) {
        for (int i = 0; i < value.length(); i++) {
            throwIfDigitOutOfBounds(value.charAt(i));
        }
    }

    private void throwIfDigitOutOfBounds(final char ch) {
        int digit = Integer.parseInt(String.valueOf(ch));
        if (digit < LOWER_BOUND || digit > UPPER_BOUND) {
            throw new IllegalArgumentException("[ERROR] 각 자리에 1부터 9까지 외 다른 숫자는 입력할 수 없습니다.");
        }
    }

    private void eachDigitUnique(final String value) {
        for (int i = 0; i < value.length() - 1; i++) {
            eachDigitUniqueHelper(value, i);
        }
    }

    private void eachDigitUniqueHelper(final String value, final int i) {
        for (int j = i + 1; j < value.length(); j++) {
            throwIfDigitsEqual(value, i, j);
        }
    }

    private void throwIfDigitsEqual(final String value, final int i, final int j) {
        if (value.charAt(i) == value.charAt(j)) {
            throw new IllegalArgumentException("[ERROR] 서로 같은 수로 이루어진 숫자를 입력할 수 없습니다.");
        }
    }

    public boolean equalsAt(final Number o, final int index) {
        return this.value.charAt(index) == o.value.charAt(index);
    }

    public boolean containsExceptAt(final Number o, final int index) {
        if (equalsAt(o, index)) {
            return false;
        }
        final String otherValue = o.value.substring(index, index + 1);
        return this.value.contains(otherValue);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Number number = (Number) o;
        return Objects.equals(value, number.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
