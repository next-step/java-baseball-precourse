package baseball.game;

import baseball.model.Board;
import camp.nextstep.edu.missionutils.Randoms;

public class Play {

    public void validInput(String input) {
        if (input.length() > 3) {
            throw new IllegalArgumentException("입력값은 3자리 숫자여야 합니다.");
        }
    }

    public void initGoal(Board board) {
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = Randoms.pickNumberInRange(1, 9);;
        }
        board.setGoal(arr);
    }
}
