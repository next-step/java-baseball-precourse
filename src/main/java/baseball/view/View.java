package baseball.view;

import baseball.model.GameState;
import camp.nextstep.edu.missionutils.Console;

public class View {
    private static final String PLAYER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String VICTORY_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String FLAG_RESTART_GAME = "1";
    private static final String FLAG_END_GAME = "2";

    private View() {}

    public static String inputPlayer() {
        System.out.print(PLAYER_INPUT_MESSAGE);
        return Console.readLine();
    }

    public static void errorMessage(String message) {
        System.out.println(message);
    }

    public static void resultMessage(String result) {
        System.out.println(result);
    }

    public static void victoryMessageBy(GameState gameState) {
        if (GameState.isVictoryGame(gameState)) {
            System.out.println(VICTORY_MESSAGE);
        }
    }

    public static GameState inputRestart() {
        String inputRestart;

        do {
            System.out.println(RESTART_GAME_MESSAGE);
            inputRestart = Console.readLine();
        } while (isNotGameFlag(inputRestart));

        return FLAG_END_GAME.equals(inputRestart) ? GameState.END : GameState.PLAY;
    }

    private static boolean isNotGameFlag(String inputRestart) {
        return !(inputRestart.equals(FLAG_RESTART_GAME) || inputRestart.equals(FLAG_END_GAME));
    }
}
