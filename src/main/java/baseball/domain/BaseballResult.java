package baseball.domain;

import java.util.List;

public class BaseballResult {

    public static Score match(List<Integer> inputNumbers, List<Integer> createdNumbers) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < inputNumbers.size(); i++) {
            strike += checkStrike(inputNumbers, createdNumbers, i);
            ball += checkBall(inputNumbers, createdNumbers, i);
        }
        return new Score(strike, ball);
    }

    private static int checkStrike(List<Integer> inputNumbers, List<Integer> createdNumbers, int idx) {
        if (createdNumbers.get(idx).equals(inputNumbers.get(idx))) {
            return 1;
        }
        return 0;
    }

    private static int checkBall(List<Integer> inputNumbers, List<Integer> createdNumbers, int idx) {
        if (createdNumbers.contains(inputNumbers.get(idx)) && !createdNumbers.get(idx).equals(inputNumbers.get(idx))) {
            return 1;
        }
        return 0;
    }
}
