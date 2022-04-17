package baseball.constants;

public enum BaseballGameCount {
    BALL("볼"), STRIKE("스트라이크"), NOTHING("낫싱");

    public String string;

    BaseballGameCount(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
