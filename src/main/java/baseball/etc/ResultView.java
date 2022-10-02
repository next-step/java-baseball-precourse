package baseball.etc;

import baseball.domain.BallStatus;
import baseball.domain.PlayResult;

public class ResultView {
    public static void printPlayResult(final PlayResult result) {
        String printString = createBallString(result) +
                createStrikeString(result) +
                createNothingString(result);
        System.out.println(printString.trim());
        gameOver(result);
    }

    private static String createBallString(final PlayResult result) {
        if (result.isNotEmptyBall()) {
            return result.getBall() + BallStatus.BALL.getDescription() + " ";
        }
        return "";
    }

    private static String createStrikeString(final PlayResult result) {
        if (result.isNotEmptyStrike()) {
            return result.getStrike() + BallStatus.STRIKE.getDescription() + " ";
        }
        return "";
    }

    private static String createNothingString(final PlayResult result) {
        if (result.isNothing()) {
            return BallStatus.NOTHING.getDescription();
        }
        return "";
    }

    private static void gameOver(final PlayResult result) {
        if (result.isGameOver()) {
            System.out.println(GameManager.BALLS_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}
