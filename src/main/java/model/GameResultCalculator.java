package model;

import static model.BaseballNumber.VALID_LENGTH;

public class GameResultCalculator {

    public static GameResult calculate(BaseballNumber target, BaseballNumber guess) {
        return new GameResult(countStrike(target, guess), countBall(target, guess));
    }

    private static int countStrike(BaseballNumber target, BaseballNumber guess) {
        int count = 0;
        for (int i = 0; i < VALID_LENGTH; i++) {
            if (target.get(i) == guess.get(i)) {
                count++;
            }
        }
        return count;
    }

    private static int countBall(BaseballNumber target, BaseballNumber guess) {
        int count = 0;
        for (int i = 0; i < VALID_LENGTH; i++) {
            if (target.contains(guess.get(i)) && target.get(i) != guess.get(i)) {
                count++;
            }
        }
        return count;
    }
}
