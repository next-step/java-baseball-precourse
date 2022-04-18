package baseball.service;

import baseball.comm.Constant;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class OpponentPlayer {
    private static final OpponentPlayer OPPONENT = new OpponentPlayer();
    private OpponentPlayer() {}
    public static OpponentPlayer getInstance() {
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
