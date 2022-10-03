package baseball.model;

import baseball.common.Validator;

/**
 * A data model dedicated to responding to whether the user proceeds with further gameplay
 */
public class UserPlayRequest implements Validator {

    private final String answer;

    private UserPlayRequest(String answer) {
        this.answer = answer;
    }

    /**
     * UserPlayRequest creation method
     *
     * @param answer the user's input string
     * @return new UserPlayRequest
     */
    public static UserPlayRequest valueOf(String answer) {
        return new UserPlayRequest(answer);
    }

    @Override
    public boolean isValidNumber() {
        try {
            int parseInt = Integer.parseInt(answer);
            return parseInt == 1;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

}
