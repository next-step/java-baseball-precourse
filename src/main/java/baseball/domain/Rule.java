package baseball.domain;

public enum Rule {

    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private String name;

    Rule(String name) {
        this.name = name;
    }

    public String getText(int count) {
        return count + this.name;
    }

    public String getName() {
        return name;
    }
}
