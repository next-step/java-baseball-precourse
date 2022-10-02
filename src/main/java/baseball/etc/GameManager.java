package baseball.etc;

import baseball.domain.Balls;
import baseball.domain.PlayResult;

public class GameManager {
    public static int MIN_BALL_NUM = 1;
    public static int MAX_BALL_NUM = 9;
    public static int BALLS_SIZE = 3;
    public static final int GAME_START_FLAG = 1;
    public static final int GAME_OVER_FLAG = 2;

    public static void run() {
        do {
            start();
        } while (isNotFinish());
    }

    public static void start() {
        Balls computerBalls = Balls.of(RandomBallNumberGenerator.generate());
        PlayResult result;
        do {
            Balls userBalls = Balls.of(InputView.inputBallNumbers());
            result = computerBalls.inning(userBalls);
            ResultView.printPlayResult(result);
        } while (result.isNotGameOver());
    }

    private static boolean isNotFinish() {
        return InputView.inputGameOverFlag() != GAME_OVER_FLAG;
    }
}
