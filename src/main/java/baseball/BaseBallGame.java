package baseball;

import view.InputView;
import view.ResultView;

import java.util.List;

import static baseball.commonConstants.COMMON_THREE;

public class BaseBallGame {


    private Balls computerBalls;
    private Boolean gameContinue;
    private InputView inputView;
    private ResultView resultView;

    public BaseBallGame() {
        this.computerBalls = Balls.of(new RandomBaseBallGenerator());
        this.gameContinue = true;
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void playBallsBallGame() {
        while (gameContinue) {
            String playerBall = inputView.insertBallNumbers();
            playStart(playerBall);
        }
    }

    private void playStart(String playerBall) {
        try {
            countHit(Balls.playerBallInit(playerBall));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void countHit(List<Ball> playerBallNumber) {
        PlayResult playResult = computerBalls.playBalls(playerBallNumber);
        if (playResult.strikeCount() == COMMON_THREE) {
            selectGamePlay();
            return;
        }
        resultView.printResult(playResult);
    }


    private void selectGamePlay() {
        resultView.answerContinuePlay();
        if (inputView.insertSelectGameContinue() == 1) {
            computerBalls = Balls.of(new RandomBaseBallGenerator());
            playBallsBallGame();
        }
        gameEnd();
    }

    private void gameEnd() {
        gameContinue = false;
    }
}




