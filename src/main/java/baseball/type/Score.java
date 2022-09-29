package baseball.type;

public enum Score {
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱");

    private final String name;

    Score(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
