package baseball.domain;

import baseball.enums.BaseballOption;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final int MAX_NUMBER = 9;
    private final int MIN_NUMBER = 1;


    private final List<Integer> numbers = new ArrayList<>();

    public void pickNumbers() {
        numbers.clear();
        while (numbers.size() < BaseballOption.NUMBERS_LENGTH.getNumber()){
            addUniqueNumber(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
        }
    }

    private void addUniqueNumber(int number){
        if (!this.numbers.contains(number)) {
            this.numbers.add(number);
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

}
