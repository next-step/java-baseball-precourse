package baseball.model;

import java.util.List;

public class Computer {
    private final List<Integer> numbers;

    public Computer(NumberGenerator numberGenerator) {
        this.numbers = numberGenerator.generate();
    }

    public JudgeResult judge(int index, int playerNumber) {
        if (playerNumber == numbers.get(index)) {
            return JudgeResult.STRIKE;
        }
        if (numbers.contains(playerNumber)) {
            return JudgeResult.BALL;
        }
        return JudgeResult.NONE;
    }


}
