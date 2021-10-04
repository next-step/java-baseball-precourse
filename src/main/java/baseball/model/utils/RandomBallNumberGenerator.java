package baseball.model.utils;

import baseball.model.enums.AnswerSize;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomBallNumberGenerator {
    private static final List<Integer> dummy = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    private static final int ZERO = 0;
    private static final int ONE  = 1;

    /**
     * 랜덤한 숫자를 가진 List 를 생성한다
     * 중복을 피하기 위해 랜덤한 숫자를 직접 만드는 대신 Index 를 만든 후 뽑는 방식
     *
     * @param answerSize  랜덤한 배열의 사이즈
     * @return      랜덤하게 만들어진 숫자 List
     */
    public static List<Integer> generate(AnswerSize answerSize) {
        List<Integer> candidate = new ArrayList<>(dummy);
        List<Integer> result = new ArrayList<>(answerSize.size());

        for (int i = ZERO; i < answerSize.size(); i++) {
            int randomIndex = Randoms.pickNumberInRange(ZERO, candidate.size() - ONE - i);
            int pickedNumber = candidate.remove(randomIndex);
            result.add(pickedNumber);
        }

        return result;
    }
}
