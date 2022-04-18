package baseball.model;

import baseball.common.Constants;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class AnswerRandomNumberGenerator {
    String answerRandomNumbers;

    public String generateAnswerRandomNumbers() {
        ArrayList<String> answerRandomNumbers = new ArrayList<String>();

        while (answerRandomNumbers.size() < Constants.USER_NUMBER_LENGTH) {
            addValidAnswerRandomNumber(getAnswerRandomNumber(), answerRandomNumbers);
        }
        this.answerRandomNumbers = String.join("", answerRandomNumbers);
        return this.answerRandomNumbers;
    }

    public void addValidAnswerRandomNumber(String randomNumber, ArrayList<String> answerRandomNumbers) {
        if (!answerRandomNumbers.contains(randomNumber)) {
            answerRandomNumbers.add(randomNumber);
        }
    }

    public String getAnswerRandomNumber() {
        return Integer.toString(Randoms.pickNumberInRange(Constants.ANSWER_RANGE_MIN_RANDOM_NUM, Constants.ANSWER_RANGE_MAX_RANDOM_NUM));
    }
}
