package baseball.type;

import static baseball.type.ErrorMessageType.GREATER_THAN_END_INCLUSIVE;
import static baseball.type.ErrorMessageType.LESS_THAN_START_INCLUSIVE;

public enum NumberRangeType {
    START_INCLUSIVE(1),
    END_INCLUSIVE(9);

    private final int number;

    NumberRangeType(final int number) {
        this.number = number;
    }

    public static void isNumberRangeType(final int number) {
        if (number < START_INCLUSIVE.getNumber()) {
            throw new IllegalArgumentException(LESS_THAN_START_INCLUSIVE.getMessage());
        }
        if (number > END_INCLUSIVE.getNumber()) {
            throw new IllegalArgumentException(GREATER_THAN_END_INCLUSIVE.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }
}
