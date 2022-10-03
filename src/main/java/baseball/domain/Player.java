package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import static baseball.validate.InputValidator.*;
import static baseball.validate.NumberValidator.*;

public class Player {

    private List<Integer> numbers = new ArrayList<>();

    public void inputNumbers(String numbersStr){
        clearNumbers();
        validateInputLength(numbersStr);
        validateInputNumber(numbersStr);

        for(int i=0; i<numbersStr.length(); i++ ){
            numbers.add(numbersStr.charAt(i) - '0');
        }

        validateUnique(numbers);
    }

    public void clearNumbers(){
        this.numbers.clear();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
