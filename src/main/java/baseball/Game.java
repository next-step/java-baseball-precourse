package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private final ComputerBalls computerBalls;

    Game() {
        computerBalls = new ComputerBalls();
    }

    public void play() {
        String moreGame;
        do {
            moreGame = playAGame();
        }while(moreGame.equals("1"));

        GameMessages.displayGameEnded();
    }

    private String playAGame() {
        int strikes = 0;
        int balls;

        computerBalls.setBalls();
        while(!isGameEnd(strikes)) {
            GameMessages.displayWaitInput();
            String playerBalls = readPlayerInput();

            strikes = CompareBalls.countStrikes(computerBalls.getBalls(), playerBalls);
            balls = CompareBalls.countBalls(computerBalls.getBalls(), playerBalls);

            GameMessages.displayCompareResult(strikes, balls);
        }

        GameMessages.displayAnswerIsCorrect();

        return playMore();
    }

    private String readPlayerInput() {
        String input = Console.readLine();
        validateBalls(input);
        return input;
    }

    private void validateBalls(String balls) throws IllegalArgumentException {
        if(!BallValidator.isValidBalls(balls))
            throw new IllegalArgumentException("올바르지 않은 값을 입력했습니다.");
    }

    private String playMore() {
        GameMessages.displayNeedMoreGame();
        return Console.readLine();
    }

    private boolean isGameEnd(int strikes) {
        return strikes == GameConstants.numberOfBalls;
    }
}
