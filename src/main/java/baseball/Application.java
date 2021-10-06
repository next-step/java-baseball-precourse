package baseball;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

import java.util.*;

public class Application {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 9;
    private static final int ANSWER_LENGTH = 3;
    private static final String USER_INPUT_REGEX = "^["+ MIN_RANGE + "-" + MAX_RANGE + "]" + "{" + ANSWER_LENGTH + "," + ANSWER_LENGTH + "}" + "$";

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        // 문제 생성 (문제 길이, 최소값, 최대값 설정)
        String answer = createAnswer();

    }


    /**
     * 문제 생성 메소드입니다.
     * @return 최소 최대 설정값 범위 내 중복되지 않는 숫자로 구성된 설정값 길이만큼의 문자열을 반환합니다.
     */
    private static String createAnswer() {
        Set<Integer> answerSet = new LinkedHashSet<>();
        while (answerSet.size() < ANSWER_LENGTH) {
            answerSet.add(Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE));
        }
        String answer = "";
        for (Integer integer : answerSet) {
            answer += integer;
        }
        return answer;
    }

}
