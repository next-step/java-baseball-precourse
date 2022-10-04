package baseball;

public enum Message {

    INPUT("숫자를 입력해주세요"),

    GAME_INFO("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요"),

    GAME_WIN("3개의 숫자를 모두 맞히셨습니다!"),

    GAME_STOP("게임 종료");

    final String message;

    Message(String message) {
        this.message = message;
    }

}
