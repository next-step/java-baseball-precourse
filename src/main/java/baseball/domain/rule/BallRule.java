package baseball.domain.rule;

import baseball.domain.result.Result;
import java.util.Deque;
import java.util.LinkedList;

public class BallRule implements Rule {

    @Override
    public int count(String input, String randomValue, Result baseballResult) {
        Deque<Character> randomValueDeque = createRandomValueDeque(randomValue);
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            result = getBallCount(input, randomValueDeque, result, i);
        }
        baseballResult.setBall(result);
        return result;
    }

    private Deque<Character> createRandomValueDeque(String randomValue) {
        Deque<Character> randomValueDeque = new LinkedList<>();
        for (int i = 0; i < randomValue.length(); i++) {
            randomValueDeque.addLast(randomValue.charAt(i));
        }
        return randomValueDeque;
    }

    private int getBallCount(String input, Deque<Character> randomValueDeque, int result, int i) {
        for (int j = 0; j < input.length() - 1; j++) {
            result = isBallThenAddCount(input, randomValueDeque, result, i);
        }
        return result;
    }

    private int isBallThenAddCount(String input, Deque<Character> randomValueDeque, int result, int i) {
        Character random = randomValueDeque.removeLast();
        if (input.charAt(i) == random) {
            result++;
        }
        randomValueDeque.addFirst(random);
        return result;
    }
}
