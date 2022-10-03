package baseball.model;

import baseball.common.PlayBaseStatus;

public class PlayResult {
    private final String answer;
    private final PlayBaseStatus status;

    private PlayResult(String answer, PlayBaseStatus status) {
        this.answer = answer;
        this.status = status;
    }

    /**
     * PlayResult creation method
     *
     * @param answer play result string
     * @param status play result status
     * @return new PlayResult
     */
    public static PlayResult valueOf(String answer, PlayBaseStatus status) {
        return new PlayResult(answer, status);
    }

    /**
     * Returns the answer variable.
     *
     * @return answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Returns the status variable.
     *
     * @return status
     */
    public PlayBaseStatus getStatus() {
        return status;
    }
}
