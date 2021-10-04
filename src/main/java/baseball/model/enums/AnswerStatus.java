package baseball.model.enums;

public enum AnswerStatus {
    WRONG, RIGHT;

    public boolean isWrong() {
        return this == WRONG;
    }

    public boolean isRight() {
        return this == RIGHT;
    }
}
