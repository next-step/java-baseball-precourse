package baseball.message.hint;

import baseball.message.text.TextMessage;

public class HintMessage {

    public static final String ANSWER = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";
    public static final String NOTHING = "낫싱";


    public static String OnlyStrike(int strike) {
        return strike + TextMessage.STRIKE;
    }

    public static String OnlyBall(int ball) {
        return ball + TextMessage.BALL;
    }

    public static String StrikeAndBall(int strike, int ball) {
        return strike + TextMessage.STRIKE + " " + ball + TextMessage.BALL;
    }
}