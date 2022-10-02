package baseball.view;

import baseball.dto.BaseballGameResultDto;

public class OutputView {

    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOT_MATCH = "낫싱";

    public static void printGameResult(BaseballGameResultDto gameResult) {
        if (gameResult.isFinishGame()) {
            System.out.println(gameResult.getStrike() + STRIKE);
            System.out.println(gameResult.getStrike() + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }
        isPlayingGame(gameResult);
    }

    private static void isPlayingGame(BaseballGameResultDto gameResult) {
        if (isNotMatch(gameResult)) {
            return;
        }
        if (isStrike(gameResult)) {
            return;
        }
        if (isBall(gameResult)) {
            return;
        }
        System.out.println(gameResult.getBall() + BALL + " " + gameResult.getStrike() + STRIKE);
    }

    private static boolean isNotMatch(BaseballGameResultDto gameResult) {
        if (isNoneStrike(gameResult) && isNoneBall(gameResult)) {
            System.out.println(NOT_MATCH);
            return true;
        }
        return false;
    }

    private static boolean isStrike(BaseballGameResultDto gameResult) {
        if (isNoneBall(gameResult)) {
            System.out.println(gameResult.getStrike() + STRIKE);
            return true;
        }
        return false;
    }

    private static boolean isBall(BaseballGameResultDto gameResult) {
        if (isNoneStrike(gameResult)) {
            System.out.println(gameResult.getBall() + BALL);
            return true;
        }
        return false;
    }

    private static boolean isNoneStrike(BaseballGameResultDto gameResult) {
        return gameResult.getStrike() == 0;
    }

    private static boolean isNoneBall(BaseballGameResultDto gameResult) {
        return gameResult.getBall() == 0;
    }
}
