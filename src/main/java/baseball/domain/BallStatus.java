package baseball.domain;

public enum BallStatus {
    BALL("볼 "),
    NOTHING("낫싱"),
    STRIKE("스트라이크 ");

    private String status;

    BallStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
