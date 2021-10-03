package baseball.exception;

public class BaseballInputException extends RuntimeException {

    public BaseballInputException(String errorMsg){
        super(errorMsg);
    }
}
