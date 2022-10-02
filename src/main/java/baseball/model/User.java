package baseball.model;

import baseball.util.InputValidator;

import java.util.ArrayList;
import java.util.List;

import static baseball.constant.BaseballProperties.GAME_SIZE;

public class User {
    private List<Ball> guesses = new ArrayList<>();

    private Result result = new Result();

    public String guessAndGetResult(String inputString, List<Ball> answer) {
        InputValidator.validateGuessNumber(inputString);
        initGuesses(inputString);
        checkAnswer(answer);
        return result.getResultString();
    }

    private void checkAnswer(List<Ball> answer) {
        result = new Result();

        for (int i = 0; i < GAME_SIZE; i++) {
            recordResult(answer.get(i), i);
        }
    }

    private void recordResult(Ball ball, int index) {
        if(ball.getValue() == guesses.get(index).getValue()) {
            result.addStrike();
            return;
        }

        if(guesses.contains(ball)) {
            result.addBall();
        }
    }

    private void initGuesses(String inputString) {
        guesses = new ArrayList<>();
        for (String number : inputString.split("")) {
            guesses.add(new Ball(Integer.parseInt(number)));
        }
    }

    public boolean isCorrect() {
        return result.isAllStrike();
    }
}
