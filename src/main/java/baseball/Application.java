package baseball;

import baseball.game.Game;
import baseball.game.GameState;
import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        String line = "1";
        while (Objects.equals(line, "1") && !Objects.equals(line, "2")) {
            Game.play(new GameState());
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            line = Console.readLine();
        }
        if (!Objects.equals(line, "2")) {
            throw new IllegalArgumentException("your input is wrong");
        }
    }
}
