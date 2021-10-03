package baseball.service;
import baseball.util.Constant;
import java.util.LinkedHashSet;
import java.util.Set;

public class Opponent {
    private static final Opponent OPPONENT = new Opponent();

    private Opponent(){}

    public static Opponent getOpponent() {
        return OPPONENT;
    }

    // 난수로 숫자 생성
    public String makeNumber() {
        StringBuilder number = new StringBuilder();
        Set<Integer> numSet = new LinkedHashSet<>();
        while (numSet.size() < Constant.NUMBER_SIZE) {
            numSet.add(nextstep.utils.Randoms.pickNumberInRange(1, 9));
        }

        for (int num : numSet) {
            number.append(num);
        }

        return number.toString();
    }
}
