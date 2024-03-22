package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baseball {

    private final static List<Integer> SINGLE_DIGITS = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

    private GameState state;
    private Numbers numbers;
    private final int size;

    public Baseball() {
        this(3);
    }

    public Baseball(int size) {
        this.state = GameState.Init;
        this.size = size;
    }

    public void startGame() throws BaseballStateException {
        if (!(state == GameState.Init || state == GameState.End)) {
            throw new BaseballStateException("startGame은 Init, End 상태에서만 가능합니다 (현재 상태: " + state +  ")");
        }
        numbers = generateRandomNumbers(size);
        state = GameState.Running;
        System.out.println(numbers);
    }

    private static Numbers generateRandomNumbers(int size) {
        List<Integer> digits = new ArrayList<>(SINGLE_DIGITS);
        Collections.shuffle(digits);
        return new Numbers(digits.subList(0, size));
    }

    public Result guessNumbers(Numbers input) {
        if (state != GameState.Running) {
            throw new BaseballStateException("guessNumbers는 Running 상태에서만 가능합니다 (현재 상태: " + state +  ")");
        }
        Result result = numbers.matchWith(input);
        if (result.isSuccess(size)) {
            state = GameState.End;
        }
        return result;
    }

    GameState getState() {
        return state;
    }

    Numbers getNumbers() {
        return numbers;
    }

}
