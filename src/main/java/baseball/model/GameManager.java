package baseball.model;

import baseball.common.Constants;

public class GameManager {
    private String gameStatusNumber;

    public GameManager(String gameStatusNumber) {
        this.gameStatusNumber = gameStatusNumber;
    }

    public String getGameStatusNumber() {
        return gameStatusNumber;
    }

    public void setGameStatusNumber(String gameStatusNumber) {
        this.gameStatusNumber = gameStatusNumber;
    }

    public void validCheckGameStatusNumber(String gameStatusNumber) {
        if (!gameStatusNumber.equals(Constants.GAME_STATUS_END_NUMBER) && !gameStatusNumber.equals(Constants.GAME_STATUS_RESTART_NUMBER)) {
            throw new IllegalArgumentException();
        }
    }
}
