package baseball.domain;

import baseball.common.NumberOption;
import baseball.exception.BaseballInputException;
import baseball.exception.BaseballInputSizeException;
import baseball.exception.BaseballInputZeroException;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumber {
    private static List<Integer> numbers;

    public BaseballNumber() {
        numbers = new ArrayList<>();
        while (!NumberOption.MAX_SIZE.isEqualValue(numbers.size())) {
            pickRandomNumber();
        }
    }

    private void pickRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(NumberOption.MIN_NUMBER.getValue(), NumberOption.MAX_NUMBER.getValue());
        if (numbers.contains(randomNumber)) {
            return;
        }
        numbers.add(randomNumber);
    }

    public int getValueByIndex(int index) {
        return numbers.get(index);
    }

    public BaseballNumber(int inputNumber) throws BaseballInputException {
        numbers = new ArrayList<>();
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
        if (!NumberOption.MAX_SIZE.isEqualValue(numbers.size())) {
            throw new BaseballInputSizeException("[ERROR]3자리가 아닙니다. 다시 입력하세요.");
        }
    }

    private void checkZeroValidate(int number) throws BaseballInputZeroException {
        if (NumberOption.ZERO.isEqualValue(number)) {
            throw new BaseballInputZeroException("[ERROR]입력값에 0이 있습니다. 다시 입력하세요.");
        }
    }

    public String numberToString() {
        StringBuilder numberForString = new StringBuilder();
        for (Integer number : numbers) {
            numberForString.append(number);
        }
        return numberForString.toString();
    }
}
