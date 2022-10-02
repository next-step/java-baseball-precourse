package baseball.message;

public enum PrintMessage {
    ASK_THE_USER_TO_ENTER_A_NUMBER("숫자를 입력해주세요 : "),
    ASK_THE_USER_TO_ENTER_EXIST_FLAG("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    GOT_ALL_THREE_NUMBERS_RIGHT("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

    public final String message;

    PrintMessage(String message) {
        this.message = message;
    }
}
