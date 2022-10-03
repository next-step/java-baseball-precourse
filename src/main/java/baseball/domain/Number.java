package baseball.domain;

import java.util.HashMap;
import java.util.Map;

public class Number {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    private static final Map<Integer, Number> NUMBER_MAP;

    static {
        NUMBER_MAP = new HashMap<>();
        for (int number = MIN_NUMBER; number <= MAX_NUMBER; number++) {
            NUMBER_MAP.put(number, new Number(number));
        }
    }

    private final int number;

    private Number(int number) {
        this.number = number;
    }

    public static Number from(int number) {
        numberValid(number);
        return NUMBER_MAP.get(number);
    }

    private static void numberValid(int number) {
        if (!NUMBER_MAP.containsKey(number)) {
            throw new IllegalArgumentException("입력한 숫자를 확인 하세요.");
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return number;
    }
}
