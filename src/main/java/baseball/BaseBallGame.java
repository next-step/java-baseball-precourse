package baseball;

import view.InputView;
import view.ResultView;

import static view.InputView.insertSelectGameContinue;

public class BaseBallGame {


    private static Balls computerBalls = Balls.of();
    private static PlayResult playResult;


    public static void playBallsBallGame() {
        try {
            executeBaseBall();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            executeBaseBall();
        }
    }

    private static void executeBaseBall() {
        while (true) {
            playResult = computerBalls.playBalls(Balls.playerBallInit(InputView.insertBallNumbers()));
            if (playResult.strikeCount() == 3) {
                selectGamePlay(insertSelectGameContinue());
                break;
            }
            ResultView.printResult(playResult);
        }
    }

    private static void selectGamePlay(int inputGameContinue) {
        if (inputGameContinue == 1) {
            executeBaseBall();
        }
    }

}
