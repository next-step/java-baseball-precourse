package baseball.game;

public class Message {
    public static void printStartMessage() {
        final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
        print(INPUT_MESSAGE);
    }

    public static void printErrorMessage() {
        final String ERROR_MESSAGE = "[ERROR] 중복되지 않는 3자리 숫자만 입력 가능합니다.";
        println(ERROR_MESSAGE);
    }

    public static void printResultMessage(int strikeCount, int ballCount) {
        String message = makeMessage(strikeCount, ballCount);
        println(message);
    }

    private static String makeMessage(int strikeCount, int ballCount) {
        StringBuilder stringBuilder = new StringBuilder();
        if(strikeCount > 0) {
            stringBuilder.append(strikeCount).append("스트라이크");
        }
        if(strikeCount > 0 && ballCount > 0) {
            stringBuilder.append(" ");
        }
        if(ballCount > 0) {
            stringBuilder.append(ballCount).append("볼");
        }
        if(strikeCount == 0 && ballCount == 0) {
            stringBuilder.append("낫싱");
        }
        return stringBuilder.toString();
    }

    public static void printFinishMessage() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printKeyErrorMessage() {
        final String ERROR_MESSAGE = "[ERROR] 숫자 1,2만 입력가능합니다.";
        println(ERROR_MESSAGE);
    }

    private static void println(String message) {
        System.out.println(message);
    }

    private static void print(String message) {
        System.out.print(message);
    }
}
