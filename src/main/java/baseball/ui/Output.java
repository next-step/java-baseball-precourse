package baseball.ui;

public class Output {
    private static final String REQUEST_NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";
    public static final String GAME_ASK_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String PLAY_AGAIN_WRONG_INPUT_MESSAGE = "잘못된 입력입니다. 1 또는 2를 입력해주세요.";

    public static void printRequestNumberMessage() {
        System.out.print(REQUEST_NUMBER_INPUT_MESSAGE);
    }
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printExceptionMessage(String exceptionMessage) {
        System.out.println("[ERROR] " + exceptionMessage);
    }
}
