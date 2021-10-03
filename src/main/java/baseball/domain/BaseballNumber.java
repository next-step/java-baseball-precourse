package baseball.domain;

import baseball.exception.BaseballInputException;
import baseball.exception.BaseballInputSizeException;
import baseball.exception.BaseballInputZeroException;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumber {
    private static final int MAX_SIZE = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int ZERO = 0;

    private List<Integer> numbers;

    public BaseballNumber() {
        this.numbers = new ArrayList<>();
        while (this.numbers.size() != MAX_SIZE) {
            this.numbers.add(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
        }
    }

    public int getValueByIndex(int index) {
        return numbers.get(index);
    }

    public BaseballNumber(int inputNumber) throws BaseballInputException {
        this.numbers = new ArrayList<>();
        inputBaseballNumber(inputNumber);
        checkValidate();
    }

    private void inputBaseballNumber(int inputNumber) {
        String[] splitInputNumbers = String.valueOf(inputNumber).split("");
        for (String splitInputNumber : splitInputNumbers) {
            numbers.add(Integer.parseInt(splitInputNumber));
        }
    }

    private void checkValidate() throws BaseballInputException {
        checkSizeValidate();
        for (Integer number : numbers) {
            checkZeroValidate(number);
        }
    }

    private void checkSizeValidate() throws BaseballInputSizeException {
        if (numbers.size() != MAX_SIZE) {
            throw new BaseballInputSizeException("[ERROR]3자리가 아닙니다. 다시 입력하세요.");
        }
    }

    private void checkZeroValidate(int number) throws BaseballInputZeroException {
        if (number == ZERO) {
            throw new BaseballInputZeroException("[ERROR]입력값에 0이 있습니다. 다시 입력하세요.");
        }
    }

    public String numberToString(){
        StringBuilder numberForString = new StringBuilder();
        for (Integer number : numbers) {
            numberForString.append(number);
        }
        return numberForString.toString();
    }
}
