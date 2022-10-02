package baseball.domain;

import baseball.exception.BaseballGameException;

import java.util.HashMap;
import java.util.Map;

public enum GameState {

    PROGRESS("1"),
    END("2"),
    ;

    private static final Map<String, GameState> gameStates = new HashMap<>();
    static {
        for (GameState gameState : values()) {
            gameStates.put(gameState.state, gameState);
        }
    }
    private final String state;

    GameState(String state) {
        this.state = state;
    }

    public boolean isGameProgress() {
        return this == PROGRESS;
    }

    public static GameState getGameState(String state) {
        GameState gameState = gameStates.get(state);
        if (gameState == null) {
            throw new BaseballGameException("게임 상태를 잘못 입력하셨습니다.");
        }
        return gameState;
    }
}
