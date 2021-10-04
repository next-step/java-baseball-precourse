package baseball.model.utils;

import baseball.model.enums.AnswerSize;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomBallNumberGenerator {
    private static final int START_INCLUSIVE  = 1;
    private static final int END_INCLUSIVE    = 9;

    /**
     * 랜덤한 숫자를 가진 List 를 생성한다
     * 중복을 피하기 위해 랜덤한 숫자를 직접 만드는 대신 Index 를 만든 후 뽑는 방식
     *
     * @param answerSize  랜덤한 배열의 사이즈
     * @return      랜덤하게 만들어진 숫자 List
     */
    public static List<Integer> generate(AnswerSize answerSize) {
        List<Integer> result = new ArrayList<>(answerSize.size());

        while (lessThanMaxSize(result, answerSize)) {
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            addIfNotContains(result, randomNumber);
        }

        return result;
    }

    private static boolean lessThanMaxSize(List<Integer> result, AnswerSize answerSize) {
        return result.size() < answerSize.size();
    }

    private static void addIfNotContains(List<Integer> result, int randomNumber) {
        if (!result.contains(randomNumber)) {
            result.add(randomNumber);
        }
    }
}
