package baseball.domain;

import baseball.common.Const;

public class ResultMessage {
    public static void printResult(int strikeCount, int ballCount) {
        String resultMessage = "";

        if(strikeCount != 0 ) {
            resultMessage += strikeCount + Const.STRIKE;
        }
        if(ballCount != 0) {
            resultMessage += ballCount + Const.BALL;
        }

        if(resultMessage.equals("")) {
            resultMessage += Const.NOTHING;
        }
        System.out.println(resultMessage);
    }

    public static void printWinningMessage() {
        System.out.println(Const.WINNING_MESSAGE);
    }
}
