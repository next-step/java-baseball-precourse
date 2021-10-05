package baseball.exceptions;

public class InvalidInputLengthException extends RuntimeException{
    public InvalidInputLengthException() {
        super("3자리 값을 입력해주세요");
    }
}
