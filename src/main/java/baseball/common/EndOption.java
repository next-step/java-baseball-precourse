package baseball.common;

public enum EndOption {
    RESTART(1),
    EXIT(2);

    private int value;

    EndOption(int value) {
        this.value = value;
    }

    public boolean isEqualValue(int input) {
        return this.value == input;
    }
}
