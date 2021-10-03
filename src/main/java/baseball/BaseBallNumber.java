package baseball;

public class BaseBallNumber {

    private BaseBallAnswer baseBallAnswer;

    public BaseBallNumber(int number) {
        baseBallAnswer = new BaseBallAnswer(number);
    }

    public BaseBallNumber() {
        baseBallAnswer = new BaseBallAnswer();
    }

    public boolean isCorrectAnswer(int userAnswer) {
        AnswerResult answerResult = baseBallAnswer.makeAnswerResult(userAnswer);
        System.out.println(answerResult);
        return answerResult.isCorrectAnswer();
    }

}
