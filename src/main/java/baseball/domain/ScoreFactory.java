package baseball.domain;

public class ScoreFactory {

    private Strike strike;
    private Ball ball;
    private Nothing nothing;

    public ScoreFactory(Strike strike, Ball ball, Nothing nothing) {
        this.strike = strike;
        this.ball = ball;
        this.nothing = nothing;
    }

    public Score getScore(Numbers randomNumbers, Numbers numbers) {
        for (int i = 0; i < 3; i++) {
            Number number1 = randomNumbers.getNumber(i);
            countLoop(numbers, i, number1);
        }
        if (isNothing()) {
            this.ball = null;
            this.strike = null;
        }
        return new Score(strike, ball, nothing);
    }

    private boolean isNothing() {
        return strike.getCount() == 0 && ball.getCount() == 0;
    }

    private void countLoop(Numbers numbers, int i, Number number1) {
        for (int j = 0; j < 3; j++) {
            Number number2 = numbers.getNumber(j);
            count(i, number1, j, number2);
        }
    }

    private void count(int i, Number number1, int j, Number number2) {
        if (i == j) {
            countStrike(number1, number2);
        } else {
            countBall(number1, number2);
        }
    }

    private void countBall(Number number1, Number number2) {
        if (number1.equals(number2)) {
            ball.count();
        }
    }

    private void countStrike(Number number1, Number number2) {
        if (number1.equals(number2)) {
            strike.count();
        }
    }
}
