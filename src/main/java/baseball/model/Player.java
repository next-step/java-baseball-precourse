package baseball.model;

import java.util.List;

public class Player {
    private Integer[] numArray;
    private int ball;
    private int strike;

    public Player(Integer[] newNumArray, List<Integer> answerNumList) {
        numArray = newNumArray;
        ball = 0;
        strike = 0;

        judgeFromAnswer(answerNumList);
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    private void judgeFromAnswer(List<Integer> answerList) {
        for (int i = 0; i < numArray.length; i++) {
            checkHintFromSingleDigit(answerList, i);
        }
    }

    public boolean isNothing() {
        if (ball == 0 && strike == 0) {
            return true;
        }
        return false;
    }

    public boolean hasOnlyBall() {
        if (ball > 0 && strike == 0) {
            return true;
        }
        return false;
    }

    public boolean hasOnlyStrike() {
        if (ball == 0 && strike > 0) {
            return true;
        }
        return false;
    }

    public boolean hasBallAndStrike() {
        if (ball > 0 && strike > 0) {
            return true;
        }
        return false;
    }

    private void checkHintFromSingleDigit(List<Integer> answerList, int seq) {
        if (answerList.get(seq) == numArray[seq]) {
            strike++;
            return;
        }

        for (int i = 0; i < answerList.size(); i++) {
            countBall(answerList.get(i), numArray[seq]);
        }
    }

    private void countBall(int answer, int tryNum) {
        if (answer == tryNum) {
            ball++;
        }
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }
}
