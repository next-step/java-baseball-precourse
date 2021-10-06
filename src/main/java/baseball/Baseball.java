package baseball;

import baseball.ball.Ball;
import baseball.service.BaseballService;

/**
 * @author KingCjy
 */
public class Baseball {

    private static final BaseballService baseballService = new BaseballService();

    private Baseball() {

    }

    public static void start() {
        initGame();
    }

    private static void initGame() {
        Ball computerBall = baseballService.generateBall();
        System.out.println(computerBall);
    }
}
