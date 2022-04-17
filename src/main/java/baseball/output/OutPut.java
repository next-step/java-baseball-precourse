package baseball.output;

public class OutPut {

    private final String gameMessage = "숫자를 입력해주세요 : ";
    private final String restartMessage = "재시작 하시겠습니까? (y/n)";

    public String getGameMessage() {
        return this.gameMessage;
    }

    public String getRestartMessage() {
        return restartMessage;
    }
}
