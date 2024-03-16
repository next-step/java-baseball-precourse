package ui;

public enum NextGame {
    CONTINUE(1),
    END(2);

    private final int value;

    NextGame(int value) {
        this.value = value;
    }

    public static NextGame of(int value) {
        switch (value) {
            case 1: return CONTINUE;
            case 2: return END;
            default:
                // TODO
                throw new RuntimeException("");
        }
    }

    public int getValue() {
        return value;
    }

}
