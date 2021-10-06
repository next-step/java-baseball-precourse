package baseball;

import baseball.ball.Ball;
import baseball.input.InputService;
import baseball.service.BaseballService;

/**
 * @author KingCjy
 */
public class Baseball {

    private static final BaseballService baseballService = new BaseballService();
    private static final InputService inputService = new InputService();

    private Baseball() {

    }

    public static void start() {
        initGame();
    }

    private static void initGame() {
        Ball computerBall = baseballService.generateBall();
        int[] input = inputService.readBallValue();
    }
}
