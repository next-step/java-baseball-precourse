package baseball.domain;

public enum GameConfig {
    PICK_NUMBER_SIZE(3),
    MIN_NUMBER(1),
    MAX_NUMBER(9),
    ;

    private int value;

    GameConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
