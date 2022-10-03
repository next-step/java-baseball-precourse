package baseball.domain.result;

public enum State {

    NOTHING("낫싱"), STRIKE("스트라이크"), BALL("볼");
    private String description;

    State(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public boolean isNothing() {
        return this == NOTHING;
    }
}
