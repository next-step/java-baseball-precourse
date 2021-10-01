package baseball;

import nextstep.utils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class BaseballGame {

    private final int[] answer;

    BaseballGame(int[] numbers) {
        answer = numbers;
    }

    static int[] generateGameAnswer() {
        // 1부터 9까지 서로 다른 수로 이루어진 3자리의 수 생성
        Set<Integer> numberSet = new HashSet<>();

        while(numberSet.size() < 3) numberSet.add(Randoms.pickNumberInRange(1, 9));

        return numberSet.stream().mapToInt(Integer::intValue).toArray();
    }

    public static boolean isFinished() {
        return false;
    }

    static boolean isValid(String input) {
        return false;
    }

    void grade(String input) {

    }

    static boolean nonMatch() {
        return false;
    }

    static boolean allMatch() {
        return false;
    }

    static int getStrikeCount() {
        return 0;
    }

    static int getBallCount() {
        return 0;
    }
}
