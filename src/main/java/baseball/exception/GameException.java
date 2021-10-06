package baseball.exception;

public class GameException extends IllegalArgumentException {
    public GameException(String s) {
        super(s);
    }
}
