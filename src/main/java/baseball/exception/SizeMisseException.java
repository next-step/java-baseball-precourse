package baseball.exception;

public class SizeMisseException extends IllegalArgumentException{
        private static final String SIZE_MISS = "3개의 숫자를 입력해야 합니다.";

        public SizeMisseException() {
                super(SIZE_MISS);
        }
}