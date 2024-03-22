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
                // TODO
                throw new RuntimeException("");
        }
    }

    public int getValue() {
        return value;
    }

}
