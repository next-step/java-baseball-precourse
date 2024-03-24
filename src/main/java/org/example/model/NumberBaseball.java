package org.example.model;

import org.example.support.RandomNumberGenerator;

import static org.example.model.Constants.*;

public class NumberBaseball {

    private Result result;
    private GameStatus gameStatus;
    private int targetNumber;

    public NumberBaseball() {
        result = new Result();
        gameStatus = GameStatus.START;
        targetNumber = RandomNumberGenerator.generate(DIGIT_LOWER_BOUND, DIGIT_UPPER_BOUND, DIGIT_LENGTH);
    }

    public void reset() {
        result.clear();
        gameStatus = GameStatus.START;
        targetNumber = RandomNumberGenerator.generate(DIGIT_LOWER_BOUND, DIGIT_UPPER_BOUND, DIGIT_LENGTH);
    }

    public void play(int userNumber) {
        result.clear();
        compareNumbers(targetNumber, userNumber);
        checkResult();
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    private void compareNumbers(int randomNumber, int userNumber) {
        String randomNumberString = String.valueOf(randomNumber);
        String userNumberString = String.valueOf(userNumber);

        for (int i = 0; i < DIGIT_LENGTH; i++) {
            if (randomNumberString.charAt(i) == userNumberString.charAt(i)) {
                result.strike();
                continue;
            }

            if (randomNumberString.contains(String.valueOf(userNumberString.charAt(i)))) {
                result.ball();
            }
        }
    }

    private void checkResult() {
        System.out.println(result);
        if (result.getStrike() == DIGIT_LENGTH) {
            gameStatus = GameStatus.END;
        }
    }
}