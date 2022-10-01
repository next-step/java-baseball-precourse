package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;

public class Game {

    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 9;
    public static final int ANSWER_SIZE = 3;

    public LinkedHashSet<Integer> generateAnswer() {
        LinkedHashSet<Integer> answer = new LinkedHashSet<>();
        while (answer.size() < ANSWER_SIZE) {
            answer.add(Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
        }
        return answer;
    }

}
