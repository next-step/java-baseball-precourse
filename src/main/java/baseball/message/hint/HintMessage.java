package baseball.message.hint;

public class HintMessage {

    public static final String ANSWER = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";
    public static final String NOTHING = "낫싱";


    public static String OnlyStrike(int strike) {
        return String.format("%d스트라이크", strike);
    }

    public static String OnlyBall(int ball) {
        return String.format("%d볼", ball);
    }

    public static String StrikeAndBall(int strike, int ball) {
        return String.format("%d스트라이크 %d볼", strike, ball);
    }
}