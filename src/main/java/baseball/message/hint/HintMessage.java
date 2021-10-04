package baseball.message.hint;

public class HintMessage {

    public static final String ANSWER = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";
    public static final String NOTHING = "낫싱";

    private int strike;
    private int ball;

    public HintMessage(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static String OnlyStrike(int strike) {
        return String.format("%d 스트라이크", strike);
    }

    public static String OnlyBall(int ball) {
        return String.format("%d 볼", ball);
    }

    public static String StrikeAndBall(int strike, int ball) {
        return String.format("%d 스트라이크 %d 볼", strike, ball);
    }
}