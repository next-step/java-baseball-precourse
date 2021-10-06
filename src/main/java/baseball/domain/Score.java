package baseball.domain;

public enum Score {
    BALL("볼"), STRIKE("스트라이크"), NOTHING("낫싱");

    private final String value;

    Score(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
