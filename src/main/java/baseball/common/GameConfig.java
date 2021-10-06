package baseball.common;

public enum GameConfig {
    RULE_NUMBER_DIGIT(3),
    RULE_NUMBER_MIN(1),
    RULE_NUMBER_MAX(9);

    private final int number;

    GameConfig(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
