package baseball;

import baseball.domain.Game;
import java.util.LinkedHashSet;

public class Application {

    public static final String IS_WIN = "3스트라이크 ";
    public static final String MESSAGE_INFO_WIN = "3개의 숫자를 모두 맞히셨습니다! 게임종료";

    public static void main(String[] args) {
        Game game = new Game();
        LinkedHashSet<Integer> answer = game.generateAnswer();

        String result = "";
        while (!result.equals(IS_WIN)) {
            result = game.play(answer);
            System.out.println(result);
        }
        System.out.println(MESSAGE_INFO_WIN);
    }
}
