package baseball.output;

public class OutPut {
    private final String gameMessage;
    private final String restartMessage;
    private final String endMessage;

    public OutPut() {
        this.gameMessage = "숫자를 입력해주세요 : ";
        this.restartMessage = "재시작 하시겠습니까? (y/n)";
        this.endMessage = "게임 종료";
    }

    public String getGameMessage() {
        return this.gameMessage;
    }

    public String getRestartMessage() {
        return this.restartMessage;
    }

    public String getEndMessage() {
        return this.endMessage;
    }

    public String getHintMessage(int strike, int ball) {
        String result = "";
        if(strike == 0 && ball == 0) {
            return "낫싱";
        }
        if(ball > 0) {
            result = String.format("%d볼", ball);
        }
        if(ball>0 && strike>0) {
            result += " ";
        }
        if(strike > 0) {
            result += String.format("%d스트라이크", strike);
        }
        return result;
    }
}
