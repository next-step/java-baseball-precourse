package baseball.model;

import baseball.rule.BaseballGameRule;
import baseball.util.Message;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> numbers;

    public Player() {
        init();
    }

    private void init() {
        numbers = new ArrayList<>();
    }

    public void setNumbers(String input) {
        checkValidInputLength(input.length());

        numbers.clear();

        for(char c : input.toCharArray()) {
            checkValidNumber(c);
            numbers.add(c - '0');
        }
    }

    private void checkValidInputLength(int length) {
        if(length != BaseballGameRule.LENGTH_OF_NUMBERS){
            throw new IllegalArgumentException(Message.ERROR_INPUT.getMessage());
        }
    }

    private void checkValidNumber(char c) {
        if(c < '1' || c > '9'){
            throw new IllegalArgumentException(Message.ERROR_INPUT.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
