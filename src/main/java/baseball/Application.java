package baseball;

import baseball.domain.Game;
import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedHashSet;

public class Application {

    public static final String IS_WIN = "3스트라이크 ";
    public static final String MESSAGE_INFO_WIN = "3개의 숫자를 모두 맞히셨습니다! 게임종료";
    public static final String MESSAGE_INFO_SELECT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String MESSAGE_INFO_GAME_OVER = "게임 종료";
    public static final String MESSAGE_ERROR_INPUT = "입력이 올바르지 않습니다.";
    public static final String GAME_RESTART = "1";
    public static final String GAME_OVER = "2";

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        Game game = new Game();
        LinkedHashSet<Integer> answer = game.generateAnswer();

        String result = "";
        while (!result.equals(IS_WIN)) {
            result = game.play(answer);
            System.out.println(result);
        }
        System.out.println(MESSAGE_INFO_WIN);
        end();
    }

    private static void end() {
        System.out.println(MESSAGE_INFO_SELECT);
        String input = Console.readLine().trim();

        if (!input.equals(GAME_RESTART) && !input.equals(GAME_OVER)) {
            throw new IllegalArgumentException(MESSAGE_ERROR_INPUT);
        }

        if (input.equals(GAME_RESTART)) {
            start();
        }
        if (input.equals(GAME_OVER)) {
            System.out.println(MESSAGE_INFO_GAME_OVER);
        }
    }
}
