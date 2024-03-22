package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baseball {

    private final static List<Integer> SINGLE_DIGITS = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

    private GameState state;
    private Numbers numbers;

    public Baseball() {
        this.state = GameState.Init;
    }

    public void startGame() throws BaseballStateException {
        if (!(state == GameState.Init || state == GameState.End)) {
            throw new BaseballStateException("startGame은 Init, End 상태에서만 가능합니다 (현재 상태: " + state +  ")");
        }
        numbers = generateRandomNumbers();
        state = GameState.Running;
        System.out.println(numbers);
    }

    private static Numbers generateRandomNumbers() {
        List<Integer> digits = new ArrayList<>(SINGLE_DIGITS);
        Collections.shuffle(digits);
        return new Numbers(digits.get(0), digits.get(1), digits.get(2));
    }

    public Result guessNumbers(Numbers input) {
        if (state != GameState.Running) {
            throw new BaseballStateException("guessNumbers는 Running 상태에서만 가능합니다 (현재 상태: " + state +  ")");
        }
        Result result = numbers.matchWith(input);
        if (result.isSuccess()) {
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
