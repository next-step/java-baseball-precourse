package baseball.output;
import static baseball.output.OutPutEnum.*;


public class OutPut {
    public String getGameMessage() {
        return GAME_MESSAGE.text();
    }

    public String getRestartMessage() {
        return RESTART_MESSAGE.text();
    }

    public String getEndMessage() {
        return END_MESSAGE.text();
    }

    public String getHintMessage(int strike, int ball) {
        String result = "";
        if(strike == 0 && ball == 0) {
            return NOTHING.text();
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
