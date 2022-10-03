package baseball.result;

import baseball.constants.Condition;
import baseball.result.bean.Computer;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ComputerNumberGenerator {


    public Computer generateComputerNumber() {
        Computer computerNumber = new Computer();
        List<Integer> numbers = getRandomNumberList();
        computerNumber.setNumbers(numbers);
        return computerNumber;
    }

    private List<Integer> getRandomNumberList() {
        List<Integer> numbers = getNumberList();
        while(checkInvalidDigitNumber(numbers)) {
            numbers = getNumberList();
        }
        return numbers;
    }

    private List<Integer> getNumberList() {
        List<Integer> numbers = new ArrayList<>();
        while(numbers.size() < 3) {
            if(numbers.size() == 3) {
                break;
            }
            numbers.add(getRandomDigit());
        }
        return numbers;
    }

    private boolean checkInvalidDigitNumber(List<Integer> numbers) {
        int distinctedDigitSize = new HashSet<Integer>(numbers).size();
        if(distinctedDigitSize != Condition.DIGIT_LENGTH) {
            return true;
        }
        return false;
    }

    private int getRandomDigit() {
        return Randoms.pickNumberInRange(Condition.START_INCLUSIVE, Condition.END_INCLUSIVE);
    }
}
