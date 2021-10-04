package baseball.model.enums;

public enum BallStatus {
    NONE, BALL, STRIKE;

    /**
     * 한번이라도 BALL 이나 STRIKE 를 만나면 그 상태를 유지하기 위한 메소드
     *
     * @param newStatus 비교하려는 대상
     * @return          newStatus 가 NONE 이 아닌 경우에만 반환
     */
    public BallStatus replaceIfNotNone(BallStatus newStatus) {
        if (newStatus.isNone()) {
            return this;
        }

        return newStatus;
    }

    public boolean isNone() {
        return this == NONE;
    }
}
