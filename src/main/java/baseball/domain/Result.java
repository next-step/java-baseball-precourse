package baseball.domain;

public class Result {
    private final String resultMessage;
    public boolean isOver;

    public Result(int strike, int ball, String resultMessage) {
        this.resultMessage = resultMessage;
        this.isOver = strike == Baseball.VALID_BASEBALL_LENGTH;
    }

    public String getResultMessage() {
        return resultMessage;
    }
}