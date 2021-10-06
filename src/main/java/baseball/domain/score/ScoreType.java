package baseball.domain.score;

public enum ScoreType {
    STRIKE("스트라이크"), BALL("볼"), NOTHING("낫싱");

    private final String name;

    ScoreType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

