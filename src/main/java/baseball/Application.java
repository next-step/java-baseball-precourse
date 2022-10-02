package baseball;

import baseball.game.Game;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final int RESTART_GAME = 1;
    private static final int END_GAME = 2;
    private static final String MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        Game game = new Game();
        game.startGame();
        int restartNum = restartGame();
        if (restartNum == RESTART_GAME) {
            start();
        }
        if (restartNum == END_GAME){
            System.out.println("게임 종료");
        }
    }

    private static int restartGame() {
        System.out.println(MESSAGE);
        String restartGame = Console.readLine();
        int gameStart = inputToNumber(restartGame);
        validCorrectInput(gameStart);
        return gameStart;
    }

    private static int inputToNumber(String restartGame) {
        try {
            return Integer.parseInt(restartGame);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MESSAGE);
        }
    }

    private static void validCorrectInput(int restartGame) {
        if (restartGame != RESTART_GAME && restartGame != END_GAME) {
            throw new IllegalArgumentException(MESSAGE);
        }
    }
}