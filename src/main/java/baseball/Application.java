package baseball;

import baseball.domain.Game;
import java.util.LinkedHashSet;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        LinkedHashSet<Integer> answer = game.generateAnswer();

        String result = game.play(answer);
        System.out.println(result);
    }
}
