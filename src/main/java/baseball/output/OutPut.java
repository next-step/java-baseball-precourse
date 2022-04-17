package baseball.output;

public class OutPut {
    private final String gameMessage;
    private final String restartMessage;

    public OutPut() {
        this.gameMessage = "숫자를 입력해주세요 : ";
        this.restartMessage = "재시작 하시겠습니까? (y/n)";
    }

    public String getGameMessage() {
        return this.gameMessage;
    }

    public String getRestartMessage() {
        return restartMessage;
    }

    public String getHintMessage(int strike, int ball) {
        if(strike == 0 && ball == 0) {
            return "낫싱";
        }
        return String.format("%d 스트라이크 %d 볼", strike, ball);
    }
}
