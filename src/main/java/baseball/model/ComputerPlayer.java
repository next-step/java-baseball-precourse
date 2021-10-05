package baseball.model;

public class ComputerPlayer {
    private AnswerNumbers answerNumbers;

    public ComputerPlayer(AnswerNumbers answerNumbers) {
        this.answerNumbers = answerNumbers;
    }

    public CheckResult checkAnswer(AnswerNumbers askAnswer) {
        return answerNumbers.checkAnswer(askAnswer);
    }
}
