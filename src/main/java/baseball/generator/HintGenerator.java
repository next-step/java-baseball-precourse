package baseball.generator;

import baseball.message.Number;
import baseball.message.hint.HintMessage;

import java.util.List;

public class HintGenerator {

    private int strike;
    private int ball;

    public HintGenerator(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }


    /**
     * 스트라이크인지 볼인지 체크
     * @return
     */

    public static HintGenerator getHint(List<Integer> input, List<Integer> answer) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (answer.contains(input.get(i))) {
                ball++;
            }
            if (answer.get(i).equals(input.get(i))) {
                ball--;
                strike++;
            }
        }
        return HintGenerator.of(strike, ball);
    }

    /**
     * 스트라이크인지 볼인지 정답인지 알려주기
     * @return
     */
    public boolean printHint() {
        if (strike == Number.MAX_COUNT) {
            System.out.println(HintMessage.OnlyStrike(strike));
            System.out.println(HintMessage.ANSWER);
            return true;
        }
        if (strike == Number.MIN_COUNT && ball == Number.MIN_COUNT) {
            System.out.println(HintMessage.NOTHING);
            return false;
        }
        if (strike != Number.MIN_COUNT && ball == Number.MIN_COUNT) {
            System.out.println(HintMessage.OnlyStrike(strike));
            return false;
        }
        if (strike == Number.MIN_COUNT) {
            System.out.println(HintMessage.OnlyBall(ball));
            return false;
        }
        System.out.println(HintMessage.StrikeAndBall(strike, ball));
        return false;
    }


    public static HintGenerator of(int strike, int ball) {
        return new HintGenerator(strike, ball);
    }


}