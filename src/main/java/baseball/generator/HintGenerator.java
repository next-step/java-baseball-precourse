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

    public void getHint() {
        for (int i = 0; i < 3; i++) {
            if (answer.contains(input.get(i))) {
                ball++;
            }
            if (answer.get(i).equals(input.get(i))) {
                ball--;
                strike++;
            }
        }
        printHint(strike, ball);
    }

    private void printHint(int strike, int ball) {
        if (strike == 3) {
            System.out.println(HintMessage.ANSWER);
            return;
        }
        if (strike == 0 && ball == 0) {
            System.out.println(HintMessage.NOTHING);
            return;
        }
        if (strike != 0 && ball == 0) {
            System.out.println(HintMessage.OnlyStrike(strike));
            return;
        }
        if (strike == 0) {
            System.out.println(HintMessage.OnlyBall(ball));
            return;
        }
        System.out.println(HintMessage.StrikeAndBall(strike, ball));

    }


    public static HintGenerator of(List<Integer> input, List<Integer> answer) {
        return new HintGenerator(input, answer);
    }


}