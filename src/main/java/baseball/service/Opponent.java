package baseball.service;
import baseball.util.Constant;
import java.util.HashSet;
import java.util.Set;

public class Opponent {
    private static final Opponent OPPONENT = new Opponent();

    private Opponent(){}

    public static Opponent getOpponent() {
        return OPPONENT;
    }

    // 난수로 숫자 생성
    public String makeNumber() {
        String number = "";

        Set<Integer> numSet = new HashSet<>();
        while (numSet.size() < Constant.NUMBER_SIZE) {
            numSet.add(nextstep.utils.Randoms.pickNumberInRange(1, 9));
        }

        for (Integer num : numSet) {
            number += num.toString();
        }

        return number;
    }
}
