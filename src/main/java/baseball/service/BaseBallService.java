package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseBallService {
    private static final int count = 3;
    private boolean isDoing;

    public void doGame() {
        isDoing = true;

        // 랜덤 값 추출
        int randomNumber = Randoms.pickNumberInRange(1, 9);

        while (isDoing) {

        }
    }

}
