package baseball;

import baseball.console.GameResultPrint;
import baseball.console.UserInputPrompt;
import baseball.domain.GameBall;
import baseball.domain.GameBallGenerator;
import baseball.domain.GameResult;


public class Application {
    public static void main(String[] args) {
        // 숫자 야구 게임 구현
        GameBall computerGameBalls = getNewGameBalls();
        gameModeStart(computerGameBalls, false);
    }

    public static void gameModeStart(GameBall computerGameBalls, boolean isGameOver) {
        try {
            do {
                computerGameBalls = isGameOver ? getNewGameBalls() : computerGameBalls;
                System.out.println("[빠른실행검증을 위한 HINT] computerGameBalls = " + computerGameBalls);
                isGameOver = gameStart(computerGameBalls);
            } while (!isBreakGame(isGameOver));
        } catch (Exception e) {
            System.out.println("[ERROR]"+e.getLocalizedMessage());
            gameModeStart(computerGameBalls, false);
        }
    }

    public static boolean gameStart(GameBall computerGameBalls) {
        String userInputValue = UserInputPrompt.getUserInputValue();
        GameBall userInputGameBalls = new GameBall(GameBallGenerator.generateBaseballNums(userInputValue));
        GameResult gameResult = computerGameBalls.playball(userInputGameBalls);
        GameResultPrint.printResult(gameResult);

        return gameResult.isGameOver();
    }

    public static boolean isBreakGame(boolean isGameOver) {
        if (isGameOver) {
            String userSelectGameMode = UserInputPrompt.getUserSelectGameMode();
            return !(Integer.parseInt(userSelectGameMode.trim()) == 1);
        }
        return false;
    }

    public static GameBall getNewGameBalls() {
        return new GameBall(GameBallGenerator.generateBaseballNums());
    }
}