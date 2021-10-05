package baseball;

import view.InputView;
import view.ResultView;

public class BaseBallGame {


    private static PlayResult playResult;
    private static Balls computerBalls = Balls.of();

    public static void playBallsBallGame() {
        try {
            executeBaseBall();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            executeBaseBall();
        }
    }

    public static void executeBaseBall() {
        while (true) {
            playResult = computerBalls.playBalls(Balls.playerBallInit(InputView.insertBallNumbers()));
            if (playResult.strikeCount() == 3) {
                selectGamePlay();
                break;
            }
            ResultView.printResult(playResult);
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
