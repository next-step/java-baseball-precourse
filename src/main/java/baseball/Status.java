package baseball;

public enum Status {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    public final String statusName;

    Status(String statusName) {
        this.statusName = statusName;
    }

}
