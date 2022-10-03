package baseball.controller;

import baseball.constant.GameStatus;
import baseball.model.Game;
import baseball.model.GameCounter;
import baseball.util.DataConverter;
import baseball.view.InputConsole;
import baseball.view.OutputConsole;

public class GameController {

    private static Game game;

    public static void initGame() {
        game = new Game();
    }

    public static void run() {
        initGame();
        do {
            String playerNumber = startGame();
            GameCounter counter = guessNumber(playerNumber);
            boolean isGameOver = checkGameOver(counter);
            checkRestart(isGameOver);
        } while (game.isRunning());
    }

    private static String startGame() {
        return InputConsole.readGameNumbers();
    }

    private static GameCounter guessNumber(String input) {
        GameCounter counter = game.play(input);
        OutputConsole.printNumberMatchesView(counter);
        return counter;
    }

    private static boolean checkGameOver(GameCounter counter) {
        if (game.isOver()) {
            OutputConsole.printWinView(counter);
            return true;
        }
        return false;
    }

    private static void checkRestart(boolean isGameOver) {
        if (!isGameOver) {
            return;
        }

        int restartNumber = DataConverter.stringToDigit(InputConsole.readRestartNumber());
        if (restartNumber == GameStatus.START.getStatus()) {
            game = new Game();
        }
    }
}