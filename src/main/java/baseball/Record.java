package baseball;

import java.util.ArrayList;
import java.util.List;

public class Record {
    List<Integer> answer;
    List<Integer> input;
    int strike;
    int ball;

    public Record(List<Integer> answer, String input) {
        this.answer = answer;
        this.input = convertIntegerArray(input);
        this.strike = 0;
        this.ball = 0;
    }

    private List<Integer> convertIntegerArray(String input) {
        List<Integer> newInput= new ArrayList<>();
        String[] inputs = input.split("");
        for (String s : inputs) {
            newInput.add(Integer.parseInt(s));
        }
        return newInput;
    }

    public boolean isCorrect() {
        return strike == 3;
    }

    public void plusOneStrike() {
        this.strike++;
    }

    public void plusOneBall() {
        this.ball++;
    }
}
