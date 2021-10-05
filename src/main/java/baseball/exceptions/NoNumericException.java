package baseball.exceptions;

public class NoNumericException extends RuntimeException{
    public NoNumericException(){
        super("1~9 사이의 숫자를 입력해주세요.");
    }
}
