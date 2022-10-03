package baseball.model;

import baseball.common.Validator;

/**
 * A data model for the user's gameplay response
 */
public class UserAnswerRequest implements Validator {
    private final String answer;

    private UserAnswerRequest(String answer) {
        this.answer = answer;
    }

    /**
     * UserAnswerRequest creation method
     *
     * @param answer the user's input string
     * @return new UserAnswerRequest
     */
    public static UserAnswerRequest valueOf(String answer) {
        return new UserAnswerRequest(answer);
    }

    /**
     * Returns the answer variable.
     *
     * @return answer
     */
    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean isValidNumber() {
        try {
            Integer.parseInt(answer);
            if (answer.length() != 3) {
                return false;
            }
            return isCheckEachNumber();
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    /**
     * Check the user's input string one character at a time.
     *
     * @return check result
     */
    private boolean isCheckEachNumber() {
        for (int i = 0; i < 3; i++) {
            char c = answer.charAt(i);
            if (c > 57 || c < 49) {
                return false;
            }
        }
        return true;
    }
}
