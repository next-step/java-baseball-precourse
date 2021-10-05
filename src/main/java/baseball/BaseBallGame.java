package baseball;

import view.InputView;
import view.ResultView;

public class BaseBallGame {


    private static PlayResult playResult;
    private static Balls computerBalls = Balls.of();

    public static void playBallsBallGame() {
        executeBaseBall();
    }

    public static void executeBaseBall() {
        while (true) {
            String playerBall = InputView.insertBallNumbers();
            try {
                playResult = computerBalls.playBalls(Balls.playerBallInit(playerBall));
                if (playResult.strikeCount() == 3) {
                    selectGamePlay();
                    break;
                }
                ResultView.printResult(playResult);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
    }

    private static void selectGamePlay() {
        ResultView.printThreeStrike();
        ResultView.answerContinuePlay();
        if (InputView.insertSelectGameContinue() == 1) {
            computerBalls = Balls.of();
            executeBaseBall();
        }
    }
}
