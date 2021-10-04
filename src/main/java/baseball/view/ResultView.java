package baseball.view;

import baseball.AnswerResult;

public class ResultView {

    private static final String NOTHING_RESULT = "낫싱";

    private static final String STRIKE_RESULT = "스트라이크";

    private static final String BALL_RESULT = "볼";

    public static void answerResult(AnswerResult answerResult) {
        if (answerResult.getBallCount() == 0 && answerResult.getStrikeCount() == 0) {
            System.out.println(NOTHING_RESULT);
            return;
        }
        if (answerResult.getBallCount() == 0 && answerResult.getStrikeCount() != 0) {
            System.out.println(answerResult.getStrikeCount() + STRIKE_RESULT);
            return;
        }
        if (answerResult.getBallCount() != 0 && answerResult.getStrikeCount() == 0) {
            System.out.println(answerResult.getBallCount() + BALL_RESULT);
            return;
        }
        System.out.println(answerResult.getStrikeCount() + STRIKE_RESULT + " " + answerResult.getBallCount() + BALL_RESULT);

    }
}
