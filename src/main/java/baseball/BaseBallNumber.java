package baseball;

public class BaseBallNumber {

    private BaseBallAnswer baseBallAnswer;

    public BaseBallNumber(int number) {
        baseBallAnswer = new BaseBallAnswer(number);
    }

    public BaseBallNumber() {
        baseBallAnswer = new BaseBallAnswer();
    }

    public AnswerResult makeAnswerResult(int userAnswer) {
        AnswerResult answerResult = baseBallAnswer.makeAnswerResult(userAnswer);
        return answerResult;
    }

}
