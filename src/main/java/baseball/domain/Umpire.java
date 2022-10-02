package baseball.domain;

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class Umpire {

    public static final String IS_STRIKE = "스트라이크 ";
    public static final String IS_BALL = "볼 ";
    public static final String IS_NOTHING = "낫싱";

    public String judge(LinkedHashSet<Integer> target, LinkedHashSet<Integer> player) {
        int strikeCount = 0;
        int ballCount = 0;

        LinkedList<Integer> answer = new LinkedList<>(target);
        LinkedList<Integer> input = new LinkedList<>(player);

        for (int index = 0; index < answer.size(); index++) {
            strikeCount = Judgement.getStrikeCount(strikeCount, answer, input, index);
            ballCount = Judgement.getBallCount(ballCount, answer, input, index);
        }

        return call(strikeCount, ballCount);
    }

    private String call(int strikeCount, int ballCount) {
        String isStrike = "";
        String isBall = "";

        if (strikeCount > 0) {
            isStrike = strikeCount + IS_STRIKE;
        }
        if (ballCount > 0) {
            isBall = ballCount + IS_BALL;
        }

        String result = "";
        if (strikeCount > 0 || ballCount > 0) {
            result = isBall + isStrike;
        }
        if (strikeCount == 0 && ballCount == 0) {
            result = IS_NOTHING;
        }
        return result;
    }

}
