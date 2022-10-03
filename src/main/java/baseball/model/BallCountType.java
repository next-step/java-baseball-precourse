package baseball.model;

public enum BallCountType {

    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String typeName;

    BallCountType(String typeName) {
        this.typeName = typeName;
    }

    public String count(int countNumber) {
        return String.format("%d%s", countNumber, typeName);
    }

    @Override
    public String toString() {
        return typeName;
    }
}
