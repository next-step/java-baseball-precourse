package baseball.domain;

public enum Command {
    REPLAY(1), QUIT(2);
    private int value;

    Command(int value) {
        this.value = value;
    }

    public static Command of(int value) {
        if (REPLAY.value == value) return REPLAY;
        if (QUIT.value == value) return QUIT;
        throw new IllegalArgumentException("Please give correct command [1: replay | 2: quit]");
    }

    public boolean isReplay() {
        return this == REPLAY;
    }
}
