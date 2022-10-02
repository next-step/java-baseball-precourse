package baseball.application.io;

public enum Flag {
    RESTART, STOP;

    public static Flag from(String number) {
        if (number.equals("1")) {
            return RESTART;
        }
        if (number.equals("2")) {
            return STOP;
        }
        throw new IllegalArgumentException("잘못된 입력입니다.");
    }

    public boolean isStop() {
        return this == STOP;
    }
}
