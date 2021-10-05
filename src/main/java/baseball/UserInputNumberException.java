package baseball;

public class UserInputNumberException extends RuntimeException {
    public static final UserInputNumberException ERR_INPUT_LENGTH = new UserInputNumberException(OutputView.MSG_INPUT_LENGTH);
    public static final UserInputNumberException ERR_DUPLICATE_VALUE = new UserInputNumberException(OutputView.MSG_DUPLICATE_VALUE);
    public static final UserInputNumberException ERR_NUMBER_VALIDATE = new UserInputNumberException(OutputView.MSG_NUMBER_VALIDATE);

    UserInputNumberException(String msg) {
        super(msg);

    }
}
