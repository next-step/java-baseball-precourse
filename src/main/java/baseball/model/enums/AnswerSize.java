package baseball.model.enums;

public enum AnswerSize {
    THREE(3),
    FOUR(4)
    ;

    private final int size;

    AnswerSize(int size) {
        this.size = size;
    }

    public int size() {
        return size;
    }
}
