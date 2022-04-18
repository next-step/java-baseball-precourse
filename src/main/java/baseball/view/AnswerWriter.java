package baseball.view;

import baseball.common.message.SystemMessage;
import baseball.model.ResponseHint;

public class AnswerWriter {
    public static void answer(ResponseHint responseHint) {
        answerIfHasBall(responseHint);
        answerIfHasStrike(responseHint);
        answerIfHasNothing(responseHint);
        answerIfGameEnd(responseHint);

        System.out.println();
    }

    private static void answerIfGameEnd(ResponseHint responseHint) {
        if (responseHint.isGameEndFlag()) {
            System.out.print(SystemMessage.GAME_END_MESSAGE);
        }
    }

    private static void answerIfHasNothing(ResponseHint responseHint) {
        if (responseHint.getStrike() == 0 && responseHint.getBall() == 0) {
            System.out.print(SystemMessage.NOTHING_MESSAGE + " ");
        }
    }

    private static void answerIfHasStrike(ResponseHint responseHint) {
        if (responseHint.getStrike() != 0) {
            System.out.print(responseHint.getStrike() + SystemMessage.STRIKE_MESSAGE + " ");
        }
    }

    private static void answerIfHasBall(ResponseHint responseHint) {
        if (responseHint.getBall() != 0) {
            System.out.print(responseHint.getBall() + SystemMessage.BALL_MESSAGE + " ");
        }
    }
}
