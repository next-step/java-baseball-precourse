package baseball;

import java.util.Arrays;

public class BaseBallNumber {

    private BaseBallAnswer baseBallAnswer;

    public BaseBallNumber() {
        baseBallAnswer = new BaseBallAnswer();
    }

    public boolean isCorrectAnswer(int userAnswer) {
        AnswerResult answerResult = baseBallAnswer.makeAnswerResult(userAnswer);
        System.out.println(answerResult);
        return answerResult.isCorrectAnswer();
    }


    public void printAnswer() {
        System.out.println(Arrays.toString(baseBallAnswer.getAnswer().toArray()));
    }
}
