package baseball;

import baseball.ball.Ball;
import baseball.ball.BallCount;
import baseball.input.InputService;
import baseball.service.BaseballService;

/**
 * @author KingCjy
 */
public class Baseball {

    private static final String GAME_FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다. 게임 끝";

    private static final BaseballService baseballService = new BaseballService();
    private static final InputService inputService = new InputService();

    private Baseball() {

    }

    public static void start() {
        boolean restart = true;

        while (restart) {
            initGame();
            restart = inputService.readRestartValue();
        }
    }

    private static void initGame() {
        Ball computerBall = baseballService.generateBall();
        BallCount ballCount = BallCount.NOTHING;

        while(!ballCount.isFinish()) {
            int[] input = inputService.readBallValue();
            ballCount = baseballService.judgementBall(computerBall, input);
            System.out.println(ballCount.getMessage());
        }

        System.out.println(GAME_FINISH_MESSAGE);
    }
}
