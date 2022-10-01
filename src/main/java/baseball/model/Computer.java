package baseball.model;

import java.util.Map;

/**
 * 상대방(컴퓨터)
 */
public class Computer {

    private final Map<Integer, Integer> number;

    public Computer(NumberGenerator numberGenerator, NumberControl numberControl) {
        number = numberGenerator.generateNumber(numberControl);
    }

    public Map<Integer, Integer> getNumber() {
        return number;
    }
}
