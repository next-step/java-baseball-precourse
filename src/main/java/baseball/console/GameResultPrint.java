package baseball.console;

import baseball.domain.GameResult;

public class GameResultPrint {
    private static final int STRIKE_OUT = 3;
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "나싱";
    private static final String END_MESSAGE = STRIKE_OUT+"개의 숫자를 모두 맞히셨습니다.게임 끝";

    public static void printResult(GameResult gameResult) {
        StringBuffer printResult = new StringBuffer();

        if (gameResult.getStrikeCnt() > 0) {
            printResult.append(gameResult.getStrikeCnt());
            printResult.append(STRIKE_MESSAGE);
        }

        if (gameResult.getBallCnt() > 0) {
            printResult.append(gameResult.getBallCnt());
            printResult.append(BALL_MESSAGE);
        }

        if (gameResult.getStrikeCnt() == 0 && gameResult.getBallCnt() == 0) {
            printResult.append(NOTHING_MESSAGE);
        }

        System.out.println(printResult.toString());

        if (gameResult.getStrikeCnt() == STRIKE_OUT) {
            System.out.println(END_MESSAGE);
        }
    }
}
