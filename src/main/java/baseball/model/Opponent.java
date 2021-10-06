package baseball.model;

import baseball.comm.Constant;
import nextstep.utils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class Opponent {

    private static final Opponent OPPONENT = new Opponent();

    private Opponent() {}

    public static Opponent getInstance() {
        return OPPONENT;
    }

    public String makeNumber(){
        StringBuilder resultNumber = new StringBuilder();
        Set<Integer> makeNumberSet = new HashSet<>();
        while (makeNumberSet.size() < Constant.NUM_SIZE) {
            makeNumberSet.add(Randoms.pickNumberInRange(1, 9));
        }
        for (Integer number : makeNumberSet) {
            resultNumber.append(number);
        }
        return resultNumber.toString();
    }

}
