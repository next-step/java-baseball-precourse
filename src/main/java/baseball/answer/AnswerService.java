package baseball.answer;

import java.util.List;

public class AnswerService {

    private List<Integer> gameAnswer;

    public AnswerService(List<Integer> gameAnswer) {
        this.gameAnswer = gameAnswer;
    }

    public void resetGameAnswer(List<Integer> gameAnswer) {
        this.gameAnswer = gameAnswer;
    }

    public Answer result(List<Integer> input) {
        return makeCall(input);
    }

    private Answer makeCall(List<Integer> input) {
        Answer answer = new Answer();
        for (int i = 0; i < input.size(); i++) {
            calculateStrikesAndBalls(input, answer, i);
        }
        return answer;
    }

    private void calculateStrikesAndBalls(List<Integer> input, Answer answer, int index) {
        Integer gameAnswerDigit = gameAnswer.get(index);
        Integer inputDigit = input.get(index);
        if(gameAnswerDigit.equals(inputDigit)) {
            answer.addStrike();
            return;
        }
        if(gameAnswer.contains(inputDigit)) {
            answer.addBall();
        }
    }
}
