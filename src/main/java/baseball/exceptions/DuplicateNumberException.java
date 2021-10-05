package baseball.exceptions;

public class DuplicateNumberException extends RuntimeException{
    public DuplicateNumberException(){
        super("중복된 숫자가 있습니다. 중복없이 입력해주세요");
    }
}
