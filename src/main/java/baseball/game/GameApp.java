package baseball.game;

import baseball.game.util.Console;

import java.util.Objects;

public class GameApp {
    public static void run() {
        String input = "1";

        while (Objects.equals(input, "1") && !Objects.equals(input, "2")) {
            new Game().play();
            Console.println(GameMessage.RESTART_OR_EXIT.get());
            input = Console.readLine();
        }

        if (!Objects.equals(input, "2")) {
            throw new IllegalArgumentException("wrong input");
        }
    }
}
