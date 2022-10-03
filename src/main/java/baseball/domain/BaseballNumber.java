package baseball.domain;

import java.util.Objects;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballNumber {
    
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIUM_NUMBER = 9;

    private final int number;

    private BaseballNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static BaseballNumber from(int number) {
        return new BaseballNumber(number);
    }

    public static BaseballNumber newRandomNumber() {
        int random = Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIUM_NUMBER);
        return new BaseballNumber(random);
    }

    private void validate(int number) {
        if (!isValid(number)) {
            throw new IllegalArgumentException(
                    ErrorMessage.BASEBALL_NUMBER_OUT_OF_RANGE_ERROR.getMessage(MINIMUM_NUMBER, MAXIUM_NUMBER));
        }
    }

    private boolean isValid(int number) {
        return (number >= MINIMUM_NUMBER && number <= MAXIUM_NUMBER);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof BaseballNumber)) {
            return false;
        }

        BaseballNumber that = (BaseballNumber) obj;
        return (this.number == that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
