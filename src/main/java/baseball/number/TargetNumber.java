package baseball.number;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import static baseball.number.NumberConstant.MAXIMUM_NUMBER;
import static baseball.number.NumberConstant.MINIMUM_NUMBER;

public class TargetNumber {
    private static final Map<Integer, TargetNumber> CACHED_TARGET_NUMBERS = new LinkedHashMap<>();

    static {
        for (int i = MINIMUM_NUMBER; i <= MAXIMUM_NUMBER; i++) {
            CACHED_TARGET_NUMBERS.put(i, new TargetNumber(i));
        }
    }

    private final Number number;

    public TargetNumber(String targetNumberString) {
        this(Integer.parseInt(targetNumberString));
    }

    public TargetNumber(int targetNumber) {
        this(new Number(targetNumber));
    }

    public TargetNumber(Number number) {
        this.number = number;
    }

    public static TargetNumber getCachedTargetNumber(Number number) {
        return CACHED_TARGET_NUMBERS.get(number.getNumber());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TargetNumber that = (TargetNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
