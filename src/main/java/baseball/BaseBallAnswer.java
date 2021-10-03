package baseball;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseBallAnswer {

    private static final int ANSWER_SIZE = 3;

    private List<Integer> answer = new ArrayList<>();

    public BaseBallAnswer(int number) {
        String stringNumber = String.valueOf(number);
        char[] digits = stringNumber.toCharArray();
        for (char digit : digits) {
            answer.add(Integer.valueOf(digit) - '0');
        }
    }

    public BaseBallAnswer() {
        while (answer.size() != ANSWER_SIZE) {
            int number = Randoms.pickNumberInRange(1, 9);
            addNumber(number);
        }
    }

    private void addNumber(int number) {
        if (answer.contains(number)) {
            return;
        }
        answer.add(number);
    }

    public AnswerResult makeAnswerResult(int userAnswer) {
        AnswerResult answerResult = new AnswerResult();
        for (int i = 2; i >= 0; i--) {
            int userNumber = userAnswer % 10;
            checkAnswerResult(answerResult, answer.get(i), userNumber);
            userAnswer = userAnswer / 10;
        }
        return answerResult;
    }

    private void checkAnswerResult(AnswerResult answerResult, int answerNumber, int userNumber) {
        if (answerNumber == userNumber) {
            answerResult.addStrikeCount();
        }
        if (answerNumber != userNumber && answer.contains(userNumber)) {
            answerResult.addBallCount();
        }
    }

    public List<Integer> getAnswer() {
        return answer;
    }

}
