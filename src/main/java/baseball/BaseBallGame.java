package baseball;

import view.InputView;
import view.ResultView;

public class BaseBallGame {


    private static Balls computerBalls = Balls.of(new RandomBaseBallGenerator());
    private static Boolean gameContinue = true;

    public static void playBallsBallGame() {
        while (gameContinue) {
            String playerBall = InputView.insertBallNumbers();
            playStart(playerBall);
        }
    }

    private static void playStart(String playerBall) {
        try {
            countHit(playerBall);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void countHit(String playerBall) {
        PlayResult playResult = computerBalls.playBalls(Balls.playerBallInit(playerBall));
        if (playResult.strikeCount() == 3) {
            selectGamePlay();
            return;
        }
        ResultView.printResult(playResult);
    }


    private static void selectGamePlay() {
        ResultView.answerContinuePlay();
        if (InputView.insertSelectGameContinue() == 1) {
            computerBalls = Balls.of(new RandomBaseBallGenerator());
            playBallsBallGame();
        }
        gameEnd();
    }

    private static void gameEnd() {
        gameContinue = false;
    }
}




