package baseball.game;

import baseball.model.Board;
import camp.nextstep.edu.missionutils.Randoms;

public class Play {
    public Board initGoal(Board board) {
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = Randoms.pickNumberInRange(1, 9);;
        }
        board.setGoal(arr);

        return board;
    }
}
