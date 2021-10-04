package baseball.generator;

import baseball.message.hint.HintMessage;

import java.util.List;

public class HintGenerator {

    private int strike;
    private int ball;
    private final List<Integer> input;
    private final List<Integer> answer;

    public HintGenerator(List<Integer> input, List<Integer> answer) {
        this.input = input;
        this.answer = answer;
        this.strike = 0;
        this.ball = 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }


    /**
     * 스트라이크인지 볼인지 체크
     * @return
     */

    public boolean getHint() {
        for (int i = 0; i < 3; i++) {
            if (answer.contains(input.get(i))) {
                ball++;
            }
            if (answer.get(i).equals(input.get(i))) {
                ball--;
                strike++;
            }
        }
        return printHint(strike, ball);
    }

    /**
     * 스트라이크인지 볼인지 정답인지 알려주기
     * @param strike
     * @param ball
     * @return
     */
    private boolean printHint(int strike, int ball) {
        if (strike == 3) {
            System.out.println(HintMessage.OnlyStrike(strike));
            System.out.println(HintMessage.ANSWER);
            return true;
        }
        if (strike == 0 && ball == 0) {
            System.out.println(HintMessage.NOTHING);
            return false;
        }
        if (strike != 0 && ball == 0) {
            System.out.println(HintMessage.OnlyStrike(strike));
            return false;
        }
        if (strike == 0) {
            System.out.println(HintMessage.OnlyBall(ball));
            return false;
        }
        System.out.println(HintMessage.StrikeAndBall(strike, ball));
        return false;
    }


    public static HintGenerator of(List<Integer> input, List<Integer> answer) {
        return new HintGenerator(input, answer);
    }


}