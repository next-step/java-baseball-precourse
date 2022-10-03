package baseball.view;

public enum PrintMessage {

    QUESTION_CONTINUE("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요."),
    QUESTION_BASEBALL_NUMBERS("숫자를 입력해주세요 : "),
    INFORMATION_ANSWER("%d개의 숫자를 모두 맞히셨습니다! "),
    INFORMATION_QUIT("게임 종료");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    } 

    public String getMessage() {
        return message;
    }

    public String getMessage(Object... values) {
        return String.format(message, values);
    }
}
