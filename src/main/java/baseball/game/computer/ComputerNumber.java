package baseball.game.computer;

import nextstep.utils.Randoms;

public class ComputerNumber {

    private int computerRandomNumber = pickNumberInRange();

    public int getComputerRandomNumber() {
        return computerRandomNumber;
    }

    private int pickNumberInRange() { //-> 예외 1) 중복 2) '0' 포함
        return Randoms.pickNumberInRange(100, 999);
    }

}
