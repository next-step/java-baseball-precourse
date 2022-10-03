package baseball.domain;


import java.util.ArrayList;

public class Game {
    private ArrayList<Integer> problemNumbers;

    private BallCount ballCount;

    public Game(IRandomNumberPicker randomNumberPicker) {
        this.problemNumbers = new ArrayList<>();
        this.pickQuestionNumbers(randomNumberPicker);

    }

    public BallCount check(int[] answer) {
        this.ballCount = new BallCount();

        for (int i = 0; i < this.problemNumbers.size(); i++) {
            compareEachDigit(answer[i], i);
        }
        return ballCount;
    }

    private void compareEachDigit(int target, int answerDigitIndex) {
        for (int j = 0; j < this.problemNumbers.size(); j++) {
            checkEffective(target, answerDigitIndex, j);
        }
    }

    private void checkEffective(int target, int answerDigitIndex, int problemDigitIndex) {

        if (target == this.problemNumbers.get(problemDigitIndex) && answerDigitIndex == problemDigitIndex) {
            ballCount.addStrikeCount();
        }

        if (target == this.problemNumbers.get(problemDigitIndex) && answerDigitIndex != problemDigitIndex) {
            ballCount.addBallCount();
        }
    }

    private void pickQuestionNumbers(IRandomNumberPicker randomNumberPicker) {
        while (this.problemNumbers.size() < 3) {
            addDigitsToProblemNumbers(randomNumberPicker.pick(1, 9));
        }
    }

    private void addDigitsToProblemNumbers(int number) {
        if (!this.problemNumbers.contains(number)) {
            this.problemNumbers.add(number);
        }
    }


}
