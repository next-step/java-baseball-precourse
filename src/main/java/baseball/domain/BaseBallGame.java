package baseball.domain;

import baseball.Constants.GameStatus;

import java.util.List;

public class BaseBallGame {
    private final List<Integer> targetNumberList;

    private GameStatus gameStatus;

    public BaseBallGame(List<Integer> targetNumberList){
        this.targetNumberList = targetNumberList;
        gameStatus = GameStatus.START;
    }

    public List<Integer> getTargetNumberList() {
        return targetNumberList;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
}
