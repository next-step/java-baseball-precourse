package baseball.model;

import baseball.vo.CompareResultVO;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseballGameService {

    private final List<Integer> answerNumberList = new ArrayList<>();
    private static final int NUMBER_OF_DIGIT = 3;

    public void createAnswer() {
        answerNumberList.clear();

        for (int count = 0; count < NUMBER_OF_DIGIT; count++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            answerNumberList.add(randomNumber);
        }
    }

    public CompareResultVO compareInputToAnswer(String inputNumber, List<Integer> answerNumberList) {
        validateInputNumber(inputNumber);
        List<Integer> inputNumberList = parseStringToIntegerList(inputNumber);
        int ballCount = 0, strikeCount = 0;
        for (int i = 0; i < answerNumberList.size(); i++) {
            if (answerNumberList.get(i).intValue() == inputNumberList.get(i).intValue()) {
                strikeCount++;
                continue;
            }
            if (answerNumberList.contains(inputNumberList.get(i))) {
                ballCount++;
            }
        }
        return new CompareResultVO(ballCount, strikeCount);
    }

    private List<Integer> parseStringToIntegerList(String inputNumber) {
        int parseInput = Integer.parseInt(inputNumber);
        List<Integer> inputNumberList = new ArrayList<>();
        while (parseInput > 0) {
            int number = parseInput % 10;
            validateNonZero(number);
            parseInput = parseInput / 10;
            inputNumberList.add(number);
        }
        Collections.reverse(inputNumberList);
        return inputNumberList;
    }

    private void validateNonZero(int number) {
        if (number == 0) {
            throw new IllegalArgumentException("0은 사용할 수 없습니다.");
        }
    }

    private void validateInputNumber(String inputNumber) {
        try {
            int parseInput = Integer.parseInt(inputNumber);

            if (parseInput < 100 || parseInput > 999) {
                throw new IllegalArgumentException("3자리수가 아닙니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    public List<Integer> getAnswerNumberList() {
        return answerNumberList;
    }

}
