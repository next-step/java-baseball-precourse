package baseball.model;

import static baseball.common.ConstValue.MAX_NUMBER;
import static baseball.common.ConstValue.MIN_NUMBER;

public class Ball {

    private int number;

    public Ball(int number) {
        isNumberValidCheck(number);
        this.number = number;
    }

    /**
     * 1 ~ 9 의 숫자만 허용
     */
    private void isNumberValidCheck(int number) {
        if (number < MIN_NUMBER || MAX_NUMBER < number) {
            throw new IllegalArgumentException();
        }
    }

    public int getNumber() {
        return number;
    }
}
