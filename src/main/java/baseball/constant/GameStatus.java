package baseball.constant;

import java.util.LinkedList;
import java.util.List;

public enum GameStatus {
    START(1), END(2);

    private final int status;

    GameStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public static List<Integer> getStatusList() {
        List<Integer> statusList = new LinkedList<>();
        for (GameStatus gameStatus : GameStatus.values()) {
            statusList.add(gameStatus.status);
        }

        return statusList;
    }
}
