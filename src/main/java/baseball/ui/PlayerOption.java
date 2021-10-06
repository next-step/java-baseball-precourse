package baseball.ui;

public class PlayerOption {

    private static final String CONTINUE = "1";
    private static final String EXIT = "2";

    private final String value;

    public PlayerOption(final String value) {
        validate(value);
        this.value = value;
    }

    private void validate(final String value) {
        if (!value.equals(CONTINUE) && !value.equals(EXIT)) {
            throw new IllegalArgumentException("[ERROR] 1 또는 2 중 하나의 옵션을 선택해주세요.");
        }
    }

    public boolean isContinue() {
        return this.value.equals(CONTINUE);
    }
}
