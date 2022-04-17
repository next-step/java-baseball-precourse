package baseball.domain;

import java.util.List;

public class ScoreBoard {
    private int totalSameNumber;
    private int ball;
    private int strike;

    public ScoreBoard() {
        this.totalSameNumber = 0;
        this.ball = 0;
        this.strike = 0;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public void countScore(final List<Integer> answer, final List<Integer> userAnswer) {
        countSameNumber(answer, userAnswer);
        countStrike(answer, userAnswer);

        ball = totalSameNumber - strike;
    }

    private void countSameNumber(final List<Integer> answer, final List<Integer> userAnswer) {
        for (Integer number : userAnswer) {
            incrementTotalSameNumberInList(answer, number);
        }
    }

    private void incrementTotalSameNumberInList(final List<Integer> answer, final Integer number) {
        if (answer.contains(number)) {
            totalSameNumber++;
        }
    }

    private void countStrike(final List<Integer> answer, final List<Integer> userAnswer) {
        for(int i = 0; i < userAnswer.size(); i++) {
            incrementStrike(answer.get(i), userAnswer.get(i));
        }
    }

    private void incrementStrike(final Integer answerDigit, final Integer userAnswerDigit) {
        if (answerDigit.equals(userAnswerDigit)) {
            strike++;
        }
    }
}
