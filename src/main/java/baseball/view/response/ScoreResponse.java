package baseball.view.response;

public class ScoreResponse {
    private final String message;

    public ScoreResponse(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
