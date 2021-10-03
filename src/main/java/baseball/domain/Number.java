package baseball.domain;

public class Number {

    private static final String INVALID_VALUE_MESSAGE = "[ERROR] 올바른 숫자를 입력해주세요.";
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;

    private final int value;

    public Number(int value) {
        checkValue(value);
        this.value = value;
    }

    private void checkValue(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new RuntimeException(INVALID_VALUE_MESSAGE);
        }
    }

    public int getValue() {
        return this.value;
    }
}
