package baseball.domain;

import java.util.Objects;

public enum BaseballGameStatus {

    PLAYING("1"), ENDED("2"), ERROR("");

    private final String code;

    BaseballGameStatus(String code) {
        this.code = code;
    }

    public static BaseballGameStatus of(String code) {
        for (BaseballGameStatus gameStatus : values()) {
            if (Objects.equals(code, gameStatus.code)) return gameStatus;
        }
        return ERROR;
    }
}
