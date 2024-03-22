package ui;

public enum NextGame {
    Continue(1),
    End(2);

    private final int value;

    NextGame(int value) {
        this.value = value;
    }

    public static NextGame of(int value) {
        switch (value) {
            case 1: return Continue;
            case 2: return End;
            default:
                throw new IllegalArgumentException("NextGame 값은 1 or 2 만 가능합니다 (입력값: " + value + ")");
        }
    }

    public int getValue() {
        return value;
    }

}
