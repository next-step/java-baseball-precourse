package baseball.answer;

public enum AnswerErrorEnum {
    SUM_OVER_THREE("스트라이크와 볼의 합은 3을 넘을 수 없습니다.");

    private final String value;

    AnswerErrorEnum(String value) {
        this.value = value;
    }

    public String text() {
        return this.value;
    }
}
