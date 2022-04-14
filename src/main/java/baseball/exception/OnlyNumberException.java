package baseball.exception;

public class OnlyNumberException extends IllegalArgumentException{
        private static final String ONLY_NUMBER_MSG = "숫자만 입력해주시기 바랍니다.";

        public OnlyNumberException() {
                super(ONLY_NUMBER_MSG);
        }
}

